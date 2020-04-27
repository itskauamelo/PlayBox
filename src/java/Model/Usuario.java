/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Kauã Morateli
 */


public class Usuario {
    
    private int id;
    private String nome;
    private String login;
    private String pw;
    private EnumPerfilAcesso perfil;
    private String situacao;

    public Usuario(int id, String nome, String login, String pw, EnumPerfilAcesso perfil, String situacao) {
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.pw = pw;
        this.perfil = perfil;
        this.situacao = situacao;
    }

    public Usuario() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public EnumPerfilAcesso getPerfil() {
        return perfil;
    }

    public void setPerfil(EnumPerfilAcesso perfil) {
        this.perfil = perfil;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public void getPerfil(String administrador) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
