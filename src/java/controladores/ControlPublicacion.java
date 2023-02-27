/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import daos.PublicacionDAO;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;
import modelos.Publicacion;

/**
 *
 * @author
 */
public class ControlPublicacion {

    PublicacionDAO publicacionDAO;

    public ControlPublicacion() {
        publicacionDAO = new PublicacionDAO();
    }

    public Publicacion
            getById(int id) {
        return publicacionDAO.getById(id);
    }

    public List<Publicacion> getAll() {
        return publicacionDAO.getAll();
    }

    public List<Publicacion> find(String titulo, String nombreUsuario, LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        return publicacionDAO.find(titulo, nombreUsuario, fechaInicio, fechaFin);
    }

    public List<Publicacion> findByDateRange(Calendar fechaInicio, Calendar fechaFin) {
        return publicacionDAO.findByDateRange(fechaInicio, fechaFin);
    }

    public List<Publicacion> findByUserName(String nombreUsuario) {
        return publicacionDAO.findByUserName(nombreUsuario);
    }

    public List<Publicacion> findByTitle(String titulo) {
        return publicacionDAO.findByTitle(titulo);
    }

    public boolean create(Publicacion publicacion) {
        return publicacionDAO.create(publicacion);
    }

    public boolean update(Publicacion publicacion) {
        return publicacionDAO.update(publicacion);
    }

    public boolean delete(int id) {
        return publicacionDAO.delete(id);
    }

}
