/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class ConexionSQLite {

    // Ruta relativa de la base de datos
    private static final String URL = "C:\\Temp\\ITSON\\distribuidos\\ServicioRESTFul\\CruzAzul.db";

    // Método para conectar a la base de datos
    public static Connection conectar() throws SQLException {
        try {
            // Cargar el driver de SQLite
            Class.forName("org.sqlite.JDBC");
            // Obtener la conexión a la base de datos
            Connection conexion = DriverManager.getConnection("jdbc:sqlite:" +  URL);
            return conexion;
        } catch (ClassNotFoundException ex) {
            System.out.println("No se pudo cargar el driver de SQLite");
            ex.printStackTrace();
            return null;
        }
    }

}

