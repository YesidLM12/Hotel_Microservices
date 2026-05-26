package com.yesidl.hotel.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.yesidl.hotel.models.Reservas;

@Repository
public interface ReservasRepository extends JpaRepository<Reservas, Integer> {

}
