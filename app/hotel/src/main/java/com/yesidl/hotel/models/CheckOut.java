package com.yesidl.hotel.models;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import jakarta.persistence.Id;
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
    @Column(name = "id_reserva", nullable = false)
    private String idReserva;

    @Column(name = "total_antes_descuento", nullable = false)
    private double totalAntesDescuento;
    
    @Column(name = "descuento", nullable = false)
    private double descuento;
    
    @Column(name = "total_despues_descuento", nullable = false)
    private double totalDespuesDescuento;
}
