/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Kaua Morateli
 */
public class Assinatura {
    
    public int id;
    public String nome;
    public double preco;

    public Assinatura() {
    }

    public Assinatura(int id, String nome, double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public Assinatura(int id, String nome) {
        this.id = id;
        this.nome = nome;
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

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

        @Override
    public boolean equals(Object obj) {
        try {
            Assinatura a = (Assinatura) obj;
            return a.getId() == id;
        } catch (Exception e) {
            return false;
        }
    }

    
}
