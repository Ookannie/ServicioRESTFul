/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recursos;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import daos.UsuarioDAO;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import modelos.Usuario;

/**
 *
 * @author 
 */

@Path("/usuario")
public class RecursoUsuario {
    
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsuario() {
        Usuario usuario = new Usuario(01, "Prueba", "prueba@gmail", "****");
        Usuario temp = new Usuario( 01,"PRRRROB", "prueba@gmail", "****");
        
        UsuarioDAO dao = new UsuarioDAO();
        //System.out.println(dao.delete(1));

        ObjectMapper mapper = new ObjectMapper();
        String jsonUsuario = null;
        try {
            jsonUsuario = mapper.writeValueAsString(usuario);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return Response.status(Response.Status.OK).entity(jsonUsuario).build();
    }}
