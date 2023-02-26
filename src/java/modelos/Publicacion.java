/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author
 */
public class PublicacionT {

    @JsonProperty("id")
    private int id;

    @JsonProperty("fecha_hora")
    private LocalDateTime fechaHora;

    @JsonProperty("titulo")
    private String titulo;

    @JsonProperty("texto")
    private String texto;

    @JsonProperty("id_usr")
    private int idUsr;

<<<<<<< HEAD:src/java/modelos/Publicacion.java
    @JsonProperty("fecha")
    private Calendar fecha;

    @JsonProperty("autor")
    private String autor;

    public Publicacion() {
=======
    public PublicacionT() {
>>>>>>> bd:src/java/modelos/PublicacionT.java
    }

    public PublicacionT(int id, LocalDateTime fechaHora, String titulo, String texto, int idUsr) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.titulo = titulo;
        this.texto = texto;
        this.idUsr = idUsr;
    }

    public PublicacionT(LocalDateTime fechaHora, String titulo, String texto, int idUsr) {
        this.fechaHora = fechaHora;
        this.titulo = titulo;
        this.texto = texto;
        this.idUsr = idUsr;
    }

    public Publicacion(int id, String titulo, String texto, String autor) {
        this.id = id;
        this.titulo = titulo;
        this.texto = texto;
        this.autor = autor;
        this.fecha = new GregorianCalendar();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getIdUsr() {
        return idUsr;
    }

    public void setIdUsr(int idUsr) {
        this.idUsr = idUsr;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
