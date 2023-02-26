/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicios;

import java.util.List;
import modelos.Comentario;
import simulacionBD.DataBaseComment;

/**
 *
 * @author alexj
 */
public class ServicioComentario {
    
    private List<Comentario> commentList = DataBaseComment.getInstance().getList();
    
    public List<Comentario> getComments(){
        return commentList;
    }
    
    public Comentario getComment(int id){
        for(Comentario comentario : commentList){
            if(comentario.getId() == id)
                return comentario;
        }
        return null;
    }
    
    public Comentario addComment(Comentario comentario){
        comentario.setId(getLast());
        commentList.add(comentario);
        return comentario;
    }
    
    public void deleteComment(int id){
        int position = getPosition(id);
        commentList.remove(position);
    }
    
    private int getPosition(int id){
        for (int i = 0; i< commentList.size(); i++){
            if (commentList.get(i).getId() == id){
                return i;
            }
        }
        return -1;
    }
    private int getLast(){
        int size = commentList.size();
        if (size > 0){
            return commentList.get(size - 1).getId() + 1;
        }
        else{
            return 1;
        }
    }
}
