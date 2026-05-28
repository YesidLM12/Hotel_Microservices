package com.yesidl.hotel.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO para crear un pago")
public record PagosDto(

    @Schema(description = "Método de pago", example = "Efectivo")
    String metodoPago,
    
    @Schema(description = "Monto recibido", example = "100000")
    double montoRecibido
) {
    
}
