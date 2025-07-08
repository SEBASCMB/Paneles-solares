package org.example.controller;

import java.sql.SQLException;
import java.util.List;
import org.example.dao.UsuarioDAO;
import org.example.model.Usuario;

public class UsuarioController {

    private UsuarioDAO usuarioDAO;

    public UsuarioController() {
        this.usuarioDAO = new UsuarioDAO();
    }

    public void crearUsuario(
        String nombre,
        String apellido,
        String email,
        String password,
        String telefono,
        String direccion,
        int regionId
    ) {
        try {
            Usuario usuario = new Usuario();
            usuario.setNombre(nombre);
            usuario.setApellido(apellido);
            usuario.setEmail(email);
            usuario.setPassword(password);
            usuario.setTelefono(telefono);
            usuario.setDireccion(direccion);
            usuario.setRegionId(regionId);

            usuarioDAO.addUsuario(usuario);
            System.out.println(
                "Usuario creado con éxito: " + nombre + " " + apellido
            );
        } catch (SQLException e) {
            System.err.println("Error al crear el usuario: " + e.getMessage());
        }
    }

    public List<Usuario> listarUsuarios() {
        try {
            return usuarioDAO.getAllUsuarios();
        } catch (SQLException e) {
            System.err.println("Error al listar usuarios: " + e.getMessage());
            return null;
        }
    }

    public Usuario buscarUsuarioPorId(int id) {
        try {
            return usuarioDAO.getUsuarioById(id);
        } catch (SQLException e) {
            System.err.println("Error al buscar usuario: " + e.getMessage());
            return null;
        }
    }

    public Usuario buscarUsuarioPorEmail(String email) {
        try {
            return usuarioDAO.getUsuarioByEmail(email);
        } catch (SQLException e) {
            System.err.println(
                "Error al buscar usuario por email: " + e.getMessage()
            );
            return null;
        }
    }

    public boolean autenticarUsuario(String email, String password) {
        try {
            Usuario usuario = usuarioDAO.getUsuarioByEmail(email);
            if (usuario != null) {
                return usuario.getPassword().equals(password);
            }
            return false;
        } catch (SQLException e) {
            System.err.println(
                "Error al autenticar usuario: " + e.getMessage()
            );
            return false;
        }
    }

    public void actualizarUsuario(Usuario usuario) {
        try {
            usuarioDAO.updateUsuario(usuario);
            System.out.println("Usuario actualizado con éxito");
        } catch (SQLException e) {
            System.err.println(
                "Error al actualizar usuario: " + e.getMessage()
            );
        }
    }

    public void eliminarUsuario(int id) {
        try {
            usuarioDAO.deleteUsuario(id);
            System.out.println("Usuario eliminado con éxito");
        } catch (SQLException e) {
            System.err.println("Error al eliminar usuario: " + e.getMessage());
        }
    }
}
