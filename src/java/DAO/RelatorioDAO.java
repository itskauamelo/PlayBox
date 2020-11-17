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
            PreparedStatement comando = con.prepareStatement("SELECT \n"
                    + "p.id, p.nome, p.situacao, p.quantidade, p.preco\n"
                    + "FROM produto p\n"
                    + "\n"
                    + "UNION ALL\n"
                    + "\n"
                    + "SELECT \n"
                    + "c.id, c.nome, c.situacao, c.quantidade, c.preco\n"
                    + "FROM camiseta c\n"
                    + "\n"
                    + "UNION ALL\n"
                    + "\n"
                    + "SELECT \n"
                    + "g.id, g.nome, g.situacao, g.quantidade, g.preco\n"
                    + "FROM games g");
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
            PreparedStatement comando = con.prepareStatement(
                    "SELECT\n"
                    + "       COUNT(clientefk) AS Quantidade,\n"
                    + "       EXTRACT(MONTH FROM datahora) mes,\n"
                    + "       EXTRACT(YEAR FROM datahora) ano\n"
                    + " \n"
                    + "  FROM compra\n"
                    + "  GROUP BY\n"
                    + "       MES,\n"
                    + "       EXTRACT(MONTH FROM datahora),\n"
                    + "       EXTRACT(YEAR FROM datahora) \n"
                    + "ORDER BY mes"
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

    public List<Relatorio> getPedidosStatus() throws ClassNotFoundException, SQLException {

        List<Relatorio> vendas2020;

        try (Connection con = ConectaBanco.getConexao()) {
            PreparedStatement comando = con.prepareStatement(
                    "SELECT \n"
                    + "COUNT(ID) as Quantidade,\n"
                    + "statusfk as Status\n"
                    + "FROM compra WHERE statusfk IN (1,2,3,4,5,6)\n"
                    + "GROUP BY Status"
            );
            ResultSet resultado = comando.executeQuery();
            vendas2020 = new ArrayList<>();
            while (resultado.next()) {
                Relatorio t = new Relatorio();
                t.setQuantidade(resultado.getString("quantidade"));
                t.setStatus(resultado.getString("status"));

                vendas2020.add(t);
            }
        }
        return vendas2020;

    }
    
    public List<Relatorio> getQuantHorasJogo() throws ClassNotFoundException, SQLException {

        List<Relatorio> horasJogo;

        try (Connection con = ConectaBanco.getConexao()) {
            PreparedStatement comando = con.prepareStatement(
                "SELECT \n" +
                "COUNT(ID) AS Quantidade,\n" +
                "horasjogo as Horas\n" +
                "FROM preferencia WHERE horasjogo IN ('1 a 2 hrs', '3 a 4 hrs', '5 a 7 hrs', 'Mais')\n" +
                "GROUP BY Horas"
            );
            ResultSet resultado = comando.executeQuery();
            horasJogo = new ArrayList<>();
            while (resultado.next()) {
                Relatorio t = new Relatorio();
                t.setQuantidade(resultado.getString("quantidade"));
                t.setHorasjogo(resultado.getString("horas"));

                horasJogo.add(t);
            }
        }
        return horasJogo;

    }
    
    public List<Relatorio> getJogoOnline() throws ClassNotFoundException, SQLException {

        List<Relatorio> jogoOnline;

        try (Connection con = ConectaBanco.getConexao()) {
            PreparedStatement comando = con.prepareStatement(
                "SELECT \n" +
                "COUNT(ID) AS Quantidade,\n" +
                "jogoonline as Online\n" +
                "FROM preferencia WHERE jogoonline IN ('Sim', 'Não')\n" +
                "GROUP BY Online"
            );
            ResultSet resultado = comando.executeQuery();
            jogoOnline = new ArrayList<>();
            while (resultado.next()) {
                Relatorio t = new Relatorio();
                t.setQuantidade(resultado.getString("quantidade"));
                t.setJogoonline(resultado.getString("online"));

                jogoOnline.add(t);
            }
        }
        return jogoOnline;

    }
    
    public List<Relatorio> getAssinaturaQuant() throws ClassNotFoundException, SQLException {

        List<Relatorio> assCliente;

        try (Connection con = ConectaBanco.getConexao()) {
            PreparedStatement comando = con.prepareStatement(
                "SELECT \n" +
                "COUNT(ID) as Quantidade,\n" +
                "assinaturafk as Assinatura\n" +
                "FROM cliente WHERE assinaturafk IN (1,2,3)\n" +
                "GROUP BY Assinatura"
            );
            ResultSet resultado = comando.executeQuery();
            assCliente = new ArrayList<>();
            while (resultado.next()) {
                Relatorio a = new Relatorio();
                a.setQuantidade(resultado.getString("quantidade"));
                a.setAssinatura(resultado.getString("assinatura"));

                assCliente.add(a);
            }
        }
        return assCliente;

    }

    public List<Relatorio> getConsultarPeriodoVenda2020() throws ClassNotFoundException, SQLException {

        List<Relatorio> periodoVendas2020;

        try (Connection con = ConectaBanco.getConexao()) {
            PreparedStatement comando = con.prepareStatement(
                    "SELECT \n"
                    + "	   COUNT(clientefk) AS Quantidade,\n"
                    + "	   EXTRACT(MONTH FROM datahora) AS mesano\n"
                    + "FROM compra WHERE to_char(datahora, 'YYYY') = '2020'\n"
                    + "GROUP BY \n"
                    + "		mesano\n"
                    + "ORDER BY mesano asc"
            );
            ResultSet resultado = comando.executeQuery();
            periodoVendas2020 = new ArrayList<>();
            while (resultado.next()) {
                Relatorio v = new Relatorio();
                v.setQuantidade(resultado.getString("quantidade"));
                v.setMesano(resultado.getString("mesano"));

                periodoVendas2020.add(v);
            }
        }
        return periodoVendas2020;
    }
    
    public List<Relatorio> getGanheiPerdiAss() throws ClassNotFoundException, SQLException {

        List<Relatorio> ganheiPerdiAss;

        try (Connection con = ConectaBanco.getConexao()) {
            PreparedStatement comando = con.prepareStatement(
                "SELECT\n" +
                "	   COUNT(clientefk) AS Quantidade,\n" +
                "	   CONCAT(EXTRACT(MONTH FROM datahora),'/',EXTRACT(YEAR FROM datahora)) AS mesAno,\n" +
                "	   EXTRACT(YEAR FROM datahora) ano\n" +
                "FROM compra WHERE compra.tipocompra = 'ASSINATURA'\n" +
                "GROUP BY\n" +
                "		MESANO,\n" +
                "		EXTRACT(MONTH FROM datahora),\n" +
                "		EXTRACT(YEAR FROM datahora)\n" +
                "ORDER BY Ano desc"
            );
            ResultSet resultado = comando.executeQuery();
            ganheiPerdiAss = new ArrayList<>();
            while (resultado.next()) {
                Relatorio ass = new Relatorio();
                ass.setQuantidade(resultado.getString("quantidade"));
                ass.setMesano(resultado.getString("mesano"));

                ganheiPerdiAss.add(ass);
            }
        }
        return ganheiPerdiAss;
    }
    
    public List<Relatorio> getConsultarPeriodoVenda2019() throws ClassNotFoundException, SQLException {

        List<Relatorio> periodoVendas2019;

        try (Connection con = ConectaBanco.getConexao()) {
            PreparedStatement comando = con.prepareStatement(
                    "SELECT \n"
                    + "	   COUNT(clientefk) AS Quantidade,\n"
                    + "	   EXTRACT(MONTH FROM datahora) AS mesano\n"
                    + "FROM compra WHERE to_char(datahora, 'YYYY') = '2019'\n"
                    + "GROUP BY \n"
                    + "		mesano\n"
                    + "ORDER BY mesano asc"
            );
            ResultSet resultado = comando.executeQuery();
            periodoVendas2019 = new ArrayList<>();
            while (resultado.next()) {
                Relatorio v = new Relatorio();
                v.setQuantidade(resultado.getString("quantidade"));
                v.setMesano(resultado.getString("mesano"));

                periodoVendas2019.add(v);
            }
        }
        return periodoVendas2019;
    }

    public List<Relatorio> getQuantClientes() throws ClassNotFoundException, SQLException {

        List<Relatorio> quantClientesMes;

        try (Connection con = ConectaBanco.getConexao()) {
            PreparedStatement comando = con.prepareStatement(
                    "SELECT\n"
                    + "       COUNT(id) AS Quantidade,\n"
                    + "       EXTRACT(MONTH FROM datahora) mes,\n"
                    + "       EXTRACT(YEAR FROM datahora) ano\n"
                    + " \n"
                    + "FROM log_novo_cliente\n"
                    + "GROUP BY\n"
                    + "       MES,\n"
                    + "       EXTRACT(MONTH FROM datahora),\n"
                    + "       EXTRACT(YEAR FROM datahora) \n"
                    + "ORDER BY mes;"
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
