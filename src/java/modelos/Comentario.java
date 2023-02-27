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
public class Comentario {

    @JsonProperty("id")
    private int id;
    
    @JsonProperty("fecha_hora")
    private Calendar fecha_hora;
    
    @JsonProperty("texto")
    private String texto;
    
    @JsonProperty("id_usr")
    private int id_usr;
    
    @JsonProperty("id_pub")
    private int id_pub;

    public Comentario() {
      this.fecha_hora = Calendar.getInstance();
    }

    public Comentario(int id, Calendar fecha_hora,  String texto, int id_usr, int id_pub) {
        this.id = id;
        this.fecha_hora = fecha_hora;
        this.texto = texto;
        this.id_usr = id_usr;
        this.id_pub = id_pub;
    }

    public Comentario(int id, String texto, int id_usr, int id_pub) {
        this.id = id;
        this.texto = texto;
        this.id_usr = id_usr;
        this.id_pub = id_pub;
    }

    
    public Comentario(int id, String texto, String autor, int id_usr, int id_pub) {
        this.id = id;
        this.texto = texto;
        this.id_usr = id_usr;
        this.id_pub = id_pub;
        this.fecha_hora = new GregorianCalendar();
    }

    public Comentario(Calendar fecha_hora, String texto, int id_usr, int id_pub) {
        this.fecha_hora = fecha_hora;
        this.texto = texto;
        this.id_usr = id_usr;
        this.id_pub = id_pub;
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

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
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
