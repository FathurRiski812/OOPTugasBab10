/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TUGASPRAKOOP9;

import TUGASPRAKOOP8.*;


/**
 *
 * @author Fatur Riski
 */
public class ClassObat {
    public String namaobat,jenisobat;
    private String kodeobat; // mengubah variabel kodeobat menjadi private
    
    public String getKodeobat() { // menambahkan Getter variabel kodeobat
        return kodeobat;
    }
    public void setKodeobat(String kodeobat) { // menambahkan Setter variabel kodeobat
        this.kodeobat = kodeobat;
    }

    void dataNamaobat(String Namaobat){
        this.namaobat = Namaobat;
    }
    void datajenisobat(String jenisobat){
        this.jenisobat = jenisobat;
    }

}
