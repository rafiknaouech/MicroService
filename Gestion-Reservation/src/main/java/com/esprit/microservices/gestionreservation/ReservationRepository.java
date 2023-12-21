package com.esprit.microservices.gestionreservation;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ReservationRepository extends JpaRepository <Reservation , Integer> {
    @Query("select r from Reservation r where r.dure = :dure")
    public Page<Reservation> findReservationByDure(@Param("dure") String dure, Pageable pageable);
}
