/**
 * Provides console interface for processing booking queue and confirming room reservations
 * @author developer
 * @version 4.0
 */
package com.seveneleven.bookmystay.main;

import com.seveneleven.bookmystay.model.Reservation;
import com.seveneleven.bookmystay.service.ReservationService;
import java.util.Scanner;

public class ReservationRunner {
    private ReservationService reservationService;
    private Scanner scanner;

    public ReservationRunner(ReservationService reservationService, Scanner scanner) {
        this.reservationService = reservationService;
        this.scanner = scanner;
    }

    public void run() {
        int choice;
        do {
            System.out.println("\n=== Reservation Confirmation ===");
            System.out.println("1. Process Next Booking");
            System.out.println("2. View Booked Rooms");
            System.out.println("0. Back to Main Menu");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    Reservation confirmed = reservationService.confirmReservation();
                    if (confirmed != null) {
                        System.out.println("Status: " + confirmed.getStatus());
                    }
                    break;
                case 2:
                    reservationService.displayBookedRooms();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }
}
