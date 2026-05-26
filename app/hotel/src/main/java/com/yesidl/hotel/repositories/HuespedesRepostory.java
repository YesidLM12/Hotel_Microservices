package com.yesidl.hotel.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.yesidl.hotel.models.Huespedes;

@Repository
public interface HuespedesRepostory extends JpaRepository<Huespedes, String> {

}
