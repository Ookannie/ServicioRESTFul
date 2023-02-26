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
public class Comentario {
    @JsonProperty("id")     private int id;
    @JsonProperty("fecha")  private Calendar fecha;
    @JsonProperty("texto")  private String texto;
    @JsonProperty("autor")  private String autor;
    @JsonProperty("id_usr") private int id_usr;
    @JsonProperty("id_pub") private int id_pub;

    public Comentario() {
    }

    public Comentario(int id, String texto, String autor, int id_usr, int id_pub) {
        this.id = id;
        this.texto = texto;
        this.autor = autor;
        this.id_usr = id_usr;
        this.id_pub = id_pub;
        this.fecha = new GregorianCalendar();
    }

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

    public int getId_usr() {
        return id_usr;
    }

    public void setId_usr(int id_usr) {
        this.id_usr = id_usr;
    }

    public int getId_pub() {
        return id_pub;
    }

    public void setId_pub(int id_pub) {
        this.id_pub = id_pub;
    }
}
