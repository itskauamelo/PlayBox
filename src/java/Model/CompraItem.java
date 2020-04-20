/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Kaua.Morateli
 */
public class CompraItem {
    
    private int id;
    private Pacote pacote;
    private int quantidade;
    private double total;

    public CompraItem() {
    }

    public CompraItem(int id, Pacote pacote, int quantidade, double total) {
        this.id = id;
        this.pacote = pacote;
        this.quantidade = quantidade;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pacote getPacote() {
        return pacote;
    }

    public void setPacote(Pacote pacote) {
        this.pacote = pacote;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getTotal() {
        this.total = this.quantidade * this.pacote.getPreco();
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    
    
}
