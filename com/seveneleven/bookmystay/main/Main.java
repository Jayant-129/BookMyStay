/**
 * Main entry point for BookMyStay application providing console-based menu for hotel management
 * @author developer
 * @version 1.0
 */
package com.seveneleven.bookmystay.main;

import com.seveneleven.bookmystay.service.InventoryService;
import com.seveneleven.bookmystay.service.SearchService;
import com.seveneleven.bookmystay.service.BookingQueueService;
import com.seveneleven.bookmystay.service.ReservationService;
import com.seveneleven.bookmystay.service.ServiceManagementService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InventoryService inventoryService = new InventoryService();
        SearchService searchService = new SearchService(inventoryService);
        BookingQueueService bookingQueueService = new BookingQueueService();
        ReservationService reservationService = new ReservationService(inventoryService, bookingQueueService);
        ServiceManagementService serviceManagementService = new ServiceManagementService();
        
        InventoryRunner inventoryRunner = new InventoryRunner(inventoryService, scanner);
        SearchRunner searchRunner = new SearchRunner(searchService, scanner);
        BookingQueueRunner bookingQueueRunner = new BookingQueueRunner(bookingQueueService, scanner);
        ReservationRunner reservationRunner = new ReservationRunner(reservationService, scanner);
        ServiceSelectionRunner serviceSelectionRunner = new ServiceSelectionRunner(serviceManagementService, scanner);

        int choice;
        do {
            System.out.println("\n========== BookMyStay - Hotel Management ==========");
            System.out.println("1. Room Inventory Management");
            System.out.println("2. Room Search & Availability");
            System.out.println("3. Booking Request");
            System.out.println("4. Reservation Confirmation");
            System.out.println("5. Add-On Services");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: inventoryRunner.run(); break;
                case 2: searchRunner.run(); break;
                case 3: bookingQueueRunner.run(); break;
                case 4: reservationRunner.run(); break;
                case 5: serviceSelectionRunner.run(); break;
                case 0: System.out.println("Thank you for using BookMyStay!"); break;
                default: System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 0);
        scanner.close();
    }
}
