/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Movil.Temp;

import Movil.Data.Movil;
import java.util.ArrayList;

/**
 *
 * @author ricar
 */
public class MovilTemp {
  private ArrayList<Movil> listMovil;
  private Movil select;
  private Movil aux;
  private Double identificacion;
   

    public MovilTemp() {
      this.listMovil = new ArrayList<Movil>();
      select = new Movil();
      aux=new Movil();
           
    }
   
   

    public ArrayList<Movil> getListMovil() {
        return listMovil;
    }

    public void setListMovil(ArrayList<Movil> listMovil) {
        this.listMovil = listMovil;
    }

    public Movil getSelect() {
        return select;
    }

    public void setSelect(Movil select) {
        this.select = select;
    }

    public void setAux(Movil add) {
        this.aux = add;
    }

    public Movil getAux() {
        return aux;
    }

    public void setIdentificacion(Double identificacion) {
        this.identificacion = identificacion;
    }

    public Double getIdentificacion() {
        return identificacion;
    }
   
    
    
   
   
}
