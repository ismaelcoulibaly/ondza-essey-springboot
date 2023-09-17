package com.ondza.essey.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ResponseModel {
    private String message;
    private boolean success;
    private Object data;

    private List<Reservation> reservationList;

    public ResponseModel(String message, boolean success, Object data) {
        this.message = message;
        this.success = success;
        this.data = data;
    }

    public ResponseModel() {

    }

    public ResponseModel(String message, boolean success, List<Reservation> reservationList) {
        this.message = message;
        this.success = success;
        this.reservationList = reservationList;
    }
}