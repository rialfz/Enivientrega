/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User.Dao.Impl;

import Bd.Conexion;
import User.Dao.UserDaoInterface;
import User.Data.RolUser;
import User.Data.User;
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
public class UserDao implements UserDaoInterface {
    
     private Connection conector;
    /**Este metodo permite agregar un usuario, retorna true si la transacion es realizada con exito, false si ocurre algin error
     * 
     * @param user
     * @return 
     */
    @Override
    public boolean addUser(User user){
        boolean b=true;
        PreparedStatement prepareSentence = null;
        Conexion conexion = new Conexion();
        try {
            conexion.conectar();
            conector=conexion.getConector();

            String query = "insert into usuario (identificacion_usuario, nombre_usuario, clave_usuario, id_rol)\n" +
                            "VALUES ("+user.getIdentificationUser()+", '"+user.getNameUser()+"' , '"+user.getPasswordUser()+"' ,"+2+")";
         
             prepareSentence = conector.prepareStatement(query);
             prepareSentence.execute();
             this.conector.close();
         } catch (SQLException ex) {
             b=false;
             Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
         }
       return b;
    }
    /**Este metodo devuelve un usuario 
     * 
     * @param identification
     * @return 
     */
    @Override
    public User findUser(double identification) {
            User user = null;
            PreparedStatement prepareSentence = null;
            Conexion conexion = new Conexion();
            conexion.conectar();
            this.conector=conexion.getConector();
            int idRol=0;
            String query = "select * from usuario where identificacion_usuario = ? ";
         try {
             prepareSentence = conector.prepareStatement(query);
             prepareSentence.setDouble(1, identification);
             ResultSet result = prepareSentence.executeQuery();
             User aux = new User();
             while(result.next()){
                 aux.setIdentificationUser(result.getDouble("identificacion_usuario"));
                 aux.setNameUser(result.getString("nombre_usuario"));
                 aux.setPasswordUser(result.getString("clave_usuario"));
                 idRol= result.getInt("id_rol");
                 aux.setRol(findRoll(idRol));
                
             }
             this.conector.close();
             user=aux;
             user.setRol(findRoll(idRol));
             return user;
         } catch (SQLException ex) {
             Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
             return user;
         }
         
        }
    
    public RolUser findRoll(int id){
        PreparedStatement prepareSentence = null;
        Conexion conexion = new Conexion();
        conexion.conectar();
        RolUser rol = new RolUser();
        this.conector=conexion.getConector();
        String query = "select * from rol where id_rol = "+id;
         try {
             java.sql.Statement st = conector.createStatement();
             //prepareSentence = conector.prepareStatement(query);
             //prepareSentence.set(1, id);
             ResultSet result = st.executeQuery(query);//prepareSentence.executeQuery(query);
             while (result.next()){
                 rol.setIdRol(result.getInt("id_rol"));
                 rol.setRol(result.getString("tipo_rol"));
             }
             this.conector.close();
         } catch (SQLException ex) {
             Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
         }
         return rol;
    }

    @Override
    public ArrayList<User> listUser() {
        ArrayList<User> users = new ArrayList<User>();
        Conexion conexion = new Conexion();
        conexion.conectar();
        this.conector=conexion.getConector();
        java.sql.Statement st;
         try {
             String query="select * from usuario";
             st = conector.createStatement();
             ResultSet result = st.executeQuery(query);
             while(result.next()){
                 User user = new User();
                 user.setIdentificationUser(result.getDouble("identificacion_usuario"));
                 user.setNameUser(result.getString("nombre_usuario"));
                 int idRol= result.getInt("id_rol");
                 user.setRol(findRoll(idRol));
                 users.add(user);
             }
             this.conector.close();
             return users;
             
         } catch (SQLException ex) {
             Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
         }
       
        
        return users;
    }

    @Override
    public boolean updateUser(User user, Double identification) {
        
        boolean b = false;
        PreparedStatement prepareSentence;
        Conexion conexion = new Conexion();
        conexion.conectar();
        this.conector=conexion.getConector();
         try {
             String query ="UPDATE usuario\n" +
                            "SET identificacion_usuario= ?, nombre_usuario= ?\n" +
                            "WHERE identificacion_usuario = ?";
             prepareSentence= conector.prepareStatement(query);
             prepareSentence.setDouble(1, user.getIdentificationUser());
             prepareSentence.setString(2, user.getNameUser());
             prepareSentence.setDouble(3, identification);
           
             prepareSentence.execute();
             b=true;
             this.conector.close();
             
        } catch (SQLException ex) {
             Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
         }finally{
              return b;
         }
        
       
    }

    @Override
    public boolean deleteUser(Double identification) {
        boolean b = false;
        PreparedStatement prepareSentence;
        Conexion conexion = new Conexion();
        conexion.conectar();
        this.conector=conexion.getConector();
       
         try {
            String query="DELETE FROM envientrega.usuario\n" +
                         "WHERE identificacion_usuario = ?;";
            prepareSentence = this.conector.prepareStatement(query);
            prepareSentence.setDouble(1, identification);
            prepareSentence.executeQuery();
            b=true;
            this.conector.close();
         } catch (SQLException ex) {
             Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
         }finally{
             return b;
         }
        
        
        
    }

    @Override
    public boolean changePassword(Double identification, String password) {
        PreparedStatement prepareSentence = null;
        Conexion conexion = new Conexion();
        conexion .conectar();
        this.conector=conexion.getConector();
        
       
         try {
              String query = "update usuario "
                + "SET clave_usuario = ? "
                + "where identificacion_usuario = ?";
             prepareSentence=this.conector.prepareStatement(query);
             prepareSentence.setString(1, password);
             prepareSentence.setDouble(2, identification);
             prepareSentence.execute();
             return true;
         } catch (SQLException ex) {
             Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
             return false;
         }
        
    }
    
}
