/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Comparator;
import java.util.Date;

/**
 *
 * @author Kaua.Morateli
 */
public class Compra {
    
    private int id;
    private Carrinho carrinho;
    private Date data;
    private double total;

    public Compra() {
    }

    public Compra(int id, Carrinho carrinho, Date data, double total) {
        this.id = id;
        this.carrinho = carrinho;
        this.data = data;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    
/*
    public static Comparator<Compra> getOrdenar_por_data_desc() {
        return ordenar_por_data_desc;
    }

    public static void setOrdenar_por_data_desc(Comparator<Compra> ordenar_por_data_desc) {
        Compra.ordenar_por_data_desc = ordenar_por_data_desc;
    }

    
    
    public static Comparator<Compra> ordenar_por_data_desc = new Comparator<Compra>() {
        @Override
        public int compare(Compra o1, Compra o2) {
        return o2.getData().compareTo(o1.getData());
        
        }
    };*/

}
