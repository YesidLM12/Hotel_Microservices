package com.yesidl.hotel.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.yesidl.hotel.models.Habitaciones;

@Repository
public interface HabitacionesRepository extends JpaRepository<Habitaciones, Integer> {

}
