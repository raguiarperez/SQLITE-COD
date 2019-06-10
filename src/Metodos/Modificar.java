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
import javax.swing.JOptionPane;

/**
 *
 * @author rafag
 */
public class Modificar {
    //Método para modificar el nombre y nota de una fila de la tabla rally,
    //especificando el dorsal

    /**
     *
     * @param nome
     * @param nota
     * @param referencia
     */
    public static void modificarCompetidor(String Piloto, String Vehiculo, int Dorsal) {
        String sql = "UPDATE rally SET Piloto = ? , "
                + "Vehiculo = ? "
                + "WHERE Dorsal = ?";
        try (Connection conn = conectar();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, Piloto);
            pstmt.setString(2, Vehiculo);
            pstmt.setInt(3, Dorsal);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Competidor modificado correctamente");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    //Método para modificar el piloto, vehiculo y categoria de una fila de la tabla rally,
    //especificando el id

    /**
     *
     * @param Piloto
     * @param Vehiculo
     * @param Categoria
     * @param Dorsal
     */
    public static void modificarCategoriaCompetidor(String Piloto, String Vehiculo, int Categoria, int Dorsal) {
        String sql = "UPDATE rally SET Piloto = ? , "
                + "Vehiculo = ? , "
                + "Categoria = ?"
                + "WHERE Dorsal = ?";
        try (Connection conn = conectar();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, Piloto);
            pstmt.setString(2, Vehiculo);
            pstmt.setInt(3, Categoria);
            pstmt.setInt(4, Dorsal);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Competidor modificado correctamente");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
