/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Produto;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kaua.Morateli
 */
public class ProdutoDAOTest {
    
    @Test
    public void TesteCadastro() {
        
        Produto p = new Produto();
        p.setNome("Camiseta");
        p.setDescricao("Camiseta Gamer");
        p.setImagem("123.png");
        p.setSituacao("ATIVO");
        p.setQuantidade(1);
        p.setPreco(58);
        
        assertEquals("Camiseta", p.getNome());
        
    }
    
}
