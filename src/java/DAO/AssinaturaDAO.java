package DAO;

import Model.Assinatura;
import Model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Util.ConectaBanco;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class AssinaturaDAO {

    public Assinatura consultarPorIdCarrinho(int id) throws ClassNotFoundException, SQLException {
        List<Assinatura> todasAssinaturas = consultarTodos();
        
        for (Assinatura assinatura : todasAssinaturas) {
            if (assinatura.getId() == id) 
                return assinatura;
        }
        return null;
    }
    
        public void inserirAssinatura(int id, Cliente objcliente) throws ClassNotFoundException, SQLException {
        
            try (Connection con = ConectaBanco.getConexao()) {
            PreparedStatement comando = con.prepareStatement("UPDATE cliente SET assinatura = ? WHERE id = ?");
            comando.setInt(1, id);
            comando.setInt(2, objcliente.getId());
            comando.execute();
        }
    }
        
    public List<Assinatura> consultarMinhaAssinatura(Cliente objcliente) throws ClassNotFoundException, SQLException {
        List<Assinatura> aAssinatura;
        try (Connection con = ConectaBanco.getConexao()) {
            PreparedStatement comando = con.prepareStatement
            ("SELECT assinatura FROM cliente where id = ?");
            comando.setInt(1, objcliente.getId());
            ResultSet resultado = comando.executeQuery();
            aAssinatura = new ArrayList<>();
            while (resultado.next()) {
                Assinatura a = new Assinatura();
                a.setId(resultado.getInt("id"));
                
                aAssinatura.add(a);
            }
        }
        return aAssinatura;
    }
    
    public List<Assinatura> consultarTodos() throws ClassNotFoundException, SQLException {

        List<Assinatura> todasAssinaturas;
        try (Connection con = ConectaBanco.getConexao()) {
            PreparedStatement comando = con.prepareStatement
            ("SELECT id, nome, preco FROM assinatura");
            ResultSet resultado = comando.executeQuery();
            todasAssinaturas = new ArrayList<>();
            while (resultado.next()) {
                Assinatura a = new Assinatura();
                a.setId(resultado.getInt("id"));
                a.setNome(resultado.getString("nome"));
                a.setPreco(resultado.getDouble("preco"));
                
                todasAssinaturas.add(a);
            }
        }
        return todasAssinaturas;
    }
   
}
