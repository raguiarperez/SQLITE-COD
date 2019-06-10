package proyectoSQLITECOD;

import Interfaz.Tabla;

/**
 *
 * @author rafag
 */
public class ProyectoSQLITECOD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        /**
         * Se crea un Objeto de tipo Tabla con el cual se hace visible la
         * Ventana de la interfaz.
         *
         * @return Interfaz de la Base de Datos
         */
        Tabla bdtab = new Tabla();
        bdtab.setVisible(true);
    }

}
