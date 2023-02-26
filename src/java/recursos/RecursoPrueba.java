/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recursos;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import daos.ComentarioDAO;
import daos.PublicacionDAO;
import daos.UsuarioDAO;
import java.time.LocalDateTime;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import modelos.Usuario;
import modelos.PublicacionT;
import modelos.ComentarioT;

/**
 *
 * @author
 */
@Path("/prueba")
public class RecursoPrueba {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsuario() {
        Usuario usuario1 = new Usuario("Juan Perez", "juanperez@gmail.com", "password123");
        UsuarioDAO dao = new UsuarioDAO();
        //dao.create(usuario1);
        PublicacionDAO publicacionDAO = new PublicacionDAO();

        //Publicacion publicacion1 = new Publicacion(1, LocalDateTime.now(), "Titulo 2", "Textoxxxxx 1", 1);
        //boolean success = publicacionDAO.update(publicacion1);
        PublicacionT publicacion2 = new PublicacionT(LocalDateTime.now(), "AAAAAAAAH", "Nuevo texto", 1);
        // publicacionDAO.create(publicacion2);

        // publicacionDAO.delete(0);
        ComentarioDAO comentarioDAO = new ComentarioDAO();
        ComentarioT comentario = new ComentarioT();
        comentario.setTexto("AAAAAAAAAAAAH");
        comentario.setFechaHora(LocalDateTime.now());
        comentario.setIdUsuario(0);
        comentario.setIdPublicacion(0); 
        comentarioDAO.delete(0);

        ObjectMapper mapper = new ObjectMapper();
        String jsonUsuario = null;
        try {
            jsonUsuario = mapper.writeValueAsString(usuario1);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return Response.status(Response.Status.OK).entity(jsonUsuario).build();
    }
}
