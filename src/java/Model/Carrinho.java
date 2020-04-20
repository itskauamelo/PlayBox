/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kaua.Morateli
 */
public class Carrinho {
    
    private int id;
    private double total;

    public Carrinho() {
    }

    public Carrinho(int id, double total) {
        this.id = id;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    private List<Pacote> pacotesNoCarrinho = new ArrayList<>();
    
    public void addPacote(Pacote pacote) {
        pacotesNoCarrinho.add(pacote);
    }
    
    public List<Pacote> getPacotesNoCarrinho() {
        return pacotesNoCarrinho;
    }

    public void remover(Pacote pacoteARemover) {
        pacotesNoCarrinho.remove(pacoteARemover);
    }
    
    public double calcularTotal(double total) {
        total = 0;
        for (Pacote pacote : pacotesNoCarrinho) {
            total += pacote.getPreco();
        }
        return total;
    }

    public double calcularTotal() {
        
        total = 0;
        for (Pacote pacote : pacotesNoCarrinho) {
            total += pacote.getPreco();
        }
        return total;
        
    }

}
