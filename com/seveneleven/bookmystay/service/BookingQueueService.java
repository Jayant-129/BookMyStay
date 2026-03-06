/**
 * Handles booking requests using a FIFO queue with a 2-second processing delay for fair allocation
 * @author developer
 * @version 3.0
 */
package com.seveneleven.bookmystay.service;

import com.seveneleven.bookmystay.model.Reservation;
import java.util.LinkedList;
import java.util.Queue;

public class BookingQueueService {
    private Queue<Reservation> bookingQueue;

    public BookingQueueService() {
        bookingQueue = new LinkedList<>();
    }

    public void enqueueBooking(Reservation reservation) {
        try {
            System.out.println("Processing booking request...");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        bookingQueue.add(reservation);
        System.out.println("Booking request queued successfully: " + reservation.getReservationId());
    }

    public Reservation dequeueBooking() {
        return bookingQueue.poll();
    }

    public Reservation peekNext() {
        return bookingQueue.peek();
    }

    public int getQueueSize() {
        return bookingQueue.size();
    }

    public boolean hasBookings() {
        return !bookingQueue.isEmpty();
    }
}
