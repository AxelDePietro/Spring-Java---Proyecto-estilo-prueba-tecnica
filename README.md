# Spring-Java---Proyecto-estilo-prueba-t-cnica
este proyecto es una prueba personal al estilo prueba técnica.

base de datos SQL - MySQLserver:
la conexion con la bd esta en bruto, sin variables de entorno (momentaneamente).

      create database if not exists prueba_tecnica_v2;
      
      use prueba_tecnica_v2;
      
      -- SERVICIOS
      create table if not exists lavado(
      id_lavado int primary key auto_increment not null,
      tipo varchar(20)
      );
      
      create table if not exists alineacion_balanceo(
      id_alineacion_balanceo int primary key auto_increment not null,	
      cambio_cubiertas boolean
      );
      
      create table if not exists cambio_aceite_filtros(
      id_cambio_aceite_filtros int primary key auto_increment not null,
      motor varchar(20),
      rendimiento varchar(20)
      );
      
      -- CLIENTE, VEHICULO Y TURNO
      create table if not exists cliente(
      id_cliente int primary key auto_increment not null,
      nombre varchar(50),
      apellido varchar(50)
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
      fecha_hora datetime,
      
      -- vehiculo
      fk_vehiculo int null,
      foreign key(fk_vehiculo) references vehiculo(id_vehiculo),
      
      -- servicios
      fk_lavado int null,
      fk_alineacion_balanceo int null,
      fk_cambio_aceite_filtros int null,
      foreign key (fk_lavado) references lavado(id_lavado),
      foreign key (fk_alineacion_balanceo) references alineacion_balanceo(id_alineacion_balanceo),
      foreign key (fk_cambio_aceite_filtros) references cambio_aceite_filtros(id_cambio_aceite_filtros)
      );
