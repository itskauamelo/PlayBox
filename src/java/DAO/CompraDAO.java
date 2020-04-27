/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import java.util.List;
import Model.Compra;
import Util.ConectaBanco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author alunocmc
 */

public class CompraDAO {


    public void cadastrar(Compra compra) throws ClassNotFoundException, SQLException {
            
        try (Connection con = ConectaBanco.getConexao()) {
            PreparedStatement comando = con.prepareStatement("INSERT INTO compra (id, datahora, valor) VALUES (NEXTVAL('id_compra'), now(),?)");           
            //comando.setString(1, compra.getCarrinho().toString());
            //comando.setString(2, compra.getCliente().toString());
            comando.setDouble(1, compra.getTotal());
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
            ("select id, datahora, valor from compra");
            ResultSet resultado = comando.executeQuery();
            todasCompras = new ArrayList<>();
            while (resultado.next()) {
                Compra c = new Compra();
                c.setId(resultado.getInt("id"));
                c.setData(resultado.getDate("datahora"));
                c.setTotal(resultado.getDouble("valor"));
                
                todasCompras.add(c);
            }
        }
        return todasCompras;
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
