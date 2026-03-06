/**
 * Provides console interface for hotel admins to manage room inventory with add, update, and view operations
 * @author developer
 * @version 1.0
 */
package com.seveneleven.bookmystay.main;

import com.seveneleven.bookmystay.service.InventoryService;
import java.util.Scanner;

public class InventoryRunner {
    private InventoryService inventoryService;
    private Scanner scanner;

    public InventoryRunner(InventoryService inventoryService, Scanner scanner) {
        this.inventoryService = inventoryService;
        this.scanner = scanner;
    }

    public void run() {
        int choice;
        do {
            System.out.println("\n=== Room Inventory Management ===");
            System.out.println("1. View Inventory");
            System.out.println("2. Add Room Type");
            System.out.println("3. Update Room Count");
            System.out.println("4. Update Room Price");
            System.out.println("0. Back to Main Menu");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    inventoryService.displayInventory();
                    break;
                case 2:
                    System.out.print("Enter room type: ");
                    String type = scanner.nextLine();
                    System.out.print("Enter count: ");
                    int count = scanner.nextInt();
                    System.out.print("Enter price per night: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine();
                    inventoryService.addRoomType(type, count, price);
                    System.out.println("Room type added successfully.");
                    break;
                case 3:
                    System.out.print("Enter room type: ");
                    String uType = scanner.nextLine();
                    System.out.print("Enter new count: ");
                    int uCount = scanner.nextInt();
                    scanner.nextLine();
                    inventoryService.updateCount(uType, uCount);
                    System.out.println("Room count updated.");
                    break;
                case 4:
                    System.out.print("Enter room type: ");
                    String pType = scanner.nextLine();
                    System.out.print("Enter new price: ");
                    double uPrice = scanner.nextDouble();
                    scanner.nextLine();
                    inventoryService.updatePrice(pType, uPrice);
                    System.out.println("Room price updated.");
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }
}
