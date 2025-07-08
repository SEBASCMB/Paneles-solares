package org.example.model;

public class Caracterizacion {

    private int id;
    private double radiacionSolar;
    private double inclinacionOptima;
    private String orientacion;
    private double porcentajeSombra;
    private double temperaturaMedia;
    private double altitud;
    private String observaciones;

    public Caracterizacion() {}

    public Caracterizacion(
        int id,
        double radiacionSolar,
        double inclinacionOptima,
        String orientacion
    ) {
        this.id = id;
        this.radiacionSolar = radiacionSolar;
        this.inclinacionOptima = inclinacionOptima;
        this.orientacion = orientacion;
    }

    public Caracterizacion(
        int id,
        double radiacionSolar,
        double inclinacionOptima,
        String orientacion,
        double porcentajeSombra,
        double temperaturaMedia,
        double altitud,
        String observaciones
    ) {
        this.id = id;
        this.radiacionSolar = radiacionSolar;
        this.inclinacionOptima = inclinacionOptima;
        this.orientacion = orientacion;
        this.porcentajeSombra = porcentajeSombra;
        this.temperaturaMedia = temperaturaMedia;
        this.altitud = altitud;
        this.observaciones = observaciones;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getRadiacionSolar() {
        return radiacionSolar;
    }

    public void setRadiacionSolar(double radiacionSolar) {
        this.radiacionSolar = radiacionSolar;
    }

    public double getInclinacionOptima() {
        return inclinacionOptima;
    }

    public void setInclinacionOptima(double inclinacionOptima) {
        this.inclinacionOptima = inclinacionOptima;
    }

    public String getOrientacion() {
        return orientacion;
    }

    public void setOrientacion(String orientacion) {
        this.orientacion = orientacion;
    }

    public double getPorcentajeSombra() {
        return porcentajeSombra;
    }

    public void setPorcentajeSombra(double porcentajeSombra) {
        this.porcentajeSombra = porcentajeSombra;
    }

    public double getTemperaturaMedia() {
        return temperaturaMedia;
    }

    public void setTemperaturaMedia(double temperaturaMedia) {
        this.temperaturaMedia = temperaturaMedia;
    }

    public double getAltitud() {
        return altitud;
    }

    public void setAltitud(double altitud) {
        this.altitud = altitud;
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
            "Caracterizacion{" +
            "id=" +
            id +
            ", radiacionSolar=" +
            radiacionSolar +
            ", inclinacionOptima=" +
            inclinacionOptima +
            ", orientacion='" +
            orientacion +
            '\'' +
            ", porcentajeSombra=" +
            porcentajeSombra +
            ", temperaturaMedia=" +
            temperaturaMedia +
            ", altitud=" +
            altitud +
            ", observaciones='" +
            observaciones +
            '\'' +
            '}'
        );
    }
}
