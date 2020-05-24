package DAO;

import Model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Util.ConectaBanco;
import static java.lang.Integer.parseInt;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ProdutoDAO {

    public void cadastrar(Produto produto) throws ClassNotFoundException, SQLException {
        
        try (Connection con = ConectaBanco.getConexao()) {
            PreparedStatement comando = con.prepareStatement("INSERT INTO produto VALUES (NEXTVAL('id_produto'),?,?,?,?,?,?)");
            comando.setString(1, produto.getNome());
            comando.setString(2, produto.getDescricao());
            comando.setString(3, produto.getImagem());
            comando.setString(4, produto.getSituacao());
            comando.setInt(5, produto.getQuantidade());
            comando.setDouble(6, produto.getPreco());
            
            comando.execute();
        }
    }

    public List<Produto> consultarTodos() throws ClassNotFoundException, SQLException {

        List<Produto> todosProdutos;
        try (Connection con = ConectaBanco.getConexao()) {
            PreparedStatement comando = con.prepareStatement("SELECT id, imagem, nome, descricao, situacao, quantidade, preco FROM produto WHERE situacao = 'ATIVO'");
            ResultSet resultado = comando.executeQuery();
            todosProdutos = new ArrayList<>();
            while (resultado.next()) {
                Produto p = new Produto();
                p.setId(resultado.getInt("id"));
                p.setNome(resultado.getString("nome"));
                p.setDescricao(resultado.getString("descricao"));
                p.setImagem(resultado.getString("imagem"));
                p.setSituacao(resultado.getString("situacao"));
                p.setQuantidade(resultado.getInt("quantidade"));
                p.setPreco(resultado.getDouble("preco"));
                
                todosProdutos.add(p);
            }
        }
        return todosProdutos;
    }
    
            public List<Produto> listarOpt(){
        List<Produto> produtos = new ArrayList<>();       
        
        try {
            
            Connection conexao = ConectaBanco.getConexao();
            String sql = "SELECT * FROM Produto";
            
            PreparedStatement pstmt = conexao.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
                produtos.add(new Produto(rs.getInt("id"), rs.getString("nome")));
            }
 
        } catch (Exception e) {
        }
        
        return produtos;
    }

    public void Editar(Produto produto) throws ClassNotFoundException, SQLException {
        Connection con = ConectaBanco.getConexao();
        PreparedStatement comando = con.prepareStatement("UPDATE produto SET nome = ?, descricao = ?, imagem = ?, situacao = ?, quantidade = ?, preco = ? WHERE id = ?");
        comando.setString(1, produto.getNome());
        comando.setString(2, produto.getDescricao());
        comando.setString(3, produto.getImagem());
        comando.setString(4, produto.getSituacao());
        comando.setInt(5, produto.getQuantidade());
        comando.setDouble(6, produto.getPreco());
        comando.setInt(7, produto.getId());
        comando.execute();
    }

    public void Excluir(Produto produto) throws ClassNotFoundException, SQLException {
        Connection con = ConectaBanco.getConexao();
        PreparedStatement comando = con.prepareStatement("UPDATE produto SET situacao = 'INATIVO' WHERE id = ?");
        comando.setInt(1, produto.getId());
        comando.execute();
    }

    public void consultarporId(Produto produto) throws ClassNotFoundException, SQLException {
        Connection con = ConectaBanco.getConexao();
        PreparedStatement comando = con.prepareStatement("SELECT * FROM produto WHERE id = ?");
        comando.setInt(1, produto.getId());
        ResultSet resultado = comando.executeQuery();

        if (resultado.next()) {
            produto.setNome(resultado.getString("nome"));
            produto.setDescricao(resultado.getString("descricao"));
            produto.setImagem(resultado.getString("imagem"));
            produto.setSituacao(resultado.getString("situacao"));
            produto.setQuantidade(resultado.getInt("quantidade"));
            produto.setPreco(resultado.getDouble("preco"));
            produto.setId(resultado.getInt("id"));
        }
    }
}
