/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author alexj
 */
public class Publicacion {

    @JsonProperty("id")
    private int id;

    @JsonProperty("fecha_hora")
    private Calendar fecha_hora;

    @JsonProperty("titulo")
    private String titulo;

    @JsonProperty("texto")
    private String texto;

    @JsonProperty("id_usr")
    private int idUsr;

    public Publicacion() {
       this.fecha_hora = Calendar.getInstance();

    }

    public Publicacion(int id, String titulo, String texto, int idUsr) {
        this.id = id;
        this.titulo = titulo;
        this.texto = texto;
        this.idUsr = idUsr;
    }

    public Publicacion(Calendar fecha, String titulo, String texto, int idUsr) {
        this.fecha_hora = fecha;
        this.titulo = titulo;
        this.texto = texto;
        this.idUsr = idUsr;
    }

    public Publicacion(int id, Calendar fecha_hora, String titulo, String texto, int idUsr) {
        this.id = id;
        this.fecha_hora = fecha_hora;
        this.titulo = titulo;
        this.texto = texto;
        this.idUsr = idUsr;
    }

    public Publicacion(int id, String titulo, String texto, String autor) {
        this.id = id;
        this.titulo = titulo;
        this.texto = texto;
        this.fecha_hora = new GregorianCalendar();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Calendar getFecha() {
        return fecha_hora;
    }

    public void setFecha(Calendar fecha) {
        this.fecha_hora = fecha;
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
