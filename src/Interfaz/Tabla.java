/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;


import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Metodos.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author raguiarperez
 */
public class Tabla extends javax.swing.JFrame {

    /**
     * Creates new form Tabla
     */

    
    ArrayList<Integer> ids = new ArrayList<>();
    
    

    /**
     * En el constructor, me conecto con la base de datos, crear las tablas 
     * rally y categoria, añadir filas a la tabla categoria y mostrar filas de 
     * rally y categoria.
     */


    public Tabla() {
        initComponents();
        Conectar.conectar();
        CreaciónTablas.crearTablaCategorias();
        CreaciónTablas.crearTablaCompetición();
        Insertar.insertarCompetidor(1,"Rafa Aguiar","Renault Clio",1);
        Insertar.insertarCompetidor(2,"Edu Perez","Peugeot 206",2);
        Insertar.insertarCompetidor(3,"Javi Otero","Suzuki Swift",1);
        Insertar.insertarCategorias();
    }

    
    //Método para vaciar las filas de una tabla del programa, no de la base de datos

    /**
     *
     * @param tabla
     */
    public boolean borrarTabla(JTable tabla){
        boolean brTab=false;
        try {
            DefaultTableModel modelo=(DefaultTableModel) tabla.getModel();
            int filas=tabla.getRowCount();
            for (int i = 0;filas>i; i++) {
                modelo.removeRow(0);
                brTab=true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
            brTab=false;
        }
        return brTab;
    }
    
    //Método para insertar filas a la tabla rally desde el código

    /**
     *
     * @param Dorsal
     * @param Piloto
     * @param Vehiculo
     * @param Categoria
     */
    public final boolean insertarCompetidores(int Dorsal, String Piloto, String Vehiculo, int Categoria){
        Insertar.insertarCompetidor(Dorsal, Piloto, Vehiculo, Categoria);
        String[] competidor = Devolver.devolverCompetidor(Dorsal).split(",");
        DefaultTableModel model = (DefaultTableModel) tablacomp.getModel();
        model.addRow(new Object[]{competidor[0], competidor[1], competidor[2], Consultas.obtenerNombreCategoria(Integer.parseInt(competidor[3]))});
        ids.add(Dorsal);
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablacomp = new javax.swing.JTable();
        bAñadir = new javax.swing.JButton();
        tID = new javax.swing.JTextField();
        tNombre = new javax.swing.JTextField();
        tVehiculo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbConsulta = new javax.swing.JComboBox<>();
        tConsulta = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        bConsulta = new javax.swing.JButton();
        bMostrar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        bModificar = new javax.swing.JButton();
        tNombreM = new javax.swing.JTextField();
        tVehiculoM = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        bBorrar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaCat = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablacomp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Dorsal", "Piloto", "Vehiculo", "Categoria"
            }
        ));
        jScrollPane1.setViewportView(tablacomp);

        bAñadir.setText("Añadir");
        bAñadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAñadirActionPerformed(evt);
            }
        });

        jLabel1.setText("Dorsal");

        jLabel2.setText("Piloto");

        jLabel3.setText("Vehiculo");

        cbConsulta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dorsal", "Piloto", "Vehiculo", "Categoria" }));

        jLabel4.setText("Inserción de filas");

        jLabel5.setText("Consulta de filas");

        bConsulta.setText("Consultar");
        bConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bConsultaActionPerformed(evt);
            }
        });

        bMostrar.setText("Mostrar");
        bMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bMostrarActionPerformed(evt);
            }
        });

        jLabel6.setText("Modificación de filas");

        bModificar.setText("Modificar");
        bModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bModificarActionPerformed(evt);
            }
        });

        jLabel7.setText("Piloto");

        jLabel8.setText("Vehiculo");

        bBorrar.setText("Borrar");
        bBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBorrarActionPerformed(evt);
            }
        });

        tablaCat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre"
            }
        ));
        jScrollPane2.setViewportView(tablaCat);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addGap(97, 97, 97))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(tNombreM, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(20, 20, 20)
                                    .addComponent(jLabel8)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(tVehiculoM, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(26, 26, 26))))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addGap(50, 50, 50))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                                                .addComponent(bAñadir)
                                                .addGap(57, 57, 57))))
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 1, Short.MAX_VALUE))
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(tNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tID, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(58, 58, 58))
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addComponent(cbConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(26, 26, 26)
                                        .addComponent(tConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addComponent(bModificar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(bConsulta)
                                        .addGap(67, 67, 67)))
                                .addGap(218, 218, 218))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                                .addComponent(bBorrar)
                                .addGap(51, 51, 51)
                                .addComponent(bMostrar)
                                .addGap(29, 29, 29))))))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(19, 19, 19)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tID, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addComponent(bAñadir, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(80, 80, 80)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(28, 28, 28)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tVehiculoM, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tNombreM, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7))
                                .addGap(18, 18, 18)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(bConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(bModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)))
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Evento del botón Borrar, que elimina una fila de la tabla rally al seleccionarla
    private void bBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBorrarActionPerformed
        int fila = tablacomp.getSelectedRow();
        if(fila == -1){
            JOptionPane.showMessageDialog(null, "No hay ninguna fila seleccionada");
        }
        else{
            int Dorsal = Integer.parseInt(tablacomp.getValueAt(fila,0).toString());
            for (int i=0;i<ids.size();i++){
                if(ids.get(i)==Dorsal){
                    ids.remove(i);
                }
            }
            Borrar.borrarCompetidor(Dorsal);
            bMostrarActionPerformed(evt);
            JOptionPane.showMessageDialog(null, "Competidor eliminado");
        }
    }//GEN-LAST:event_bBorrarActionPerformed

    //Evento del botón Modificar, que modifica la fila seleccionada
    //con los datos de dos TextField
    //Se puede modificar el curso si se selecciona en la tabla Categoria
    private void bModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bModificarActionPerformed
        int filaA = tablacomp.getSelectedRow();
        int filaC = tablaCat.getSelectedRow();
        if(filaA == -1){
            JOptionPane.showMessageDialog(null, "No hay ninguna fila seleccionada");
        }
        else if (filaC == -1){
            String Piloto = tNombreM.getText();
            String Vehiculo = tVehiculoM.getText();
            int Dorsal = Integer.parseInt(tablacomp.getValueAt(filaA,0).toString());
            Modificar.modificarCompetidor(Piloto, Vehiculo, Dorsal);
            bMostrarActionPerformed(evt);
        }
        else{
            String Piloto = tNombreM.getText();
            String Vehiculo = tVehiculoM.getText();
            int Dorsal = Integer.parseInt(tablacomp.getValueAt(filaA,0).toString());
            int Categoria = Integer.parseInt(tablaCat.getValueAt(filaC,0).toString());
            Modificar.modificarCategoriaCompetidor(Piloto, Vehiculo, Categoria, Dorsal);
            bMostrarActionPerformed(evt);
        }
    }//GEN-LAST:event_bModificarActionPerformed

    //Evento del botón Mostrar, que muestra todas las filas de la tabla alumnos y cursos
    //Usada para reiniciar la vista de la tabla después de las consultas
    private void bMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bMostrarActionPerformed

      borrarTabla(tablacomp);
       try {
           DefaultTableModel modelo = new DefaultTableModel();
           ResultSet rs = Conectar.getTabla("select * from rally");
           modelo.setColumnIdentifiers(new Object[]{"Dorsal", "Piloto", "Vehiculo","Categoria"});
           try {
               while (rs.next()) {
                   modelo.addRow(new Object[]{rs.getInt("Dorsal"), rs.getString("Piloto"),rs.getString("Vehiculo"), rs.getString("Categoria")});
               }
               tablacomp.setModel(modelo);
           } catch (Exception e) {
               System.out.println(e);
           }} catch (Exception e) {
           System.out.println(e);
       }
            
           
        borrarTabla(tablaCat);
        for(int i=1;i<5;i++){
            String[] categoria = Devolver.devolverCategoria(i).split(",");
            DefaultTableModel model = (DefaultTableModel) tablaCat.getModel();
            model.addRow(new Object[]{categoria[0], categoria[1]});
        }
    }//GEN-LAST:event_bMostrarActionPerformed

    //Evento del botón Consultar, que con ayuda de un ComboBox y un TextField
    //le permite buscar filas que tengan un campo específico con un valor específico
    private void bConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bConsultaActionPerformed
        borrarTabla(tablacomp);
        String opcion = cbConsulta.getSelectedItem().toString();
        Object buscar = tConsulta.getText();
        switch (opcion){
            case "Dorsal": opcion="Dorsal";
            break;
            case "Piloto": opcion="Piloto";
            break;
            case "Vehiculo": opcion="Vehiculo";
            break;
            case "Categoria": opcion="Categoria";
            buscar = Consultas.obtenerIdCategoria((String) buscar);
            break;
            default: opcion="Piloto";
            break;
        }
        ArrayList<String> competidor = Consultas.consultaRally(opcion, buscar);
        for(int i=0; i<competidor.size(); i++){
            int id = Integer.parseInt(competidor.get(i).split(",")[0]);
            String[] competidores = Devolver.devolverCompetidor(id).split(",");
            DefaultTableModel model = (DefaultTableModel) tablacomp.getModel();
            model.addRow(new Object[]{competidores[0], competidores[1], competidores[2], Consultas.obtenerNombreCategoria(Integer.parseInt(competidores[3]))});
        }
    }//GEN-LAST:event_bConsultaActionPerformed

    //Evento del botón Añadir, que inserta una nueva fila en la tabla alumnos
    //usando tres TextField y la tabla categoría para seleccionar el curso
    private void bAñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAñadirActionPerformed
        int fila = tablaCat.getSelectedRow();
        int Dorsal, Categoria;
        String Piloto, Vehiculo;
        Dorsal = Integer.parseInt(tID.getText());
        Piloto = tNombre.getText();
        Vehiculo = tVehiculo.getText();
        for (Integer i : ids){
            if(Dorsal == i){
                JOptionPane.showMessageDialog(null, "El Dorsal ya existe");
                return;
            }
        }
        if(fila == -1){
            JOptionPane.showMessageDialog(null, "No se ha seleccionado una Categoria");
        } else{
            Categoria = Integer.parseInt(tablaCat.getValueAt(fila,0).toString());
            Insertar.insertarCompetidor(Dorsal, Piloto, Vehiculo, Categoria);
            String[] competidor = Devolver.devolverCompetidor(Dorsal).split(",");
            DefaultTableModel model = (DefaultTableModel) tablacomp.getModel();
            model.addRow(new Object[]{competidor[0], competidor[1], competidor[2], Consultas.obtenerNombreCategoria(Integer.parseInt(competidor[3]))});
            ids.add(Dorsal);
        }
        
    }//GEN-LAST:event_bAñadirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tabla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tabla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tabla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tabla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tabla().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAñadir;
    private javax.swing.JButton bBorrar;
    private javax.swing.JButton bConsulta;
    private javax.swing.JButton bModificar;
    private javax.swing.JButton bMostrar;
    private javax.swing.JComboBox<String> cbConsulta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panel;
    private javax.swing.JTextField tConsulta;
    private javax.swing.JTextField tID;
    private javax.swing.JTextField tNombre;
    private javax.swing.JTextField tNombreM;
    private javax.swing.JTextField tVehiculo;
    private javax.swing.JTextField tVehiculoM;
    private javax.swing.JTable tablaCat;
    private javax.swing.JTable tablacomp;
    // End of variables declaration//GEN-END:variables
}
