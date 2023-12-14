package com.esprit.microservices.gestionreservation;

import jakarta.ws.rs.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ReservationRestAPI {
    private String title=("/Heloo");
    @RequestMapping("")
    public String sayHeloo(){
        System.out.println(title);
        return title;
    }

    @Autowired
    private ReservationService reservationService;
    @GetMapping("/reservation")
    public List<Reservation> getAllReservation() {
        return reservationService.getAllReservation();
    }



    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/add")
    public ResponseEntity<Reservation> addReservation(@RequestBody Reservation reservation) {
        return new ResponseEntity<>(reservationService.addReservation(reservation), HttpStatus.OK);
    }

    @GetMapping("/reservationsByDure")
    public ResponseEntity<Page<Reservation>> getReservationsByDure(
            @RequestParam String dure,
            Pageable pageable
    ) {
        Page<Reservation> reservations = reservationService.getReservationsByDure(dure, pageable);

        if (reservations.hasContent()) {
            return ResponseEntity.ok().body(reservations);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/reservations/{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable int id) {
        Reservation reservation = reservationService.getReservationById(id);

        if (reservation != null) {
            return ResponseEntity.ok().body(reservation);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
   @PutMapping(value = "update/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Reservation> updateCandidat(@PathVariable(value = "id") int id,
                                                   @RequestBody Reservation reservation){
        return new ResponseEntity<>(reservationService.updateReservation(id, reservation),
                HttpStatus.OK);
    }



    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteReservation(@PathVariable(value = "id") int id){
        return new ResponseEntity<>(reservationService.deleteReservation(id), HttpStatus.OK);
    }

}
