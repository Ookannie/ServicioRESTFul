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

    private List<Usuario> userList = DataBaseUser.getInstance().getList();
    private ControlUsuario controlUsuario;

    public ServicioUsuario() {
        this.controlUsuario = new ControlUsuario();
    }

    public List<Usuario> getUsers() {
        return userList;
    }

    public Usuario getUser(int id) {
        for (Usuario usuario : userList) {
            if (usuario.getId() == id) {
                return usuario;
            }
        }
        return null;
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

    public void deleteUser(int id) {
        int position = getPosition(id);
        userList.remove(position);
    }

    private int getPosition(int id) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    private int getLast() {
        int size = userList.size();
        if (size > 0) {
            return userList.get(size - 1).getId() + 1;
        } else {
            return 1;
        }
    }
}
