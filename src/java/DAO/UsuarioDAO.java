package DAO;

import Model.EnumPerfilAcesso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Model.Usuario;
import Util.ConectaBanco;


public class UsuarioDAO {
    
    private static final String AUTENTICA_USUARIO = "SELECT * FROM usuario WHERE login=? AND pw=?";
    
        public Usuario autenticaUsuario(Usuario usuario) throws ClassNotFoundException {
        Usuario usuarioAutenticado = null;
        Connection conexao = null;
        PreparedStatement pstmt = null;
        ResultSet rsUsuario = null;
        try {
            conexao = ConectaBanco.getConexao();
            pstmt = conexao.prepareStatement(AUTENTICA_USUARIO);
            pstmt.setString(1, usuario.getLogin());
            pstmt.setString(2, usuario.getPw());
            rsUsuario = pstmt.executeQuery();
            if (rsUsuario.next()) {
                usuarioAutenticado = new Usuario();
                usuarioAutenticado.setLogin(rsUsuario.getString("login"));
                usuarioAutenticado.setPw(rsUsuario.getString("pw"));
                usuarioAutenticado.setPerfil(EnumPerfilAcesso.valueOf(rsUsuario.getString("perfil")));
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
        return usuarioAutenticado;
    }

    public void cadastrar(Usuario usuario) throws ClassNotFoundException, SQLException {
        
        try (Connection con = ConectaBanco.getConexao()) {
            PreparedStatement comando = con.prepareStatement("INSERT INTO usuario VALUES (NEXTVAL('id_user'),?,?,?,?,?)");
            comando.setString(1, usuario.getNome());
            comando.setString(2, usuario.getLogin());
            comando.setString(3, usuario.getPw());
            comando.setString(4, usuario.getPerfil().toString());
            comando.setString(5, usuario.getSituacao());
            
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
