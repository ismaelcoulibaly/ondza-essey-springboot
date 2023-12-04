package com.ondza.essey.entities;

import com.ondza.essey.commons.ReservationType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.util.Date;


@Entity
@Table(name = "reservations", schema = "public")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "First name is mandatory")
    @Column(name = "first_name", nullable = false, length = 100)
    private String firstName;


    @NotBlank(message = "Last Name is mandatory")
    @Column(name = "last_name", nullable = false, length = 100)
    private String lastName;

    @NotBlank(message = "email is mandatory")
    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "message", nullable = false, length = 100)
    private String message;

    @Enumerated(EnumType.STRING)
    private ReservationType reservationType;


    @NotBlank(message = "Phone is mandatory")
    @Column(name = "phone", nullable = false, length = 20)
    private Integer phone;


    @Column(name = "date_request", nullable = false, length = 100)
    private Date dateOfRequest;

    @NotBlank(message = "date of event is mandatory")
    @Column(name = "date_event", nullable = false, length = 100)
    private Date dateOfEvent;

    @NotBlank(message = "Number of Guests is mandatory")
    @Column(name = "number_of_guests", nullable = false,updatable = false)
    private Integer numberOfGuests;


    public Reservation(String firstName, String lastName, String email, String message, ReservationType reservationType, Integer phone, Date dateOfRequest, Date dateOfEvent, Integer numberOfGuests) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.message = message;
        this.reservationType = reservationType;
        this.phone = phone;
        this.dateOfRequest = dateOfRequest;
        this.dateOfEvent = dateOfEvent;
        this.numberOfGuests = numberOfGuests;
    }

    public Reservation() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ReservationType getReservationType() {
        return reservationType;
    }

    public void setReservationType(ReservationType reservationType) {
        this.reservationType = reservationType;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public Date getDateOfRequest() {
        return dateOfRequest;
    }

    public void setDateOfRequest(Date dateOfRequest) {
        this.dateOfRequest = dateOfRequest;
    }

    public Date getDateOfEvent() {
        return dateOfEvent;
    }

    public void setDateOfEvent(Date dateOfEvent) {
        this.dateOfEvent = dateOfEvent;
    }

    public Integer getNumberOfGuests() {
        return numberOfGuests;
    }

    public void setNumberOfGuests(Integer numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }
}
