package DAO;

import Model.Compra;
import Model.ItensRelatorio;
import Model.Relatorio;
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
    
        public List<Relatorio> getConsultarPeriodoVenda() throws ClassNotFoundException, SQLException {

        List<Relatorio> periodoVendas;
        
        try (Connection con = ConectaBanco.getConexao()) {
            PreparedStatement comando = con.prepareStatement
                    (
                        "SELECT\n" +
                        "       COUNT(clientefk) AS Quantidade,\n" +
                        "       EXTRACT(MONTH FROM datahora) mes,\n" +
                        "       EXTRACT(YEAR FROM datahora) ano\n" +
                        " \n" +
                        "  FROM compra\n" +
                        "  GROUP BY\n" +
                        "       MES,\n" +
                        "       EXTRACT(MONTH FROM datahora),\n" +
                        "       EXTRACT(YEAR FROM datahora) \n" +
                        "ORDER BY Quantidade desc"
                    );
            ResultSet resultado = comando.executeQuery();
            periodoVendas = new ArrayList<>();
            while (resultado.next()) {
                Relatorio v = new Relatorio();
                v.setQuantidade(resultado.getString("quantidade"));
                v.setMes(resultado.getString("mes"));
                v.setAno(resultado.getString("ano"));
                
                periodoVendas.add(v);
            }
            }
        return periodoVendas;
}
        
        public List<Relatorio> getQuantClientes() throws ClassNotFoundException, SQLException {

        List<Relatorio> quantClientesMes;
        
        try (Connection con = ConectaBanco.getConexao()) {
            PreparedStatement comando = con.prepareStatement
                    (
                        "SELECT\n" +
                        "       COUNT(id) AS Quantidade,\n" +
                        "       EXTRACT(MONTH FROM datahora) mes,\n" +
                        "       EXTRACT(YEAR FROM datahora) ano\n" +
                        " \n" +
                        "FROM log_novo_cliente\n" +
                        "GROUP BY\n" +
                        "       MES,\n" +
                        "       EXTRACT(MONTH FROM datahora),\n" +
                        "       EXTRACT(YEAR FROM datahora) \n" +
                        "ORDER BY Quantidade desc;"
                    );
            ResultSet resultado = comando.executeQuery();
            quantClientesMes = new ArrayList<>();
            while (resultado.next()) {
                Relatorio r = new Relatorio();
                r.setQuantidade(resultado.getString("quantidade"));
                r.setMes(resultado.getString("mes"));
                r.setAno(resultado.getString("ano"));
                
                quantClientesMes.add(r);
            }
            }
        return quantClientesMes;
}
}
