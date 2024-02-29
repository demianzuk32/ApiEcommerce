# Ventas APIRest

### Resumen
APIRest de ventas con patron de N Capas e implementacion de SpringBoot con JPA como ORM.

### Estructura del Repositorio

- bin: Contiene el/los archivo/s Java
- src: codigo fuente de la APIRest
- postman scripts: Scripts de Postman


### Dependencias
- Spring Web
- Spring Data JPA
- Lombok
- MySql Driver

### Configuracion
#### Spring
- Maven
- Spring Boot version 3.2.2
- Java version: 21

#### MySQL
- Puerto: 3306

### Ejecucion

`$ java -jar FacturacionEntregaProyectoFinalZuk.jar`

### Route:
- localhost:8080/api/clientes/listar: Lista la tabla de clientes
- localhost:8080/api/clientes/agregar: agrega el json definido a la db
- localhost:8080/api/clientes/modificar/{id}: modifica el registro de clientes de acuerdo a su ID
- localhost:8080/api/clientes/eliminar/{id}
- localhost:8080/api/productos/listar
- localhost:8080/api/productos/agregar
- localhost:8080/api/productos/modificar
- localhost:8080/api/productos/eliminar/{id}
- localhost:8080/api/productos/stock?id=[ID]&ventas=[PRODUCTOS_VENDIDOS]
- localhost:8080/api/facturas/listar
- localhost:8080/documentacion.html: Documentacion API con Swagger



