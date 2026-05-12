# Rental Multiherramienta

Backend desarrollado con Java Spring Boot para gestionar el arriendo de herramientas.

## Integrantes

- Javier Olave
- Franco Fernandez
- Nicolas Labrin

## Descripción del proyecto

Rental Herramientas permite administrar usuarios, herramientas, reservas, direcciones, comunas, regiones, marcas, materiales, tipos de herramienta, tipos de pago, tipos de reserva y mantenciones.

## Tecnologías

- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- MySQL
- Lombok
- Maven
- Git / GitHub

## Arquitectura

El proyecto utiliza arquitectura CSR:

- `Controller`: expone endpoints REST.
- `Service`: contiene lógica de negocio.
- `Repository`: acceso a datos mediante `JpaRepository`.
- `Model`: entidades JPA persistidas en MySQL.
- `DTO`: utilizado en entidades donde se requiere separar la respuesta mostrada al cliente del modelo persistido.

## Base de datos

Crear la base de datos en MySQL:

```sql
CREATE DATABASE db_rental_herramientas;
``

Configurar `src/main/resources/application.properties`:

```properties
spring.application.name=multiherramienta

spring.datasource.url=jdbc:mysql://localhost:3306/db_rental_herramientas
spring.datasource.username=root
spring.datasource.password=

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
```

## Ejecución

Desde la raíz del proyecto:

```bash
mvn clean compile
mvn spring-boot:run
```

Si se usa Maven Wrapper:

```bash
.\mvnw.cmd clean compile
.\mvnw.cmd spring-boot:run
```

## Endpoints principales

### Usuarios

```txt
GET    /api/v1/usuarios
GET    /api/v1/usuarios/{rut}
POST   /api/v1/usuarios
PUT    /api/v1/usuarios/{rut}
DELETE /api/v1/usuarios/{rut}
```

### Herramientas

```txt
GET    /api/v1/herramientas
GET    /api/v1/herramientas/{id}
POST   /api/v1/herramientas
PUT    /api/v1/herramientas/{id}
DELETE /api/v1/herramientas/{id}
```

### Reservas

```txt
GET    /api/v1/reservas
GET    /api/v1/reservas/{id}
POST   /api/v1/reservas
PUT    /api/v1/reservas/{id}
DELETE /api/v1/reservas/{id}
```

### Comunas

```txt
GET    /api/v1/comunas
GET    /api/v1/comunas/{id}
POST   /api/v1/comunas
PUT    /api/v1/comunas/{id}
DELETE /api/v1/comunas/{id}
```

### Materiales

```txt
GET    /api/v1/material
GET    /api/v1/material/{id}
POST   /api/v1/material
PUT    /api/v1/material/{id}
DELETE /api/v1/material/{id}
```

### Tipos de herramienta

```txt
GET    /api/v1/tipoherramienta
GET    /api/v1/tipoherramienta/{id}
POST   /api/v1/tipoherramienta
PUT    /api/v1/tipoherramienta/{id}
DELETE /api/v1/tipoherramienta/{id}
```

### Tipos de pago

```txt
GET    /api/v1/tipopago
GET    /api/v1/tipopago/{id}
POST   /api/v1/tipopago
PUT    /api/v1/tipopago/{id}
DELETE /api/v1/tipopago/{id}
```

### Tipos de reserva

```txt
GET    /api/v1/tiporeserva
GET    /api/v1/tiporeserva/{id}
POST   /api/v1/tiporeserva
PUT    /api/v1/tiporeserva/{id}
DELETE /api/v1/tiporeserva/{id}
```

### Mantención

```txt
GET    /api/v1/mantencion
GET    /api/v1/mantencion/{id}
POST   /api/v1/mantencion
PUT    /api/v1/mantencion/{id}
DELETE /api/v1/mantencion/{id}
```

## Ejemplos JSON

### Crear material

```json
{
  "nombreMaterial": "Acero",
  "descripcionMaterial": "Material resistente utilizado en herramientas metálicas"
}
```

### Crear tipo de herramienta

```json
{
  "nombreTipoHerramienta": "Taladro",
  "descripcionTipoHerramienta": "Herramienta utilizada para perforar superficies"
}
```

### Crear tipo de pago

```json
{
  "metodoPago": "Transferencia"
}
```

### Crear tipo de reserva

```json
{
  "nombreTipoReserva": "Retiro en local"
}
```

## Validaciones

El proyecto utiliza Bean Validation con anotaciones como:

- `@NotBlank`
- `@NotNull`
- `@Size`

Estas validaciones controlan campos obligatorios y restricciones básicas antes de guardar datos.

## Manejo de errores

El proyecto utiliza:

- `ResponseEntity`
- códigos HTTP
- `@ControllerAdvice`
- validaciones en entidades

## Control de versiones

El proyecto utiliza Git y GitHub con commits técnicos y Pull Requests.

## Estado actual

Backend funcional con persistencia JPA/Hibernate, conexión a MySQL, arquitectura CSR y endpoints REST para la gestión de arriendo de herramientas.