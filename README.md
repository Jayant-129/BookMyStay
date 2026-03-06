# BookMyStay

Hotel Booking Management System built with core Java data structures.

## Use Cases

### UC1: Room Inventory Setup & Management
- Initialized room types (Single, Double, Suite) with counts and prices using HashMap
- Supports dynamic inventory updates (add, update count, update price)
- Provides real-time availability status with O(1) access

### UC2: Room Search & Availability Check
- Read-only search over room inventory using HashMap lookups
- Display available rooms with pricing information
- Validate room availability before booking

### UC3: Booking Request (First-Come-First-Served)
- Accepts booking requests into a FIFO Queue using LinkedList
- Adds 2-second processing delay using Thread.sleep before enqueueing
- Ensures fair booking order during peak demand

### UC4: Reservation Confirmation & Room Allocation
- Confirms reservations by dequeuing from booking queue
- Allocates unique room IDs using HashSet to prevent double-booking
- Tracks room type assignments using HashMap with Set values
