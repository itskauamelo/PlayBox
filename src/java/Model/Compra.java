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
    private Usuario usuario;
    private Date data;
    private Carrinho carrinho;
    private double total;

    public Compra() {
    }

    public Compra(int id, Usuario usuario, Date data, Carrinho carrinho, double total) {
        this.id = id;
        this.usuario = usuario;
        this.data = data;
        this.carrinho = carrinho;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    public static Comparator<Compra> ordenar_por_data_desc = new Comparator<Compra>() {
        @Override
        public int compare(Compra o1, Compra o2) {
        return o2.getData().compareTo(o1.getData());
        
        }
    };
}
