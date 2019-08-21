/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frecuence.Dao;

import Frecuence.Data.Frecuence;
import Frecuence.Data.FrecuenceMovil;
import Movil.Data.Movil;
import java.util.ArrayList;

/**
 *
 * @author ricar
 */
public interface FrecuenceDaoInterface {
    
    public boolean createFrecuence(Frecuence frecuence);
    public ArrayList<Frecuence> getFrecuence();
    public void relationFrecueMovil(ArrayList<Movil> movil, Frecuence frecuence);
    public ArrayList<FrecuenceMovil> loadFrecuence(Integer idFrecuence);
}
