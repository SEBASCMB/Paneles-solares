package org.example.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.example.model.Caracterizacion;
import org.example.util.DatabaseUtil;

public class CaracterizacionDAO {

    public void addCaracterizacion(Caracterizacion caracterizacion)
        throws SQLException {
        String sql =
            "INSERT INTO caracterizaciones (radiacion_solar, inclinacion_optima, orientacion, " +
            "porcentaje_sombra, temperatura_media, altitud, observaciones) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (
            Connection conn = DatabaseUtil.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(
                sql,
                Statement.RETURN_GENERATED_KEYS
            );
        ) {
            pstmt.setDouble(1, caracterizacion.getRadiacionSolar());
            pstmt.setDouble(2, caracterizacion.getInclinacionOptima());
            pstmt.setString(3, caracterizacion.getOrientacion());
            pstmt.setDouble(4, caracterizacion.getPorcentajeSombra());
            pstmt.setDouble(5, caracterizacion.getTemperaturaMedia());
            pstmt.setDouble(6, caracterizacion.getAltitud());
            pstmt.setString(7, caracterizacion.getObservaciones());

            pstmt.executeUpdate();

            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    caracterizacion.setId(generatedKeys.getInt(1));
                }
            }
        }
    }

    public List<Caracterizacion> getAllCaracterizaciones() throws SQLException {
        List<Caracterizacion> caracterizaciones = new ArrayList<>();
        String sql = "SELECT * FROM caracterizaciones";

        try (
            Connection conn = DatabaseUtil.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
        ) {
            while (rs.next()) {
                Caracterizacion caracterizacion = new Caracterizacion();
                caracterizacion.setId(rs.getInt("id"));
                caracterizacion.setRadiacionSolar(
                    rs.getDouble("radiacion_solar")
                );
                caracterizacion.setInclinacionOptima(
                    rs.getDouble("inclinacion_optima")
                );
                caracterizacion.setOrientacion(rs.getString("orientacion"));
                caracterizacion.setPorcentajeSombra(
                    rs.getDouble("porcentaje_sombra")
                );
                caracterizacion.setTemperaturaMedia(
                    rs.getDouble("temperatura_media")
                );
                caracterizacion.setAltitud(rs.getDouble("altitud"));
                caracterizacion.setObservaciones(rs.getString("observaciones"));

                caracterizaciones.add(caracterizacion);
            }
        }

        return caracterizaciones;
    }

    public Caracterizacion getCaracterizacionById(int id) throws SQLException {
        String sql = "SELECT * FROM caracterizaciones WHERE id = ?";
        try (
            Connection conn = DatabaseUtil.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    Caracterizacion caracterizacion = new Caracterizacion();
                    caracterizacion.setId(rs.getInt("id"));
                    caracterizacion.setRadiacionSolar(
                        rs.getDouble("radiacion_solar")
                    );
                    caracterizacion.setInclinacionOptima(
                        rs.getDouble("inclinacion_optima")
                    );
                    caracterizacion.setOrientacion(rs.getString("orientacion"));
                    caracterizacion.setPorcentajeSombra(
                        rs.getDouble("porcentaje_sombra")
                    );
                    caracterizacion.setTemperaturaMedia(
                        rs.getDouble("temperatura_media")
                    );
                    caracterizacion.setAltitud(rs.getDouble("altitud"));
                    caracterizacion.setObservaciones(
                        rs.getString("observaciones")
                    );
                    return caracterizacion;
                }
            }
        }
        return null;
    }

    public void updateCaracterizacion(Caracterizacion caracterizacion)
        throws SQLException {
        String sql =
            "UPDATE caracterizaciones SET radiacion_solar = ?, inclinacion_optima = ?, orientacion = ?, " +
            "porcentaje_sombra = ?, temperatura_media = ?, altitud = ?, observaciones = ? WHERE id = ?";
        try (
            Connection conn = DatabaseUtil.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            pstmt.setDouble(1, caracterizacion.getRadiacionSolar());
            pstmt.setDouble(2, caracterizacion.getInclinacionOptima());
            pstmt.setString(3, caracterizacion.getOrientacion());
            pstmt.setDouble(4, caracterizacion.getPorcentajeSombra());
            pstmt.setDouble(5, caracterizacion.getTemperaturaMedia());
            pstmt.setDouble(6, caracterizacion.getAltitud());
            pstmt.setString(7, caracterizacion.getObservaciones());
            pstmt.setInt(8, caracterizacion.getId());
            pstmt.executeUpdate();
        }
    }

    public void deleteCaracterizacion(int id) throws SQLException {
        String sql = "DELETE FROM caracterizaciones WHERE id = ?";
        try (
            Connection conn = DatabaseUtil.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }
}
