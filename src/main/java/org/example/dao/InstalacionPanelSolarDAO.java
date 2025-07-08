package org.example.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.example.model.InstalacionPanelSolar;
import org.example.util.DatabaseUtil;

public class InstalacionPanelSolarDAO {

    public void addInstalacion(InstalacionPanelSolar instalacion)
        throws SQLException {
        String sql =
            "INSERT INTO instalaciones_panel_solar (usuario_id, panel_solar_id, caracterizacion_id, region_id, " +
            "fecha_instalacion, direccion_instalacion, cantidad_paneles, potencia_total, estado, costo_total, observaciones) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (
            Connection conn = DatabaseUtil.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(
                sql,
                Statement.RETURN_GENERATED_KEYS
            );
        ) {
            pstmt.setInt(1, instalacion.getUsuarioId());
            pstmt.setInt(2, instalacion.getPanelSolarId());
            pstmt.setInt(3, instalacion.getCaracterizacionId());
            pstmt.setInt(4, instalacion.getRegionId());
            pstmt.setDate(
                5,
                new java.sql.Date(instalacion.getFechaInstalacion().getTime())
            );
            pstmt.setString(6, instalacion.getDireccionInstalacion());
            pstmt.setInt(7, instalacion.getCantidadPaneles());
            pstmt.setDouble(8, instalacion.getPotenciaTotal());
            pstmt.setString(9, instalacion.getEstado());
            pstmt.setDouble(10, instalacion.getCostoTotal());
            pstmt.setString(11, instalacion.getObservaciones());

            pstmt.executeUpdate();

            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    instalacion.setId(generatedKeys.getInt(1));
                }
            }
        }
    }

    public List<InstalacionPanelSolar> getAllInstalaciones()
        throws SQLException {
        List<InstalacionPanelSolar> instalaciones = new ArrayList<>();
        String sql = "SELECT * FROM instalaciones_panel_solar";

        try (
            Connection conn = DatabaseUtil.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
        ) {
            while (rs.next()) {
                instalaciones.add(mapResultSetToInstalacion(rs));
            }
        }

        return instalaciones;
    }

    public InstalacionPanelSolar getInstalacionById(int id)
        throws SQLException {
        String sql = "SELECT * FROM instalaciones_panel_solar WHERE id = ?";
        try (
            Connection conn = DatabaseUtil.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToInstalacion(rs);
                }
            }
        }
        return null;
    }

    public List<InstalacionPanelSolar> getInstalacionesByUsuarioId(
        int usuarioId
    ) throws SQLException {
        List<InstalacionPanelSolar> instalaciones = new ArrayList<>();
        String sql =
            "SELECT * FROM instalaciones_panel_solar WHERE usuario_id = ?";

        try (
            Connection conn = DatabaseUtil.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            pstmt.setInt(1, usuarioId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    instalaciones.add(mapResultSetToInstalacion(rs));
                }
            }
        }

        return instalaciones;
    }

    public List<InstalacionPanelSolar> getInstalacionesByRegionId(int regionId)
        throws SQLException {
        List<InstalacionPanelSolar> instalaciones = new ArrayList<>();
        String sql =
            "SELECT * FROM instalaciones_panel_solar WHERE region_id = ?";

        try (
            Connection conn = DatabaseUtil.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            pstmt.setInt(1, regionId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    instalaciones.add(mapResultSetToInstalacion(rs));
                }
            }
        }

        return instalaciones;
    }

    public void updateInstalacion(InstalacionPanelSolar instalacion)
        throws SQLException {
        String sql =
            "UPDATE instalaciones_panel_solar SET usuario_id = ?, panel_solar_id = ?, caracterizacion_id = ?, " +
            "region_id = ?, fecha_instalacion = ?, direccion_instalacion = ?, cantidad_paneles = ?, " +
            "potencia_total = ?, estado = ?, costo_total = ?, observaciones = ? WHERE id = ?";
        try (
            Connection conn = DatabaseUtil.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            pstmt.setInt(1, instalacion.getUsuarioId());
            pstmt.setInt(2, instalacion.getPanelSolarId());
            pstmt.setInt(3, instalacion.getCaracterizacionId());
            pstmt.setInt(4, instalacion.getRegionId());
            pstmt.setDate(
                5,
                new java.sql.Date(instalacion.getFechaInstalacion().getTime())
            );
            pstmt.setString(6, instalacion.getDireccionInstalacion());
            pstmt.setInt(7, instalacion.getCantidadPaneles());
            pstmt.setDouble(8, instalacion.getPotenciaTotal());
            pstmt.setString(9, instalacion.getEstado());
            pstmt.setDouble(10, instalacion.getCostoTotal());
            pstmt.setString(11, instalacion.getObservaciones());
            pstmt.setInt(12, instalacion.getId());
            pstmt.executeUpdate();
        }
    }

    public void deleteInstalacion(int id) throws SQLException {
        String sql = "DELETE FROM instalaciones_panel_solar WHERE id = ?";
        try (
            Connection conn = DatabaseUtil.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }

    private InstalacionPanelSolar mapResultSetToInstalacion(ResultSet rs)
        throws SQLException {
        InstalacionPanelSolar instalacion = new InstalacionPanelSolar();
        instalacion.setId(rs.getInt("id"));
        instalacion.setUsuarioId(rs.getInt("usuario_id"));
        instalacion.setPanelSolarId(rs.getInt("panel_solar_id"));
        instalacion.setCaracterizacionId(rs.getInt("caracterizacion_id"));
        instalacion.setRegionId(rs.getInt("region_id"));
        instalacion.setFechaInstalacion(rs.getDate("fecha_instalacion"));
        instalacion.setDireccionInstalacion(
            rs.getString("direccion_instalacion")
        );
        instalacion.setCantidadPaneles(rs.getInt("cantidad_paneles"));
        instalacion.setPotenciaTotal(rs.getDouble("potencia_total"));
        instalacion.setEstado(rs.getString("estado"));
        instalacion.setCostoTotal(rs.getDouble("costo_total"));
        instalacion.setObservaciones(rs.getString("observaciones"));
        return instalacion;
    }
}
