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

    /**
     * Método para modificar el piloto y vehiculo de una fila de la tabla rally,
     * especificando el dorsal
     *
     * @param Piloto
     * @param Vehiculo
     * @param Dorsal
     * @return modificación de Piloto y Vehiculo en fila de tabla Competidor
     */
    public static boolean modificarCompetidor(String Piloto, String Vehiculo, int Dorsal) {
        boolean modCom = false;
        String sql = "UPDATE rally SET Piloto = ? , "
                + "Vehiculo = ? "
                + "WHERE Dorsal = ?";
        try (Connection conn = conectar();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, Piloto);
            pstmt.setString(2, Vehiculo);
            pstmt.setInt(3, Dorsal);
            pstmt.executeUpdate();
            modCom = true;
            JOptionPane.showMessageDialog(null, "Competidor modificado correctamente");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            modCom = false;
        }
        return modCom;
    }

    /**
     * Método para modificar el piloto Categoria y vehiculo de una fila de la
     * tabla rally, especificando el id de la Categoria
     *
     * @param Piloto
     * @param Vehiculo
     * @param Categoria
     * @param Dorsal
     * @return modificación de Piloto, Vehiculo y Categoría en la tabla
     * Competidor
     *
     */
    public static boolean modificarCategoriaCompetidor(String Piloto, String Vehiculo, int Categoria, int Dorsal) {
        boolean modCat = false;
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
            modCat = true;
            JOptionPane.showMessageDialog(null, "Competidor modificado correctamente");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            modCat = false;
        }
        return modCat;
    }
}
