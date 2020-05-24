package DAO;

import Model.Game;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Util.ConectaBanco;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class GameDAO {

    public void cadastrar(Game game) throws ClassNotFoundException, SQLException {
        
        try (Connection con = ConectaBanco.getConexao()) {
            PreparedStatement comando = con.prepareStatement("INSERT INTO games VALUES (NEXTVAL('id_game'),?,?,?,?,?,?,?)");
            comando.setString(1, game.getNome());
            comando.setString(2, game.getDescricao());
            comando.setString(3, game.getPlataforma());
            comando.setString(4, game.getImagem());
            comando.setString(5, game.getSituacao());
            comando.setInt(6, game.getQuantidade());
            comando.setDouble(7, game.getPreco());
            
            comando.execute();
        }
    }

    public List<Game> consultarTodos() throws ClassNotFoundException, SQLException {

        List<Game> todosGames;
        try (Connection con = ConectaBanco.getConexao()) {
            PreparedStatement comando = con.prepareStatement("SELECT * FROM games ORDER BY id WHERE situacao = ''");
            ResultSet resultado = comando.executeQuery();
            todosGames = new ArrayList<>();
            while (resultado.next()) {
                Game g = new Game();
                g.setId(resultado.getInt("id"));
                g.setNome(resultado.getString("nome"));
                g.setDescricao(resultado.getString("descricao"));
                g.setPlataforma(resultado.getString("plataforma"));
                g.setImagem(resultado.getString("imagem"));
                g.setSituacao(resultado.getString("situacao"));
                g.setQuantidade(resultado.getInt("quantidade"));
                g.setPreco(resultado.getDouble("preco"));
                
                todosGames.add(g);
            }
        }
        return todosGames;
    }
    
        public List<Game> listarOpt(){
        List<Game> games = new ArrayList<>();       
        
        try {
            
            Connection conexao = ConectaBanco.getConexao();
            String sql = "SELECT * FROM GAMES";
            
            PreparedStatement pstmt = conexao.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
                games.add(new Game(rs.getInt("id"), rs.getString("nome")));
            }
 
        } catch (Exception e) {
        }
        
        return games;
    }

    public void Editar(Game game) throws ClassNotFoundException, SQLException {
        Connection con = ConectaBanco.getConexao();
        PreparedStatement comando = con.prepareStatement("UPDATE games SET nome = ?, descricao = ?, plataforma = ?, imagem = ?, situacao = ?, quantidade = ?, preco = ? WHERE id = ?");
        comando.setString(1, game.getNome());
        comando.setString(2, game.getDescricao());
        comando.setString(3, game.getPlataforma());
        comando.setString(4, game.getImagem());
        comando.setString(5, game.getSituacao());
        comando.setInt(6, game.getQuantidade());
        comando.setDouble(7, game.getPreco());
        comando.setInt(8, game.getId());
        comando.execute();
    }

    public void Desativar(Game game) throws ClassNotFoundException, SQLException {
        Connection con = ConectaBanco.getConexao();
        PreparedStatement comando = con.prepareStatement("UPDATE games SET situacao = 'INATIVO' WHERE id = ?");
        comando.setInt(1, game.getId());
        comando.execute();
    }

    public void consultarporId(Game game) throws ClassNotFoundException, SQLException {
        Connection con = ConectaBanco.getConexao();
        PreparedStatement comando = con.prepareStatement("SELECT * FROM games WHERE id = ?");
        comando.setInt(1, game.getId());
        ResultSet resultado = comando.executeQuery();

        if (resultado.next()) {
            game.setNome(resultado.getString("nome"));
            game.setDescricao(resultado.getString("descricao"));
            game.setPlataforma(resultado.getString("plataforma"));
            game.setImagem(resultado.getString("imagem"));
            game.setSituacao(resultado.getString("situacao"));
            game.setQuantidade(resultado.getInt("quantidade"));
            game.setPreco(resultado.getDouble("preco"));
            game.setId(resultado.getInt("id"));
        }
    }
}
