package com.yesidl.hotel.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Schema(description = "DTO para crear y retornar un huésped")
public record HuespedesDto(
    @Schema(description = "Documento del huésped", example = "123456789")
    @NotBlank(message = "El documento es obligatorio")
    @Size(max = 12, message = "El documento debe tener máximo 12 carácteres")
    String documento,
    
    @Schema(description = "Nombre del huésped", example = "Juan")
    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 3, max = 20, message = "El nombre debe tener entre 3 y 20 carácteres")
    String nombre,
    
    @Schema(description = "Apellido del huésped", example = "Perez")
    @NotBlank(message = "El apellido es obligatorio")
    @Size(min = 3, max = 20, message = "El apellido debe tener entre 3 y 20 carácteres")
    String apellido,
    
    @Schema(description = "Edad del huésped", example = "25")
    @Positive(message = "La edad debe ser un número entero positivo")
    @NotNull(message = "La edad es obligatoria")
    Integer edad,

    @Schema(description = "Género del huésped", example = "M")
    @NotBlank(message = "El género es obligatorio")
    @Size(max = 1, message = "El género se expresa con un carácter (M/F)")
    String genero
) {
}
