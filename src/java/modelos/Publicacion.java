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
 * @author alexj
 */
public class Publicacion {

    @JsonProperty("id")
    private int id;
    
    @JsonProperty("fecha")
    private Calendar fecha;
    
    @JsonProperty("fecha_hora")
    private LocalDateTime fechaHora;
    
    @JsonProperty("titulo")
    private String titulo;
    
    @JsonProperty("texto")
    private String texto;
    
    @JsonProperty("id_usr")
    private int idUsr;

    public Publicacion() {
    }

    public Publicacion(int id, LocalDateTime fechaHora, String titulo, String texto, int idUsr) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.titulo = titulo;
        this.texto = texto;
        this.idUsr = idUsr;
    }
    
    

    public Publicacion(LocalDateTime fechaHora, String titulo, String texto, int idUsr) {
        this.fechaHora = fechaHora;
        this.titulo = titulo;
        this.texto = texto;
        this.idUsr = idUsr;
    }

    public Publicacion(Calendar fecha, LocalDateTime fechaHora, String titulo, String texto, int idUsr) {
        this.fecha = fecha;
        this.fechaHora = fechaHora;
        this.titulo = titulo;
        this.texto = texto;
        this.idUsr = idUsr;
    }
    
    

    public Publicacion(int id, String titulo, String texto, String autor) {
        this.id = id;
        this.titulo = titulo;
        this.texto = texto;
        this.fecha = new GregorianCalendar();
    }

  
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public int getIdUsr() {
        return idUsr;
    }

    public void setIdUsr(int idUsr) {
        this.idUsr = idUsr;
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

}
