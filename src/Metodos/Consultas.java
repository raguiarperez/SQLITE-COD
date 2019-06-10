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
import java.util.ArrayList;

/**
 *
 * @author rafag
 */
public class Consultas {

    /**
     * Método para buscar filas en la tabla rally, especificando cualquier
     * campo.
     *
     * @param campo
     * @param valor
     * @return Arraylist de todos los campos
     */
    public static ArrayList<String> consultaRally(String campo, Object valor) {
        ArrayList<String> rally = new ArrayList<>();
        String sql = "SELECT Dorsal,Piloto,Vehiculo,Categoria"
                + " FROM rally WHERE " + campo + "=?";
        try (Connection conn = conectar();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setObject(1, valor);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                rally.add(rs.getInt("Dorsal") + ","
                        + rs.getString("Piloto") + ","
                        + rs.getString("Vehiculo") + ","
                        + rs.getInt("Categoria"));
            }
            return rally;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            return rally;
        }
    }

    /**
     * Método que devuelve el nombre de la categoria, especificando el id
     *
     * @param id
     * @return Nombre de Categoria
     */
    public static String obtenerNombreCategoria(int id) {
        String sql = "SELECT nombre FROM Categoria where id = ?;";
        String resultado = "";
        try (Connection conn = conectar();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                resultado = rs.getString("nombre");
            }
            return resultado;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            return resultado;
        }
    }

    /**
     * Método que devuelve el id de la categoria, especificando el nombre.
     *
     * @param nombre
     * @return Id de Categoria
     */
    public static int obtenerIdCategoria(String nombre) {
        String sql = "SELECT id FROM Categoria where nombre = ?;";
        int resultado = 0;
        try (Connection conn = conectar();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nombre);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                resultado = rs.getInt("id");
            }
            return resultado;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            return resultado;
        }
    }
}
