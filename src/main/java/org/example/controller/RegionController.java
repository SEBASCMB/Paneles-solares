package org.example.controller;

import java.sql.SQLException;
import java.util.List;
import org.example.dao.RegionDAO;
import org.example.model.Region;

public class RegionController {

    private RegionDAO regionDAO;

    public RegionController() {
        this.regionDAO = new RegionDAO();
    }

    public void crearRegion(String nombre) {
        try {
            Region region = new Region();
            region.setNombre(nombre);
            regionDAO.addRegion(region);
            System.out.println("Región creada con éxito: " + nombre);
        } catch (SQLException e) {
            System.err.println("Error al crear la región: " + e.getMessage());
        }
    }

    public List<Region> listarRegiones() {
        try {
            return regionDAO.getAllRegions();
        } catch (SQLException e) {
            System.err.println("Error al listar regiones: " + e.getMessage());
            return null;
        }
    }

    public Region buscarRegionPorId(int id) {
        try {
            return regionDAO.getRegionById(id);
        } catch (SQLException e) {
            System.err.println("Error al buscar región: " + e.getMessage());
            return null;
        }
    }

    public void actualizarRegion(int id, String nuevoNombre) {
        try {
            Region region = regionDAO.getRegionById(id);
            if (region != null) {
                region.setNombre(nuevoNombre);
                regionDAO.updateRegion(region);
                System.out.println("Región actualizada con éxito");
            }
        } catch (SQLException e) {
            System.err.println("Error al actualizar región: " + e.getMessage());
        }
    }

    public void eliminarRegion(int id) {
        try {
            regionDAO.deleteRegion(id);
            System.out.println("Región eliminada con éxito");
        } catch (SQLException e) {
            System.err.println("Error al eliminar región: " + e.getMessage());
        }
    }
}
