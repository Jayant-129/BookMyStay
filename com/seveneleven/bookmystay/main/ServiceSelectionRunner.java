/**
 * Provides console interface for guests to browse and attach add-on services to their reservation
 * @author developer
 * @version 5.0
 */
package com.seveneleven.bookmystay.main;

import com.seveneleven.bookmystay.model.Service;
import com.seveneleven.bookmystay.service.ServiceManagementService;
import java.util.List;
import java.util.Scanner;

public class ServiceSelectionRunner {
    private ServiceManagementService serviceManagementService;
    private Scanner scanner;

    public ServiceSelectionRunner(ServiceManagementService serviceManagementService, Scanner scanner) {
        this.serviceManagementService = serviceManagementService;
        this.scanner = scanner;
    }

    public void run() {
        int choice;
        do {
            System.out.println("\n=== Add-On Services ===");
            System.out.println("1. View Available Services");
            System.out.println("2. Add Service to Reservation");
            System.out.println("3. View Services by Reservation");
            System.out.println("0. Back to Main Menu");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    serviceManagementService.displayAvailableServices();
                    break;
                case 2:
                    System.out.print("Enter Reservation ID: ");
                    String resId = scanner.nextLine();
                    serviceManagementService.displayAvailableServices();
                    System.out.print("Select service index (1-" + serviceManagementService.getAvailableServices().size() + "): ");
                    int serviceIdx = scanner.nextInt() - 1;
                    scanner.nextLine();
                    List<Service> available = serviceManagementService.getAvailableServices();
                    if (serviceIdx >= 0 && serviceIdx < available.size()) {
                        serviceManagementService.addServiceToReservation(resId, available.get(serviceIdx));
                    } else {
                        System.out.println("Invalid service selection.");
                    }
                    break;
                case 3:
                    System.out.print("Enter Reservation ID: ");
                    String viewResId = scanner.nextLine();
                    List<Service> services = serviceManagementService.getServicesForReservation(viewResId);
                    if (services.isEmpty()) {
                        System.out.println("No services attached to this reservation.");
                    } else {
                        System.out.println("\nServices for " + viewResId + ":");
                        for (Service s : services) {
                            System.out.println("- " + s);
                        }
                        System.out.println("Total Add-On Cost: Rs." + serviceManagementService.calculateAdditionalCost(viewResId));
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
