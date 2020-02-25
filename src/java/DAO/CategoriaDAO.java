/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Categoria;
import Util.ConectaBanco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kaua.Morateli
 */
public class CategoriaDAO {
    
    
    public void cadastrar(Categoria categoria) throws ClassNotFoundException, SQLException {
        
        try (Connection con = ConectaBanco.getConexao()) {
            PreparedStatement comando = con.prepareStatement("INSERT INTO categoria VALUES (NEXTVAL('id_categoria'),?)");
            comando.setString(1, categoria.getCategoria());
            
            comando.execute();
        }
    }

    public List<Categoria> consultarTodos() throws ClassNotFoundException, SQLException {

        List<Categoria> todosPacotes;
        try (Connection con = ConectaBanco.getConexao()) {
            PreparedStatement comando = con.prepareStatement("SELECT * FROM categoria ORDER BY id");
            ResultSet resultado = comando.executeQuery();
            todosPacotes = new ArrayList<>();
            while (resultado.next()) {
                Categoria c = new Categoria();
                c.setId(resultado.getInt("id"));
                c.setCategoria(resultado.getString("categoria"));

                
                todosPacotes.add(c);
            }
        }
        return todosPacotes;
    }

    public void Editar(Categoria categoria) throws ClassNotFoundException, SQLException {
        Connection con = ConectaBanco.getConexao();
        PreparedStatement comando = con.prepareStatement("UPDATE categoria SET categoria = ? WHERE id = ?");
        comando.setString(1, categoria.getCategoria());
        comando.setInt(2, categoria.getId());
        comando.execute();
    }

    public void Excluir(Categoria categoria) throws ClassNotFoundException, SQLException {
        Connection con = ConectaBanco.getConexao();
        PreparedStatement comando = con.prepareStatement("DELETE FROM categoria WHERE id = ?");
        comando.setInt(1, categoria.getId());
        comando.execute();
    }

    public void consultarporId(Categoria categoria) throws ClassNotFoundException, SQLException {
        Connection con = ConectaBanco.getConexao();
        PreparedStatement comando = con.prepareStatement("SELECT * FROM categoria WHERE id = ?");
        comando.setInt(1, categoria.getId());
        ResultSet resultado = comando.executeQuery();

        if (resultado.next()) {
            categoria.setCategoria(resultado.getString("categoria"));
            categoria.setId(resultado.getInt("id"));
        }
    }
    
}
