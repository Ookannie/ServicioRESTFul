/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicios;

import java.util.List;
import modelos.Usuario;
import simulacionBD.DataBaseUser;

/**
 *
 * @author 
 */
public class ServicioUsuario {
    
    private List<Usuario> userList = DataBaseUser.getInstance().getList();
    
    public List<Usuario> getUsers(){
        return userList;
    }
    
    public Usuario getUser(int id){
        for(Usuario usuario : userList){
            if(usuario.getId() == id){
                return usuario;
            }
        }
        return null;
    }
    
    public Usuario addUser(Usuario usuario){
        usuario.setId(getLast());
        userList.add(usuario);
        return usuario;
    }
    
    public void deleteUser(int id){
        int position = getPosition(id);
        userList.remove(position);
    }
    
    private int getPosition(int id){
        for(int i = 0; i < userList.size(); i++){
            if (userList.get(i).getId() == id){
                return i;
            }
        }
        return -1;
    }
            
    private int getLast(){
        int size = userList.size();
        if (size >0){
            return userList.get(size - 1).getId() + 1;
        }
        else {
            return 1;
        }
    }
}
