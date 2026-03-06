/**
 * Tracks and generates reports on booking history using a sequential List store
 * @author developer
 * @version 6.0
 */
package com.seveneleven.bookmystay.service;

import com.seveneleven.bookmystay.model.Reservation;
import java.util.List;

public class ReportingService {
    private ReservationService reservationService;

    public ReportingService(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    public void viewAllReservations() {
        List<Reservation> history = reservationService.getConfirmedReservations();
        System.out.println("\n--- Reservation History ---");
        if (history.isEmpty()) {
            System.out.println("No confirmed reservations found.");
            return;
        }
        for (Reservation res : history) {
            System.out.println("ID: " + res.getReservationId() + " | Guest: " + res.getGuestName() +
                    " | Room: " + res.getRoomId() + " (" + res.getRoomType() + ")" +
                    " | In: " + res.getCheckIn() + " | Out: " + res.getCheckOut());
        }
    }

    public void generateReport() {
        List<Reservation> history = reservationService.getConfirmedReservations();
        System.out.println("\n--- Hotel Booking Report ---");
        System.out.println("Total Confirmed Bookings: " + history.size());
        
        int singleCount = 0, doubleCount = 0, suiteCount = 0;
        for (Reservation res : history) {
            if ("Single".equalsIgnoreCase(res.getRoomType())) singleCount++;
            else if ("Double".equalsIgnoreCase(res.getRoomType())) doubleCount++;
            else if ("Suite".equalsIgnoreCase(res.getRoomType())) suiteCount++;
        }
        System.out.println("Single Rooms Booked: " + singleCount);
        System.out.println("Double Rooms Booked: " + doubleCount);
        System.out.println("Suites Booked: " + suiteCount);
        System.out.println("----------------------------");
    }

    public void searchByGuest(String guestName) {
        List<Reservation> history = reservationService.getConfirmedReservations();
        System.out.println("\n--- Search Results for Guest: " + guestName + " ---");
        boolean found = false;
        for (Reservation res : history) {
            if (res.getGuestName().equalsIgnoreCase(guestName)) {
                System.out.println(res);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No reservations found for guest: " + guestName);
        }
    }
}
