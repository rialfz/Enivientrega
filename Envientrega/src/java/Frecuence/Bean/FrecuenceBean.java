/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frecuence.Bean;


import Frecuence.Impl.FrecuenceImplInterface;
import Frecuence.Impl.Impl.FrecuenceImplImpl;
import Frecuence.Temp.FrecuenceTemp;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

/**
 *
 * @author ricar
 */
@SessionScoped
@ManagedBean(name = "frecuenceBean")
public class FrecuenceBean {

    
    private FrecuenceTemp temp;
    private FrecuenceImplInterface impl;
    
    public FrecuenceBean() {
        temp = new FrecuenceTemp();
        impl = new FrecuenceImplImpl();
        impl.getFrecuence(temp);
    }
    
    public void addEvent() {
        impl.addFrecuence(temp);
    }

    public void selectEvent(SelectEvent selectEvent) {
        temp.setEvent((ScheduleEvent) selectEvent.getObject());
        impl.loadFrecuence(temp);
    }

    public FrecuenceTemp getTemp() {
        return temp;
    }

    public void setTemp(FrecuenceTemp temp) {
        this.temp = temp;
    }
    
    
    
    
    
}
