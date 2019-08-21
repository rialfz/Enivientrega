/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frecuence.Data;

import java.util.Date;



/**
 *
 * @author ricar
 */
public class Frecuence {
    
    private Date day;
    private int state;
    private int idFrecuence;
    
    public Frecuence() {
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getIdFrecuence() {
        return idFrecuence;
    }

    public void setIdFrecuence(int idFrecuence) {
        this.idFrecuence = idFrecuence;
    }
    
    
    
}
