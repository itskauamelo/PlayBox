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
    private double totalAss;

    public Carrinho() {
    }

    public Carrinho(int id, double total, double totalAss) {
        this.id = id;
        this.total = total;
        this.totalAss = totalAss;
    }

    public Carrinho(int id) {
        this.id = id;
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

    public void setTotal(double totalAss) {
        this.totalAss = totalAss;
    }
    
    public double getTotalAss() {
        return totalAss;
    }

    public void setTotalAss(double totalAss) {
        this.totalAss = totalAss;
    }
    
    private List<Pacote> pacotesNoCarrinho = new ArrayList<>();
    
    public void addPacote(Pacote pacote) {
        pacotesNoCarrinho.add(pacote);
    }
    
    private List<Assinatura> assinaturaNoCarrinho = new ArrayList<>();
    
    public void addAssinatura(Assinatura assinatura) {
        assinaturaNoCarrinho.add(assinatura);
    }
    
    public List<Pacote> getPacotesNoCarrinho() {
        return pacotesNoCarrinho;
    }
    
    public List<Assinatura> getAssinaturaNoCarrinho() {
        return assinaturaNoCarrinho;
    }

    public void remover(Pacote pacoteARemover) {
        pacotesNoCarrinho.remove(pacoteARemover);
    }
    
    public void removerAssinatura(Assinatura assinaturaARemover) {
        assinaturaNoCarrinho.remove(assinaturaARemover);
    }
    
    public double calcularTotal() {
        
        total = 0;
        for (Assinatura assinatura : assinaturaNoCarrinho) {
            total += assinatura.getPreco();
        }
        return total;
        
    }
    
    public double precoAssinatura() {
        
        totalAss = 0;
        for (Assinatura assinatura : assinaturaNoCarrinho) {
            totalAss += assinatura.getPreco();
        }
        return totalAss;
        
    }

}
