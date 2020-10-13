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
    public String assinatura;
    public String jogo;
    public String camiseta;
    public String brinde1;
    public String brinde2;
    public String brinde3;
    public String brinde4;
    public String brinde5;
    public String situacao;
    public int quantidade;
    public double preco;

    public Pacote() {
    }

    public Pacote(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Pacote(int id, String nome, String assinatura, String jogo, String camiseta, String brinde1, String brinde2, String brinde3, String brinde4, String brinde5, String situacao, int quantidade, double preco) {
        this.id = id;
        this.nome = nome;
        this.assinatura = assinatura;
        this.jogo = jogo;
        this.camiseta = camiseta;
        this.brinde1 = brinde1;
        this.brinde2 = brinde2;
        this.brinde3 = brinde3;
        this.brinde4 = brinde4;
        this.brinde5 = brinde5;
        this.situacao = situacao;
        this.quantidade = quantidade;
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

    public String getAssinatura() {
        return assinatura;
    }

    public void setAssinatura(String assinatura) {
        this.assinatura = assinatura;
    }

    public String getJogo() {
        return jogo;
    }

    public void setJogo(String jogo) {
        this.jogo = jogo;
    }

    public String getCamiseta() {
        return camiseta;
    }

    public void setCamiseta(String camiseta) {
        this.camiseta = camiseta;
    }

    public String getBrinde1() {
        return brinde1;
    }

    public void setBrinde1(String brinde1) {
        this.brinde1 = brinde1;
    }

    public String getBrinde2() {
        return brinde2;
    }

    public void setBrinde2(String brinde2) {
        this.brinde2 = brinde2;
    }

    public String getBrinde3() {
        return brinde3;
    }

    public void setBrinde3(String brinde3) {
        this.brinde3 = brinde3;
    }

    public String getBrinde4() {
        return brinde4;
    }

    public void setBrinde4(String brinde4) {
        this.brinde4 = brinde4;
    }

    public String getBrinde5() {
        return brinde5;
    }

    public void setBrinde5(String brinde5) {
        this.brinde5 = brinde5;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    
    
        @Override
    public boolean equals(Object obj) {
        try {
            Pacote p = (Pacote) obj;
            return p.getId() == id;
        } catch (Exception e) {
            return false;
        }
    }

    
}
