# Spring-Java---Proyecto-estilo-prueba-t-cnica
este proyecto es una prueba personal al estilo prueba técnica.

base de datos SQL - MySQLserver:
la conexion con la bd esta en bruto, sin variables de entorno (momentaneamente).

        create database if not exists prueba_tecnica_v3;
  
        use prueba_tecnica_v3;
        
        -- CLIENTE, VEHICULO Y TURNO
        create table if not exists cliente(
        id_cliente int primary key auto_increment not null,
        nombre varchar(50),
        apellido varchar(50),
        premium boolean
        );
        
        create table if not exists vehiculo(
        id_vehiculo int primary key auto_increment not null,
        matricula varchar(10),
        
        -- cliente
        fk_cliente int,
        foreign key(fk_cliente) references cliente(id_cliente)
        );
        
        create table if not exists turno(
        id_turno int primary key auto_increment not null,
        fecha date,
        hora int,
        precio int,
        
        -- vehiculo
        fk_vehiculo int null,
        foreign key(fk_vehiculo) references vehiculo(id_vehiculo),
        
        tipo varchar(20),
        
        alineacion_balanceo boolean,
        cambio_cubiertas boolean,
        
        motor varchar(20),
        rendimiento varchar(20)
        );
