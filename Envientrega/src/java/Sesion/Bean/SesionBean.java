/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sesion.Bean;

import Sesion.Data.Menu;
import Sesion.Impl.Impl.SesionImpl;
import Sesion.Impl.SesionImplInterface;
import Sesion.Temp.SesionTemp;
import User.Data.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.model.menu.DefaultMenuColumn;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuElement;

/**
 *
 * @author ricar
 */
@SessionScoped
@ManagedBean(name = "sesionBean")
public class SesionBean {
    
    private SesionTemp temp;
    private SesionImplInterface impl;

    public SesionBean() {
        temp = new SesionTemp();
        impl = new SesionImpl();
    }
    
    
    public String validateUser(){
        User user = impl.findUser(temp);
        if(impl.validateUser(user, temp)){
          FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", user);
              if(user.getRol().getRol().equals("Administrador")){
                  impl.loadMenu(user.getRol().getIdRol(), temp);
                  return "faces/Administrador/Administrador.xhtml?faces-redirect=true";
              }else if (user.getRol().getRol().equals("Central")){
                  impl.loadMenu(user.getRol().getIdRol(), temp);
                  return "faces/Central/Central.xhtml?faces-redirect=true";
              }else {
                    return"faces/index.xhtml?faces-redirect=false";
                    }
              }
        else {
            return"faces/index.xhtml?faces-redirect=false";
        }
        
    }

    public SesionTemp getTemp() {
        return temp;
    }
    
    
    public String optenerUsuario(){
        User user = (User) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
        return user.getNameUser();
    }
    
    public void cerrarSesion() throws IOException{
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        FacesContext.getCurrentInstance().getExternalContext().redirect("../index.xhtml");
        
    }
    
    public void validateSesion(String pagina) throws IOException{
        User user = (User)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
        if(user!=null){
        
        }else{
            FacesContext.getCurrentInstance().getExternalContext().redirect("../index.xhtml");
        }
    } 
}
