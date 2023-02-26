/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recursos;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import modelos.Comentario;
import servicios.ServicioComentario;
;

/**
 *
 * @author alexj
 */
@Path("/comentario")
public class RecursoComentario {

    ServicioComentario commentService = new ServicioComentario();

    private String objectToString(Object object) {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = null;
        try {
            jsonString = mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonString;
    }
    
    private Comentario stringToComment(String jsonString){
                ObjectMapper mapper = new ObjectMapper();
        Comentario comentario = new Comentario();
        try {
         comentario = mapper.readValue(jsonString, Comentario.class);
        }
        catch(JsonProcessingException e) {
            e.printStackTrace();
        }
       
        return comentario;
    }
    
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getComments(){
        List<Comentario> commentList = commentService.getComments();
        
        return Response.status(Response.Status.OK).entity(objectToString(commentList)).build();
    }
    
    @GET
    @Path("/{commentId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getComment(@PathParam("commentId") int id){
        Comentario comentario = commentService.getComment(id);
        return Response.status(Response.Status.OK).entity(objectToString(comentario)).build();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addComment(String comentario){
        commentService.addComment(stringToComment(comentario));
        return Response.status(Response.Status.OK).entity(comentario).build();
    }
    
    @DELETE
    @Path("/{commentId}")
    public void deleteComment(@PathParam("commentId") int id){
        commentService.deleteComment(id);
    }
    
}
