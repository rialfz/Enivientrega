/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ricar
 */


public class Conexion {
    
    private Connection conector;
    
   /*
    private final String URL = "jdbc:mysql://localhost:3306/envientrega?zeroDateTimeBehavior=convertToNull";
    private final String USUARIO="envientrega";
    private final String CONTRASENA="envientrega";
   */
    
    private final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private final String USUARIO="envientrega";
    private final String CONTRASENA="envientrega";
    
    
    
    public Conexion() {
    }
    
    public void conectar() {
        
        try {   
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
       // Class.forName("com.mysql.jdbc.Driver");
        try {
            this.conector= DriverManager.getConnection(URL, USUARIO, CONTRASENA);
            System.out.println("Conección realizada con exito");
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
           
    } 

    public Connection getConector() {
        return conector;
    }
    
    
    
    
}
