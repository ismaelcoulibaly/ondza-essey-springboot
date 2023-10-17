package com.ondza.essey.repositories;

import com.ondza.essey.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    List<Reservation> findByEmail(String email);
    Optional<Reservation> findFirstByEmail(String email);

}
