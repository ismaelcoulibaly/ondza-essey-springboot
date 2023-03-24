package com.ondza.essey.controllers;


import com.ondza.essey.entities.Reservation;
import com.ondza.essey.entities.ResponseModel;
import com.ondza.essey.services.ReservationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/reservations")
@Api(value = "Backend oNDZA ESSEY")
public class ReservationController {

    private ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService){
        this.reservationService = reservationService;
    }

    @ApiOperation(value = "Get a greeting", response = String.class)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved greeting"),
            @ApiResponse(responseCode = "404", description = "The resource you were trying to reach is not found")
    })
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
