/**
 * Provides console interface for submitting booking requests into the FIFO queue with 2-second delay
 * @author developer
 * @version 3.0
 */
package com.seveneleven.bookmystay.main;

import com.seveneleven.bookmystay.model.Reservation;
import com.seveneleven.bookmystay.service.BookingQueueService;
import java.util.Scanner;

public class BookingQueueRunner {
    private BookingQueueService bookingQueueService;
    private Scanner scanner;
    private int reservationCounter;

    public BookingQueueRunner(BookingQueueService bookingQueueService, Scanner scanner) {
        this.bookingQueueService = bookingQueueService;
        this.scanner = scanner;
        this.reservationCounter = 0;
    }

    public void run() {
        int choice;
        do {
            System.out.println("\n=== Booking Request (Queue) ===");
            System.out.println("1. Submit Booking Request");
            System.out.println("2. View Queue Size");
            System.out.println("3. View Next in Queue");
            System.out.println("0. Back to Main Menu");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter guest name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter room type (Single/Double/Suite): ");
                    String type = scanner.nextLine();
                    System.out.print("Enter check-in date (YYYY-MM-DD): ");
                    String checkIn = scanner.nextLine();
                    System.out.print("Enter check-out date (YYYY-MM-DD): ");
                    String checkOut = scanner.nextLine();
                    reservationCounter++;
                    String resId = "RES-" + reservationCounter;
                    Reservation reservation = new Reservation(resId, name, type, checkIn, checkOut);
                    bookingQueueService.enqueueBooking(reservation);
                    break;
                case 2:
                    System.out.println("Bookings in queue: " + bookingQueueService.getQueueSize());
                    break;
                case 3:
                    Reservation next = bookingQueueService.peekNext();
                    if (next != null) {
                        System.out.println("Next in queue: " + next);
                    } else {
                        System.out.println("Queue is empty.");
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }
}
