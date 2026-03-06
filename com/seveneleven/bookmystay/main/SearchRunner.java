/**
 * Provides console interface for guests to search and check room availability without altering inventory
 * @author developer
 * @version 2.0
 */
package com.seveneleven.bookmystay.main;

import com.seveneleven.bookmystay.service.SearchService;
import java.util.Scanner;

public class SearchRunner {
    private SearchService searchService;
    private Scanner scanner;

    public SearchRunner(SearchService searchService, Scanner scanner) {
        this.searchService = searchService;
        this.scanner = scanner;
    }

    public void run() {
        int choice;
        do {
            System.out.println("\n=== Room Search & Availability ===");
            System.out.println("1. View All Rooms");
            System.out.println("2. Search by Room Type");
            System.out.println("3. Check Availability");
            System.out.println("0. Back to Main Menu");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    searchService.displayAllRooms();
                    break;
                case 2:
                    System.out.print("Enter room type (Single/Double/Suite): ");
                    String type = scanner.nextLine();
                    searchService.searchByType(type);
                    break;
                case 3:
                    System.out.print("Enter room type to check: ");
                    String checkType = scanner.nextLine();
                    boolean available = searchService.checkAvailability(checkType);
                    System.out.println(checkType + " rooms " + (available ? "are available." : "are not available."));
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }
}
