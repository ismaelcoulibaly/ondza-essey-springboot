package com.ondza.essey.entities;



import java.util.List;

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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public List<Reservation> getReservationList() {
        return reservationList;
    }

    public void setReservationList(List<Reservation> reservationList) {
        this.reservationList = reservationList;
    }
}