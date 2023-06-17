package com.ondza.essey.services;

import com.ondza.essey.entities.Reservation;
import com.ondza.essey.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReservationService {


    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public Reservation createReservation(Reservation reservation) {
        // Perform any necessary validations or business logic before creating the reservation
        // For example, check if the desired date and location are available

        return reservationRepository.save(reservation);
    }

    public Reservation getReservationById(Long reservationId) {
        return reservationRepository.findById(reservationId)
                .orElseThrow(() -> new IllegalArgumentException("Reservation not found with ID: " + reservationId));
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Reservation updateReservation(Long id, Reservation reservation) {
        // Perform any necessary validations or business logic before updating the reservation
        // For example, check if the reservation can be modified based on its status

        reservationRepository.save(reservation);
        return reservation;
    }

    public void deleteReservation(Long reservationId) {
        Reservation reservation = getReservationById(reservationId);

        // Perform any necessary validations or business logic before deleting the reservation
        // For example, check if the reservation can be deleted based on its status

        reservationRepository.delete(reservation);
    }
}
