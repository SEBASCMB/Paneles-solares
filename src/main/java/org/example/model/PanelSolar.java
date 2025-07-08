package org.example.model;

public class PanelSolar {

    private int id;
    private String modelo;
    private double potencia;
    private String dimensiones;
    private double eficiencia;
    private double precio;
    private String tipo;
    private int garantia;

    public PanelSolar() {}

    public PanelSolar(int id, String modelo, double potencia) {
        this.id = id;
        this.modelo = modelo;
        this.potencia = potencia;
    }

    public PanelSolar(
        int id,
        String modelo,
        double potencia,
        String dimensiones,
        double eficiencia,
        double precio,
        String tipo,
        int garantia
    ) {
        this.id = id;
        this.modelo = modelo;
        this.potencia = potencia;
        this.dimensiones = dimensiones;
        this.eficiencia = eficiencia;
        this.precio = precio;
        this.tipo = tipo;
        this.garantia = garantia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPotencia() {
        return potencia;
    }

    public void setPotencia(double potencia) {
        this.potencia = potencia;
    }

    public String getDimensiones() {
        return dimensiones;
    }

    public void setDimensiones(String dimensiones) {
        this.dimensiones = dimensiones;
    }

    public double getEficiencia() {
        return eficiencia;
    }

    public void setEficiencia(double eficiencia) {
        this.eficiencia = eficiencia;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getGarantia() {
        return garantia;
    }

    public void setGarantia(int garantia) {
        this.garantia = garantia;
    }

    @Override
    public String toString() {
        return (
            "PanelSolar{" +
            "id=" +
            id +
            ", modelo='" +
            modelo +
            '\'' +
            ", potencia=" +
            potencia +
            ", dimensiones='" +
            dimensiones +
            '\'' +
            ", eficiencia=" +
            eficiencia +
            ", precio=" +
            precio +
            ", tipo='" +
            tipo +
            '\'' +
            ", garantia=" +
            garantia +
            '}'
        );
    }
}
