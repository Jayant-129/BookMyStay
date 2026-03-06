/**
 * Manages add-on services for reservations using a one-to-many Map relationship
 * @author developer
 * @version 5.0
 */
package com.seveneleven.bookmystay.service;

import com.seveneleven.bookmystay.model.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServiceManagementService {
    private Map<String, List<Service>> reservationServices;
    private List<Service> availableServices;

    public ServiceManagementService() {
        reservationServices = new HashMap<>();
        availableServices = new ArrayList<>();
        initializeAvailableServices();
    }

    private void initializeAvailableServices() {
        availableServices.add(new Service("Breakfast", 500.0));
        availableServices.add(new Service("Spa Access", 1500.0));
        availableServices.add(new Service("Airport Pickup", 1200.0));
        availableServices.add(new Service("Late Checkout", 800.0));
    }

    public void addServiceToReservation(String reservationId, Service service) {
        reservationServices.computeIfAbsent(reservationId, k -> new ArrayList<>()).add(service);
        System.out.println("Service added: " + service.getServiceName() + " to Reservation: " + reservationId);
    }

    public List<Service> getAvailableServices() {
        return availableServices;
    }

    public List<Service> getServicesForReservation(String reservationId) {
        return reservationServices.getOrDefault(reservationId, new ArrayList<>());
    }

    public double calculateAdditionalCost(String reservationId) {
        List<Service> services = getServicesForReservation(reservationId);
        double total = 0.0;
        for (Service s : services) {
            total += s.getPrice();
        }
        return total;
    }

    public void displayAvailableServices() {
        System.out.println("\n--- Available Add-On Services ---");
        for (int i = 0; i < availableServices.size(); i++) {
            System.out.println((i + 1) + ". " + availableServices.get(i));
        }
    }
}
