/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simulacionBD;

import java.util.ArrayList;
import java.util.List;
import modelos.Publicacion;

/*
 * Clase que simula una base de datos, solamente es para hacer pruebas
 * No debe incluirse en la version final
 * O eso creo yo...
 * @author alexj
 */

public final class DataBasePublication {
    private final static DataBasePublication dataBasePublication = new DataBasePublication();
    private final List<Publicacion> publicationList = new ArrayList<>();
    
    private DataBasePublication(){
        
        
        Publicacion publicacion1 = new Publicacion(1, "El perro que come cereal con cuchara",
                "No lo lean.", "Michel Kotry");
        Publicacion publicacion2 = new Publicacion(2, "La sociedad industrial y su futuro",
                "Si lean este", "Alain");
        Publicacion publicacion3 = new Publicacion(3, "1001 chascarrillos",
                "No se, estan comicos", "Mariana");
        publicationList.add(publicacion1);
        publicationList.add(publicacion2);
        publicationList.add(publicacion3);
    }
    
    public static DataBasePublication getInstance(){
        return dataBasePublication;
    }
    
    public List<Publicacion> getList(){
        return publicationList;
    }
}
