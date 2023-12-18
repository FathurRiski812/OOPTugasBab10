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
public class PajakPersen extends Pajak {
    int pajakPersen;
   @Override
   int hitungPajak(){
       int harga = Integer.parseInt(hargajual);
               
       harga = (harga * pajakPersen / 100);
       pajak = harga;
       
       return harga;
   }
}
