CREATE TABLE huespedes
(
    documento varchar(100) primary key not null,
    nombre    varchar(255)             not null,
    apellido  varchar(255)             not null,
    edad      int                      not null,
    genero    char(1)           not null
);

CREATE TABLE habitaciones
(
    numero_habitacion int primary key not null,
    tipo              varchar(100)    not null,
    estado            varchar(100)    not null,
    precio            decimal(10,2)          not null
);

CREATE TABLE reservas
(
    id_reserva        int auto_increment primary key not null,
    documento         varchar(100) not null,
    numero_habitacion int          not null,
    cantidad_personas int          not null,
    noches            int          not null,
    fecha_ingreso     date         not null,
    fecha_salida      date         not null,
    total             decimal(10,2)       not null,
    foreign key (documento)
        references huespedes (documento)
        on delete cascade on update cascade,
    foreign key (numero_habitacion)
        references habitaciones (numero_habitacion)
        on delete cascade on update cascade
);

CREATE TABLE servicios
(
    codigo    varchar(100) primary key not null,
    nombre    varchar(100)             not null,
    precio    decimal(10,2)                     not null,
    id_reserva int                     not null,
    foreign key (id_reserva)
        references reservas (id_reserva)
        on delete cascade on update cascade
);

CREATE TABLE pagos
(
    referencia     varchar(255) primary key not null,
    metodo_pago    varchar(100) not null,
    monto_recibido decimal(10,2)                   not null,
    diferencia     decimal(10,2),
    id_reserva     int                      not null,
    foreign key (id_reserva)
        references reservas (id_reserva)
        on delete cascade on update cascade
);

CREATE TABLE check_out
(
    id_check_out            int auto_increment primary key not null,
    id_reserva              int not null,
    total_antes_descuento    decimal(10,2)      not null,
    descuentos              decimal(10,2),
    total_despues_descuento decimal(10,2)       not null,
    foreign key (id_reserva)
        references reservas (id_reserva)
);