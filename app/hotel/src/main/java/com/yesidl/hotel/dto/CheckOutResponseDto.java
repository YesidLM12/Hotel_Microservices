package com.yesidl.hotel.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO para respuesta de checkout")
public record CheckOutResponseDto(
    @Schema(description = "Total antes de descuento", example = "150.00")
    double totalAntesDescuento,
    
    @Schema(description = "Descuento aplicado", example = "15.00")
    double descuento,
    
    @Schema(description = "Total después de descuento", example = "135.00")
    double totalDespuesDescuento
) {

}
