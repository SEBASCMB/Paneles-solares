package org.example.model;

public class Region {

    private int id;
    private String nombre;

    public Region() {}

    /**
     * Constructor con parametros
     *
     * @param id Identificador unico de la Region
     * @param nombre Nombre de la region
     */

    public Region(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Region{" + "id=" + id + ", nombre='" + nombre + '\'' + '}';
    }
}
