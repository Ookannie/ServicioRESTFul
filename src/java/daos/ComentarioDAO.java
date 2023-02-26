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
import modelos.Comentario;

/**
 *
 * @author
 */
public class ComentarioDAO implements IDAO<Comentario> {

    private Connection conexion;

    public ComentarioDAO() {
        try {
            this.conexion = ConexionSQLite.conectar();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Comentario getById(int id) {
        String sql = "SELECT * FROM comentarios WHERE ID = ?";
        try {
            PreparedStatement statement = conexion.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            Comentario comentario = null;
            if (resultSet.next()) {
                comentario = new Comentario(
                        resultSet.getInt("ID"),
                        LocalDateTime.parse(resultSet.getString("FechaHora")),
                        resultSet.getString("Texto"),
                        resultSet.getInt("ID_Usr"),
                        resultSet.getInt("ID_Pub")
                );
            }
            resultSet.close();
            statement.close();
            return comentario;
        } catch (SQLException ex) {
            System.out.println("Error al buscar el comentario en la base de datos: " + ex.getMessage());
            return null;
        }
    }

    @Override
    public List<Comentario> getAll() {
        String sql = "SELECT * FROM comentarios";
        try {
            PreparedStatement statement = conexion.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            List<Comentario> comentarios = new ArrayList<>();
            while (resultSet.next()) {
                Comentario comentario = new Comentario(
                        resultSet.getInt("ID"),
                        LocalDateTime.parse(resultSet.getString("FechaHora")),
                        resultSet.getString("Texto"),
                        resultSet.getInt("ID_Usr"),
                        resultSet.getInt("ID_Pub")
                );
                comentarios.add(comentario);
            }
            resultSet.close();
            statement.close();
            return comentarios;
        } catch (SQLException ex) {
            System.out.println("Error al listar los comentarios de la base de datos: " + ex.getMessage());
            return null;
        }
    }

    @Override
    public boolean create(Comentario comentario) {
        String sql = "INSERT INTO comentarios (ID, FechaHora, Texto, ID_Usr, ID_Pub) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement statement = conexion.prepareStatement(sql);
            statement.setInt(1, comentario.getId());
            statement.setString(2, comentario.getFechaHora().toString());
            statement.setString(3, comentario.getTexto());
            statement.setInt(4, comentario.getIdUsuario());
            statement.setInt(5, comentario.getIdPublicacion());
            statement.executeUpdate();
            statement.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("Error al insertar el comentario en la base de datos: " + ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean update(Comentario comentario) {
        String sql = "UPDATE comentarios SET Texto = ? WHERE ID = ?";
        try {
            PreparedStatement statement = conexion.prepareStatement(sql);
            statement.setString(1, comentario.getTexto());
            statement.setInt(2, comentario.getId());
            statement.executeUpdate();
            statement.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("Error al actualizar el comentario en la base de datos: " + ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM comentarios WHERE ID = ?";
        try {
            PreparedStatement statement = conexion.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
            statement.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("Error al eliminar el comentario de la base de datos: " + ex.getMessage());
            return false;
        }
    }

}
