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

    @Column(name = "first_name", nullable = false, length = 100)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 100)
    private String lastName;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "message", nullable = false, length = 100)
    private String message;

    @Enumerated(EnumType.STRING)
    private ReservationType reservationType;

    @Column(name = "date_request", nullable = false, length = 100)
    private Date dateOfRequest;

    @Column(name = "date_event", nullable = false, length = 100)
    private Date dateOfEvent;

    @Column(name = "number_of_guests", nullable = false,updatable = false)
    private Integer numberOfGuests;


    public Reservation(Long id, String firstName, String lastName, String email, String message, ReservationType reservationType, Date dateOfRequest, Date dateOfEvent, Integer numberOfGuests) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.message = message;
        this.reservationType = reservationType;
        this.dateOfRequest = dateOfRequest;
        this.dateOfEvent = dateOfEvent;
        this.numberOfGuests = numberOfGuests;
    }

    public Reservation() {
    }
}
