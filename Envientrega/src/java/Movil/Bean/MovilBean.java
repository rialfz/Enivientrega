/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Movil.Bean;

import Movil.Impl.MovilImpl;
import Movil.Temp.MovilTemp;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author ricar
 */
@ViewScoped
@ManagedBean
public class MovilBean {
    
    private MovilImpl impl;
    private MovilTemp temp;

    public MovilTemp getTemp() {
        return temp;
    }

    public MovilBean() {
        impl = new Movil.Impl.Impl.MovilImpl();
        temp = new MovilTemp();
        listAll();
    }
    
    public void listAll(){
        impl.list(temp);
    }
    
    public void addMovil(){
        impl.addMovil(temp);
        listAll();
    }
    
    public void copy(){
      impl.copy(temp);
    }
    
    public void updateMovil(){
        impl.updateMovil(temp);
        listAll();
        
    }
    
    
    public void deleteMovil(){
        impl.deleteMovil(temp);
        listAll();
    }
}
