/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebas;

import daos.UsuarioDAO;
import modelos.Usuario;

/**
 *
 * @author anaga
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic her
        Usuario usuario = new Usuario("Prueba", "prueba@gmail", "****");
        UsuarioDAO usuarioDao = new UsuarioDAO();
        
        usuarioDao.create(usuario);
    }
    
}
