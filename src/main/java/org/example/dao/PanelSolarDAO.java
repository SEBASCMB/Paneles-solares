package org.example.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.example.model.PanelSolar;
import org.example.util.DatabaseUtil;

public class PanelSolarDAO {

    public void addPanelSolar(PanelSolar panelSolar) throws SQLException {
        String sql =
            "INSERT INTO paneles_solares (modelo, potencia, dimensiones, eficiencia, precio, tipo, garantia) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (
            Connection conn = DatabaseUtil.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(
                sql,
                Statement.RETURN_GENERATED_KEYS
            );
        ) {
            pstmt.setString(1, panelSolar.getModelo());
            pstmt.setDouble(2, panelSolar.getPotencia());
            pstmt.setString(3, panelSolar.getDimensiones());
            pstmt.setDouble(4, panelSolar.getEficiencia());
            pstmt.setDouble(5, panelSolar.getPrecio());
            pstmt.setString(6, panelSolar.getTipo());
            pstmt.setInt(7, panelSolar.getGarantia());

            pstmt.executeUpdate();

            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    panelSolar.setId(generatedKeys.getInt(1));
                }
            }
        }
    }

    public List<PanelSolar> getAllPanelesSolares() throws SQLException {
        List<PanelSolar> panelesSolares = new ArrayList<>();
        String sql = "SELECT * FROM paneles_solares";

        try (
            Connection conn = DatabaseUtil.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
        ) {
            while (rs.next()) {
                PanelSolar panelSolar = new PanelSolar();
                panelSolar.setId(rs.getInt("id"));
                panelSolar.setModelo(rs.getString("modelo"));
                panelSolar.setPotencia(rs.getDouble("potencia"));
                panelSolar.setDimensiones(rs.getString("dimensiones"));
                panelSolar.setEficiencia(rs.getDouble("eficiencia"));
                panelSolar.setPrecio(rs.getDouble("precio"));
                panelSolar.setTipo(rs.getString("tipo"));
                panelSolar.setGarantia(rs.getInt("garantia"));

                panelesSolares.add(panelSolar);
            }
        }

        return panelesSolares;
    }

    public PanelSolar getPanelSolarById(int id) throws SQLException {
        String sql = "SELECT * FROM paneles_solares WHERE id = ?";
        try (
            Connection conn = DatabaseUtil.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    PanelSolar panelSolar = new PanelSolar();
                    panelSolar.setId(rs.getInt("id"));
                    panelSolar.setModelo(rs.getString("modelo"));
                    panelSolar.setPotencia(rs.getDouble("potencia"));
                    panelSolar.setDimensiones(rs.getString("dimensiones"));
                    panelSolar.setEficiencia(rs.getDouble("eficiencia"));
                    panelSolar.setPrecio(rs.getDouble("precio"));
                    panelSolar.setTipo(rs.getString("tipo"));
                    panelSolar.setGarantia(rs.getInt("garantia"));
                    return panelSolar;
                }
            }
        }
        return null;
    }

    public void updatePanelSolar(PanelSolar panelSolar) throws SQLException {
        String sql =
            "UPDATE paneles_solares SET modelo = ?, potencia = ?, dimensiones = ?, " +
            "eficiencia = ?, precio = ?, tipo = ?, garantia = ? WHERE id = ?";
        try (
            Connection conn = DatabaseUtil.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            pstmt.setString(1, panelSolar.getModelo());
            pstmt.setDouble(2, panelSolar.getPotencia());
            pstmt.setString(3, panelSolar.getDimensiones());
            pstmt.setDouble(4, panelSolar.getEficiencia());
            pstmt.setDouble(5, panelSolar.getPrecio());
            pstmt.setString(6, panelSolar.getTipo());
            pstmt.setInt(7, panelSolar.getGarantia());
            pstmt.setInt(8, panelSolar.getId());
            pstmt.executeUpdate();
        }
    }

    public void deletePanelSolar(int id) throws SQLException {
        String sql = "DELETE FROM paneles_solares WHERE id = ?";
        try (
            Connection conn = DatabaseUtil.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }
}
