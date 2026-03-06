/**
 * Provides read-only search and availability checking over the hotel room inventory using HashMap lookups
 * @author developer
 * @version 2.0
 */
package com.seveneleven.bookmystay.service;

import java.util.HashMap;
import java.util.Map;

public class SearchService {
    private InventoryService inventoryService;

    public SearchService(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    public void displayAllRooms() {
        inventoryService.displayInventory();
    }

    public void searchByType(String type) {
        int count = inventoryService.getAvailableCount(type);
        double price = inventoryService.getPrice(type);
        if (count > 0) {
            System.out.println("\n--- Search Result ---");
            System.out.println("Room Type: " + type);
            System.out.println("Available: " + count);
            System.out.println("Price/Night: Rs." + price);
        } else {
            System.out.println("No rooms available for type: " + type);
        }
    }

    public boolean checkAvailability(String type) {
        return inventoryService.getAvailableCount(type) > 0;
    }

    public void displayAvailableRooms() {
        System.out.println("\n--- Available Rooms ---");
        HashMap<String, Integer> counts = inventoryService.getRoomCounts();
        HashMap<String, Double> prices = inventoryService.getRoomPrices();
        System.out.printf("%-15s %-10s %-15s%n", "Room Type", "Available", "Price/Night");
        System.out.println("-".repeat(40));
        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            if (entry.getValue() > 0) {
                System.out.printf("%-15s %-10d Rs.%-14.2f%n", entry.getKey(), entry.getValue(), prices.get(entry.getKey()));
            }
        }
    }
}
