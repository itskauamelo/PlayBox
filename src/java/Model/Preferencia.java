/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Kauã Morateli
 */
public class Preferencia {
    
    private String preferencia1;
    private String preferencia2;
    private String preferencia3;
    private String horasjogo;
    private String jogoonline;

    public Preferencia() {
    }

    public Preferencia(String preferencia1, String preferencia2, String preferencia3, String horasjogo, String jogoonline) {
        this.preferencia1 = preferencia1;
        this.preferencia2 = preferencia2;
        this.preferencia3 = preferencia3;
        this.horasjogo = horasjogo;
        this.jogoonline = jogoonline;
    }

    public String getPreferencia1() {
        return preferencia1;
    }

    public void setPreferencia1(String preferencia1) {
        this.preferencia1 = preferencia1;
    }

    public String getPreferencia2() {
        return preferencia2;
    }

    public void setPreferencia2(String preferencia2) {
        this.preferencia2 = preferencia2;
    }

    public String getPreferencia3() {
        return preferencia3;
    }

    public void setPreferencia3(String preferencia3) {
        this.preferencia3 = preferencia3;
    }

    public String getHorasjogo() {
        return horasjogo;
    }

    public void setHorasjogo(String horasjogo) {
        this.horasjogo = horasjogo;
    }

    public String getJogoonline() {
        return jogoonline;
    }

    public void setJogoonline(String jogoonline) {
        this.jogoonline = jogoonline;
    }
    
}
