package com.ondza.essey.controllers;

import com.ondza.essey.commons.Constants;
import com.ondza.essey.entities.Reservation;
import com.ondza.essey.services.EmailService;
import com.ondza.essey.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.springframework.http.HttpHeaders;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/reservations")
//@CrossOrigin(origins = "http://localhost:3000")
public class ReservationController {

    private final ReservationService reservationService;
    private final EmailService emailService;

    @RequestMapping(value = "/favicon.ico", method = RequestMethod.GET)
    public ResponseEntity<Object> favicon(HttpServletResponse response) throws IOException {
    HttpHeaders headers = new HttpHeaders();
    headers.add(HttpHeaders.CACHE_CONTROL, "no-store, no-cache, must-revalidate, max-age=0");
    // ... Rest of your code ...
    return ResponseEntity
        .ok()
        .headers(headers)
        .body(new HashMap<>());

}
    
    @Autowired
    public ReservationController(ReservationService reservationService, EmailService emailService) {
        this.reservationService = reservationService;
        this.emailService = emailService;
    }

    @GetMapping
    public ResponseEntity<List<Reservation>> getAllReservations() {
        List<Reservation> reservations = reservationService.getAllReservations();
        return new ResponseEntity<>(reservations, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable Long id) {
        Reservation reservation = reservationService.getReservationById(id);
        return new ResponseEntity<>(reservation, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation) throws Exception {
        Reservation createdReservation = reservationService.createReservation(reservation);

        // Send confirmation email
        try {
            emailService.sendEmailToBooker(reservation.getEmail(), "Reservation Confirmation", "Your reservation has been confirmed!");
            emailService.sendEmailToChef(Constants.CHEF_EMAIL, "New Reservation", reservation.getFirstName() + " has booked a new reservation " + "\n"
            + reservation.getReservationType() + reservation.getMessage());
        } catch (Exception e) {
            throw new Exception("Failed to send email");
        }
        return new ResponseEntity<>(createdReservation, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reservation> updateReservation(@PathVariable Long id, @RequestBody Reservation reservation) {
        Reservation updatedReservation = reservationService.updateReservation(id, reservation);
        return new ResponseEntity<>(updatedReservation, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable Long id) {
        reservationService.deleteReservation(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
