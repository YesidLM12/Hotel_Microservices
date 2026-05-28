package com.yesidl.hotel.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.yesidl.hotel.models.CheckOut;

@Repository
public interface CheckOutRepository extends JpaRepository<CheckOut, Integer> {

}
