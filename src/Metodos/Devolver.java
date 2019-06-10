/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Metodos;

import static Metodos.Conectar.conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author rafag
 */
public class Devolver {

    /**
     * Método que devuelve un String con todos los campos de una fila,
     * especificando el Dorsal
     *
     * @param Dorsal
     * @return Todos los campos de Competidor
     */
    public static String devolverCompetidor(int Dorsal) {
        String sql = "SELECT Dorsal,Piloto,Vehiculo,Categoria"
                + " FROM rally WHERE Dorsal=?";
        String resultado = "";
        try (Connection conn = conectar();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, Dorsal);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                resultado = (rs.getInt("Dorsal") + ","
                        + rs.getString("Piloto") + ","
                        + rs.getString("Vehiculo") + ","
                        + rs.getInt("Categoria"));
            }
            return resultado;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            return resultado;
        }
    }

    /**
     * Método que devuelve un String con todos los campos de una fila,
     * especificando el id
     *
     * @param id
     * @return Todos los campos de Categoria
     */
    public static String devolverCategoria(int id) {
        String sql = "SELECT id,nombre"
                + " FROM Categoria WHERE id=?";
        String resultado = "";
        try (Connection conn = conectar();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                resultado = (rs.getInt("id") + ","
                        + rs.getString("nombre"));
            }
            return resultado;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            return resultado;
        }
    }

}
