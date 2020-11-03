/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Cartao;
import Model.Cliente;
import Model.Compra;
import Model.Endereco;
import Model.Pesquisa;
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
                clienteAutenticado.setId(rsCliente.getInt("id"));
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
            PreparedStatement comando = con.prepareStatement("INSERT INTO cliente VALUES (NEXTVAL('id_cliente'),'DESATIVADO',?,?,?,?,?,?,?)");

            comando.setString(1, cliente.getCpf());
            comando.setString(2, cliente.getNomecompleto());
            comando.setDate(3, (Date) cliente.getDatanascimento());
            comando.setString(4, cliente.getGenero());
            comando.setString(5, cliente.getEmail());
            comando.setString(6, cliente.getSenha());
            comando.setString(7, cliente.getCelular());/*
            comando.setString(8, cliente.getEndidentific());
            comando.setString(9, cliente.getNomedestinatario());
            comando.setString(10, cliente.getCep());
            comando.setString(11, cliente.getEndereco());
            comando.setString(12, cliente.getNumero());
            comando.setString(13, cliente.getComplemento());
            comando.setString(14, cliente.getReferencia());
            comando.setString(15, cliente.getBairro());
            comando.setString(16, cliente.getCidade());
            comando.setString(17, cliente.getEstado());*/

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

    public void cadastrarPesquisa(Pesquisa pesquisa) throws ClassNotFoundException, SQLException {

        try (Connection con = ConectaBanco.getConexao()) {
            PreparedStatement comando = con.prepareStatement("INSERT INTO pesquisacancelamento VALUES (NEXTVAL('id_pesquisa'),?,?,?,?,?)");

            comando.setString(1, pesquisa.getAvaliacao1());
            comando.setString(2, pesquisa.getAvaliacao2());
            comando.setString(3, pesquisa.getAvaliacao3());
            comando.setString(4, pesquisa.getAvaliacao4());
            comando.setString(5, pesquisa.getAvaliacao5());

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
                c.setSituacao(resultado.getString("situacao"));
                c.setCpf(resultado.getString("cpf"));
                c.setNomecompleto(resultado.getString("nomecompleto"));
                c.setDatanascimento(resultado.getDate("datanascimento"));
                c.setGenero(resultado.getString("genero"));
                c.setEmail(resultado.getString("email"));
                c.setSenha(resultado.getString("senha"));
                c.setCelular(resultado.getString("celular"));/*
                c.setEndidentific(resultado.getString("endidentific"));
                c.setNomedestinatario(resultado.getString("nomedestinatario"));
                c.setCep(resultado.getString("cep"));
                c.setEndereco(resultado.getString("endereco"));
                c.setNumero(resultado.getString("numero"));
                c.setComplemento(resultado.getString("complemento"));
                c.setReferencia(resultado.getString("referencia"));
                c.setBairro(resultado.getString("bairro"));
                c.setCidade(resultado.getString("cidade"));
                c.setEstado(resultado.getString("estado"));*/

                todosClientes.add(c);
            }
        }
        return todosClientes;
    }

    public void ativarCadastro(Cliente cliente) throws ClassNotFoundException, SQLException {

        try (Connection con = ConectaBanco.getConexao()) {
            PreparedStatement comando = con.prepareStatement("UPDATE cliente SET situacao = 'ATIVO' WHERE cpf = ?");

            comando.setString(1, cliente.getCpf());

            comando.execute();
        }
    }

    public void adicionarCartao(Cartao cartao, Cliente objcliente) throws ClassNotFoundException, SQLException {

        try (Connection con = ConectaBanco.getConexao()) {
            PreparedStatement comando = con.prepareStatement("INSERT INTO cartaocredito VALUES (NEXTVAL('id_cartaocredito'), ?, ?, ?, ?, ?, ?)");

            comando.setString(1, cartao.getNumero());
            comando.setString(2, cartao.getNomecartao());
            comando.setString(3, cartao.getValidade());
            comando.setInt(4, cartao.getCodigo());
            comando.setString(5, cartao.getBandeira());
            comando.setInt(6, objcliente.getId());

            comando.execute();
        }
    }

    public void cadastrarFk(Compra compra) throws ClassNotFoundException, SQLException {

        try (Connection con = ConectaBanco.getConexao()) { //ARRUMAR
            PreparedStatement comando = con.prepareStatement("UPDATE compra\n"
                    + "SET clienteFk = (SELECT id FROM Cliente WHERE nomecompleto= ?)\n"
                    + "WHERE id IN (SELECT MAX(ID) FROM compra)");

            comando.setString(1, compra.getCliente());

            comando.execute();
        }
    }

    public void adicionarEndereco(Endereco endereco, Cliente objcliente) throws ClassNotFoundException, SQLException {

        try (Connection con = ConectaBanco.getConexao()) {
            PreparedStatement comando = con.prepareStatement("INSERT INTO endereco VALUES (NEXTVAL('id_endereco'), ?, ?, ?, ?, ?, ?, ?, ?)");

            comando.setInt(1, endereco.getCep());
            comando.setString(2, endereco.getRua());
            comando.setInt(3, endereco.getNumero());
            comando.setString(4, endereco.getComplemento());
            comando.setString(5, endereco.getBairro());
            comando.setString(6, endereco.getCidade());
            comando.setString(7, endereco.getUf());
            comando.setInt(8, objcliente.getId());

            comando.execute();
        }
    }

    public List<Cartao> consultarTodosCartoes() throws ClassNotFoundException, SQLException {

        List<Cartao> todosCartoes;
        try (Connection con = ConectaBanco.getConexao()) {
            PreparedStatement comando = con.prepareStatement("SELECT * FROM cartaocredito ORDER BY id");
            ResultSet resultado = comando.executeQuery();
            todosCartoes = new ArrayList<>();
            while (resultado.next()) {
                Cartao c = new Cartao();
                c.setId(resultado.getInt("id"));
                c.setBandeira(resultado.getString("bandeira"));
                todosCartoes.add(c);
            }
        }
        return todosCartoes;
    }

    public List<Endereco> consultarTodosEnderecos() throws ClassNotFoundException, SQLException {

        List<Endereco> todosEnderecos;
        try (Connection con = ConectaBanco.getConexao()) {
            PreparedStatement comando = con.prepareStatement("SELECT * FROM endereco ORDER BY id");
            ResultSet resultado = comando.executeQuery();
            todosEnderecos = new ArrayList<>();
            while (resultado.next()) {
                Endereco e = new Endereco();
                e.setId(resultado.getInt("id"));
                e.setCep(Integer.valueOf(resultado.getString("cep")));
                e.setNumero(Integer.valueOf(resultado.getString("numero")));
                todosEnderecos.add(e);
            }
        }
        return todosEnderecos;
    }

    public List<Cartao> consultarMeusCartoes(Cliente objcliente) throws ClassNotFoundException, SQLException {

        List<Cartao> todosCartoes;
        try (Connection con = ConectaBanco.getConexao()) {
            PreparedStatement comando = con.prepareStatement("SELECT * FROM cartaocredito where clientefk = ? ORDER BY id");
            comando.setInt(1, objcliente.getId());
            ResultSet resultado = comando.executeQuery();
            todosCartoes = new ArrayList<>();
            while (resultado.next()) {
                Cartao c = new Cartao();
                c.setId(resultado.getInt("id"));
                c.setBandeira(resultado.getString("bandeira"));
                todosCartoes.add(c);
            }
        }
        return todosCartoes;
    }

    public List<Endereco> consultarMeusEnderecos(Cliente objcliente) throws ClassNotFoundException, SQLException {

        List<Endereco> todosEnderecos;
        try (Connection con = ConectaBanco.getConexao()) {
            PreparedStatement comando = con.prepareStatement("SELECT * FROM endereco where clientefk = ? ORDER BY id");
            comando.setInt(1, objcliente.getId());
            ResultSet resultado = comando.executeQuery();
            todosEnderecos = new ArrayList<>();
            while (resultado.next()) {
                Endereco e = new Endereco();
                e.setId(resultado.getInt("id"));
                e.setCep(Integer.valueOf(resultado.getString("cep")));
                e.setNumero(Integer.valueOf(resultado.getString("numero")));
                todosEnderecos.add(e);
            }
        }
        return todosEnderecos;
    }

    public List<Preferencia> consultarTodasPreferencias() throws ClassNotFoundException, SQLException {

        List<Preferencia> todasPreferencias;
        try (Connection con = ConectaBanco.getConexao()) {
            PreparedStatement comando = con.prepareStatement("SELECT * FROM preferencia ORDER BY id");
            ResultSet resultado = comando.executeQuery();
            todasPreferencias = new ArrayList<>();
            while (resultado.next()) {
                Preferencia p = new Preferencia();
                p.setPreferencia1(resultado.getString("preferencia1"));
                p.setPreferencia2(resultado.getString("preferencia2"));
                p.setPreferencia3(resultado.getString("preferencia3"));
                p.setHorasjogo(resultado.getString("horasjogo"));
                p.setJogoonline(resultado.getString("jogoonline"));
                todasPreferencias.add(p);
            }
        }
        return todasPreferencias;
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

    public void removerAssinatura(Cliente objcliente) throws SQLException, ClassNotFoundException {
        Connection con = ConectaBanco.getConexao();
        PreparedStatement comando = con.prepareStatement("UPDATE cliente SET assinaturaFK = NULL, cobranca = NULL WHERE id = ?");
        comando.setInt(1, objcliente.getId());
        comando.execute();

    }

    public void Editar(Cliente cliente) throws ClassNotFoundException, SQLException {
        Connection con = ConectaBanco.getConexao();
        PreparedStatement comando = con.prepareStatement("UPDATE cliente SET cpf = ?, nomecompleto = ?, genero = ?, datanascimento = ?, email = ?, celular = ? WHERE id = ?");
        comando.setString(1, cliente.getCpf());
        comando.setString(2, cliente.getNomecompleto());
        comando.setString(3, cliente.getGenero());
        comando.setDate(4, (Date) cliente.getDatanascimento());
        comando.setString(5, cliente.getEmail());
        comando.setString(6, cliente.getCelular());
        comando.setInt(7, cliente.getId());
        comando.execute();
    }

    public void consultarporId(Cliente cliente) throws ClassNotFoundException, SQLException {
        Connection con = ConectaBanco.getConexao();
        PreparedStatement comando = con.prepareStatement("SELECT * FROM cliente WHERE id = ?");
        comando.setInt(1, cliente.getId());
        ResultSet resultado = comando.executeQuery();

        if (resultado.next()) {
            cliente.setId(resultado.getInt("id"));
            cliente.setSituacao(resultado.getString("situacao"));
            cliente.setCpf(resultado.getString("cpf"));
            cliente.setNomecompleto(resultado.getString("nomecompleto"));
            cliente.setDatanascimento(resultado.getDate("datanascimento"));
            cliente.setGenero(resultado.getString("genero"));
            cliente.setEmail(resultado.getString("email"));
            cliente.setSenha(resultado.getString("senha"));
            cliente.setCelular(resultado.getString("celular"));/*
                cliente.setEndidentific(resultado.getString("endidentific"));
                cliente.setNomedestinatario(resultado.getString("nomedestinatario"));
                cliente.setCep(resultado.getString("cep"));
                cliente.setEndereco(resultado.getString("endereco"));
                cliente.setNumero(resultado.getString("numero"));
                cliente.setComplemento(resultado.getString("complemento"));
                cliente.setReferencia(resultado.getString("referencia"));
                cliente.setBairro(resultado.getString("bairro"));
                cliente.setCidade(resultado.getString("cidade"));
                cliente.setEstado(resultado.getString("estado"));*/
        }
    }

    public List<Cliente> consultarClientesCadastrados() throws ClassNotFoundException, SQLException {

        List<Cliente> todosClientesCadastrados;
        try (Connection con = ConectaBanco.getConexao()) {
            PreparedStatement comando = con.prepareStatement("select id,datahora,cpf,nomecompleto,datanascimento,genero,email,celular from log_novo_cliente");
            ResultSet resultado = comando.executeQuery();
            todosClientesCadastrados = new ArrayList<>();
            while (resultado.next()) {
                Cliente c = new Cliente();
                c.setId(resultado.getInt("id"));
                c.setDatahora(resultado.getDate("datahora"));
                c.setCpf(resultado.getString("cpf"));
                c.setNomecompleto(resultado.getString("nomecompleto"));
                c.setDatanascimento(resultado.getDate("datanascimento"));
                c.setGenero(resultado.getString("genero"));
                c.setEmail(resultado.getString("email"));
                c.setCelular(resultado.getString("celular"));

                todosClientesCadastrados.add(c);
            }
        }
        return todosClientesCadastrados;
    }

    public List<Pesquisa> consultarPesquisasCadastradas() throws ClassNotFoundException, SQLException {

        List<Pesquisa> todasPesquisas;
        try (Connection con = ConectaBanco.getConexao()) {
            PreparedStatement comando = con.prepareStatement("SELECT * FROM pesquisacancelamento");
            ResultSet resultado = comando.executeQuery();
            todasPesquisas = new ArrayList<>();
            while (resultado.next()) {
                Pesquisa p = new Pesquisa();
                p.setAvaliacao1(resultado.getString("avaliacao1"));
                p.setAvaliacao2(resultado.getString("avaliacao2"));
                p.setAvaliacao3(resultado.getString("avaliacao3"));
                p.setAvaliacao4(resultado.getString("avaliacao4"));
                p.setAvaliacao5(resultado.getString("avaliacao5"));

                todasPesquisas.add(p);
            }
        }
        return todasPesquisas;
    }
}
