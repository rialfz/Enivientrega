/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frecuence.Temp;

import Frecuence.Data.Frecuence;
import Frecuence.Data.FrecuenceMovil;
import java.util.ArrayList;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

/**
 *
 * @author ricar
 */
public class FrecuenceTemp {
     private ScheduleModel eventModel;
     private ScheduleEvent event;
     private Frecuence frecuence;
     private ArrayList<FrecuenceMovil> movil;
     private String fecha;

    public FrecuenceTemp() {
        eventModel = new DefaultScheduleModel();
        event = new DefaultScheduleEvent();
        frecuence = new Frecuence();
    }

    public ScheduleModel getEventModel() {
        return eventModel;
    }

    public void setEventModel(ScheduleModel eventModel) {
        this.eventModel = eventModel;
    }

    public ScheduleEvent getEvent() {
        return event;
    }

    public void setEvent(ScheduleEvent event) {
        this.event = event;
    }

    public Frecuence getFrecuence() {
        return frecuence;
    }

    public void setFrecuence(Frecuence frecuence) {
        this.frecuence = frecuence;
    }

    public ArrayList<FrecuenceMovil> getMovil() {
        return movil;
    }

    public void setMovil(ArrayList<FrecuenceMovil> movil) {
        this.movil = movil;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
     
    
    
     
     
}
