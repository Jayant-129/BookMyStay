/**
 * Manages hotel room inventory including room types, counts, and pricing using HashMaps for O(1) access
 * @author developer
 * @version 1.0
 */
package com.seveneleven.bookmystay.service;

import java.util.HashMap;

public class InventoryService {
    private HashMap<String, Integer> roomCounts;
    private HashMap<String, Double> roomPrices;

    public InventoryService() {
        roomCounts = new HashMap<>();
        roomPrices = new HashMap<>();
        initializeDefaults();
    }

    private void initializeDefaults() {
        roomCounts.put("Single", 10);
        roomCounts.put("Double", 8);
        roomCounts.put("Suite", 5);
        roomPrices.put("Single", 2000.0);
        roomPrices.put("Double", 3500.0);
        roomPrices.put("Suite", 6000.0);
    }

    public void addRoomType(String type, int count, double price) {
        roomCounts.put(type, count);
        roomPrices.put(type, price);
    }

    public void updateCount(String type, int count) {
        if (roomCounts.containsKey(type)) {
            roomCounts.put(type, count);
        }
    }

    public void updatePrice(String type, double price) {
        if (roomPrices.containsKey(type)) {
            roomPrices.put(type, price);
        }
    }

    public int getAvailableCount(String type) {
        return roomCounts.getOrDefault(type, 0);
    }

    public double getPrice(String type) {
        return roomPrices.getOrDefault(type, 0.0);
    }

    public HashMap<String, Integer> getRoomCounts() {
        return roomCounts;
    }

    public HashMap<String, Double> getRoomPrices() {
        return roomPrices;
    }

    public void decrementCount(String type) {
        if (roomCounts.containsKey(type) && roomCounts.get(type) > 0) {
            roomCounts.put(type, roomCounts.get(type) - 1);
        }
    }

    public void displayInventory() {
        System.out.println("\n--- Room Inventory ---");
        System.out.printf("%-15s %-10s %-15s%n", "Room Type", "Available", "Price/Night");
        System.out.println("-".repeat(40));
        for (String type : roomCounts.keySet()) {
            System.out.printf("%-15s %-10d Rs.%-14.2f%n", type, roomCounts.get(type), roomPrices.get(type));
        }
    }
}
