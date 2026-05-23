CREATE TABLE huespedes
(
    documento varchar(100) primary key not null,
    nombre    varchar(255)             not null,
    edad      int                      not null,
    genero    enum('M', 'F')           not null
);

CREATE TABLE habitaciones
(
    numero_habitacion int primary key not null,
    tipo              varchar(100)    not null,
    estado            enum('disponible', 'ocupada')    not null,
    precio            bigint          not null
);

CREATE TABLE reservas
(
    documento         varchar(100) not null,
    numero_habitacion int          not null,
    primary key (documento, numero_habitacion),
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
    precio    bigint                   not null,
    documento varchar(100)             not null,
    foreign key (documento)
        references huespedes (documento)
        on delete cascade on update cascade
);

CREATE TABLE pagos
(
    referencia     varchar(255) primary key not null,
    metodo_pago    enum('efectivo', 't.credito', 't.debito', 'transferencia') not null,
    monto_recibido bigint                   not null,
    diferencia     bigint
);

CREATE TABLE check_out
(
    documento               varchar(100) not null,
    referencia              varchar(255) not null,
    pago_antes_descuento    bigint       not null,
    descuentos              bigint,
    pago_despues_descuentos bigint       not null,
    primary key (documento, referencia),
    foreign key (documento)
        references huespedes (documento),
    foreign key (referencia)
        references pagos (referencia)
);