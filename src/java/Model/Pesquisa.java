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
public class Pesquisa {
    
    private String avaliacao1;
    private String avaliacao2;
    private String avaliacao3;
    private String avaliacao4;
    private String avaliacao5;

    public Pesquisa() {
    }

    public Pesquisa(String avaliacao1, String avaliacao2, String avaliacao3, String avaliacao4, String avaliacao5) {
        this.avaliacao1 = avaliacao1;
        this.avaliacao2 = avaliacao2;
        this.avaliacao3 = avaliacao3;
        this.avaliacao4 = avaliacao4;
        this.avaliacao5 = avaliacao5;
    }

    public String getAvaliacao1() {
        return avaliacao1;
    }

    public void setAvaliacao1(String avaliacao1) {
        this.avaliacao1 = avaliacao1;
    }

    public String getAvaliacao2() {
        return avaliacao2;
    }

    public void setAvaliacao2(String avaliacao2) {
        this.avaliacao2 = avaliacao2;
    }

    public String getAvaliacao3() {
        return avaliacao3;
    }

    public void setAvaliacao3(String avaliacao3) {
        this.avaliacao3 = avaliacao3;
    }

    public String getAvaliacao4() {
        return avaliacao4;
    }

    public void setAvaliacao4(String avaliacao4) {
        this.avaliacao4 = avaliacao4;
    }

    public String getAvaliacao5() {
        return avaliacao5;
    }

    public void setAvaliacao5(String avaliacao5) {
        this.avaliacao5 = avaliacao5;
    }
    
}
