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
    
    public double calcularTotal() {
        double total = 0;
        for (Pacote pacote : pacotesNoCarrinho) {
            total += pacote.getPreco();
        }
        return total;
    }
}
