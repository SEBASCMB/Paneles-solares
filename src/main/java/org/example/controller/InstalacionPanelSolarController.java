package org.example.controller;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import org.example.dao.InstalacionPanelSolarDAO;
import org.example.dao.PanelSolarDAO;
import org.example.model.InstalacionPanelSolar;
import org.example.model.PanelSolar;

public class InstalacionPanelSolarController {

    private InstalacionPanelSolarDAO instalacionDAO;
    private PanelSolarDAO panelSolarDAO;

    public InstalacionPanelSolarController() {
        this.instalacionDAO = new InstalacionPanelSolarDAO();
        this.panelSolarDAO = new PanelSolarDAO();
    }

    public void crearInstalacion(
        int usuarioId,
        int panelSolarId,
        int caracterizacionId,
        int regionId,
        Date fechaInstalacion,
        String direccionInstalacion,
        int cantidadPaneles,
        String estado,
        String observaciones
    ) {
        try {
            // Obtener información del panel solar para calcular la potencia total
            PanelSolar panelSolar = panelSolarDAO.getPanelSolarById(
                panelSolarId
            );
            if (panelSolar == null) {
                System.err.println(
                    "Error: El panel solar especificado no existe"
                );
                return;
            }

            double potenciaTotal = panelSolar.getPotencia() * cantidadPaneles;
            double costoTotal = panelSolar.getPrecio() * cantidadPaneles;

            InstalacionPanelSolar instalacion = new InstalacionPanelSolar();
            instalacion.setUsuarioId(usuarioId);
            instalacion.setPanelSolarId(panelSolarId);
            instalacion.setCaracterizacionId(caracterizacionId);
            instalacion.setRegionId(regionId);
            instalacion.setFechaInstalacion(fechaInstalacion);
            instalacion.setDireccionInstalacion(direccionInstalacion);
            instalacion.setCantidadPaneles(cantidadPaneles);
            instalacion.setPotenciaTotal(potenciaTotal);
            instalacion.setEstado(estado);
            instalacion.setCostoTotal(costoTotal);
            instalacion.setObservaciones(observaciones);

            instalacionDAO.addInstalacion(instalacion);
            System.out.println(
                "Instalación creada con éxito para el usuario ID: " + usuarioId
            );
        } catch (SQLException e) {
            System.err.println(
                "Error al crear la instalación: " + e.getMessage()
            );
        }
    }

    public List<InstalacionPanelSolar> listarInstalaciones() {
        try {
            return instalacionDAO.getAllInstalaciones();
        } catch (SQLException e) {
            System.err.println(
                "Error al listar instalaciones: " + e.getMessage()
            );
            return null;
        }
    }

    public List<InstalacionPanelSolar> listarInstalacionesPorUsuario(
        int usuarioId
    ) {
        try {
            return instalacionDAO.getInstalacionesByUsuarioId(usuarioId);
        } catch (SQLException e) {
            System.err.println(
                "Error al listar instalaciones por usuario: " + e.getMessage()
            );
            return null;
        }
    }

    public List<InstalacionPanelSolar> listarInstalacionesPorRegion(
        int regionId
    ) {
        try {
            return instalacionDAO.getInstalacionesByRegionId(regionId);
        } catch (SQLException e) {
            System.err.println(
                "Error al listar instalaciones por región: " + e.getMessage()
            );
            return null;
        }
    }

    public InstalacionPanelSolar buscarInstalacionPorId(int id) {
        try {
            return instalacionDAO.getInstalacionById(id);
        } catch (SQLException e) {
            System.err.println(
                "Error al buscar instalación: " + e.getMessage()
            );
            return null;
        }
    }

    public void actualizarEstadoInstalacion(int id, String nuevoEstado) {
        try {
            InstalacionPanelSolar instalacion =
                instalacionDAO.getInstalacionById(id);
            if (instalacion != null) {
                instalacion.setEstado(nuevoEstado);
                instalacionDAO.updateInstalacion(instalacion);
                System.out.println(
                    "Estado de instalación actualizado con éxito"
                );
            }
        } catch (SQLException e) {
            System.err.println(
                "Error al actualizar estado de instalación: " + e.getMessage()
            );
        }
    }

    public void actualizarInstalacion(InstalacionPanelSolar instalacion) {
        try {
            instalacionDAO.updateInstalacion(instalacion);
            System.out.println("Instalación actualizada con éxito");
        } catch (SQLException e) {
            System.err.println(
                "Error al actualizar instalación: " + e.getMessage()
            );
        }
    }

    public void eliminarInstalacion(int id) {
        try {
            instalacionDAO.deleteInstalacion(id);
            System.out.println("Instalación eliminada con éxito");
        } catch (SQLException e) {
            System.err.println(
                "Error al eliminar instalación: " + e.getMessage()
            );
        }
    }
}
