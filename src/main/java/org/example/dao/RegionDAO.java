package org.example.dao;

import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.example.model.Region;
import org.example.util.DatabaseUtil;

public class RegionDAO {

    public void addRegion(Region region) throws SQLException {
        String sql = "INSERT INTO regiones (nombre) VALUES (?)";

        try (
            Connection conn = DatabaseUtil.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            pstmt.setString(1, region.getNombre());
            pstmt.executeUpdate();
        }
    }

    public List<Region> getAllRegions() throws SQLException {
        List<Region> regiones = new ArrayList<>();
        String sql = "SELECT * FROM regiones";

        try (
            Connection conn = DatabaseUtil.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
        ) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                regiones.add(new Region(id, nombre));
            }
        }

        return regiones;
    }

    public Region getRegionById(int id) throws SQLException {
        String sql = "SELECT * FROM regiones WHERE id = ?";
        try (
            Connection conn = DatabaseUtil.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String nombre = rs.getString("nombre");
                    return new Region(id, nombre);
                }
            }
        }
        return null;
    }

    public void updateRegion(Region region) throws SQLException {
        String sql = "UPDATE regiones SET nombre = ? WHERE id = ?";
        try (
            Connection conn = DatabaseUtil.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            pstmt.setString(1, region.getNombre());
            pstmt.setInt(2, region.getId());
            pstmt.executeUpdate();
        }
    }

    public void deleteRegion(int id) throws SQLException {
        String sql = "DELETE FROM regiones WHERE id = ?";
        try (
            Connection conn = DatabaseUtil.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }
}
