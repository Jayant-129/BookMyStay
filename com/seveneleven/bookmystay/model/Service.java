/**
 * Represents an optional add-on service with a name and price
 * @author developer
 * @version 5.0
 */
package com.seveneleven.bookmystay.model;

public class Service {
    private String serviceName;
    private double price;

    public Service(String serviceName, double price) {
        this.serviceName = serviceName;
        this.price = price;
    }

    public String getServiceName() { return serviceName; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return serviceName + " (Rs." + price + ")";
    }
}
