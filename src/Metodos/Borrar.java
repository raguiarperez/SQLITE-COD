/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos;

import static Metodos.Conectar.conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author rafag
 */
public class Borrar {
        
    //Método para borrar una fila de la tabla rally, especificando el id

    /**
     *
     * @param Dorsal
     */
    public static void borrarCompetidor(int Dorsal){
        String sql = "DELETE FROM rally WHERE Dorsal=?";
        try (Connection conn = conectar();
            PreparedStatement pstmt  = conn.prepareStatement(sql)){
            pstmt.setInt(1, Dorsal);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
