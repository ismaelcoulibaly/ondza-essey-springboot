package com.ondza.essey.controllers;


import com.ondza.essey.entities.Reservation;
import com.ondza.essey.entities.ResponseModel;
import com.ondza.essey.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/reservations")
public class ReservationController {

    private ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService){
        this.reservationService = reservationService;
    }
    @PostMapping("/new")
    public ResponseEntity<ResponseModel> createReservation(@RequestBody Reservation reservation) {

        Reservation newReservation = reservationService.createReservation(reservation);
        ResponseModel responseModel = new ResponseModel("Reservation created successfully ", true, newReservation);
        return ResponseEntity.ok(responseModel);

    }
//    @GetMapping("/email")
//    public ResponseEntity<List<Reservation>> getReservationByEmail(@RequestParam String email) {
//
//        List<Reservation> reservations = reservationService.findReservation(email);
//        ResponseModel responseModel = new ResponseModel("Reservation created successfully ", true, reservations);
//        return ResponseEntity.ok(responseModel.getReservationList());
//
//    }
}
