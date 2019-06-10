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
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author rafag
 */
public class Insertar {
        //Método para insertar filas en la tabla Rally

    /**
     *
     * @param Dorsal
     * @param Piloto
     * @param Vehiculo
     * @param curso
     */
    public static boolean insertarCompetidor(int Dorsal, String Piloto, String Vehiculo, int Categoria) {
        boolean insC=false;
        String sql = "INSERT INTO rally VALUES(?,?,?,?)";
        try (Connection conn = conectar();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, Dorsal);
            pstmt.setString(2, Piloto);
            pstmt.setString(3, Vehiculo);
            pstmt.setInt(4, Categoria);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Competidor registrado correctamente");
            insC=true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al introducir los datos");
            insC=false;
        }
        return insC; 
    }
        public static void insertarCategorias() {
        String sql1 = "INSERT INTO Categoria VALUES(1,'N5');";
        String sql2 = "INSERT INTO Categoria VALUES(2,'R5');";
        String sql3 = "INSERT INTO Categoria VALUES(3,'GRUPO B');";
        String sql4 = "INSERT INTO Categoria VALUES(4,'WRC');";
        try (Connection conn = conectar();
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql1);
            stmt.execute(sql2);
            stmt.execute(sql3);
            stmt.execute(sql4);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    
}
