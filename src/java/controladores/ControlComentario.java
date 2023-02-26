/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import daos.ComentarioDAO;
import java.time.LocalDateTime;
import java.util.List;
import modelos.ComentarioT;

/**
 *
 * @author
 */
public class ControlComentario {

    ComentarioDAO comentarioDAO;

    public ControlComentario() {
        comentarioDAO = new ComentarioDAO();
    }

    public ComentarioT getById(int id) {
        return comentarioDAO.getById(id);
    }

    public List<ComentarioT> getAll() {
        return comentarioDAO.getAll();
    }

    public List<ComentarioT> find(String nombreUsuario, int idPublicacion, LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        return comentarioDAO.find(nombreUsuario, idPublicacion, fechaInicio, fechaFin);
    }

    public List<ComentarioT> findByUserName(String nombreUsuario) {
        return comentarioDAO.findByUserName(nombreUsuario);
    }
    
    public List<ComentarioT> findByIdPublicacion(int idPublicacion){
        return comentarioDAO.findByIdPublicacion(idPublicacion);
    }
    
     public List<ComentarioT> findByDateRange(LocalDateTime fechaInicio, LocalDateTime fechaFin){
         return comentarioDAO.findByDateRange(fechaInicio, fechaFin);
     }

    public boolean create(ComentarioT comentario) {
        return comentarioDAO.create(comentario);
    }

    public boolean update(ComentarioT comentario) {
        return comentarioDAO.update(comentario);
    }

    public boolean delete(int id) {
        return comentarioDAO.delete(id);
    }

}
