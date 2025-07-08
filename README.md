# 🌞 PanelSolar

## Sistema de Gestión para Instalaciones de Paneles Solares

[![Java](https://img.shields.io/badge/Java-21-orange)](https://www.java.com/)
[![MySQL](https://img.shields.io/badge/MySQL-9.3.0-blue)](https://www.mysql.com/)
[![License](https://img.shields.io/badge/License-MIT-green.svg)](LICENSE)

## 📋 Descripción del Proyecto

PanelSolar es un sistema integral para la gestión de instalaciones de paneles solares. La aplicación permite administrar usuarios, regiones, catálogos de paneles solares y el seguimiento detallado de instalaciones, considerando aspectos técnicos como la radiación solar, inclinación óptima y otras características ambientales.

## ✨ Características Principales

- 👤 **Gestión de Usuarios**: Registro, actualización y administración de información de clientes
- 🗺️ **Administración de Regiones**: Organización por zonas geográficas
- 🔋 **Catálogo de Paneles Solares**: Gestión de diferentes modelos con sus especificaciones técnicas
- 📊 **Caracterización de Sitios**: Registro de parámetros ambientales como radiación solar, inclinación óptima y sombras
- 🔧 **Control de Instalaciones**: Seguimiento completo del proceso de instalación de paneles solares

## 🛠️ Tecnologías Utilizadas

- **Java 21**: Lenguaje de programación principal
- **MySQL**: Sistema gestor de base de datos
- **Maven**: Gestión de dependencias y construcción del proyecto
- **JDBC**: Conectividad con la base de datos

## 🚀 Instalación y Configuración

### Requisitos Previos

- JDK 21
- MySQL Server
- Maven

### Pasos para la Instalación

1. **Clonar el repositorio**
   ```bash
   git clone https://github.com/tuusuario/PanelSolar.git
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

   Crear un usuario para la base de datos:
   ```sql
   CREATE USER 'usuario'@'localhost' IDENTIFIED BY 'password';
   GRANT ALL PRIVILEGES ON panelsolar.* TO 'usuario'@'localhost';
   FLUSH PRIVILEGES;
   ```

   Ejecutar el script de creación de tablas (disponible en `/scripts/database.sql`).

4. **Configurar la conexión a la base de datos**

   Editar el archivo `src/main/java/org/example/util/DatabaseUtil.java` con los valores de conexión correctos.

## 📊 Estructura de la Base de Datos

El sistema utiliza las siguientes tablas principales:

- **usuarios**: Almacena la información de los clientes
- **regiones**: Catalogo de regiones geográficas
- **paneles_solares**: Catálogo de modelos disponibles
- **caracterizaciones**: Datos técnicos de los sitios de instalación
- **instalaciones_paneles_solares**: Registro de instalaciones realizadas

## 📁 Estructura del Proyecto

```
PanelSolar/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── org/
│   │   │       └── example/
│   │   │           ├── controller/     # Controladores
│   │   │           ├── dao/            # Acceso a datos
│   │   │           ├── model/          # Modelos de datos
│   │   │           ├── util/           # Utilidades
│   │   │           └── Main.java       # Punto de entrada
│   │   └── resources/                  # Recursos adicionales
│   └── test/                           # Pruebas unitarias
└── pom.xml                             # Configuración de Maven
```

## 🔧 Uso del Sistema

### Gestión de Usuarios

```java
// Crear un nuevo usuario
Usuario nuevoUsuario = new Usuario();
nuevoUsuario.setNombre("Juan");
nuevoUsuario.setApellido("Pérez");
nuevoUsuario.setEmail("juan.perez@ejemplo.com");
nuevoUsuario.setPassword("contraseña123");
nuevoUsuario.setTelefono("123456789");
nuevoUsuario.setDireccion("Calle Principal 123");
nuevoUsuario.setRegionId(1);

UsuarioDAO usuarioDAO = new UsuarioDAO();
usuarioDAO.addUsuario(nuevoUsuario);
```

### Gestión de Regiones

```java
// Añadir una nueva región
Region nuevaRegion = new Region(0, "Región Norte");
RegionDAO regionDAO = new RegionDAO();
regionDAO.addRegion(nuevaRegion);

// Obtener todas las regiones
List<Region> regiones = regionDAO.getAllRegions();
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
