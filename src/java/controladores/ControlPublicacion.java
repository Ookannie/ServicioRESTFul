/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import daos.PublicacionDAO;
import java.time.LocalDateTime;
import java.util.List;
import modelos.PublicacionT;

/**
 *
 * @author
 */
public class ControlPublicacion {
       PublicacionDAO publicacionDAO;

    public ControlPublicacion() {
        publicacionDAO = new PublicacionDAO();
    }
    
    public PublicacionT getById(int id){
        return publicacionDAO.getById(id);
    }
    
    public List<PublicacionT> getAll(){
        return publicacionDAO.getAll();
    }
    
    public List<PublicacionT> find(String titulo, String nombreUsuario, LocalDateTime fechaInicio, LocalDateTime fechaFin){
        return publicacionDAO.find(titulo, nombreUsuario, fechaInicio, fechaFin);
    }
    
     public List<PublicacionT> findByDateRange(LocalDateTime fechaInicio, LocalDateTime fechaFin){
         return publicacionDAO.findByDateRange(fechaInicio, fechaFin);
     }
     
     public List<PublicacionT> findByUserName(String nombreUsuario){
         return publicacionDAO.findByUserName(nombreUsuario);
     }
     
     public List<PublicacionT> findByTitle(String titulo){
         return publicacionDAO.findByTitle(titulo);
     }
    
    public boolean create (PublicacionT publicacion){
        return publicacionDAO.create(publicacion);
    }
    
    public boolean update(PublicacionT publicacion){
        return publicacionDAO.update(publicacion);
    }
    
    public boolean delete (int id){
        return publicacionDAO.delete(id);
    }
    
    
    
}
