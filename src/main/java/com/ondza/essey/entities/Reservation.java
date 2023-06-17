package com.ondza.essey.entities;

import com.ondza.essey.commons.ReservationType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "reservations", schema = "public")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "first_name", nullable = false, length = 100)
    private String firstName;
    @Column(name = "message", nullable = false, length = 100)
    private String message;
    @Enumerated(EnumType.STRING)
    private ReservationType reservationType;
    @Column(name = "date_request", nullable = false, length = 100)
    private Date dateOfRequest;

    @Column(name = "number_of_guests", nullable = false,updatable = false)
    private Integer numberOfGuests;


    public Reservation(Long id, String email,String firstName, String message, ReservationType reservationType, Date dateOfRequest, Integer numberOfGuests) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.message = message;
        this.reservationType = reservationType;
        this.dateOfRequest = dateOfRequest;
        this.numberOfGuests = numberOfGuests;
    }

    public Reservation() {
    }
}
