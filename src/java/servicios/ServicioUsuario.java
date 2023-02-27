/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicios;

import controladores.ControlUsuario;
import java.util.List;
import modelos.Usuario;
import simulacionBD.DataBaseUser;

/**
 *
 * @author
 */
public class ServicioUsuario {

    private ControlUsuario controlUsuario;

    public ServicioUsuario() {
        this.controlUsuario = new ControlUsuario();
    }

    public List<Usuario> getUsers() {
        return controlUsuario.getAll();
    }

    public Usuario getUser(int id) {
        return controlUsuario.getById(id);
    }

    public Usuario getUserByName(String name) {
        return controlUsuario.findByName(name).get(0);
    }

    public Usuario getUserByEmail(String email) {
        return controlUsuario.findByEmail(email).get(0);
    }

    public Usuario addUser(Usuario usuario) {
        //usuario.setId(getLast());
        controlUsuario.create(usuario);
        //userList.add(usuario);
        return usuario;
    }

    public Usuario updateUser(Usuario usuario) {
        //usuario.setId(getLast());
        controlUsuario.update(usuario);
        //userList.add(usuario);
        return usuario;
    }

    public void deleteUser(int id) {
        //int position = getPosition(id);
        controlUsuario.delete(id);
    }

}
