/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

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


    public void cadastrar(Compra compra) throws ClassNotFoundException, SQLException {
            
        try (Connection con = ConectaBanco.getConexao()) {
            PreparedStatement comando = con.prepareStatement("INSERT INTO compra (id, datahora, valor, statusfk) VALUES (NEXTVAL('id_compra'), now(),?,'1')");           
            //comando.setString(1, compra.getCarrinho().toString());
            //comando.setString(2, compra.getCliente().toString());
            comando.setDouble(1, compra.getTotal());
            comando.execute();
        }
    }
    
    public void cadastrarAssinatura(Cliente cliente) throws ClassNotFoundException, SQLException {
            
        try (Connection con = ConectaBanco.getConexao()) {
            PreparedStatement comando = con.prepareStatement("INSERT INTO cliente (assinatura) VALUES (?)");
            Compra compra = new Compra();
            comando.setString(1, compra.getCarrinho().toString());
            //comando.setString(2, compra.getCliente().toString());
            comando.setDouble(1, compra.getTotal());
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
        
        public void cancelarPedido(Compra compra) throws ClassNotFoundException, SQLException {
        Connection con = ConectaBanco.getConexao();
        PreparedStatement comando = con.prepareStatement("UPDATE compra SET statusFk = 6 WHERE id = ?");
        comando.setInt(1, compra.getId());
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
}
