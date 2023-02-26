
package modelos;
import  com.fasterxml.jackson.annotation.JsonProperty;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Usuario {
    @JsonProperty("id")
    private int id;
    
    @JsonProperty("nombre_completo")
    private String nombreCompleto;
    
    @JsonProperty("correo")
    private String correo;

    public Usuario(String nombreCompleto, String correo, String contrasenia) {
        this.nombreCompleto = nombreCompleto;
        this.correo = correo;
        this.contrasenia = contrasenia;
    }
    
    @JsonProperty("contrasenia")
    private String contrasenia;

    public Usuario() {
    }

    
    public Usuario(int id, String nombreCompleto, String correo, String contrasenia) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.correo = correo;
        this.contrasenia = contrasenia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
