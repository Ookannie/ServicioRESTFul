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
public class ComentarioT {

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

    public ComentarioT() {
    }

    public ComentarioT(LocalDateTime fechaHora, String texto, int idUsr, int idPub) {
        this.fechaHora = fechaHora;
        this.texto = texto;
        this.idUsr = idUsr;
        this.idPub = idPub;
    }

    public ComentarioT(int id, LocalDateTime fechaHora, String texto, int idUsuario, int idPublicacion) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.texto = texto;
        this.idUsr = idUsuario;
        this.idPub = idPublicacion;
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
}
