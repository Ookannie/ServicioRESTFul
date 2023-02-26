/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import conexion.ConexionSQLite;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.Usuario;

/**
 *
 * @author
 */
public class UsuarioDAO implements IDAO<Usuario> {

    private Connection conexion;

    public UsuarioDAO() {
        try {
            this.conexion = ConexionSQLite.conectar();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Usuario getById(int id) {
        String sql = "SELECT * FROM usuarios WHERE ID = ?";
        try {
            PreparedStatement statement = conexion.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            Usuario usuario = null;
            if (resultSet.next()) {
                usuario = new Usuario(
                        resultSet.getInt("ID"),
                        resultSet.getString("NombreCompleto"),
                        resultSet.getString("Correo"),
                        resultSet.getString("Contrasenia")
                );
            }
            resultSet.close();
            statement.close();
            return usuario;
        } catch (SQLException ex) {
            System.out.println("Error al buscar el usuario en la base de datos: " + ex.getMessage());
            return null;
        }
    }

    public List<Usuario> getAll() {
        String sql = "SELECT * FROM usuarios";
        try {
            PreparedStatement statement = conexion.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            List<Usuario> usuarios = new ArrayList<>();
            while (resultSet.next()) {
                Usuario usuario = new Usuario(
                        resultSet.getInt("ID"),
                        resultSet.getString("NombreCompleto"),
                        resultSet.getString("Correo"),
                        resultSet.getString("Contrasenia")
                );
                usuarios.add(usuario);
            }
            resultSet.close();
            statement.close();
            return usuarios;
        } catch (SQLException ex) {
            System.out.println("Error al obtener todos los usuarios de la base de datos: " + ex.getMessage());
            return null;
        }
    }

    @Override
    public boolean create(Usuario usuario) {
        String sql = "INSERT INTO usuarios (ID, NombreCompleto, Correo, Contrasenia) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement statement = conexion.prepareStatement(sql);
            statement.setInt(1, usuario.getId());
            statement.setString(2, usuario.getNombreCompleto());
            statement.setString(3, usuario.getCorreo());
            statement.setString(4, usuario.getContrasenia());
            statement.executeUpdate();
            statement.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("Error al insertar el usuario en la base de datos: " + ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean update(Usuario usuario) {
        String sql = "UPDATE usuarios SET NombreCompleto = ?, Correo = ?, Contrasenia = ? WHERE ID = ?";
        try {
            PreparedStatement statement = conexion.prepareStatement(sql);
            statement.setString(1, usuario.getNombreCompleto());
            statement.setString(2, usuario.getCorreo());
            statement.setString(3, usuario.getContrasenia());
            statement.setInt(4, usuario.getId());
            statement.executeUpdate();
            statement.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("Error al actualizar el usuario en la base de datos: " + ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM usuarios WHERE ID = ?";
        try {
            PreparedStatement statement = conexion.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
            statement.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("Error al eliminar el usuario de la base de datos: " + ex.getMessage());
            return false;
        }
    }

}
