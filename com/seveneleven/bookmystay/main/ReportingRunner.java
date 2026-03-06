/**
 * Provides console interface for hotel administrators to view booking history and business reports
 * @author developer
 * @version 6.0
 */
package com.seveneleven.bookmystay.main;

import com.seveneleven.bookmystay.service.ReportingService;
import java.util.Scanner;

public class ReportingRunner {
    private ReportingService reportingService;
    private Scanner scanner;

    public ReportingRunner(ReportingService reportingService, Scanner scanner) {
        this.reportingService = reportingService;
        this.scanner = scanner;
    }

    public void run() {
        int choice;
        do {
            System.out.println("\n=== Booking History & Reports ===");
            System.out.println("1. View All Confirmed Reservations");
            System.out.println("2. Generate Business Report");
            System.out.println("3. Search Reservation by Guest Name");
            System.out.println("0. Back to Main Menu");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    reportingService.viewAllReservations();
                    break;
                case 2:
                    reportingService.generateReport();
                    break;
                case 3:
                    System.out.print("Enter Guest Name: ");
                    String name = scanner.nextLine();
                    reportingService.searchByGuest(name);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }
}
