package com.ondza.essey.services;

import com.ondza.essey.entities.Reservation;
import com.ondza.essey.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    private ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(ReservationRepository repository){
        this.reservationRepository = repository;
    }

    public Reservation createReservation(Reservation reservation){
        return reservationRepository.save(reservation);
    }


    public List<Reservation> findReservation(String email) {
        return reservationRepository.findByEmail(email);
    }
}
