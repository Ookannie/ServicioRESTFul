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

    public List<Comentario> find(String nombreUsuario, int idPublicacion, LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        String sql = "SELECT c.* FROM comentarios c INNER JOIN usuarios u ON c.ID_Usr = u.ID WHERE u.NombreUsuario = ? AND c.ID_Pub = ? AND c.FechaHora BETWEEN ? AND ?";
        try {
            PreparedStatement statement = conexion.prepareStatement(sql);
            statement.setString(1, nombreUsuario);
            statement.setInt(2, idPublicacion);
            statement.setString(3, fechaInicio.toString());
            statement.setString(4, fechaFin.toString());
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
            System.out.println("Error al buscar los comentarios en la base de datos: " + ex.getMessage());
            return null;
        }
    }

    public List<Comentario> findByUserName(String nombreUsuario) {
        String sql = "SELECT c.* FROM comentarios c "
                + "INNER JOIN usuarios u ON c.ID_Usr = u.ID "
                + "WHERE u.NombreUsuario = ?";
        try {
            PreparedStatement statement = conexion.prepareStatement(sql);
            statement.setString(1, nombreUsuario);
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
            System.out.println("Error al buscar comentarios por nombre de usuario en la base de datos: " + ex.getMessage());
            return null;
        }
    }

    public List<Comentario> findByIdPublicacion(int idPublicacion) {
        String sql = "SELECT * FROM comentarios WHERE ID_Pub = ?";
        try {
            PreparedStatement statement = conexion.prepareStatement(sql);
            statement.setInt(1, idPublicacion);
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
            System.out.println("Error al buscar comentarios por ID de publicación en la base de datos: " + ex.getMessage());
            return null;
        }
    }

    public List<Comentario> findByDateRange(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        String sql = "SELECT * FROM comentarios WHERE FechaHora BETWEEN ? AND ?";
        try {
            PreparedStatement statement = conexion.prepareStatement(sql);
            statement.setString(1, fechaInicio.toString());
            statement.setString(2, fechaFin.toString());
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
            System.out.println("Error al buscar comentarios por rango de fechas en la base de datos: " + ex.getMessage());
            return null;
        }
    }

    @Override
    public boolean create(Comentario comentario) {
        String sql = "INSERT INTO comentarios (FechaHora, Texto, ID_Usr, ID_Pub) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement statement = conexion.prepareStatement(sql);
            //statement.setInt(1, comentario.getId());
            statement.setString(1, comentario.getFechaHora().toString());
            statement.setString(2, comentario.getTexto());
            statement.setInt(3, comentario.getId_usr());
            statement.setInt(4, comentario.getId_pub());
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
