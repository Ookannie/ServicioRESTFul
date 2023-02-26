/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import daos.UsuarioDAO;
import java.util.List;
import modelos.Usuario;

/**
 *
 * @author 
 */
public class ControlUsuario {
    UsuarioDAO usuarioDAO;

    public ControlUsuario() {
        usuarioDAO = new UsuarioDAO();
    }
    
    public Usuario getById(int id){
        return usuarioDAO.getById(id);
    }
    
    public List<Usuario> getAll(){
        return usuarioDAO.getAll();
    }
    
    public List<Usuario> getAllByNameAndEmail(String nombreCompleto, String correo){
        return usuarioDAO.getAllByNameAndEmail(nombreCompleto, correo);
    }
    
    public List<Usuario> findByEmail(String correo){
        return usuarioDAO.findByEmail(correo);
    }
    
    public List<Usuario> findByName(String nombre){
        return usuarioDAO.findByName(nombre);
    }
    
    public boolean create (Usuario usuario){
        return usuarioDAO.create(usuario);
    }
    
    public boolean update(Usuario usuario){
        return usuarioDAO.update(usuario);
    }
    
    public boolean delete (int id){
        return usuarioDAO.delete(id);
    }
    
    
    
    
    
    
}
