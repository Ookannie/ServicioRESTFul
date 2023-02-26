/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;

/**
 *
 * @author
 */
public class Comentario {

    @JsonProperty("id")
    private int id;

    @JsonProperty("fecha_hora")
    private LocalDateTime fechaHora;

    @JsonProperty("texto")
    private String texto;

    @JsonProperty("id_usr")
    private int idUsr;

    @JsonProperty("id_pub")
    private int idPub;

    //@JsonProperty("fecha")  private Calendar fecha;
    @JsonProperty("autor")
    private String autor;

    public Comentario(int id, LocalDateTime fechaHora, String texto, int idUsuario, int idPublicacion) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.texto = texto;
        this.idUsr = idUsuario;
        this.idPub = idPublicacion;
    }

    public Comentario() {
    }

    public Comentario(int id, String texto, String autor, int id_usr, int id_pub) {
        this.id = id;
        this.texto = texto;
        this.autor = autor;
        //this.fecha = new GregorianCalendar();
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
        /*
    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
         >>> >>> > 2b31d0326ada84612db34109d537fc20081f5a28
    }
         */
    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }


    public int getIdUsuario() {
        return idUsr;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsr = idUsuario;
    }

    public int getIdPublicacion() {
        return idPub;
    }

    public void setIdPublicacion(int idPublicacion) {
        this.idPub = idPublicacion;
    }
    
    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }


}
