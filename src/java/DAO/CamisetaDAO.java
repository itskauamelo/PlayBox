package DAO;

import Model.Camiseta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Util.ConectaBanco;
import static java.lang.Integer.parseInt;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class CamisetaDAO {

    public void cadastrar(Camiseta camiseta) throws ClassNotFoundException, SQLException {
        
        try (Connection con = ConectaBanco.getConexao()) {
            PreparedStatement comando = con.prepareStatement("INSERT INTO camiseta VALUES (NEXTVAL('id_camiseta'),?,?,?,?,?,?,?,?)");
            comando.setString(1, camiseta.getNome());
            comando.setString(2, camiseta.getDescricao());
            comando.setString(3, camiseta.getSexo());
            comando.setString(4, camiseta.getTamanho());
            comando.setString(5, camiseta.getImagem());
            comando.setString(6, camiseta.getSituacao());
            comando.setInt(7, camiseta.getQuantidade());
            comando.setDouble(8, camiseta.getPreco());
            
            comando.execute();
        }
    }

    public List<Camiseta> consultarTodos() throws ClassNotFoundException, SQLException {

        List<Camiseta> todasCamisetas;
        try (Connection con = ConectaBanco.getConexao()) {
            PreparedStatement comando = con.prepareStatement("SELECT * FROM camiseta ORDER BY id");
            ResultSet resultado = comando.executeQuery();
            todasCamisetas = new ArrayList<>();
            while (resultado.next()) {
                Camiseta ca = new Camiseta();
                ca.setId(resultado.getInt("id"));
                ca.setNome(resultado.getString("nome"));
                ca.setDescricao(resultado.getString("descricao"));
                ca.setSexo(resultado.getString("sexo"));
                ca.setTamanho(resultado.getString("tamanho"));
                ca.setImagem(resultado.getString("imagem"));
                ca.setSituacao(resultado.getString("situacao"));
                ca.setQuantidade(resultado.getInt("quantidade"));
                ca.setPreco(resultado.getDouble("preco"));
                
                todasCamisetas.add(ca);
            }
        }
        return todasCamisetas;
    }
    
    
            public List<Camiseta> listarOpt(){
        List<Camiseta> camisetas = new ArrayList<>();       
        
        try {
            
            Connection conexao = ConectaBanco.getConexao();
            String sql = "SELECT * FROM camiseta";
            
            PreparedStatement pstmt = conexao.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
                camisetas.add(new Camiseta(rs.getInt("id"), rs.getString("nome")));
            }
 
        } catch (Exception e) {
        }
        
        return camisetas;
    }

    public void Editar(Camiseta camiseta) throws ClassNotFoundException, SQLException {
        Connection con = ConectaBanco.getConexao();
        PreparedStatement comando = con.prepareStatement("UPDATE camiseta SET nome = ?, descricao = ?, sexo = ?, tamanho = ?, imagem = ?, situacao = ?, quantidade = ?, preco = ? WHERE id = ?");
        comando.setString(1, camiseta.getNome());
        comando.setString(2, camiseta.getDescricao());
        comando.setString(3, camiseta.getSexo());
        comando.setString(4, camiseta.getTamanho());
        comando.setString(5, camiseta.getImagem());
        comando.setString(6, camiseta.getSituacao());
        comando.setInt(7, camiseta.getQuantidade());
        comando.setDouble(8, camiseta.getPreco());
        comando.setInt(9, camiseta.getId());
        comando.execute();
    }

    public void Desativar(Camiseta camiseta) throws ClassNotFoundException, SQLException {
        Connection con = ConectaBanco.getConexao();
        PreparedStatement comando = con.prepareStatement("UPDATE camiseta SET situacao = 'INATIVO' WHERE id = ?");
        comando.setInt(1, camiseta.getId());
        comando.execute();
    }

    public void consultarporId(Camiseta camiseta) throws ClassNotFoundException, SQLException {
        Connection con = ConectaBanco.getConexao();
        PreparedStatement comando = con.prepareStatement("SELECT * FROM camiseta WHERE id = ?");
        comando.setInt(1, camiseta.getId());
        ResultSet resultado = comando.executeQuery();

        if (resultado.next()) {
            camiseta.setNome(resultado.getString("nome"));
            camiseta.setDescricao(resultado.getString("descricao"));
            camiseta.setSexo(resultado.getString("sexo"));
            camiseta.setTamanho(resultado.getString("tamanho"));
            camiseta.setImagem(resultado.getString("imagem"));
            camiseta.setSituacao(resultado.getString("situacao"));
            camiseta.setQuantidade(resultado.getInt("quantidade"));
            camiseta.setPreco(resultado.getDouble("preco"));
            camiseta.setId(resultado.getInt("id"));
        }
    }
}
