package Movil.Dao;

import Movil.Data.Movil;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author ricar
 */
public interface MovilDao {
    
   public ArrayList<Movil> list();
   public void addMovil(Movil movil);
   public void updateMovil(Movil movil, Double identificacion);
   public void deleteMovil(Double identificacion);
   public ArrayList<Movil> listMivilActive();
   
}
