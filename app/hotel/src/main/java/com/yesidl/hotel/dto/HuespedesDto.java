package com.yesidl.hotel.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO para crear un huesped")
public record HuespedesDto(
    @Schema(description = "Documento del huesped", example = "123456789")
    String documento,
    
    @Schema(description = "Nombre del huesped", example = "Juan")
    String nombre,
    
    @Schema(description = "Apellido del huesped", example = "Perez")
    String apellido,
    
    @Schema(description = "Edad del huesped", example = "25")
    int edad,

    @Schema(description = "Genero del huesped", example = "M")
    String genero
) {

}
