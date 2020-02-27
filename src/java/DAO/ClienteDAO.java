/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Cliente;
import Model.Preferencia;
import Util.ConectaBanco;
import java.sql.Connection;
import java.sql.Date;
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
                clienteAutenticado.setNomecompleto(rsCliente.getString("nomecompleto"));
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
            PreparedStatement comando = con.prepareStatement("INSERT INTO cliente VALUES (NEXTVAL('id_cliente'),'DESATIVADO',?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            
            comando.setString(1, cliente.getCpf());
            comando.setString(2, cliente.getNomecompleto());
            comando.setDate(3, (Date) cliente.getDatanascimento()); // validar isso aqui pq eu to em choque
            comando.setString(4, cliente.getGenero());
            comando.setString(5, cliente.getEmail());
            comando.setString(6, cliente.getSenha());
            comando.setString(7, cliente.getCelular());
            comando.setString(8, cliente.getEndidentific());
            comando.setString(9, cliente.getNomedestinatario());
            comando.setString(10, cliente.getCep());
            comando.setString(11, cliente.getEndereco());
            comando.setString(12, cliente.getNumero());
            comando.setString(13, cliente.getComplemento());
            comando.setString(14, cliente.getReferencia());
            comando.setString(15, cliente.getBairro());
            comando.setString(16, cliente.getCidade());
            comando.setString(17, cliente.getEstado());
            
            comando.execute();
        }
    }
    
    
    
    public void cadastrarpreferencia(Preferencia preferencia) throws ClassNotFoundException, SQLException {
        
        try (Connection con = ConectaBanco.getConexao()) {
            PreparedStatement comando = con.prepareStatement("INSERT INTO preferencia VALUES (NEXTVAL('id_preferencia'),?,?,?,?,?)");
            
            comando.setString(1, preferencia.getPreferencia1());
            comando.setString(2, preferencia.getPreferencia2());
            comando.setString(3, preferencia.getPreferencia3());
            comando.setString(4, preferencia.getHorasjogo());
            comando.setString(5, preferencia.getJogoonline());
            
            comando.execute();
        }
    }
    

    public List<Cliente> consultarTodos() throws ClassNotFoundException, SQLException {

        List<Cliente> todosClientes;
        try (Connection con = ConectaBanco.getConexao()) {
            PreparedStatement comando = con.prepareStatement("SELECT * FROM cliente WHERE situacao = 'ATIVO' ORDER BY id");
            ResultSet resultado = comando.executeQuery();
            todosClientes = new ArrayList<>();
            while (resultado.next()) {
                Cliente c = new Cliente();
                c.setId(resultado.getInt("id"));
                c.setCpf(resultado.getString("cpf"));
                c.setNomecompleto(resultado.getString("nomecompleto"));
                c.setDatanascimento(resultado.getDate(""));
                c.setGenero(resultado.getString("genero"));
                c.setEmail(resultado.getString("email"));
                c.setSenha(resultado.getString("senha"));
                c.setCelular(resultado.getString("celular"));
                c.setEndidentific(resultado.getString("endidentific"));
                c.setNomedestinatario(resultado.getString("nomedestinatario"));
                c.setCep(resultado.getString("cep"));
                c.setEndereco(resultado.getString("endereco"));
                c.setNumero(resultado.getString("numero"));
                c.setComplemento(resultado.getString("complemento"));
                c.setReferencia(resultado.getString("referencia"));
                c.setBairro(resultado.getString("bairro"));
                c.setCidade(resultado.getString("cidade"));
                c.setEstado(resultado.getString("estado"));
                c.setSituacao(resultado.getString("situacao"));
                
                todosClientes.add(c);
            }
        }
        return todosClientes;
    }
    
    
    public void ativarCadastro(Cliente cliente) throws ClassNotFoundException, SQLException {
        
        try (Connection con = ConectaBanco.getConexao()) {
            PreparedStatement comando = con.prepareStatement("UPDATE cliente SET situacao = 'ATIVADO' WHERE cpf = ?");
            
            comando.setString(1, cliente.getCpf());

            comando.execute();
        }
    }

    /*
    
    public void Editar(Cliente usuario) throws ClassNotFoundException, SQLException {
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

*/
    
    public void EditarSenha(Cliente cliente) throws ClassNotFoundException, SQLException {
        Connection con = ConectaBanco.getConexao();
        PreparedStatement comando = con.prepareStatement("UPDATE cliente SET senha = ? WHERE id = ?");
        comando.setString(1, cliente.getSenha());
        comando.setInt(2, cliente.getId());
        comando.execute();
    }

    public void Desativar(Cliente cliente) throws ClassNotFoundException, SQLException {
        Connection con = ConectaBanco.getConexao();
        PreparedStatement comando = con.prepareStatement("UPDATE cliente SET situacao = 'INATIVO' WHERE id = ?");
        comando.setInt(1, cliente.getId());
        comando.execute();
    }

    public void consultarporId(Cliente cliente) throws ClassNotFoundException, SQLException {
        Connection con = ConectaBanco.getConexao();
        PreparedStatement comando = con.prepareStatement("SELECT * FROM cliente WHERE id = ?");
        comando.setInt(1, cliente.getId());
        ResultSet resultado = comando.executeQuery();

        if (resultado.next()) {
                cliente.setId(resultado.getInt("id"));
                cliente.setCpf(resultado.getString("cpf"));
                cliente.setNomecompleto(resultado.getString("nomecompleto"));
                cliente.setDatanascimento(resultado.getDate(""));
                cliente.setGenero(resultado.getString("genero"));
                cliente.setEmail(resultado.getString("email"));
                cliente.setSenha(resultado.getString("senha"));
                cliente.setCelular(resultado.getString("celular"));
                cliente.setEndidentific(resultado.getString("endidentific"));
                cliente.setNomedestinatario(resultado.getString("nomedestinatario"));
                cliente.setCep(resultado.getString("cep"));
                cliente.setEndereco(resultado.getString("endereco"));
                cliente.setNumero(resultado.getString("numero"));
                cliente.setComplemento(resultado.getString("complemento"));
                cliente.setReferencia(resultado.getString("referencia"));
                cliente.setBairro(resultado.getString("bairro"));
                cliente.setCidade(resultado.getString("cidade"));
                cliente.setEstado(resultado.getString("estado"));
                cliente.setSituacao(resultado.getString("situacao"));
        }
    }
}
