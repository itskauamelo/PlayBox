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
    
    private int id;
    private String cpf;
    private String nomecompleto;
    private Date datanascimento;
    private String genero;
    private String email;
    private String senha;
    private String celular;
    private String endidentific;
    private String nomedestinatario;
    private String cep;
    private String endereco;
    private String numero;
    private String complemento;
    private String referencia;
    private String bairro;
    private String cidade;
    private String estado;
    private String situacao;

    public Cliente() {
    }

    public Cliente(int id, String cpf, String nomecompleto, Date datanascimento, String genero, String email, String senha, String celular, String endidentific, String nomedestinatario, String cep, String endereco, String numero, String complemento, String referencia, String bairro, String cidade, String estado, String situacao) {
        this.id = id;
        this.cpf = cpf;
        this.nomecompleto = nomecompleto;
        this.datanascimento = datanascimento;
        this.genero = genero;
        this.email = email;
        this.senha = senha;
        this.celular = celular;
        this.endidentific = endidentific;
        this.nomedestinatario = nomedestinatario;
        this.cep = cep;
        this.endereco = endereco;
        this.numero = numero;
        this.complemento = complemento;
        this.referencia = referencia;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.situacao = situacao;
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

    public String getEndidentific() {
        return endidentific;
    }

    public void setEndidentific(String endidentific) {
        this.endidentific = endidentific;
    }

    public String getNomedestinatario() {
        return nomedestinatario;
    }

    public void setNomedestinatario(String nomedestinatario) {
        this.nomedestinatario = nomedestinatario;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

}
