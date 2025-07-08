package org.example;

import java.util.Date;
import java.util.List;

import org.example.controller.InstalacionPanelSolarController;
import org.example.controller.RegionController;
import org.example.controller.UsuarioController;
import org.example.model.InstalacionPanelSolar;
import org.example.model.Region;
import org.example.model.Usuario;

public class Main {

    public static void main(String[] args) {
        System.out.println("Sistema de Gestión de Paneles Solares");
        System.out.println("====================================");

        try {
            // Ejemplo de uso del controlador de regiones
            RegionController regionController = new RegionController();

            // Crear regiones de ejemplo
            regionController.crearRegion("Norte");
            regionController.crearRegion("Sur");
            regionController.crearRegion("Este");
            regionController.crearRegion("Oeste");

            // Listar todas las regiones
            List<Region> regiones = regionController.listarRegiones();
            System.out.println("\nRegiones disponibles:");
            if (regiones != null) {
                regiones.forEach(System.out::println);
            }

            // Ejemplo de uso del controlador de usuarios
            UsuarioController usuarioController = new UsuarioController();

            // Crear un usuario de ejemplo
            usuarioController.crearUsuario(
                    "Sebastian",
                    "Marquez",
                    "sebastiancmarquez1998@gmail.com",
                    "123456",
                    "555-123456",
                    "Calle Principal 123",
                    2
            );

            // Buscar usuario por correo electrónico
            Usuario usuario = usuarioController.buscarUsuarioPorEmail(
                    "juan@example.com"
            );
            if (usuario != null) {
                System.out.println("\nUsuario encontrado: " + usuario);

                // Ejemplo de uso del controlador de instalaciones
                if (regiones != null && !regiones.isEmpty()) {
                    InstalacionPanelSolarController instalacionController =
                            new InstalacionPanelSolarController();

                    // Crear una instalación de ejemplo
                    // Nota: Para que esto funcione, primero se deberían crear registros de paneles solares y caracterizaciones
                    // instalacionController.crearInstalacion(usuario.getId(), 1, 1, regiones.get(0).getId(),
                    //                                       new Date(), "Calle Principal 123", 10, "Pendiente", "Instalación residencial");
                }
            }
        } catch (Exception e) {
            System.err.println("Error en la aplicación: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
