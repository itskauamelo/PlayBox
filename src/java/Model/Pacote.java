/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Renato Alberti
 */
public class Pacote {
    
    public int id;
    public String nome;
    public int jogo;
    public int camiseta;
    public int brinde1;
    public int brinde2;
    public int brinde3;
    public int brinde4;
    public int brinde5;
    public String situacao;
    public double preco;

    public Pacote() {
    }

    
    
    public Pacote(int id, String nome, int jogo, int camiseta, int brinde1, int brinde2, int brinde3, int brinde4, int brinde5, String situacao, double preco) {
        this.id = id;
        this.nome = nome;
        this.jogo = jogo;
        this.camiseta = camiseta;
        this.brinde1 = brinde1;
        this.brinde2 = brinde2;
        this.brinde3 = brinde3;
        this.brinde4 = brinde4;
        this.brinde5 = brinde5;
        this.situacao = situacao;
        this.preco = preco;
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

    public int getJogo() {
        return jogo;
    }

    public void setJogo(int jogo) {
        this.jogo = jogo;
    }

    public int getCamiseta() {
        return camiseta;
    }

    public void setCamiseta(int camiseta) {
        this.camiseta = camiseta;
    }

    public int getBrinde1() {
        return brinde1;
    }

    public void setBrinde1(int brinde1) {
        this.brinde1 = brinde1;
    }

    public int getBrinde2() {
        return brinde2;
    }

    public void setBrinde2(int brinde2) {
        this.brinde2 = brinde2;
    }

    public int getBrinde3() {
        return brinde3;
    }

    public void setBrinde3(int brinde3) {
        this.brinde3 = brinde3;
    }

    public int getBrinde4() {
        return brinde4;
    }

    public void setBrinde4(int brinde4) {
        this.brinde4 = brinde4;
    }

    public int getBrinde5() {
        return brinde5;
    }

    public void setBrinde5(int brinde5) {
        this.brinde5 = brinde5;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    
}
