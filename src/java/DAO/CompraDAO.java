/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Assinatura;
import Model.Cliente;
import java.util.ArrayList;
import java.util.List;
import Model.Compra;
import Util.ConectaBanco;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

/**
 *
 * @author alunocmc
 */

public class CompraDAO {


    public void cadastrar(Compra compra, Cliente objcliente) throws ClassNotFoundException, SQLException {
            
        try (Connection con = ConectaBanco.getConexao()) {
            PreparedStatement comando = con.prepareStatement("INSERT INTO compra (id, datahora, valor, statusfk, clientefk, tipoCompra) VALUES (NEXTVAL('id_compra'), now(),?,'1',?,'AVULSO')");           
            //comando.setString(1, compra.getCarrinho().toString());
            comando.setDouble(1, compra.getTotal());
            comando.setInt(2, objcliente.getId());
            comando.execute();
        }
    }
    
    public void cadastrarAss(Compra compra, Cliente objcliente) throws ClassNotFoundException, SQLException {
            
        try (Connection con = ConectaBanco.getConexao()) {
            PreparedStatement comando = con.prepareStatement("INSERT INTO compra (id, datahora, valor, statusfk, clientefk, tipoCompra) VALUES (NEXTVAL('id_compra'), now(),?,'1',?, 'ASSINATURA')");           
            //comando.setString(1, compra.getCarrinho().toString());
            comando.setDouble(1, compra.getTotalAss());
            comando.setInt(2, objcliente.getId());
            comando.execute();
        }
    }
    
    public void assinatura(Cliente objcliente) throws ClassNotFoundException, SQLException {
            
        try (Connection con = ConectaBanco.getConexao()) {
            PreparedStatement comando = con.prepareStatement("UPDATE cliente SET cobranca = 1 WHERE id = ?");
            Compra compra = new Compra();
            comando.setInt(1, objcliente.getId());
            comando.execute();
        }
    }
    
        public void alterarStatus(Compra compra) throws ClassNotFoundException, SQLException {
        Connection con = ConectaBanco.getConexao();
        PreparedStatement comando = con.prepareStatement("UPDATE compra SET statusfk = ? WHERE id = ?");
        comando.setInt(1, compra.getStatus());
        comando.setInt(2, compra.getId());
        comando.execute();
    }
        public void statusPago(Compra compra) throws ClassNotFoundException, SQLException {
        Connection con = ConectaBanco.getConexao();
        PreparedStatement comando = con.prepareStatement("UPDATE compra SET statusfk = 2 WHERE id = ?");
        comando.setInt(1, compra.getId());
        comando.execute();
    }
        
        public void alterarAssinatura(Cliente objcliente) throws ClassNotFoundException, SQLException {

        try (Connection con = ConectaBanco.getConexao()) {
            PreparedStatement comando = con.prepareStatement("UPDATE compra SET statusfk = 6  WHERE id = (SELECT MAX(id) FROM compra WHERE tipoCompra = 'ASSINATURA' AND clientefk = ? )");
            comando.setInt(1, objcliente.getId());
            comando.execute();
        }
    }
    
    public void fecharCompra(Compra compra) throws ClassNotFoundException, SQLException {
            
        try (Connection con = ConectaBanco.getConexao()) {
            PreparedStatement comando = con.prepareStatement("UPDATE compra SET enderecoentregaFk = ?, metodopagamentofk = ?, cartaocreditoFk = ? WHERE id IN (SELECT MAX(ID) FROM compra)");           

            comando.setInt(1, compra.getEnderecoentrega());
            comando.setInt(2, compra.getMetodopagamento());
            comando.setInt(3, compra.getCartaocredito());
            comando.execute();
        }
    }
    
     
   
    public List<Compra> consultarUltimaCompra() throws ClassNotFoundException, SQLException {

        List<Compra> ultimaCompra;
        try (Connection con = ConectaBanco.getConexao()) {
            PreparedStatement comando = con.prepareStatement("SELECT * FROM compra ORDER BY id DESC LIMIT 1");
            ResultSet resultado = comando.executeQuery();
            ultimaCompra = new ArrayList<>();
            while (resultado.next()) {
                Compra c = new Compra();
                c.setId(resultado.getInt("id"));
                ultimaCompra.add(c);
            }
        }
        return ultimaCompra;
    }
    
    public List<Compra> consultarTodas() throws ClassNotFoundException, SQLException {  
        List<Compra> todasCompras;
        try (Connection con = ConectaBanco.getConexao()) {
            PreparedStatement comando = con.prepareStatement
            ("SELECT id, datahora, valor, statusfk FROM compra ORDER BY id DESC");
            ResultSet resultado = comando.executeQuery();
            todasCompras = new ArrayList<>();
            while (resultado.next()) {
                Compra c = new Compra();
                c.setId(resultado.getInt("id"));
                c.setData(resultado.getDate("datahora"));
                c.setTotal(resultado.getDouble("valor"));
                c.setStatus(resultado.getInt("statusfk"));
                
                todasCompras.add(c);
            }
        }
        return todasCompras;
    }
    
