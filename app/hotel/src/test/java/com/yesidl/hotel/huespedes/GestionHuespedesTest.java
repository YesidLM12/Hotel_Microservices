package com.yesidl.hotel.huespedes;

import com.yesidl.hotel.common.Enums.Genero;
import com.yesidl.hotel.common.exceptions.HuespedExistenteException;
import com.yesidl.hotel.dto.HuespedesDto;
import com.yesidl.hotel.models.Huespedes;
import com.yesidl.hotel.repositories.HuespedesRepostory;
import com.yesidl.hotel.services.HuespedesService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class GestionHuespedesTest {
  @Mock
  private HuespedesRepostory huespedesRepostory;

  @InjectMocks
  private HuespedesService huespedesService;

  @Test
  void debePermitirCrearHuesped() {
    HuespedesDto huesped = new HuespedesDto(
        "123456789",
        "Juan",
        "Perez",
        25,
        "M"
        );

    huespedesService.crearHuesped(huesped);

    verify(huespedesRepostory, times(1)).save(any(Huespedes.class));
  }

  @Test
  void noDebePermitirCrearHuespedExistente(){
    Huespedes huespedExistente = new Huespedes(
        "123456789",
        "Juan",
        "Perez",
        25,
        Genero.M,
        List.of()
    );

    HuespedesDto huesped = new HuespedesDto(
        "123456789",
        "Juan",
        "Perez",
        25,
        "M"
    );

    when(huespedesRepostory.findById(huespedExistente.getDocumento()))
        .thenReturn(Optional.of(huespedExistente));

    HuespedExistenteException exception = assertThrows(
        HuespedExistenteException.class,
        () -> huespedesService.crearHuesped(huesped)
    );

    System.out.println(exception.getMessage());
    verify(huespedesRepostory, never()).save(any(Huespedes.class));
  }

  @Test
  void debePermitirActualizarUnHuesped(){
    Huespedes huespedExistente = new Huespedes(
        "123456789",
        "Juan",
        "Perez",
        25,
        Genero.M,
        List.of()
    );

    HuespedesDto huesped = new HuespedesDto(
        "123456789",
        "Santiago",
        "Perez",
        26,
        "M"
    );

    when(huespedesRepostory.findById(huespedExistente.getDocumento()))
        .thenReturn(Optional.of(huespedExistente));

    huespedesService.editarHuesped(huesped);
    verify(huespedesRepostory).save(any(Huespedes.class));
  }

  @Test
  void debePermitirEliminarUnHuesped(){
    Huespedes huespedExistente = new Huespedes(
        "123456789",
        "Juan",
        "Perez",
        25,
        Genero.M,
        List.of()
    );

    when(huespedesRepostory.findById(huespedExistente.getDocumento()))
        .thenReturn(Optional.of(huespedExistente));

    huespedesService.eliminarHuesped(huespedExistente.getDocumento());
    verify(huespedesRepostory).delete(huespedExistente);
  }
}
