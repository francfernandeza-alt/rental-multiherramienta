# Rental Herramientas

Aplicación backend desarrollada en Java Spring Boot para gestionar el arriendo de herramientas.

## Integrantes

- Javier Olave
- Franco Fernandez
- Nicolas Labrin

## Descripción del proyecto

Rental Herramientas permite administrar usuarios, herramientas, reservas, direcciones, comunas, regiones, marcas, materiales, tipos de herramienta, tipos de pago, tipos de reserva y mantenciones.

El proyecto fue desarrollado aplicando arquitectura CSR:

- Controller: expone endpoints REST.
- Service: contiene lógica de negocio.
- Repository: acceso a datos mediante JpaRepository.
- Model: entidades JPA persistidas en MySQL.

## Tecnologías utilizadas

- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- MySQL
- Lombok
- Maven
- Git / GitHub

## Configuración de base de datos

Crear una base de datos en MySQL:

```sql
CREATE DATABASE db_rental_herramientas;
```