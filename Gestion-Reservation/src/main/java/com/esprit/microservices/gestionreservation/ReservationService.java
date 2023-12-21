package com.esprit.microservices.gestionreservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;
    public List<Reservation> getAllReservation() {
        return reservationRepository.findAll();
    }

    public Reservation addReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }
    public Page<Reservation> getReservationsByDure(String dure, Pageable pageable) {
        return reservationRepository.findReservationByDure(dure, pageable);
    }
    public Reservation updateReservation(int id, Reservation newReservation) {
        if (reservationRepository.findById(id).isPresent()) {
            Reservation existingReservation = reservationRepository.findById(id).get();
            existingReservation.setPrix(newReservation.getPrix());
            return reservationRepository.save(existingReservation);

        } else
            return null;
    }

   public Reservation getReservationById(int id){
        return reservationRepository.findById(id).get();
   }
    public String deleteReservation(int id) {
        if (reservationRepository.findById(id).isPresent()) {
            reservationRepository.deleteById(id);
            return "Reservation supprimé";
        } else
            return "Reservation non supprimé";
    }
}

