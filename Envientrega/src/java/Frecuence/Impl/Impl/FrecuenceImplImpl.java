/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frecuence.Impl.Impl;

import Frecuence.Dao.FrecuenceDaoInterface;
import Frecuence.Dao.Impl.FrecuenceDao;
import Frecuence.Data.Frecuence;
import Frecuence.Data.FrecuenceMovil;
import Frecuence.Impl.FrecuenceImplInterface;
import Frecuence.Temp.FrecuenceTemp;
import Movil.Dao.Impl.MovilDaoImpl;
import Movil.Dao.MovilDao;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;



/**
 *
 * @author ricar
 */
public class FrecuenceImplImpl implements FrecuenceImplInterface {

    private FrecuenceDaoInterface dao; 
    private MovilDao dao1;
    
    public FrecuenceImplImpl() {
        dao= new FrecuenceDao();
        dao1= new MovilDaoImpl();
    }
    
    
    
    @Override
    public boolean addFrecuence(FrecuenceTemp temp) {
        
        temp.getFrecuence().setState(1);
        if(dao.createFrecuence(temp.getFrecuence()))
        {
            dao.relationFrecueMovil(dao1.listMivilActive(), temp.getFrecuence());
            ScheduleModel eventModel = temp.getEventModel();
            DefaultScheduleEvent event= new DefaultScheduleEvent("Frecuencia", temp.getFrecuence().getDay(), temp.getFrecuence().getDay());
                event.setId(String.valueOf(temp.getFrecuence().getIdFrecuence()));
                eventModel.addEvent(event);
                
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void getFrecuence(FrecuenceTemp temp) {
        ArrayList<Frecuence> frecuence = dao.getFrecuence();
        if(frecuence!=null || frecuence.size()!=0){
            ScheduleModel eventModel = temp.getEventModel();
            for (Frecuence frecuence1 : frecuence) {
                DefaultScheduleEvent event= new DefaultScheduleEvent("Frecuencia", frecuence1.getDay(), frecuence1.getDay());
                
                event.setData(frecuence1);
                eventModel.addEvent(event);
            }
            
            
        }
       }

    @Override
    public void loadFrecuence(FrecuenceTemp temp) {
        ArrayList<FrecuenceMovil> movil = new ArrayList<>();
        Frecuence frecuence = (Frecuence) temp.getEvent().getData();
        SimpleDateFormat dt = new SimpleDateFormat("dd-MM-yyyy");
        temp.setFecha(dt.format(frecuence.getDay()));
        temp.setMovil(dao.loadFrecuence(frecuence.getIdFrecuence()));
     }
    
    
    
}

    
    

