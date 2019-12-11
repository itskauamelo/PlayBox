/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author alunocmc
 */
public class Camiseta {
    
    public int id;
    public String nome;
    public String descricao;
    public String sexo;
    public String tamanho;
    public String imagem;
    public String situacao;
    public int quantidade;
    public double preço;


    public Camiseta() {
    }

    public Camiseta(int id, String nome, String descricao, String sexo, String tamanho, String imagem, int quantidade, double preço) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.sexo = sexo;
        this.tamanho = tamanho;
        this.imagem = imagem;
        this.quantidade = quantidade;
        this.preço = preço;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreço() {
        return preço;
    }

    public void setPreço(double preço) {
        this.preço = preço;
    }
    
    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    
    
    
    
}
