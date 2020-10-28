package DAO;

import Model.Pacote;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Util.ConectaBanco;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class PacoteDAO {

    public void cadastrar(Pacote pacote) throws ClassNotFoundException, SQLException {
        
        try (Connection con = ConectaBanco.getConexao()) {
            PreparedStatement comando = con.prepareStatement
            ("        INSERT INTO pacote VALUES (NEXTVAL('id_pacote'),  \n" +
"                    (SELECT id FROM assinatura WHERE nome = ?), \n" +
"					?,   \n" +
"                    (SELECT id FROM games WHERE nome = ?), \n" +
"                    (SELECT id FROM camiseta WHERE nome = ?), \n" +
"                    (SELECT id FROM produto WHERE nome = ?), \n" +
"                    (SELECT id FROM produto WHERE nome = ?), \n" +
"                    (SELECT id FROM produto WHERE nome = ?), \n" +
"                    (SELECT id FROM produto WHERE nome = ?), \n" +
"                    (SELECT id FROM produto WHERE nome = ?), \n" +
"					?, ?, ?)");
                      
            comando.setString(1, pacote.getAssinatura());
            comando.setString(2, pacote.getNome());
            comando.setString(3, pacote.getJogo());
            comando.setString(4, pacote.getCamiseta());
            comando.setString(5, pacote.getBrinde1());
            comando.setString(6, pacote.getBrinde2());
            comando.setString(7, pacote.getBrinde3());
            comando.setString(8, pacote.getBrinde4());
            comando.setString(9, pacote.getBrinde5());
            comando.setString(10, pacote.getSituacao());
            comando.setInt(11, pacote.getQuantidade());
            comando.setDouble(12, pacote.getPreco());
            
            comando.execute();
        }
    }

    public List<Pacote> consultarTodos() throws ClassNotFoundException, SQLException {

        List<Pacote> todosPacotes;
        try (Connection con = ConectaBanco.getConexao()) {
            PreparedStatement comando = con.prepareStatement
            ("select id, nome, preco, quantidade from pacote");
            ResultSet resultado = comando.executeQuery();
            todosPacotes = new ArrayList<>();
            while (resultado.next()) {
                Pacote p = new Pacote();
                p.setId(resultado.getInt("id"));
                p.setNome(resultado.getString("nome"));
                p.setPreco(resultado.getDouble("preco"));
                p.setQuantidade(resultado.getInt("quantidade"));
                
                todosPacotes.add(p);
            }
        }
        return todosPacotes;
    }
    
public void subtrairQuantidade(Pacote pacote) throws SQLException, ClassNotFoundException {
        try(Connection con = ConectaBanco.getConexao()){
            PreparedStatement comando = con.prepareStatement

            ("UPDATE games SET quantidade = quantidade - ? WHERE nome = ?;"
            + "UPDATE camiseta SET quantidade = quantidade - ? WHERE nome = ?;"
            + "UPDATE produto SET quantidade = quantidade - ? WHERE nome = ?;"
            + "UPDATE produto SET quantidade = quantidade - ? WHERE nome = ?;"
            + "UPDATE produto SET quantidade = quantidade - ? WHERE nome = ?;"
            + "UPDATE produto SET quantidade = quantidade - ? WHERE nome = ?;"
            + "UPDATE produto SET quantidade = quantidade - ? WHERE nome = ?;");

            comando.setInt(1, pacote.getQuantidade());
            comando.setString(2, pacote.getJogo());
            comando.setInt(3, pacote.getQuantidade());
            comando.setString(4, pacote.getCamiseta());
            comando.setInt(5, pacote.getQuantidade());
            comando.setString(6, pacote.getBrinde1());
            comando.setInt(7, pacote.getQuantidade());
            comando.setString(8, pacote.getBrinde2());
            comando.setInt(9, pacote.getQuantidade());
            comando.setString(10, pacote.getBrinde3());
            comando.setInt(11, pacote.getQuantidade());
            comando.setString(12, pacote.getBrinde4());
            comando.setInt(13, pacote.getQuantidade());
            comando.setString(14, pacote.getBrinde5());

            comando.execute();
        }      
    }
    
    public void Editar(Pacote pacote) throws ClassNotFoundException, SQLException {
        Connection con = ConectaBanco.getConexao();
        PreparedStatement comando = con.prepareStatement("UPDATE Pacote SET nome = ?, jogo = ?, camiseta = ?, brinde1 = ?,brinde2 = ?,brinde3 = ?,brinde4 = ?, brinde5 = ?, situacao = ?, preco = ? WHERE id = ?");
        comando.setString(1, pacote.getNome());
        comando.setString(2, pacote.getJogo());
        comando.setString(3, pacote.getCamiseta());
        comando.setString(4, pacote.getBrinde1());
        comando.setString(5, pacote.getBrinde2());
        comando.setString(6, pacote.getBrinde3());
        comando.setString(7, pacote.getBrinde4());
        comando.setString(8, pacote.getBrinde5());
        comando.setString(9, pacote.getSituacao());
        comando.setDouble(10, pacote.getPreco());
        comando.setInt(11, pacote.getId());
        comando.execute();
    }

    public void Excluir(Pacote pacote) throws ClassNotFoundException, SQLException {
        Connection con = ConectaBanco.getConexao();
        PreparedStatement comando = con.prepareStatement("UPDATE pacote SET situacao = 'INATIVO' WHERE id = ?");
        comando.setInt(1, pacote.getId());
        comando.execute();
    }

    public void consultarporId(Pacote pacote) throws ClassNotFoundException, SQLException {
        Connection con = ConectaBanco.getConexao();
        PreparedStatement comando = con.prepareStatement("SELECT * FROM pacote WHERE id = ?");
        comando.setInt(1, pacote.getId());
        ResultSet resultado = comando.executeQuery();

        if (resultado.next()) {
            pacote.setNome(resultado.getString("nome"));
            pacote.setJogo(resultado.getString("gameFk"));
            pacote.setCamiseta(resultado.getString("camisetaFk"));
            pacote.setBrinde1(resultado.getString("brindeFk1"));
            pacote.setBrinde2(resultado.getString("brindeFk2"));
            pacote.setBrinde3(resultado.getString("brindeFk3"));
            pacote.setBrinde4(resultado.getString("brindeFk4"));
            pacote.setBrinde5(resultado.getString("brindeFk5"));
            pacote.setSituacao(resultado.getString("situacao"));
            pacote.setPreco(resultado.getDouble("preco"));
            pacote.setId(resultado.getInt("id"));
        }
    }

    public Pacote consultarPorIdCarrinho(int id) throws ClassNotFoundException, SQLException {
        List<Pacote> todosPacotes = consultarTodos();
        
        for (Pacote pacote : todosPacotes) {
            if (pacote.getId() == id) 
                return pacote;
        }
        return null;
    }
    
    public Pacote cadastrarCarrinho(int id) throws ClassNotFoundException, SQLException {
        List<Pacote> todosPacotes = consultarTodos();
        Connection con = ConectaBanco.getConexao();
        for (Pacote pacote : todosPacotes) {
            if (pacote.getId() == id) 
            {
            PreparedStatement comando = con.prepareStatement //ISSO AQUI
            ("INSERT INTO carrinho VALUES (NEXTVAL('id_carrinho'),now(),?,(select id from pacote where id = ?))");
            
            comando.setDouble(1, pacote.getPreco());
            comando.setInt(2, pacote.getId());
            
            comando.execute();
                
                
            }
        }
        return null;
    }
        
    public void removerCarrinho(int id) throws ClassNotFoundException, SQLException {
        List<Pacote> todosPacotes = consultarTodos();
        Connection con = ConectaBanco.getConexao();
        for (Pacote pacote : todosPacotes) {
            if (pacote.getId() == id)
            {
        PreparedStatement comando = con.prepareStatement("DELETE Pacote p FROM carrinho WHERE p.id = ?");
        comando.setInt(1, pacote.getId());
        comando.execute();
    }
    }
    }
}
