package com.yesidl.hotel.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Date;
import java.util.List;  


@Schema(description = "DTO para respuesta de reserva")
public record ReservaResponseDto(
    @Schema(description = "ID de la reserva", example = "1")
    String idReserva,
    
    @Schema(description = "Número de la habitación", example = "101")
    int numeroHabitacion,
    
    @Schema(description = "Nombre del huesped", example = "Juan Pérez")
    String nombreHuesped,
    
    @Schema(description = "Cantidad de personas", example = "2")
    int cantidadPersonas,
    
    @Schema(description = "Cantidad de noches", example = "3")
    int noches,
    
    @Schema(description = "Fecha de ingreso", example = "2025-10-20")
    Date fechaIngreso,
    
    @Schema(description = "Fecha de salida", example = "2025-10-23")
    Date fechaSalida,
    
    @Schema(description = "Servicios", example = "[]")
    List<ServiciosDto> servicios,
    
    @Schema(description = "Total", example = "150.00")
    double total
) {

}
