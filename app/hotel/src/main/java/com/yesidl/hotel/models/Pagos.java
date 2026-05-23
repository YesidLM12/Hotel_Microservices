package com.yesidl.hotel.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name = "pagos")
public class Pagos {

    @Id
    @Column(name = "referencia", nullable = false)
    private String referencia;

    @Column(name = "metodo_pago", nullable = false)
    private String metodoPago;
    
    @Column(name = "monto_recibido", nullable = false)
    private Long montoRecibido;
    
    @Column(name = "diferencia", nullable = false)
    private Long diferencia;

    @ManyToOne
    @JoinColumn(name = "id_reserva", referencedColumnName = "id_reserva")
    private Reservas idReserva;
}
