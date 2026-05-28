package com.yesidl.hotel.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO para respuesta de pago")
public record PagosResponseDto(
    @Schema(description = "Método de pago", example = "Efectivo")
    String metodoPago,
    
    @Schema(description = "Monto recibido", example = "100000")
    double montoRecibido,
    
    @Schema(description = "Diferencia", example = "0")
    double diferencia
) {
}
