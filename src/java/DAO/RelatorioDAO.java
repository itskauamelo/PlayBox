package DAO;

import Model.ItensRelatorio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Util.ConectaBanco;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class RelatorioDAO {

    public List<ItensRelatorio> consultarTodos() throws ClassNotFoundException, SQLException {

        List<ItensRelatorio> todosItens;
        try (Connection con = ConectaBanco.getConexao()) {
            PreparedStatement comando = con.prepareStatement
            ("SELECT \n" +
            "p.id, p.nome, p.situacao, p.quantidade, p.preco\n" +
            "FROM produto p\n" +
            "\n" +
            "UNION ALL\n" +
            "\n" +
            "SELECT \n" +
            "c.id, c.nome, c.situacao, c.quantidade, c.preco\n" +
            "FROM camiseta c\n" +
            "\n" +
            "UNION ALL\n" +
            "\n" +
            "SELECT \n" +
            "g.id, g.nome, g.situacao, g.quantidade, g.preco\n" +
            "FROM games g");
            ResultSet resultado = comando.executeQuery();
            todosItens = new ArrayList<>();
            while (resultado.next()) {
                ItensRelatorio i = new ItensRelatorio();
                i.setId(resultado.getInt("id"));
                i.setNome(resultado.getString("nome"));
                i.setSituacao(resultado.getString("situacao"));
                i.setQuantidade(resultado.getInt("quantidade"));
                i.setPreco(resultado.getDouble("preco"));
                
                todosItens.add(i);
            }
        }
        return todosItens;
    }
    

}
