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
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.Publicacion;

/**
 *
 * @author
 */
public class PublicacionDAO implements IDAO<Publicacion> {

    private Connection conexion;

    public PublicacionDAO() {
        try {
            this.conexion = ConexionSQLite.conectar();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Publicacion getById(int id) {
        String sql = "SELECT * FROM publicaciones WHERE ID = ?";
        try {
            PreparedStatement statement = conexion.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            Publicacion publicacion = null;
            if (resultSet.next()) {
                publicacion = new Publicacion(
                        resultSet.getInt("ID"),
                        LocalDateTime.parse(resultSet.getString("FechaHora")),
                        resultSet.getString("Titulo"),
                        resultSet.getString("Texto"),
                        resultSet.getInt("ID_Usr")
                );
            }
            resultSet.close();
            statement.close();
            return publicacion;
        } catch (SQLException ex) {
            System.out.println("Error al buscar la publicación en la base de datos: " + ex.getMessage());
            return null;
        }
    }

    @Override
    public List<Publicacion> getAll() {
        String sql = "SELECT * FROM publicaciones";
        try {
            PreparedStatement statement = conexion.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            List<Publicacion> publicaciones = new ArrayList<>();
            while (resultSet.next()) {
                Publicacion publicacion = new Publicacion(
                        resultSet.getInt("ID"),
                        LocalDateTime.parse(resultSet.getString("FechaHora")),
                        resultSet.getString("Titulo"),
                        resultSet.getString("Texto"),
                        resultSet.getInt("ID_Usr")
                );
                publicaciones.add(publicacion);
            }
            resultSet.close();
            statement.close();
            return publicaciones;
        } catch (SQLException ex) {
            System.out.println("Error al listar las publicaciones de la base de datos: " + ex.getMessage());
            return null;
        }
    }

    @Override
    public boolean create(Publicacion publicacion) {
        String sql = "INSERT INTO publicaciones (FechaHora, Titulo, Texto, ID_Usr) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement statement = conexion.prepareStatement(sql);
            statement.setString(1, publicacion.getFechaHora().toString());
            statement.setString(2, publicacion.getTitulo());
            statement.setString(3, publicacion.getTexto());
            statement.setInt(4, publicacion.getIdUsr());
            statement.executeUpdate();
            statement.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("Error al insertar la publicación en la base de datos: " + ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean update(Publicacion publicacion) {
        String sql = "UPDATE publicaciones SET FechaHora = ?, Titulo = ?, Texto = ?, ID_Usr = ? WHERE ID = ?";
        try {
            PreparedStatement statement = conexion.prepareStatement(sql);
            statement.setString(1, publicacion.getFechaHora().toString());
            statement.setString(2, publicacion.getTitulo());
            statement.setString(3, publicacion.getTexto());
            statement.setInt(4, publicacion.getIdUsr());
            statement.setInt(5, publicacion.getId());
            statement.executeUpdate();
            statement.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("Error al actualizar la publicación en la base de datos: " + ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM publicaciones WHERE ID = ?";
        try {
            PreparedStatement statement = conexion.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
            statement.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("Error al eliminar la publicación de la base de datos: " + ex.getMessage());
            return false;
        }
    }

}
