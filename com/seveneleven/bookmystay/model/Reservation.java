/**
 * Represents a hotel room reservation with guest details, room assignment, and booking status
 * @author developer
 * @version 3.0
 */
package com.seveneleven.bookmystay.model;

public class Reservation {
    private String reservationId;
    private String guestName;
    private String roomType;
    private String roomId;
    private String checkIn;
    private String checkOut;
    private String status;

    public Reservation(String reservationId, String guestName, String roomType, String checkIn, String checkOut) {
        this.reservationId = reservationId;
        this.guestName = guestName;
        this.roomType = roomType;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.status = "PENDING";
        this.roomId = null;
    }

    public String getReservationId() { return reservationId; }
    public String getGuestName() { return guestName; }
    public String getRoomType() { return roomType; }
    public String getRoomId() { return roomId; }
    public String getCheckIn() { return checkIn; }
    public String getCheckOut() { return checkOut; }
    public String getStatus() { return status; }
    public void setRoomId(String roomId) { this.roomId = roomId; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return "Reservation{reservationId='" + reservationId + "', guestName='" + guestName +
                "', roomType='" + roomType + "', roomId='" + roomId + "', checkIn='" + checkIn +
                "', checkOut='" + checkOut + "', status='" + status + "'}";
    }
}
