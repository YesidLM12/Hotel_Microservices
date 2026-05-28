package com.yesidl.hotel.services;

import com.yesidl.hotel.common.Enums.Genero;
import com.yesidl.hotel.common.exceptions.HuespedExistenteException;
import com.yesidl.hotel.common.exceptions.HuespedNotFoundException;
import com.yesidl.hotel.dto.HuespedesDto;
import com.yesidl.hotel.models.Huespedes;
import com.yesidl.hotel.repositories.HuespedesRepostory;
import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HuespedesService {
  private final HuespedesRepostory huespedesRepostory;

  public HuespedesService(HuespedesRepostory huespedesRepostory) {
    this.huespedesRepostory = huespedesRepostory;
  }

  public Huespedes crearHuesped(@NonNull HuespedesDto huesped) {
    Optional<Huespedes> huespedExistente = huespedesRepostory.findById(huesped.documento());

    if (huespedExistente.isPresent()) {
      throw new HuespedExistenteException("Huésped existente");
    }

    Huespedes nuevoHuesped = new Huespedes();
    nuevoHuesped.setDocumento(huesped.documento());
    nuevoHuesped.setNombre(huesped.nombre());
    nuevoHuesped.setApellido(huesped.apellido());
    nuevoHuesped.setEdad(huesped.edad());
    nuevoHuesped.setGenero(Genero.valueOf(huesped.genero()));

    huespedesRepostory.save(nuevoHuesped);
    return nuevoHuesped;
  }

  public List<HuespedesDto> obtenerHuespedes() {
    return huespedesRepostory.findAll().stream().map(h -> new HuespedesDto(
        h.getDocumento(),
        h.getNombre(),
        h.getApellido(),
        h.getEdad(),
        h.getGenero().toString()
    )).toList();
  }

  public HuespedesDto obtenerHuesped(@NonNull String documento) {
    Huespedes huesped = huespedesRepostory.findById(documento)
        .orElseThrow(() -> new HuespedNotFoundException("Huésped no encontrado"));

    return new HuespedesDto(
        huesped.getDocumento(),
        huesped.getNombre(),
        huesped.getApellido(),
        huesped.getEdad(),
        huesped.getGenero().toString()
    );
  }

  public HuespedesDto editarHuesped(@NonNull HuespedesDto huesped) {
    Huespedes huespedExistente = huespedesRepostory.findById(huesped.documento())
        .orElseThrow(() -> new HuespedNotFoundException("Huésped no encontrado"));

    huespedExistente.setNombre(huesped.nombre() != null ? huesped.nombre() : huespedExistente.getNombre());
    huespedExistente.setApellido(huesped.apellido() != null ? huesped.apellido() : huespedExistente.getNombre());
    huespedExistente.setEdad(huesped.edad() != null ? huesped.edad() : huespedExistente.getEdad());
    huespedExistente.setGenero(huesped.genero() != null ? Genero.valueOf(huesped.genero()) : huespedExistente.getGenero());

    huespedesRepostory.save(huespedExistente);
    return new HuespedesDto(
        huespedExistente.getDocumento(),
        huespedExistente.getNombre(),
        huespedExistente.getApellido(),
        huespedExistente.getEdad(),
        huespedExistente.getGenero().toString()
    );
  }

  public void eliminarHuesped (String documento){
    Huespedes huesped = huespedesRepostory.findById(documento)
        .orElseThrow(() -> new HuespedNotFoundException("Huésped no encontrado"));

    huespedesRepostory.delete(huesped);
  }
}
