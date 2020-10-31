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
public class Relatorio {
    
    public String quantidade;
    public String mes;
    public String ano;
    public String mesano;
    public String status;
    public String assinatura;

    public Relatorio() {
    }

    public Relatorio(String quantidade, String mes, String ano) {
        this.quantidade = quantidade;
        this.mes = mes;
        this.ano = ano;
    }

    public Relatorio(String quantidade, String mes, String ano, String mesano) {
        this.quantidade = quantidade;
        this.mes = mes;
        this.ano = ano;
        this.mesano = mesano;
    }

    public String getAssinatura() {
        return assinatura;
    }

    public void setAssinatura(String assinatura) {
        this.assinatura = assinatura;
    }

    public Relatorio(String quantidade, String status) {
        this.quantidade = quantidade;
        this.status = status;
    }
    
    

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getMesano() {
        return mesano;
    }

    public void setMesano(String mesano) {
        this.mesano = mesano;
    }

}
