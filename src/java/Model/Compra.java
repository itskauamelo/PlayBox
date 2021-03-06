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
    private String carrinho;
    private Date data;
    private int status;
    private String cliente;
    private int enderecoentrega;
    private int metodopagamento;
    private int cartaocredito;
    private double total;
    private double totalAss;
    private String tipoCompra;

    public Compra() {
    }

    public Compra(int id, String carrinho, Date data, int status, String cliente, int enderecoentrega, int metodopagamento, int cartaocredito, double total, double totalAss, String tipoCompra) {
        this.id = id;
        this.carrinho = carrinho;
        this.data = data;
        this.status = status;
        this.cliente = cliente;
        this.enderecoentrega = enderecoentrega;
        this.metodopagamento = metodopagamento;
        this.cartaocredito = cartaocredito;
        this.total = total;
        this.totalAss = totalAss;
        this.tipoCompra = tipoCompra;
    }

    public Compra(int id, int status) {
        this.id = id;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(String carrinho) {
        this.carrinho = carrinho;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public int getEnderecoentrega() {
        return enderecoentrega;
    }

    public void setEnderecoentrega(int enderecoentrega) {
        this.enderecoentrega = enderecoentrega;
    }

    public int getMetodopagamento() {
        return metodopagamento;
    }

    public void setMetodopagamento(int metodopagamento) {
        this.metodopagamento = metodopagamento;
    }

    public int getCartaocredito() {
        return cartaocredito;
    }

    public void setCartaocredito(int cartaocredito) {
        this.cartaocredito = cartaocredito;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }   
    
    public double getTotalAss() {
        return totalAss;
    }

    public void setTotalAss(double totalAss) {
        this.totalAss = totalAss;
    }
    
    public String getTipoCompra() {
        return tipoCompra;
    }

    public void setTipoCompra(String tipoCompra) {
        this.tipoCompra = tipoCompra;
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
