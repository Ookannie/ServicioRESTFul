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
import javax.ws.rs.PUT;
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

    private Usuario stringToUser(String jsonString) {
        ObjectMapper mapper = new ObjectMapper();
        Usuario usuario = new Usuario();
        try {
            usuario = mapper.readValue(jsonString, Usuario.class);
        } catch (JsonProcessingException e) {
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

    @GET
    @Path("/name={userName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserByName(@PathParam("userName") String name) {
        Usuario usuario = userService.getUserByName(name);
        return Response.status(Response.Status.OK).entity(objectToString(usuario)).build();
    }

    @GET
    @Path("/email={userEmail}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserByEmail(@PathParam("userEmail") String email) {
        Usuario usuario = userService.getUserByEmail(email);
        return Response.status(Response.Status.OK).entity(objectToString(usuario)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addUser(String usuarioJSON) {
        Usuario usuario = stringToUser(usuarioJSON);
        userService.addUser(usuario);
        return Response.status(Response.Status.OK).entity(usuarioJSON).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUser(String usuarioJSON) {
        Usuario usuario = stringToUser(usuarioJSON);
        userService.updateUser(usuario);
        return Response.status(Response.Status.OK).entity(usuarioJSON).build();
    }

    @DELETE
    @Path("/{userId}")
    public void deleteUser(@PathParam("userId") int id) {
        userService.deleteUser(id);
    }
}
