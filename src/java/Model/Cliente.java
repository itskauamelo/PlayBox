/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author Kaua.Morateli
 */
public class Cliente {
    private Date datahora; 
    private int id;
    private String cpf;
    private String nomecompleto;
    private Date datanascimento;
    private String genero;
    private String email;
    private String senha;
    private String celular;
    private String situacao;
    private String assinatura;

    public Cliente() {
    }

    public Cliente(Date datahora, int id, String cpf, String nomecompleto, Date datanascimento, String genero, String email, String senha, String celular, String situacao, String assinatura) {
        this.datahora = datahora;
        this.id = id;
        this.cpf = cpf;
        this.nomecompleto = nomecompleto;
        this.datanascimento = datanascimento;
        this.genero = genero;
        this.email = email;
        this.senha = senha;
        this.celular = celular;
        this.situacao = situacao;
        this.assinatura = assinatura;
    }

    public Cliente(int id, String cpf, String nomecompleto, Date datanascimento, String genero, String email, String senha, String celular, String situacao) {
        this.id = id;
        this.cpf = cpf;
        this.nomecompleto = nomecompleto;
        this.datanascimento = datanascimento;
        this.genero = genero;
        this.email = email;
        this.senha = senha;
        this.celular = celular;
        this.situacao = situacao;
    }
    
    

    public Date getDatahora() {
        return datahora;
    }

    public void setDatahora(Date datahora) {
        this.datahora = datahora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNomecompleto() {
        return nomecompleto;
    }

    public void setNomecompleto(String nomecompleto) {
        this.nomecompleto = nomecompleto;
    }

    public Date getDatanascimento() {
        return datanascimento;
    }

    public void setDatanascimento(Date datanascimento) {
        this.datanascimento = datanascimento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getAssinatura() {
        return assinatura;
    }

    public void setAssinatura(String assinatura) {
        this.assinatura = assinatura;
    }



}
