/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frecuence.Dao.Impl;

import Bd.Conexion;
import Frecuence.Dao.FrecuenceDaoInterface;
import Frecuence.Data.Frecuence;
import Frecuence.Data.FrecuenceMovil;
import Movil.Data.Movil;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ricar
 */
public class FrecuenceDao implements FrecuenceDaoInterface {

    Connection conector;
    
    @Override
    public boolean createFrecuence(Frecuence frecuence) {
        PreparedStatement preparetSenctence=null;
        Conexion conexion = new Conexion();
        conexion.conectar();
        this.conector =conexion.getConector();
        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Statement st;  
        try {
            String query="insert into frecuencia (dia_frecuencia, estado_frecuencia)"
                    + " values( '"+dt.format(frecuence.getDay())+"', "+frecuence.getState()+") returning id_frecuencia";
            st=this.conector.createStatement();
            ResultSet result =st.executeQuery(query);
            
            while(result.next()){
                frecuence.setIdFrecuence(result.getInt("id_frecuencia"));
            }
            return true;
                    } catch (SQLException ex) {
                      ex.getLocalizedMessage();
           return false;
        }
        
    }

    @Override
    public ArrayList<Frecuence> getFrecuence() {
        ArrayList<Frecuence> frecuence = new ArrayList<Frecuence>();
        Conexion conexion = new Conexion();
        conexion.conectar();
        this.conector =conexion.getConector();
        String query="select * from frecuencia";
        java.sql.Statement st;
        try {
            st=this.conector.createStatement();
            ResultSet result = st.executeQuery(query);
            while(result.next()){
                Frecuence aux = new Frecuence();
                aux.setDay(result.getDate("dia_frecuencia"));
                aux.setState(result.getInt("estado_frecuencia"));
                aux.setIdFrecuence(result.getInt("id_frecuencia"));
                frecuence.add(aux);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FrecuenceDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return frecuence;
    }

    @Override
    public void relationFrecueMovil(ArrayList<Movil> movil, Frecuence frecuence) {
        PreparedStatement preparetSenctence=null;
        Conexion conexion = new Conexion();
        conexion.conectar();
        this.conector =conexion.getConector();
        java.sql.Statement st;
        try {
            st=this.conector.createStatement();
            String query = "INSERT INTO movil_frecuencia" +
                            "(identificacion_movil, id_frecuencia, estado_frecuencia)" +
                            "VALUES ";
            for (Movil movil1 : movil) {
                query = query+"("+movil1.getIdentificacion().toString()+", "+frecuence.getIdFrecuence()+", 1),";
            }
            query=query.substring(0, query.length()-1);
            st.execute(query);
        } catch (SQLException ex) {
            Logger.getLogger(FrecuenceDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<FrecuenceMovil> loadFrecuence(Integer idFrecuence) {
        ArrayList<FrecuenceMovil> movil = new ArrayList<FrecuenceMovil>();
        Conexion conexion = new Conexion();
        conexion.conectar();
        this.conector=conexion.getConector();
        java.sql.Statement st;
        try {
            st=this.conector.createStatement();
            String query = "select mov.identificacion_movil, mov.codigo_movil, mov.nombre_movil, fre.estado_frecuencia " +
                            "from movil as mov inner join movil_frecuencia as fre " +
                            "on(mov.identificacion_movil = fre.identificacion_movil) " +
                            "where id_frecuencia = "+idFrecuence;
            ResultSet result = st.executeQuery(query);
            while(result.next()){
                FrecuenceMovil aux = new FrecuenceMovil();
                aux.setCodeMovil(result.getInt("codigo_movil"));
                aux.setIdentificationMovil(result.getInt("identificacion_movil"));
                aux.setNameMovil(result.getString("nombre_movil"));
                aux.setEstate(result.getInt("estado_frecuencia"));
                movil.add(aux);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FrecuenceDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            return movil;
        }
        
    }
    
    
}
