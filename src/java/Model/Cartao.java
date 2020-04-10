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
public class Cartao {
    
    private int id;
    private String numero;
    private String nomecartao;
    private String validade;
    private int codigo;
    private String bandeira;
    private String cliente;

    public Cartao() {
    }

    public Cartao(int id, String numero, String nomecartao, String validade, int codigo, String bandeira, String cliente) {
        this.id = id;
        this.numero = numero;
        this.nomecartao = nomecartao;
        this.validade = validade;
        this.codigo = codigo;
        this.bandeira = bandeira;
        this.cliente = cliente;
    }

    public Cartao(int id, String bandeira) {
        this.id = id;
        this.bandeira = bandeira;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNomecartao() {
        return nomecartao;
    }

    public void setNomecartao(String nomecartao) {
        this.nomecartao = nomecartao;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    

}
