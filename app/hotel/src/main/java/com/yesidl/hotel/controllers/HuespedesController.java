package com.yesidl.hotel.controllers;

import com.yesidl.hotel.common.exceptions.HuespedExistenteException;
import com.yesidl.hotel.common.exceptions.HuespedNotFoundException;
import com.yesidl.hotel.dto.HuespedesDto;
import com.yesidl.hotel.models.Huespedes;
import com.yesidl.hotel.services.HuespedesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/huespedes")
@Tag(name = "Huéspedes", description = "Gestión de huéspedes")
public class HuespedesController {
  private final HuespedesService huespedesService;

  public HuespedesController(HuespedesService huespedesService) {
    this.huespedesService = huespedesService;
  }

  @Operation(summary = "Crear un nuevo huésped")
  @ApiResponses(value = {
      @ApiResponse(
          responseCode = "201",
          description = "Huésped creado exitosamente",
          content = @Content(mediaType = "application/json",
              examples = @ExampleObject(
                  value = """
                              {
                                "documento": "123456781",
                                "nombre": "Juan",
                                "apellido": "Perez",
                                "edad": 25,
                                "genero": "M"
                              }
                      """))),
      @ApiResponse(
          responseCode = "400",
          description = "solicitud inválida",
          content = @Content(mediaType = "application/json",
              examples = @ExampleObject(
                  value = """
                              {
                                "error": "solicitud inválida"
                              }
                      """))),
      @ApiResponse(
          responseCode = "409",
          description = "Huésped existente",
          content = @Content(mediaType = "application/json",
              examples = @ExampleObject(
                  value = """
                      {
                        "error": "Huésped existente"
                      }
                      """))),
  })
  @PostMapping()
  public ResponseEntity<?> crearHuesped(@Valid @RequestBody HuespedesDto huespedesDto) {
    try {
      Huespedes nuevoHuesped = huespedesService.crearHuesped(huespedesDto);
      return ResponseEntity.status(HttpStatus.CREATED).body(nuevoHuesped);
    } catch (HuespedExistenteException e) {
      return ResponseEntity.status(HttpStatus.CONFLICT).body(Map.of("error", e.getMessage()));
    }
  }

  @Operation(summary = "Obtener todos los huéspedes", description = "Obtiene una lista de todos los huéspedes registrados")
  @ApiResponses(value = {
      @ApiResponse(
          responseCode = "200",
          description = "Lista de huéspedes obtenida exitosamente",
          content = @Content(mediaType = "application/json",
              examples = @ExampleObject(
                  value = """
                      [
                        {
                          "documento": "123456780",
                          "nombre": "Juan",
                          "apellido": "Perez",
                          "edad": 25,
                          "genero": "M"
                        },
                        {
                          "documento": "123456781",
                          "nombre": "Juan",
                          "apellido": "Perez",
                          "edad": 25,
                          "genero": "M"
                        }
                      ]
                      """))),
      @ApiResponse(
          responseCode = "204",
          description = "No se encontraron huéspedes",
          content = @Content(mediaType = "application/json",
              examples = @ExampleObject(
                  value = """
                      []
                      """)))
  })
  @GetMapping
  public ResponseEntity<?> mostrarHuespedes() {
    return ResponseEntity.ok(huespedesService.obtenerHuespedes());
  }

  @Operation(summary = "Obtener un huésped por su documento")
  @ApiResponses(value = {
      @ApiResponse(
          responseCode = "200",
          description = "Huésped obtenido exitosamente",
          content = @Content(mediaType = "application/json",
              examples = @ExampleObject(
                  value = """
                      {
                        "documento": "123456780",
                        "nombre": "Juan",
                        "apellido": "Perez",
                        "edad": 25,
                        "genero": "M"
                      }
                      """))),
      @ApiResponse(
          responseCode = "404",
          description = "Huésped no encontrado",
          content = @Content(mediaType = "application/json",
              examples = @ExampleObject(
                  value = """
                      {
                        "error": "Huésped no encontrado"
                      }
                      """)))
  })
  @GetMapping("/{documento}")
  public ResponseEntity<?> mostrarHuesped(@PathVariable(name = "documento") String documento) {
    try {
      return ResponseEntity.ok(huespedesService.obtenerHuesped(documento));
    } catch (HuespedNotFoundException e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", e.getMessage()));
    }
  }

  @Operation(summary = "Editar un huésped por su documento")
  @ApiResponses(value = {
      @ApiResponse(
          responseCode = "200",
          description = "Huésped editado exitosamente",
          content = @Content(mediaType = "application/json",
              examples = @ExampleObject(
                  value = """
                      {
                        "documento": "12345678",
                        "nombre": "Juan",
                        "apellido": "Perez",
                        "edad": 25,
                        "genero": "M"
                      }
                      """))),
      @ApiResponse(
          responseCode = "404",
          description = "Huésped no encontrado",
          content = @Content(mediaType = "application/json",
              examples = @ExampleObject(
                  value = """
                      {
                        "error": "Huésped no encontrado"
                      }
                      """)))
  })
  @PatchMapping("/{documento}")
  public ResponseEntity<?> editarHuesped(@PathVariable(name = "documento") String documento, @Valid @RequestBody HuespedesDto huesped) {
    try {
      return ResponseEntity.ok(huespedesService.editarHuesped(huesped));
    } catch (HuespedNotFoundException e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", e.getMessage()));
    }
  }

  @Operation(summary = "Eliminar un huésped por su documento")
  @ApiResponses(value = {
      @ApiResponse(
          responseCode = "204",
          description = "Huésped eliminado exitosamente",
          content = @Content(mediaType = "application/json",
              examples = @ExampleObject(
                  value = """
                      {
                        "mensaje": "Huésped eliminado correctamente"
                      }
                      """))),
      @ApiResponse(
          responseCode = "404",
          description = "Huésped no encontrado",
          content = @Content(mediaType = "application/json",
              examples = @ExampleObject(
                  value = """
                      {
                        "error": "Huésped no encontrado"
                      }
                      """)))
  })
  @DeleteMapping("/{documento}")
  public ResponseEntity<?> eliminarHuesped(@PathVariable(name = "documento") String documento) {
    try {
      huespedesService.eliminarHuesped(documento);
      return ResponseEntity.status(HttpStatus.NO_CONTENT).body(Map.of("mensaje", "Huésped eliminado correctamente"));
    } catch (HuespedNotFoundException e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", e.getMessage()));
    }
  }
}
