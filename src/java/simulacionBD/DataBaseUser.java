/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simulacionBD;

import java.util.ArrayList;
import java.util.List;
import modelos.Usuario;

/**
 * Clase que simula una base de datos, solamente es para hacer pruebas
 * No debe incluirse en la version final
 * O eso creo yo...
 * @author alexj
 */
public final class DataBaseUser {
    private final static DataBaseUser dataBaseUser = new DataBaseUser();
    private final List<Usuario> userList = new ArrayList<>();
    
    private DataBaseUser(){
        Usuario usuario1 = new Usuario(1, "Alex", "alex@yahoo.com", "j3j3");
        Usuario usuario2 = new Usuario(2, "Ana", "ana@live.com", "aaaaaaa");
        Usuario usuario3 = new Usuario(3, "Michel", "kotry@aol.com", "arribaLasChivas");
        userList.add(usuario1);
        userList.add(usuario2);
        userList.add(usuario3);
    }
    
    public static DataBaseUser getInstance(){
        return dataBaseUser;
    }
    
    public List<Usuario> getList(){
        return userList;
    }
}
