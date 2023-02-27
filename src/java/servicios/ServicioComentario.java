/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicios;

import controladores.ControlComentario;
import java.util.Calendar;
import java.util.List;
import modelos.Comentario;
import modelos.Publicacion;
import simulacionBD.DataBaseComment;

/**
 *
 * @author alexj
 */
public class ServicioComentario {

    private List<Comentario> commentList = DataBaseComment.getInstance().getList();
    private ControlComentario controlComentario;

    public ServicioComentario() {
        this.controlComentario = new ControlComentario();
    }

    public List<Comentario> getComments() {
        return controlComentario.getAll();
    }

    public Comentario getComment(int id) {
        return controlComentario.getById(id);
    }

    public List<Comentario> getCommentsByUserName(String comentarioName) {
        List<Comentario> comentarios = controlComentario.findByUserName(comentarioName);
        return comentarios;
    }

    public List<Comentario> getCommentsByPublicationID(int idPub) {
        List<Comentario> comentarios = controlComentario.findByIdPublicacion(idPub);
        return comentarios;
    }

    public List<Comentario> getCommentsByDateRange(Calendar fechaInicio, Calendar fechaFin) {
        List<Comentario> comentarios = controlComentario.findByDateRange(fechaInicio, fechaFin);
        return comentarios;
    }

    public Comentario addComment(Comentario comentario) {
        controlComentario.create(comentario);
        return comentario;
    }

    public Comentario updateComment(Comentario comentario) {
        controlComentario.update(comentario);
        return comentario;
    }

    public void deleteComment(int id) {
        controlComentario.delete(id);
    }

//    private int getPosition(int id) {
//        for (int i = 0; i < commentList.size(); i++) {
//            if (commentList.get(i).getId() == id) {
//                return i;
//            }
//        }
//        return -1;
//    }
//
//    private int getLast() {
//        int size = commentList.size();
//        if (size > 0) {
//            return commentList.get(size - 1).getId() + 1;
//        } else {
//            return 1;
//        }
//    }
}
