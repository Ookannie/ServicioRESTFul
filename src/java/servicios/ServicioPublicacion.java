/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicios;

import controladores.ControlPublicacion;
import java.util.List;
import modelos.Publicacion;
import simulacionBD.DataBasePublication;

/**
 *
 * @author alexj
 */
public class ServicioPublicacion {
    private List<Publicacion> publicationList = DataBasePublication.getInstance().getList();
    private ControlPublicacion controlPublicacion;

    public ServicioPublicacion() {
        this.controlPublicacion = new ControlPublicacion();
    }
    
    
    
    public List<Publicacion> getPublications(){
        return publicationList;
    }
    
    public Publicacion getPublication(int id){
        for(Publicacion publicacion : publicationList){
            if(publicacion.getId() == id){
                return publicacion;
            }
        }
        return null;
    }
    
    public Publicacion getPublicationByTitle(String title){
        return controlPublicacion.findByTitle(title).get(0);
    }
    
    public Publicacion addPublication(Publicacion publicacion){
        //publicacion.setId(getLast());
        //publicationList.add(publicacion);
        controlPublicacion.create(publicacion);
        return publicacion;
    }
    
    public void deletePublication(int id){
        int position = getPosition(id);
        publicationList.remove(position);
    }
    
    private int getPosition(int id){
        for (int i = 0; i < publicationList.size(); i++){
            if (publicationList.get(i).getId() == id){
                return i;
            }
        }
        return -1;
    }
    
    private int getLast(){
        int size = publicationList.size();
        if (size > 0){
            return publicationList.get(size-1).getId() + 1;
        }
        else{
            return 1;
        }
    }
}
