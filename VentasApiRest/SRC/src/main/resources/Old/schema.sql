-- Secuencias de SQL de creacion de la DB

-- Nombre de la base de datos: coder
create database coder;

USE coder;

-- Creo Tablas necesarias para el proyecto

CREATE TABLE clientes (id INT AUTO_INCREMENT ,
 nombre VARCHAR(75), apellido VARCHAR(75),
 dni VARCHAR(11), PRIMARY KEY(id));
 
 CREATE TABLE facturas (id INT AUTO_INCREMENT ,
 id_cliente INT, creado_en DATETIME, total DOUBLE, PRIMARY KEY (id), FOREIGN KEY (id_cliente) REFERENCES clientes(id));
 

 
 CREATE TABLE productos (id INT AUTO_INCREMENT PRIMARY KEY, descripcion VARCHAR(150), codigo VARCHAR(50),
 stock INT, precio DOUBLE);
 
  CREATE TABLE detalleFactura (id INT AUTO_INCREMENT,
 id_factura INT , cantidad INT NOT NULL, id_producto INT,
 precio DOUBLE,FOREIGN KEY(id_factura) REFERENCES facturas(id), FOREIGN KEY(id_producto) REFERENCES productos(id), PRIMARY KEY(id));
 
 