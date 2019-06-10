/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos;

import static Metodos.Conectar.conectar;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author rafag
 */
public class CreaciónTablas {
    
        //Método de creación de la tabla Competición

    /**
     * @param
     */
    public static boolean crearTablaCompetición() {
        boolean ctr=false;
        String sql1 = "DROP TABLE IF EXISTS rally;\n";
        String sql2 = "CREATE TABLE IF NOT EXISTS rally (\n"
                + "Dorsal integer PRIMARY KEY,\n"
                + "Piloto text NOT NULL,\n"
                + "Vehiculo text NOT NULL,\n"
                + "Categoria integer,\n"
                + "FOREIGN KEY (Categoria)\n" 
                + "REFERENCES Categoria(id)\n"
                + ");";    
        try (Connection conn = conectar();
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql1);
            stmt.execute(sql2);
            ctr=true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            ctr=false;
        }
        return ctr;
    }
    
    
    
        //Método de creación de la tabla Categorias

    /**
     *
     */
    public static boolean crearTablaCategorias() {
        boolean ctc=false;
        String sql1 = "DROP TABLE IF EXISTS Categoria;\n";
        String sql = "CREATE TABLE IF NOT EXISTS Categoria (\n"
                + "id integer PRIMARY KEY,\n"
                + "nombre text NOT NULL\n"
                + ");";
        try (Connection conn = conectar();
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql1);
            stmt.execute(sql);
            ctc=true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            ctc=false;
        }
        return ctc;
    }
    
    
}
