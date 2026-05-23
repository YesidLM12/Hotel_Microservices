package com.yesidl.hotel.models;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "reservas")
public class Reservas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserva", nullable = false)
    private String idReserva;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "numero_habitacion", referencedColumnName = "numero_habitacion")
    private Habitaciones habitacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "documento", referencedColumnName = "documento")
    private Huespedes huesped;

    @Column(name = "cantidad_personas", nullable = false)
    private int cantidadPersonas;

    @Column(name = "noches", nullable = false)
    private int noches;

    @Column(name = "fecha_ingreso", nullable = false)
    private Date fechaIngreso;

    @Column(name = "fecha_salida", nullable = false)
    private Date fechaSalida;

    @OneToMany(mappedBy = "reserva", cascade = CascadeType.ALL)
    private List<Servicios> servicios;

    @Column(name = "total", nullable = false)   
    private double total;

    @OneToMany(mappedBy = "reserva", cascade = CascadeType.ALL)
    private List<Pagos> pagos;
}
