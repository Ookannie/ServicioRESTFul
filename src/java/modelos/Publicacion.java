/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author alexj
 */
public class Publicacion {
    @JsonProperty("id")     private int id;
    @JsonProperty("fecha")  private Calendar fecha;
    @JsonProperty("titulo") private String titulo;
    @JsonProperty("texto")  private String texto;
    @JsonProperty("autor")  private String autor;

    public Publicacion() {
    }

    public Publicacion(int id, String titulo, String texto, String autor) {
        this.id = id;
        this.titulo = titulo;
        this.texto = texto;
        this.autor = autor;
        this.fecha = new GregorianCalendar();
    }
    
    public void noHaceNada(){}

    
    /*************Gets y Sets************/
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

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
