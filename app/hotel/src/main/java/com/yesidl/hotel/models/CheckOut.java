package com.yesidl.hotel.models;
import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "check_out")
public class CheckOut {

    @Id
    @Column(name = "id_check_out", nullable = false)
    private int idCheckOut;
    
    @OneToOne
    @JoinColumn(name = "id_reserva", nullable = false)
    private Reservas reserva;

    @Column(name = "total_antes_descuento", nullable = false)
    private BigDecimal totalAntesDescuento;
    
    @Column(name = "descuentos", nullable = false)
    private BigDecimal descuento;
    
    @Column(name = "total_despues_descuento", nullable = false)
    private BigDecimal totalDespuesDescuento;
}
