/**
 * Confirms reservations and allocates unique room IDs using HashSet to prevent double-booking
 * @author developer
 * @version 4.0
 */
package com.seveneleven.bookmystay.service;

import com.seveneleven.bookmystay.model.Reservation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReservationService {
    private Set<String> bookedRoomIds;
    private HashMap<String, Set<String>> roomTypeAssignments;
    private InventoryService inventoryService;
    private BookingQueueService bookingQueueService;
    private List<Reservation> confirmedReservations;
    private int roomCounter;

    public ReservationService(InventoryService inventoryService, BookingQueueService bookingQueueService) {
        this.bookedRoomIds = new HashSet<>();
        this.roomTypeAssignments = new HashMap<>();
        this.inventoryService = inventoryService;
        this.bookingQueueService = bookingQueueService;
        this.confirmedReservations = new ArrayList<>();
        this.roomCounter = 100;
    }

    public Reservation confirmReservation() {
        if (!bookingQueueService.hasBookings()) {
            System.out.println("No pending bookings in the queue.");
            return null;
        }
        Reservation reservation = bookingQueueService.dequeueBooking();
        String roomType = reservation.getRoomType();
        if (inventoryService.getAvailableCount(roomType) <= 0) {
            reservation.setStatus("REJECTED");
            System.out.println("No rooms available for type: " + roomType);
            return reservation;
        }
        String roomId = allocateRoom(roomType);
        reservation.setRoomId(roomId);
        reservation.setStatus("CONFIRMED");
        inventoryService.decrementCount(roomType);
        confirmedReservations.add(reservation);
        System.out.println("Reservation confirmed: " + reservation.getReservationId() + " | Room: " + roomId);
        return reservation;
    }

    private String allocateRoom(String roomType) {
        roomCounter++;
        String roomId = roomType.substring(0, 1).toUpperCase() + "-" + roomCounter;
        bookedRoomIds.add(roomId);
        roomTypeAssignments.computeIfAbsent(roomType, k -> new HashSet<>()).add(roomId);
        return roomId;
    }

    public boolean isRoomBooked(String roomId) {
        return bookedRoomIds.contains(roomId);
    }

    public List<Reservation> getConfirmedReservations() {
        return confirmedReservations;
    }

    public void displayBookedRooms() {
        System.out.println("\n--- Booked Rooms ---");
        if (bookedRoomIds.isEmpty()) {
            System.out.println("No rooms booked yet.");
            return;
        }
        for (String roomId : bookedRoomIds) {
            System.out.println("Room ID: " + roomId);
        }
    }
}
