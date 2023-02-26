/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simulacionBD;

import java.util.ArrayList;
import java.util.List;
import modelos.Comentario;


/**
 * Clase que simula una base de datos, solamente es para hacer pruebas
 * No debe incluirse en la version final
 * O eso creo yo...
 * @author alexj
 */

public final class DataBaseComment {
    private final static DataBaseComment dataBaseComment = new DataBaseComment();
    private final List<Comentario> publicationList = new ArrayList<>();
    
    private DataBaseComment(){
      
        Comentario comentario1 = new Comentario(1, "Yo mate a Colosio",
                "Salinas", 1, 1);
        Comentario comentario2 = new Comentario(2, "Arriba el pri",
                "Salinas", 1, 2);
        Comentario comentario3 = new Comentario(3, "Me amarraron como puerco",
                "Colosio", 2, 1);
        publicationList.add(comentario1);
        publicationList.add(comentario2);
        publicationList.add(comentario3);
    }
    
    public static DataBaseComment getInstance(){
        return dataBaseComment;
    }
    
    public List<Comentario> getList(){
        return publicationList;
    }
}
