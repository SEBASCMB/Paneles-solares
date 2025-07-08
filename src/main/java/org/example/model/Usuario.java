package org.example.model;

public class Usuario {

    private int id;
    private String nombre;
    private String apellido;
    private String email;
    private String password;
    private String telefono;
    private String direccion;
    private int regionId;

    public Usuario() {}

    /**
     * Constructor con parámetros básicos
     *
     * @param id Identificador único del usuario
     * @param nombre Nombre del usuario
     * @param apellido Apellido del usuario
     * @param email Correo electrónico del usuario
     */

    public Usuario(int id, String nombre, String apellido, String email) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
    }

    /**
     * Constructor con todos los parámetros
     */
    public Usuario(
        int id,
        String nombre,
        String apellido,
        String email,
        String password,
        String telefono,
        String direccion,
        int regionId
    ) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.telefono = telefono;
        this.direccion = direccion;
        this.regionId = regionId;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    @Override
    public String toString() {
        return (
            "Usuario{" +
            "id=" +
            id +
            ", nombre='" +
            nombre +
            '\'' +
            ", apellido='" +
            apellido +
            '\'' +
            ", email='" +
            email +
            '\'' +
            ", telefono='" +
            telefono +
            '\'' +
            ", direccion='" +
            direccion +
            '\'' +
            ", regionId=" +
            regionId +
            '}'
        );
    }
}
