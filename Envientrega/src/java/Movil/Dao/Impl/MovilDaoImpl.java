/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Movil.Dao.Impl;

import Bd.Conexion;
import Movil.Dao.MovilDao;
import Movil.Data.Movil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ricar
 */
public class MovilDaoImpl implements MovilDao {

    private Connection conector;
    
    @Override
    public ArrayList<Movil> list() {
       ArrayList<Movil> moviles = new ArrayList<Movil>();
       Conexion conexion = new Conexion();
        try {
            
            
            conexion.conectar();
            conector = conexion.getConector();
            java.sql.Statement st = conector.createStatement();
            String query = "select * from movil";
            ResultSet result = st.executeQuery(query);
            while(result.next()){
                Movil movil = new Movil();
                movil.setIdentificacion(result.getDouble("identificacion_movil"));
                movil.setNombre(result.getString("nombre_movil"));
                movil.setTelefono(result.getString("telefono_movil"));
                movil.setDireccion(result.getString("direccion_movil"));
                movil.setCodigo(result.getString("codigo_movil"));
                movil.setRefenrenciaNombre(result.getString("nombre_referencia_movil"));
                movil.setReferenciaTelefono(result.getString("telefono_referencia_movil"));
                movil.setEstado(result.getInt("estado_movil"));
                
                moviles.add(movil);
                this.conector.close();
            }
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(MovilDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        return moviles;
    }

    @Override
    public void addMovil(Movil movil) {
        PreparedStatement prepararSentencia =null;
        Conexion conexion = new Conexion();
        try {
            conexion.conectar();
       
        this.conector=conexion.getConector();
        String sql="insert into movil "+
                "(identificacion_movil,"+
                "nombre_movil,\n" +
                "telefono_movil,\n" +
                "direccion_movil,\n" +
                "codigo_movil,\n" +
                "nombre_referencia_movil,\n" +
                "telefono_referencia_movil,\n" +
                "estado_movil) "+
                "values("+movil.getIdentificacion()+
                        ",'"+movil.getNombre()+"'"+
                        ",'"+movil.getTelefono()+"'"+
                        ",'"+movil.getDireccion()+"'"+
                        ",'"+movil.getCodigo()+"'"+
                        ",'"+movil.getRefenrenciaNombre()+"'"+
                        ",'"+movil.getReferenciaTelefono()+"'"+
                        ","+1+");";
        
            prepararSentencia=this.conector.prepareStatement(sql);
            prepararSentencia.execute();
            this.conector.close();
        } catch (SQLException ex) {
            
            Logger.getLogger(MovilDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void updateMovil(Movil movil, Double identificacion) {
        PreparedStatement prepararSentencia =null;
        Conexion conexion = new Conexion();
        try {
            conexion.conectar();
        
        this.conector=conexion.getConector();
        String sql="UPDATE envientrega.movil\n" +
            "SET nombre_movil=?, telefono_movil=?, direccion_movil=?, codigo_movil=?, nombre_referencia_movil=?, "
            +"telefono_referencia_movil=?, estado_movil=?, identificacion_movil=?\n" +
            "WHERE identificacion_movil = ?;";
            prepararSentencia=this.conector.prepareStatement(sql);
            prepararSentencia.setString(1, movil.getNombre());
            prepararSentencia.setString(2, movil.getTelefono());
            prepararSentencia.setString(3, movil.getDireccion());
            prepararSentencia.setInt(4, Integer.parseInt(movil.getCodigo()));
            prepararSentencia.setString(5, movil.getRefenrenciaNombre());
            prepararSentencia.setString(6, movil.getReferenciaTelefono());
            prepararSentencia.setInt(7, movil.getEstado());
            prepararSentencia.setDouble(8, movil.getIdentificacion());
            prepararSentencia.setDouble(9, identificacion);
            prepararSentencia.execute();
            this.conector.close();
        } catch (SQLException ex) {
            
            Logger.getLogger(MovilDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void deleteMovil(Double identificacion) {
        PreparedStatement prepararSentecia = null;
        Conexion conexion = new Conexion();
        try {
            conexion.conectar();
            this.conector=conexion.getConector();
            String sql = "delete from movil where identificacion_movil = "+identificacion;

            prepararSentecia=this.conector.prepareStatement(sql);
            prepararSentecia.execute();
            this.conector.close();
        } catch (SQLException ex) {
            Logger.getLogger(MovilDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    @Override
    public ArrayList<Movil> listMivilActive() {
        ArrayList<Movil> moviles = new ArrayList<Movil>();
       Conexion conexion = new Conexion();
        try {
            
            
            conexion.conectar();
            conector = conexion.getConector();
            java.sql.Statement st = conector.createStatement();
            String query = "select * from movil where estado_movil = 1";
            ResultSet result = st.executeQuery(query);
            while(result.next()){
                Movil movil = new Movil();
                movil.setIdentificacion(result.getDouble("identificacion_movil"));
                movil.setNombre(result.getString("nombre_movil"));
                movil.setTelefono(result.getString("telefono_movil"));
                movil.setDireccion(result.getString("direccion_movil"));
                movil.setCodigo(result.getString("codigo_movil"));
                movil.setRefenrenciaNombre(result.getString("nombre_referencia_movil"));
                movil.setReferenciaTelefono(result.getString("telefono_referencia_movil"));
                movil.setEstado(result.getInt("estado_movil"));
                
                moviles.add(movil);
                this.conector.close();
            }
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(MovilDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        return moviles;
    }
   
    
}
