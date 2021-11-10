create database Tienda_Generica; 
use Tienda_Generica;

create table clientes(
cedula_cliente bigint(20) primary key,
direccion_cliente varchar(255),
email_cliente varchar (255),
nombre_cliente varchar(255),
telefono_cliente varchar(255)
);

create table usuarios(
cedula_usuario bigint(20) primary key,
email_usuario varchar(255),
nombre_usuario varchar (255),
password varchar(255),
usuario varchar(255)
);

create table detalle_ventas(
codigo_detalle_ventas bigint(20) primary key,
cantidad_producto int(11),
codigo_producto bigint (20),
codigo_venta bigint(20),
valor_total double,
valor_venta double,
valoriva double
);

create table proveedores(
nitproveedor bigint(20) primary key,
ciudad_proveedor varchar(255),
direccion_proveedor varchar (255),
nombre_proveedor varchar(255),
telefono_proveedor varchar(255)
);

create table productos(
codigo_producto bigint(20) primary key,
ivacompra double,
nitproveedor bigint(20),
nombre_producto varchar(255),
precio_compra double,
precio_venta double
);

create table ventas(
codigo_venta bigint(20) primary key,
cedula_cliente bigint(20),
cedula_usuario bigint(20),
ivaventa double,
total_venta double,
valor_venta double
);

alter table ventas add foreign key(cedula_cliente) references clientes(cedula_cliente);
alter table ventas add foreign key(cedula_usuario) references usuarios(cedula_usuario);
alter table detalle_ventas add foreign key(codigo_venta) references ventas(codigo_venta);
alter table detalle_ventas add foreign key(codigo_producto) references productos(codigo_producto);
alter table productos add foreign key(nitproveedor) references proveedores(nitproveedor);
alter table productos modify nitproveedor bigint(20);