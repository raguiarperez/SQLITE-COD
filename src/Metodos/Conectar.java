/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Metodos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author rafag
 */
public class Conectar {
    
    
    /**
     * Método para conectarse a la Base de Datos
     * @return Conexión a DB
     */
    
        public static Connection conectar() {
        String url = "jdbc:sqlite:Rally.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
        
    /**
     * Método para Conseguir la Tabla de la Base de datos mediante una Consulta.
     * @param consulta
     * @throws SQLException
     * @return Conseguir Tablas de la DB
     */
        
        public static ResultSet getTabla(String consulta) throws SQLException{
        Connection conn=conectar();
        Statement st;
        ResultSet datos= null;
        try{
            st=conn.createStatement();
            datos=st.executeQuery(consulta);
        }catch(Exception e){
            System.out.println(e.toString());
        }
       return datos;
    }
}
