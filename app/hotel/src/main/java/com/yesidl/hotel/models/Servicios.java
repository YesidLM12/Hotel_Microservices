package com.yesidl.hotel.models;
import java.math.BigDecimal;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
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
@Table(name = "servicios")
public class Servicios {

    @Id
    @Column(name = "codigo", nullable = false)
    private String codigo;
    
    @Column(name = "nombre", nullable = false)
    private String nombre;
    
    @Column(name = "precio", nullable = false)
    private BigDecimal precio;

    @ManyToOne
    @JoinColumn(name = "id_reserva", nullable = false)
    private Reservas reserva;
}
