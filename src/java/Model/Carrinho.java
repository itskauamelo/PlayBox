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
    
    private List<Game> jogosNoCarrinho = new ArrayList<>();
    
    public void addJogo(Game jogo) {
        jogosNoCarrinho.add(jogo);
    }
    
    public List<Game> getJogosNoCarrinho() {
        return jogosNoCarrinho;
    }

    public void remover(Game jogoARemover) {
        jogosNoCarrinho.remove(jogoARemover);
    }
    
    public double calcularTotal() {
        double total = 0;
        for (Game jogo : jogosNoCarrinho) {
            total += jogo.getPreco();
        }
        return total;
    }
}
