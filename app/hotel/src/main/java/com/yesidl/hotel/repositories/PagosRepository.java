package com.yesidl.hotel.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.yesidl.hotel.models.Pagos;

@Repository
public interface PagosRepository extends JpaRepository<Pagos, String> {

}
