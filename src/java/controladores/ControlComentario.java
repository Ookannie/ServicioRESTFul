/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import daos.ComentarioDAO;
import java.time.LocalDateTime;
import java.util.List;
import modelos.Comentario;

/**
 *
 * @author
 */
public class ControlComentario {

    ComentarioDAO comentarioDAO;

    public ControlComentario() {
        comentarioDAO = new ComentarioDAO();
    }

    public Comentario getById(int id) {
        return comentarioDAO.getById(id);
    }

    public List<Comentario> getAll() {
        return comentarioDAO.getAll();
    }

    public List<Comentario> find(String nombreUsuario, int idPublicacion, LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        return comentarioDAO.find(nombreUsuario, idPublicacion, fechaInicio, fechaFin);
    }

    public List<Comentario> findByUserName(String nombreUsuario) {
        return comentarioDAO.findByUserName(nombreUsuario);
    }
    
    public List<Comentario> findByIdPublicacion(int idPublicacion){
        return comentarioDAO.findByIdPublicacion(idPublicacion);
    }
    
     public List<Comentario> findByDateRange(LocalDateTime fechaInicio, LocalDateTime fechaFin){
         return comentarioDAO.findByDateRange(fechaInicio, fechaFin);
     }

    public boolean create(Comentario comentario) {
        return comentarioDAO.create(comentario);
    }

    public boolean update(Comentario comentario) {
        return comentarioDAO.update(comentario);
    }

    public boolean delete(int id) {
        return comentarioDAO.delete(id);
    }

}
