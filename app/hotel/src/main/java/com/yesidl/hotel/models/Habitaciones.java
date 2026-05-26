package com.yesidl.hotel.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;

import java.util.List;
import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Table;
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
@Table(name = "habitaciones")
public class Habitaciones {

    @Id
    @Column(name = "numero_habitacion", nullable = false)
    private int numeroHabitacion;

    @Column(name = "tipo", nullable = false)
    private String tipo;

    @Column(name = "precio", nullable = false)
    private BigDecimal precio;

    @OneToMany(mappedBy = "habitacion", cascade = CascadeType.ALL)
    private List<Reservas> reservas;

}
