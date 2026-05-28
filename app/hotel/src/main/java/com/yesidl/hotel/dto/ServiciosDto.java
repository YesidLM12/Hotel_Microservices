package com.yesidl.hotel.dto;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO para crear un servicio")
public record ServiciosDto(
    @Schema(description = "Código del servicio", example = "S001")
    String codigo,
    
    @Schema(description = "Nombre del servicio", example = "Limpieza")
    String nombre,
    
    @Schema(description = "Precio del servicio", example = "50000")
    double precio
) {
}
