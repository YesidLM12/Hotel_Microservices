package com.yesidl.hotel.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO para crear una habitacion")
public record HabitacionesDto(
    @Schema(description = "Numero de habitacion", example = "101")
    int numeroHabitacion,
    
    @Schema(description = "Tipo de habitacion", example = "Simple")
    String tipoHabitacion,
    
    @Schema(description = "Precio de la habitacion", example = "100")
    double precio
) {

}
