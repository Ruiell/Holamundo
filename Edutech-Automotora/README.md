
#  Proyecto Automotora - DUOC UC

## Descripción
API REST para gestión de vehículos desarrollada con Spring Boot.

## Tecnologías
- Java 17
- Spring Boot 3.2.0
- MySQL 8.0
- Maven

## Instalación
1. Clonar repositorio
2. Ejecutar: `mvn spring-boot:run`
3. Acceder: http://localhost:8080

## Endpoints principales
- `GET /api/vehiculos` - Listar vehículos
- `POST /api/vehiculos` - Crear vehículo
- `GET /test` - Verificar API
- `GET /testbd` - Verificar BD

## Autor
[Javier Barrios] - DUOC UC




#  Automotora API - Spring Boot

![Java](https://img.shields.io/badge/Java-17-blue)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.0-brightgreen)
![MySQL](https://img.shields.io/badge/MySQL-8.0-orange)

## Descripción
Sistema de gestión de vehículos para automotora desarrollado como proyecto educativo DUOC UC.

##  Estructura del Proyecto

automotora/
├── src/main/java/com/automotora/
│   ├── controller/     # Controladores REST
│   ├── model/         # Entidades (Vehiculo, Cliente)
│   ├── repository/    # Interfaces JPA
│   └── service/       # Lógica de negocio
├── src/main/resources/
│   ├── application.properties
│   └── templates/
├── pom.xml            # Configuración Maven
└── README.md          # Este archivo


# 🚗 Edutech-Automotora

Sistema de gestión para automotora educativa desarrollado con Spring Boot.

## Características
- Gestión completa de vehículos (CRUD)
- Registro y seguimiento de clientes
- Control de ventas con diferentes métodos de pago
- Sistema de inventario automático
- API REST documentada con Swagger
- Base de datos MySQL

## Tecnologías
- **Backend:** Java 17, Spring Boot 3.1.5
- **Base de datos:** MySQL 8.0
- **Build tool:** Maven
- **Documentación:** Swagger/OpenAPI 3.0
- **Lombok:** Para reducir código boilerplate

##  Instalación y Configuración

### Prerrequisitos
- Java 17 o superior
- MySQL 8.0+
- Maven 3.8+

### Paso 1: Clonar el repositorio
```bash
git clone https://github.com/tu-usuario/edutech-automotora.git
cd edutech-automotora