/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frecuence.Impl;

import Frecuence.Data.FrecuenceMovil;
import Frecuence.Temp.FrecuenceTemp;
import java.util.ArrayList;
import org.primefaces.model.ScheduleEvent;

/**
 *
 * @author ricar
 */
public interface FrecuenceImplInterface {
    public boolean addFrecuence(FrecuenceTemp temp);
    public void getFrecuence(FrecuenceTemp temp);
    public void loadFrecuence(FrecuenceTemp temp);
}
