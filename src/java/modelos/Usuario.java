
package modelos;
import  com.fasterxml.jackson.annotation.JsonProperty;

public class Usuario {
    @JsonProperty("id")
    private String id;
    
    @JsonProperty("nombre_completo")
    private String nombreCompleto;
    
    @JsonProperty("correo")
    private String correo;
    
    @JsonProperty("contrasenia")
    private String contrasenia;

    public Usuario() {
    }

    
    public Usuario(String id, String nombreCompleto, String correo, String contrasenia) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.correo = correo;
        this.contrasenia = contrasenia;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
}
