package Movil.Impl.Impl;

import Movil.Dao.Impl.MovilDaoImpl;
import Movil.Temp.MovilTemp;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ricar
 */
public class MovilImpl implements Movil.Impl.MovilImpl{

    private MovilDaoImpl dao; 

    public MovilImpl() {
        dao = new MovilDaoImpl();
    }
    
    
    
    @Override
    public void list(MovilTemp temp) {
        temp.setListMovil(dao.list());
       }

    @Override
    public void addMovil(MovilTemp temp) {
       dao.addMovil(temp.getAux());
    }

    @Override
    public void copy(MovilTemp temp) {
            temp.setIdentificacion(temp.getSelect().getIdentificacion());
    }

    @Override
    public void updateMovil(MovilTemp temp) {
        dao.updateMovil(temp.getSelect(), temp.getIdentificacion());
    }

    @Override
    public void deleteMovil(MovilTemp temp) {
        dao.deleteMovil(temp.getSelect().getIdentificacion());
    }
    
    
}
