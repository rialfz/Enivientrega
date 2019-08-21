/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Movil.Impl;

import Movil.Temp.MovilTemp;

/**
 *
 * @author ricar
 */
public interface MovilImpl {
    
    public void list(MovilTemp temp);
    public void addMovil(MovilTemp temp);
    public void copy(MovilTemp temp);
    public void updateMovil(MovilTemp temp);
    public void deleteMovil(MovilTemp temp);
    
    
}
