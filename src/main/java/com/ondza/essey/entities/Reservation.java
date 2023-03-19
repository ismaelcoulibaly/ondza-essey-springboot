package com.ondza.essey.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "reservation", schema = "public")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name="id", sequenceName = "id_seq_otp", allocationSize = 1, initialValue = 1)
    @Column(name = "otp", updatable = false, nullable = false)
    private Integer id;

    @Column(name = "email", nullable = false, length = 100)
    private String email;
    @Column(name = "last_name", nullable = false, length = 100)
    private String lastName;

    @Column(name = "first_name", nullable = false, length = 100)
    private String firstName;
    @Column(name = "message", nullable = false, length = 100)
    private String message;
    @Column(name = "type_of_reservation", nullable = false, length = 100)
    private String typeOfReservation;
    @Column(name = "date_request", nullable = false, length = 100)
    private Date dateOfRequest;
    @Column(name = "number_of_people", nullable = false,updatable = false)

    private Integer numberOfPeople;


    public Reservation(Integer id,
                       String email,
                       String lastName,
                       String firstName,
                       String message,
                       String typeOfReservation,
                       Date dateOfRequest,
                       Integer numberOfPeople) {
        this.id = id;
        this.email = email;
        this.lastName = lastName;
        this.firstName = firstName;
        this.message = message;
        this.typeOfReservation = typeOfReservation;
        this.dateOfRequest = dateOfRequest;
        this.numberOfPeople = numberOfPeople;
    }

    public Reservation() {

    }

    public Reservation(String email, String fName, String lName, String typeOfReservation, String message) {
        this.email = email;
        this.firstName = fName;
        this.lastName = lName;
        this.typeOfReservation = typeOfReservation;
        this.message = message;
    }
}
