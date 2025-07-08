# 🌞 PanelSolar

## Sistema de Gestión para Instalaciones de Paneles Solares

[![Java](https://img.shields.io/badge/Java-21-orange)](https://www.java.com/)
[![MySQL](https://img.shields.io/badge/MySQL-9.3.0-blue)](https://www.mysql.com/)
[![License](https://img.shields.io/badge/License-MIT-green.svg)](LICENSE)

## 📋 Descripción del Proyecto

PanelSolar es un sistema integral para la gestión de instalaciones de paneles solares. La aplicación permite administrar usuarios, regiones, catálogos de paneles solares y el seguimiento detallado de instalaciones, considerando aspectos técnicos como la radiación solar, inclinación óptima y otras características ambientales que afectan el rendimiento de los sistemas fotovoltaicos.

## ✨ Características Principales

- 👤 **Gestión de Usuarios**: Registro, autenticación, actualización y administración de información de clientes
- 🗺️ **Administración de Regiones**: Organización geográfica de instalaciones y usuarios por zonas
- 🔋 **Catálogo de Paneles Solares**: Gestión completa de modelos con especificaciones técnicas (potencia, eficiencia, dimensiones)
- 📊 **Caracterización de Sitios**: Registro detallado de parámetros ambientales como radiación solar, inclinación óptima, orientación, sombras y temperatura
- 🔧 **Control de Instalaciones**: Seguimiento completo del ciclo de vida de instalaciones con cálculo automático de potencia y costos
- 📈 **Análisis de Datos**: Capacidad para filtrar y visualizar instalaciones por regiones y usuarios

## 🛠️ Tecnologías Utilizadas

- **Java 21**: Lenguaje de programación principal con soporte para las últimas características
- **MySQL 9.3.0**: Sistema gestor de base de datos relacional
- **Maven**: Gestión de dependencias y construcción del proyecto
- **JDBC**: Conectividad y operaciones con la base de datos
- **Patrón MVC**: Arquitectura Modelo-Vista-Controlador para una estructura organizada del código
- **Patrón DAO**: Data Access Object para separar la lógica de acceso a datos

## 🚀 Instalación y Configuración

### Requisitos Previos

- JDK 21
- MySQL Server
- Maven

### Pasos para la Instalación

1. **Clonar el repositorio**
   ```bash
   git clone https://github.com/SEBASCMB/PanelSolar.git
   cd PanelSolar
   ```

2. **Compilar el proyecto con Maven**
   ```bash
   mvn clean install
   ```

3. **Configurar la base de datos**
   
   Crear una base de datos MySQL llamada `panelsolar`:
   ```sql
   CREATE DATABASE panelsolar;
   ```

   Crear un usuario para la base de datos (o usar uno existente):
   ```sql
   CREATE USER 'usuario'@'localhost' IDENTIFIED BY 'password';
   GRANT ALL PRIVILEGES ON panelsolar.* TO 'usuario'@'localhost';
   FLUSH PRIVILEGES;
   ```

   Crear las tablas necesarias:
   ```sql
   CREATE TABLE regiones (
       id INT AUTO_INCREMENT PRIMARY KEY,
       nombre VARCHAR(100) NOT NULL
   );

   CREATE TABLE usuarios (
       id INT AUTO_INCREMENT PRIMARY KEY,
       nombre VARCHAR(100) NOT NULL,
       apellido VARCHAR(100) NOT NULL,
       email VARCHAR(100) NOT NULL UNIQUE,
       password VARCHAR(255) NOT NULL,
       telefono VARCHAR(20),
       direccion VARCHAR(255),
       region_id INT,
       FOREIGN KEY (region_id) REFERENCES regiones(id)
   );

   CREATE TABLE paneles_solares (
       id INT AUTO_INCREMENT PRIMARY KEY,
       modelo VARCHAR(100) NOT NULL,
       potencia DOUBLE NOT NULL,
       dimensiones VARCHAR(100),
       eficiencia DOUBLE,
       precio DOUBLE,
       tipo VARCHAR(50),
       garantia INT
   );

   CREATE TABLE caracterizaciones (
       id INT AUTO_INCREMENT PRIMARY KEY,
       radiacion_solar DOUBLE NOT NULL,
       inclinacion_optima DOUBLE NOT NULL,
       orientacion VARCHAR(50) NOT NULL,
       porcentaje_sombra DOUBLE,
       temperatura_media DOUBLE,
       altitud DOUBLE,
       observaciones TEXT
   );

   CREATE TABLE instalaciones_panel_solar (
       id INT AUTO_INCREMENT PRIMARY KEY,
       usuario_id INT NOT NULL,
       panel_solar_id INT NOT NULL,
       caracterizacion_id INT NOT NULL,
       region_id INT NOT NULL,
       fecha_instalacion DATE,
       direccion_instalacion VARCHAR(255),
       cantidad_paneles INT NOT NULL,
       potencia_total DOUBLE,
       estado VARCHAR(50),
       costo_total DOUBLE,
       observaciones TEXT,
       FOREIGN KEY (usuario_id) REFERENCES usuarios(id),
       FOREIGN KEY (panel_solar_id) REFERENCES paneles_solares(id),
       FOREIGN KEY (caracterizacion_id) REFERENCES caracterizaciones(id),
       FOREIGN KEY (region_id) REFERENCES regiones(id)
   );
   ```

4. **Configurar la conexión a la base de datos**
   
   Editar el archivo `src/main/java/org/example/util/DatabaseUtil.java` con los valores de conexión correctos:
   ```java
   private static final String URL = "jdbc:mysql://localhost:3306/panelsolar";
   private static final String USER = "tu_usuario";
   private static final String PASSWORD = "tu_contraseña";
   ```

## 📊 Estructura de la Base de Datos

El sistema utiliza las siguientes tablas principales:

- **usuarios**: Almacena información de clientes (nombre, apellido, email, contraseña, etc.)
- **regiones**: Catálogo de regiones geográficas
- **paneles_solares**: Catálogo de modelos disponibles con sus especificaciones técnicas
- **caracterizaciones**: Almacena datos técnicos de los sitios de instalación (radiación solar, inclinación, etc.)
- **instalaciones_panel_solar**: Registro completo de instalaciones realizadas

## 📁 Estructura del Proyecto

```
PanelSolar/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── org/
│   │   │       └── example/
│   │   │           ├── controller/     # Controladores de lógica de negocio
│   │   │           │   ├── InstalacionPanelSolarController.java
│   │   │           │   ├── RegionController.java
│   │   │           │   └── UsuarioController.java
│   │   │           ├── dao/            # Objetos de acceso a datos
│   │   │           │   ├── CaracterizacionDAO.java
│   │   │           │   ├── InstalacionPanelSolarDAO.java
│   │   │           │   ├── PanelSolarDAO.java
│   │   │           │   ├── RegionDAO.java
│   │   │           │   └── UsuarioDAO.java
│   │   │           ├── model/          # Modelos de datos
│   │   │           │   ├── Caracterizacion.java
│   │   │           │   ├── InstalacionPanelSolar.java
│   │   │           │   ├── PanelSolar.java
│   │   │           │   ├── Region.java
│   │   │           │   └── Usuario.java
│   │   │           ├── util/           # Utilidades
│   │   │           │   └── DatabaseUtil.java
│   │   │           └── Main.java       # Punto de entrada
│   │   └── resources/                  # Recursos adicionales
│   └── test/                           # Pruebas unitarias
└── pom.xml                             # Configuración de Maven
```

## 🔧 Uso del Sistema

### Ejemplo Completo de Uso

```java
// Crear y gestionar regiones
RegionController regionController = new RegionController();
regionController.crearRegion("Norte");
regionController.crearRegion("Sur");
List<Region> regiones = regionController.listarRegiones();

// Crear usuarios
UsuarioController usuarioController = new UsuarioController();
usuarioController.crearUsuario(
    "Juan", "Pérez",
    "juan@example.com",
    "password123",
    "555-123456",
    "Calle Principal 123",
    1 // regionId
);

// Buscar usuarios
Usuario usuario = usuarioController.buscarUsuarioPorEmail("juan@example.com");

// Gestionar instalaciones
InstalacionPanelSolarController instalacionController = new InstalacionPanelSolarController();
instalacionController.crearInstalacion(
    usuario.getId(),      // usuarioId
    1,                    // panelSolarId
    1,                    // caracterizacionId
    usuario.getRegionId(), // regionId
    new Date(),           // fechaInstalacion
    "Av. Principal 123",  // direcciónInstalación
    10,                   // cantidadPaneles
    "Pendiente",          // estado
    "Instalación residencial" // observaciones
);
```

### Autenticación de Usuarios

```java
UsuarioController usuarioController = new UsuarioController();
boolean autenticado = usuarioController.autenticarUsuario("juan@example.com", "password123");
if (autenticado) {
    System.out.println("Usuario autenticado correctamente");
} else {
    System.out.println("Credenciales incorrectas");
}
```

### Consulta de Instalaciones por Región

```java
InstalacionPanelSolarController instalacionController = new InstalacionPanelSolarController();
List<InstalacionPanelSolar> instalacionesPorRegion = instalacionController.listarInstalacionesPorRegion(1);
```

## 🔄 Diagrama del Sistema

```
┌───────────────┐       ┌───────────────┐       ┌───────────────┐
│   Controllers │       │     Models    │       │     DAOs      │
│   (Lógica de  │◄─────►│  (Entidades)  │◄─────►│  (Acceso a    │
│    negocio)   │       │               │       │    datos)     │
└───────┬───────┘       └───────────────┘       └───────┬───────┘
        │                                                │
        │                                                │
        │                                                │
        └────────────────────┬───────────────────────────┘
                            │
                     ┌──────▼───────┐
                     │  DatabaseUtil│
                     │ (Conexión BD)│
                     └──────┬───────┘
                            │
                     ┌──────▼───────┐
                     │  Base de     │
                     │   Datos      │
                     │  MySQL       │
                     └──────────────┘
```

## 🤝 Contribución

Si deseas contribuir al proyecto, sigue estos pasos:

1. Haz un Fork del proyecto
2. Crea una rama para tu función (`git checkout -b feature/nueva-funcion`)
3. Realiza tus cambios y haz commit (`git commit -m 'Añadir nueva función'`)
4. Sube los cambios (`git push origin feature/nueva-funcion`)
5. Abre un Pull Request

## 📄 Licencia

Este proyecto está bajo la Licencia MIT - ver el archivo [LICENSE](LICENSE) para más detalles.

## 📞 Contacto

Para cualquier consulta sobre el proyecto, puedes contactar a:

- Email: sebastiancmarquez1998@gmail.com
- GitHub: [SEBASCMB](https://github.com/SEBASCMB)