    public List<Compra> consultarTodasAgPagamento() throws ClassNotFoundException, SQLException {

        List<Compra> todasComprasPagamento;
        try (Connection con = ConectaBanco.getConexao()) {
            PreparedStatement comando = con.prepareStatement
            ("SELECT id, datahora, valor, statusfk FROM compra ORDER BY id DESC");
            ResultSet resultado = comando.executeQuery();
            todasComprasPagamento = new ArrayList<>();
            while (resultado.next()) {
                Compra c = new Compra();
                c.setId(resultado.getInt("id"));
                c.setData(resultado.getDate("datahora"));
                c.setTotal(resultado.getDouble("valor"));
                c.setStatus(resultado.getInt("statusfk"));
                
                todasComprasPagamento.add(c);
            }
        }
        return todasComprasPagamento;
    }

        public void aprovarPagamento(Compra compra) throws ClassNotFoundException, SQLException {
        Connection con = ConectaBanco.getConexao();
        PreparedStatement comando = con.prepareStatement("UPDATE compra SET statusFk = 2 WHERE id = ?");
        comando.setInt(1, compra.getId());
        comando.execute();
    }
        
        public void cancelarPedido() throws ClassNotFoundException, SQLException {
        Connection con = ConectaBanco.getConexao();
        PreparedStatement comando = con.prepareStatement("UPDATE compra\n" +
        "SET statusfk = 6\n" +
        "WHERE datahora < CURRENT_DATE - 5 AND statusfk = 1");
        comando.execute();
    }
        
    public void cancelarPedido() throws ClassNotFoundException, SQLException {
        Connection con = ConectaBanco.getConexao();
        PreparedStatement comando = con.prepareStatement("UPDATE compra\n" +
        "SET statusfk = 6\n" +
        "WHERE datahora < CURRENT_DATE - 5 AND statusfk = 1");
        comando.execute();
    }
        
        public void renovarAssinatura() throws ClassNotFoundException, SQLException {
        Connection con = ConectaBanco.getConexao();
        PreparedStatement comando = con.prepareStatement
        (
                "INSERT INTO COMPRA\n" +
                "(id, datahora, valor, statusfk, clientefk,\n" +
                "enderecoentregafk, metodopagamentofk, cartaocreditofk, tipocompra)\n" +
                "SELECT \n" +
                "NEXTVAL('id_compra'), \n" +
                "	now(), \n" +
                "	c.valor, \n" +
                "	1, \n" +
                "	c.clientefk,\n" +
                "	c.enderecoentregafk, \n" +
                "	c.metodopagamentofk, \n" +
                "	c.cartaocreditofk,\n" +
                "	c.tipocompra\n" +
                "FROM compra c, cliente cli\n" +
                "WHERE cli.id = c.clienteFK\n" +
                "AND cli.cobranca = 1 AND cli.situacao = 'ATIVO'\n" +
                "AND c.statusfk = 5 AND c.tipoCompra = 'ASSINATURA' AND c.datahora = (CURRENT_DATE - INTERVAL '1' MONTH)"
        );
        comando.execute();
    }
    
    public void consultarporId(Compra compra) throws ClassNotFoundException, SQLException {
        Connection con = ConectaBanco.getConexao();
        PreparedStatement comando = con.prepareStatement("SELECT * from compra WHERE id = ?");
        comando.setInt(1, compra.getId());
        ResultSet resultado = comando.executeQuery();

        if (resultado.next()) {
            compra.setStatus(resultado.getInt("statusfk"));
            compra.setId(resultado.getInt("id"));
        }
    }
    
    public List<Compra> consultarComprasFinalizadas() throws ClassNotFoundException, SQLException {

        List<Compra> todasComprasFinalizadas;
        try (Connection con = ConectaBanco.getConexao()) {
            PreparedStatement comando = con.prepareStatement
            ("select id, datahora, clientefk, metodopagamentofk, valor from compra where statusfk = 5");
            ResultSet resultado = comando.executeQuery();
            todasComprasFinalizadas = new ArrayList<>();
            while (resultado.next()) {
                Compra c = new Compra();
                c.setId(resultado.getInt("id"));
                c.setData(resultado.getDate("datahora"));
                c.setCliente(resultado.getString("clientefk"));
                c.setMetodopagamento(resultado.getInt("metodopagamentofk"));
                c.setTotal(resultado.getDouble("valor"));
                
                todasComprasFinalizadas.add(c);
            }
        }
        return todasComprasFinalizadas;
    }
    
    public List<Compra> consultarMinhasCompras(Cliente objcliente) throws ClassNotFoundException, SQLException {
        List<Compra> todasCompras;
        try (Connection con = ConectaBanco.getConexao()) {
            PreparedStatement comando = con.prepareStatement
            ("SELECT id, datahora, valor, statusfk FROM compra where clientefk = ? ORDER BY id DESC");
            comando.setInt(1, objcliente.getId());
            ResultSet resultado = comando.executeQuery();
            todasCompras = new ArrayList<>();
            while (resultado.next()) {
                Compra c = new Compra();
                c.setId(resultado.getInt("id"));
                c.setData(resultado.getDate("datahora"));
                c.setTotal(resultado.getDouble("valor"));
                c.setStatus(resultado.getInt("statusfk"));
                
                todasCompras.add(c);
            }
        }
        return todasCompras;
    }

}
    
    /*public List<Compra> listarComprasUsuario(Cliente cliente) {
        
        List<Compra> comprasUsuario = new ArrayList<>();
        
        for (Compra compra : todasCompras) {
            if (compra.getCliente().getId() == cliente.getId()) {
                comprasUsuario.add(compra);
            }
        }
        
        Collections.sort(comprasUsuario, Compra.ordenar_por_data_desc);
        return comprasUsuario;
    }*/
