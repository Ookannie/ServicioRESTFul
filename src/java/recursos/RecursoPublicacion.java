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
import modelos.Publicacion;
import modelos.Usuario;
import servicios.ServicioPublicacion;

/**
 *
 * @author alexj
 */
@Path("/publicacion")
public class RecursoPublicacion {

    ServicioPublicacion publicationService = new ServicioPublicacion();

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

    private Publicacion stringToPublication(String jsonString) {
        ObjectMapper mapper = new ObjectMapper();
        Publicacion publicacion = new Publicacion();
        try {
            publicacion = mapper.readValue(jsonString, Publicacion.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return publicacion;
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPublicaciones() {
        List<Publicacion> publicationList = publicationService.getPublications();

        return Response.status(Response.Status.OK).entity(objectToString(publicationList)).build();
    }

    @GET
    @Path("/{publicationId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPublication(@PathParam("publicationId") int id) {
        Publicacion publicacion = publicationService.getPublication(id);

        return Response.status(Response.Status.OK).entity(objectToString(publicacion)).build();
    }

    @GET
    @Path("/title={publicationTitle}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPublicationByTitle(@PathParam("publicationTitle") String title) {
        Publicacion publicacion = publicationService.getPublicationByTitle(title);

        return Response.status(Response.Status.OK).entity(objectToString(publicacion)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addPublication(String publicacion) {
        publicationService.addPublication(stringToPublication(publicacion));
        return Response.status(Response.Status.OK).entity(publicacion).build();
    }

    @DELETE
    @Path("/{publicationId}")
    public void deletePublication(@PathParam("publicationId") int id) {
        publicationService.deletePublication(id);
    }
}
