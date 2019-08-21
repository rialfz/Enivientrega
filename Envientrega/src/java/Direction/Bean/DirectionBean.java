/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Direction.Bean;

import User.Data.User;
import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author ricar
 */
@ManagedBean(name="directionBean")
public class DirectionBean {
    
    public void redirection(String url) throws IOException{
        User user = (User)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
        if(user.getRol().getRol().equals("Administrador")){
            if(url.equals("movil")){
                FacesContext.getCurrentInstance().getExternalContext().redirect("../Administrador/Administrador.xhtml");
            }
            if(url.equals("central")){
                FacesContext.getCurrentInstance().getExternalContext().redirect("../Administrador/Central.xhtml");
            }
            if(url.equals("frecuencia")){
                FacesContext.getCurrentInstance().getExternalContext().redirect("../Administrador/Frecuencia.xhtml");
            }
        }else if(user.getRol().getRol().equals("Central")){
            if(url.equals("movil")){
                FacesContext.getCurrentInstance().getExternalContext().redirect("../Central/Central.xhtml");
            }
            if(url.equals("frecuencia")){
                FacesContext.getCurrentInstance().getExternalContext().redirect("../Central/Frecuencia.xhtml");
            }
        }
    }
    
}
