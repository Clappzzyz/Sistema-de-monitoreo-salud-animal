package com.monitoreo.dao;

import com.monitoreo.conexion.ConexionBD;
import java.sql.*;

public class AnimalDAO {

    // 1. INSERCIÓN
    public void registrarAnimal(String nombre, String especie, String estadoSalud) {
        String sql = "INSERT INTO animales (nombre, especie, estado_salud) VALUES (?, ?, ?)";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nombre);
            pstmt.setString(2, especie);
            pstmt.setString(3, estadoSalud);
            pstmt.executeUpdate();
            System.out.println("Animal registrado correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al insertar: " + e.getMessage());
        }
    }

    // 2. CONSULTA
    public void consultarAnimales() {
        String sql = "SELECT * FROM animales";
        try (Connection conn = ConexionBD.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + 
                                   " | Nombre: " + rs.getString("nombre") + 
                                   " | Especie: " + rs.getString("especie") + 
                                   " | Estado: " + rs.getString("estado_salud"));
            }
        } catch (SQLException e) {
            System.err.println("Error al consultar: " + e.getMessage());
        }
    }

    // 3. ACTUALIZACIÓN
    public void actualizarEstadoSalud(int idAnimal, nuevoEstadoSalud) {
        String sql = "UPDATE animales SET estado_salud = ? WHERE id = ?";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nuevoEstadoSalud);
            pstmt.setInt(2, idAnimal);
            pstmt.executeUpdate();
            System.out.println("Estado de salud actualizado con éxito.");
        } catch (SQLException e) {
            System.err.println("Error al actualizar: " + e.getMessage());
        }
    }

    // 4. ELIMINACIÓN
    public void eliminarAnimal(int idAnimal) {
        String sql = "DELETE FROM animales WHERE id = ?";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idAnimal);
            pstmt.executeUpdate();
            System.out.println("Registro de animal eliminado correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al eliminar: " + e.getMessage());
        }
    }
}