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
            ("        INSERT INTO pacote VALUES (NEXTVAL('id_pacote'), ?, \n" +
            "        (SELECT id FROM games WHERE nome = ?), \n" +
            "        (SELECT id FROM camiseta WHERE nome = ?), \n" +
            "        (SELECT id FROM produto WHERE nome = ?), \n" +
            "        (SELECT id FROM produto WHERE nome = ?), \n" +
            "        (SELECT id FROM produto WHERE nome = ?), \n" +
            "        (SELECT id FROM produto WHERE nome = ?), \n" +
            "        (SELECT id FROM produto WHERE nome = ?),\n" +
            "        ?,\n" +
            "        ?)");
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
            
            comando.execute();
        }
    }

    public List<Pacote> consultarTodos() throws ClassNotFoundException, SQLException {

        List<Pacote> todosPacotes;
        try (Connection con = ConectaBanco.getConexao()) {
            PreparedStatement comando = con.prepareStatement
            ("select id, nome, \n" +
            "(select nome from games where id = ?),\n" +
            "(select nome from camiseta where id = ?),\n" +
            "(select nome from produto where id = ?),\n" +
            "(select nome from produto where id = ?),\n" +
            "(select nome from produto where id = ?),\n" +
            "(select nome from produto where id = ?),\n" +
            "(select nome from produto where id = ?),\n" +
            "situacao, preco\n" +
            "from pacote");
            ResultSet resultado = comando.executeQuery();
            todosPacotes = new ArrayList<>();
            while (resultado.next()) {
                Pacote p = new Pacote();
                p.setId(resultado.getInt("id"));
                p.setNome(resultado.getString("nome"));
                p.setJogo(resultado.getString("gameFk"));
                p.setCamiseta(resultado.getString("camisetaFk"));
                p.setBrinde1(resultado.getString("brindeFk1"));
                p.setBrinde2(resultado.getString("brindeFk2"));
                p.setBrinde3(resultado.getString("brindeFk3"));
                p.setBrinde4(resultado.getString("brindeFk4"));
                p.setBrinde5(resultado.getString("brindeFk5"));
                p.setSituacao(resultado.getString("situacao"));
                p.setPreco(resultado.getDouble("preco"));
                
                todosPacotes.add(p);
            }
        }
        return todosPacotes;
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
}
