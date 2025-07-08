package org.example.model;

import java.util.Date;

public class InstalacionPanelSolar {

    private int id;
    private int usuarioId;
    private int panelSolarId;
    private int caracterizacionId;
    private int regionId;
    private Date fechaInstalacion;
    private String direccionInstalacion;
    private int cantidadPaneles;
    private double potenciaTotal;
    private String estado;
    private double costoTotal;
    private String observaciones;

    public InstalacionPanelSolar() {}

    public InstalacionPanelSolar(
        int id,
        int usuarioId,
        int panelSolarId,
        int cantidadPaneles
    ) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.panelSolarId = panelSolarId;
        this.cantidadPaneles = cantidadPaneles;
    }

    public InstalacionPanelSolar(
        int id,
        int usuarioId,
        int panelSolarId,
        int caracterizacionId,
        int regionId,
        Date fechaInstalacion,
        String direccionInstalacion,
        int cantidadPaneles,
        double potenciaTotal,
        String estado,
        double costoTotal,
        String observaciones
    ) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.panelSolarId = panelSolarId;
        this.caracterizacionId = caracterizacionId;
        this.regionId = regionId;
        this.fechaInstalacion = fechaInstalacion;
        this.direccionInstalacion = direccionInstalacion;
        this.cantidadPaneles = cantidadPaneles;
        this.potenciaTotal = potenciaTotal;
        this.estado = estado;
        this.costoTotal = costoTotal;
        this.observaciones = observaciones;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public int getPanelSolarId() {
        return panelSolarId;
    }

    public void setPanelSolarId(int panelSolarId) {
        this.panelSolarId = panelSolarId;
    }

    public int getCaracterizacionId() {
        return caracterizacionId;
    }

    public void setCaracterizacionId(int caracterizacionId) {
        this.caracterizacionId = caracterizacionId;
    }

    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    public Date getFechaInstalacion() {
        return fechaInstalacion;
    }

    public void setFechaInstalacion(Date fechaInstalacion) {
        this.fechaInstalacion = fechaInstalacion;
    }

    public String getDireccionInstalacion() {
        return direccionInstalacion;
    }

    public void setDireccionInstalacion(String direccionInstalacion) {
        this.direccionInstalacion = direccionInstalacion;
    }

    public int getCantidadPaneles() {
        return cantidadPaneles;
    }

    public void setCantidadPaneles(int cantidadPaneles) {
        this.cantidadPaneles = cantidadPaneles;
    }

    public double getPotenciaTotal() {
        return potenciaTotal;
    }

    public void setPotenciaTotal(double potenciaTotal) {
        this.potenciaTotal = potenciaTotal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @Override
    public String toString() {
        return (
            "InstalacionPanelSolar{" +
            "id=" +
            id +
            ", usuarioId=" +
            usuarioId +
            ", panelSolarId=" +
            panelSolarId +
            ", caracterizacionId=" +
            caracterizacionId +
            ", regionId=" +
            regionId +
            ", fechaInstalacion=" +
            fechaInstalacion +
            ", direccionInstalacion='" +
            direccionInstalacion +
            '\'' +
            ", cantidadPaneles=" +
            cantidadPaneles +
            ", potenciaTotal=" +
            potenciaTotal +
            ", estado='" +
            estado +
            '\'' +
            ", costoTotal=" +
            costoTotal +
            ", observaciones='" +
            observaciones +
            '\'' +
            '}'
        );
    }
}
