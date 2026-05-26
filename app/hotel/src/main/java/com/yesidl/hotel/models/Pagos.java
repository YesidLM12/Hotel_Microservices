package com.yesidl.hotel.models;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "pagos")
public class Pagos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "referencia", nullable = false)
    private String referencia;

    @Column(name = "metodo_pago", nullable = false)
    private String metodoPago; 
    
    @Column(name = "monto_recibido", nullable = false)
    private BigDecimal montoRecibido;
    
    @Column(name = "diferencia", nullable = false)
    private BigDecimal diferencia;

    @ManyToOne
    @JoinColumn(name = "id_reserva", referencedColumnName = "id_reserva")
    private Reservas reserva;
}
