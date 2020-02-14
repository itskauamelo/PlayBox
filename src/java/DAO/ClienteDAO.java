/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.EnumPerfilAcesso;
import Model.Cliente;
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
public class ClienteDAO {
        
    private static final String AUTENTICA_CLIENTE = "SELECT * FROM cliente WHERE email=? AND senha=?";
    
        public Cliente autenticaCliente(Cliente cliente) throws ClassNotFoundException {
        Cliente clienteAutenticado = null;
        Connection conexao = null;
        PreparedStatement pstmt = null;
        ResultSet rsCliente = null;
        try {
            conexao = ConectaBanco.getConexao();
            pstmt = conexao.prepareStatement(AUTENTICA_CLIENTE);
            pstmt.setString(1, cliente.getEmail());
            pstmt.setString(2, cliente.getSenha());
            rsCliente = pstmt.executeQuery();
            if (rsCliente.next()) {
                clienteAutenticado = new Cliente();
                clienteAutenticado.setEmail(rsCliente.getString("email"));
                clienteAutenticado.setSenha(rsCliente.getString("senha"));
            }
        } catch (SQLException sqlErro) {
            throw new RuntimeException(sqlErro);
        } finally {
            if (conexao != null) {
                try {
                    conexao.close();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
        return clienteAutenticado;
    }

    public void cadastrar(Cliente cliente) throws ClassNotFoundException, SQLException {
        
        try (Connection con = ConectaBanco.getConexao()) {
            PreparedStatement comando = con.prepareStatement("INSERT INTO cliente VALUES (NEXTVAL('id_cliente'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            comando.setString(1, cliente.getCpf());
            comando.setString(2, cliente.getNomecompleto());
            comando.setString(3, cliente.getDatanascimento());
            comando.setString(3, cliente.getGenero());
            comando.setString(3, cliente.getEmail());
            comando.setString(3, cliente.getSenha());
            comando.setString(3, cliente.getCelular());
            comando.setString(3, cliente.getDatanascimento());
            comando.setString(3, cliente.getDatanascimento());
            comando.setString(3, cliente.getDatanascimento());
            comando.setString(3, cliente.getDatanascimento());
            comando.setString(3, cliente.getDatanascimento());
            comando.setString(3, cliente.getDatanascimento());
            comando.setString(3, cliente.getDatanascimento());
            comando.setString(3, cliente.getDatanascimento());
            comando.setString(3, cliente.getDatanascimento());
            comando.setString(3, cliente.getDatanascimento());
            
            
            
            
            
            
            
            
            
            comando.setString(4, cliente.getPerfil().toString());
            comando.setString(5, cliente.getSituacao());
            
            comando.execute();
        }
    }

    public List<Usuario> consultarTodos() throws ClassNotFoundException, SQLException {

        List<Usuario> todosUsuario;
        try (Connection con = ConectaBanco.getConexao()) {
            PreparedStatement comando = con.prepareStatement("SELECT * FROM usuario WHERE situacao = 'ATIVO' ORDER BY id");
            ResultSet resultado = comando.executeQuery();
            todosUsuario = new ArrayList<>();
            while (resultado.next()) {
                Usuario u = new Usuario();
                u.setId(resultado.getInt("id"));
                u.setNome(resultado.getString("nome"));
                u.setLogin(resultado.getString("login"));
                u.setPw(resultado.getString("pw"));
                u.setPerfil(EnumPerfilAcesso.valueOf(resultado.getString("perfil")));
                u.setSituacao(resultado.getString("situacao"));
                
                todosUsuario.add(u);
            }
        }
        return todosUsuario;
    }

    public void Editar(Usuario usuario) throws ClassNotFoundException, SQLException {
        Connection con = ConectaBanco.getConexao();
        PreparedStatement comando = con.prepareStatement("UPDATE usuario SET nome = ?, login = ?, pw = ?, perfil = ?, situacao = ? WHERE id = ?");
        comando.setString(1, usuario.getNome());
        comando.setString(2, usuario.getLogin());
        comando.setString(3, usuario.getPw());
        comando.setString(4, usuario.getPerfil().toString());
        comando.setString(5, usuario.getSituacao());
        comando.setInt(6, usuario.getId());
        comando.execute();
    }

    public void Excluir(Usuario usuario) throws ClassNotFoundException, SQLException {
        Connection con = ConectaBanco.getConexao();
        PreparedStatement comando = con.prepareStatement("UPDATE usuario SET situacao = 'INATIVO' WHERE id = ?");
        comando.setInt(1, usuario.getId());
        comando.execute();
    }

    public void consultarporId(Usuario usuario) throws ClassNotFoundException, SQLException {
        Connection con = ConectaBanco.getConexao();
        PreparedStatement comando = con.prepareStatement("SELECT * FROM usuario WHERE id = ?");
        comando.setInt(1, usuario.getId());
        ResultSet resultado = comando.executeQuery();

        if (resultado.next()) {
            usuario.setNome(resultado.getString("nome"));
            usuario.setLogin(resultado.getString("login"));
            usuario.setPw(resultado.getString("pw"));
            usuario.setPerfil(EnumPerfilAcesso.valueOf(resultado.getString("perfil")));
            usuario.setSituacao(resultado.getString("situacao"));
            usuario.setId(resultado.getInt("id"));
        }
    }
    
}
