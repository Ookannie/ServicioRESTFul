/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recursos;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
<<<<<<< HEAD
import daos.UsuarioDAO;
=======
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
>>>>>>> 2b31d0326ada84612db34109d537fc20081f5a28
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import modelos.Usuario;
import servicios.ServicioUsuario;

/**
 *
 * @author 
 */

@Path("/usuario")
public class RecursoUsuario {
    
    ServicioUsuario userService = new ServicioUsuario();
    
<<<<<<< HEAD
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsuario() {
        Usuario usuario = new Usuario(01, "Prueba", "prueba@gmail", "****");
        Usuario temp = new Usuario( 01,"PRRRROB", "prueba@gmail", "****");
        
        UsuarioDAO dao = new UsuarioDAO();
        System.out.println(dao.delete(1));

=======
    private String objectToString(Object object)
    {
>>>>>>> 2b31d0326ada84612db34109d537fc20081f5a28
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = null;
        try {
            jsonString = mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonString;
    }
    
    private Usuario stringToUser(String jsonString) {
        ObjectMapper mapper = new ObjectMapper();
        Usuario usuario = new Usuario();
        try {
         usuario = mapper.readValue(jsonString, Usuario.class);
        }
        catch(JsonProcessingException e) {
            e.printStackTrace();
        }
       
        return usuario;
    }
    
    
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers() {
        //Usuario usuario = new Usuario(01, "Prueba", "prueba@gmail", "****");
        List<Usuario> userList = userService.getUsers();

        return Response.status(Response.Status.OK).entity(objectToString(userList)).build();
    }

    @GET
    @Path("/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@PathParam("userId") int id) {
        Usuario usuario = userService.getUser(id);
        return Response.status(Response.Status.OK).entity(objectToString(usuario)).build();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addUser(String usuario)
    {
        userService.addUser(stringToUser(usuario));
        return Response.status(Response.Status.OK).entity(usuario).build();
    }
    
    @DELETE
    @Path("/{userId}")
    public void deleteUser(@PathParam("userId") int id)
    {
        userService.deleteUser(id);
    }
}
