import java.util.LinkedList;
import java.util.Queue;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/**
 * The Ride class represents an amusement park ride with queue management and ride history functionality.
 * This class implements the RideInterface and provides methods for managing visitors, operators, and ride operations.
 */
public class Ride implements RideInterface {
    // Private instance variables representing ride attributes
    private String rideName;       // Name of the amusement ride
    private int maxCapacity;       // Maximum number of visitors per ride cycle
    private Employee operator;     // Employee responsible for operating the ride
    
    // Data structures for managing visitors
    private Queue<Visitor> waitingQueue;  // FIFO queue for visitors waiting to ride
    private LinkedList<Visitor> rideHistory; // Historical record of visitors who have ridden

    /**
     * Default constructor that initializes a Ride with default values.
     * Sets up default ride name, capacity, a default operator, and initializes empty data structures.
     */
    public Ride() {
        this.rideName = "ridename";  // Default ride name
        this.maxCapacity = 2;  // Default capacity of 2 visitors per cycle
        this.operator = new Employee();  // Create a default operator
        this.waitingQueue = new LinkedList<>();  // Initialize empty waiting queue
        this.rideHistory = new LinkedList<>();   // Initialize empty ride history
    }

    /**
     * Parameterized constructor that initializes a Ride with specified values.
     * 
     * @param rideName The name of the ride
     * @param maxCapacity The maximum number of visitors per ride cycle
     * @param operator The employee responsible for operating the ride
     */
    public Ride(String rideName, int maxCapacity, Employee operator) {
        this.rideName = rideName;
        this.maxCapacity = maxCapacity;
        this.operator = operator;
        this.waitingQueue = new LinkedList<>();  // Initialize empty waiting queue
        this.rideHistory = new LinkedList<>();   // Initialize empty ride history
    }

    // Getters and setters (unchanged from original)
    public String getRideName() { return rideName; }
    public void setRideName(String rideName) { this.rideName = rideName; }
    public int getMaxCapacity() { return maxCapacity; }
    public void setMaxCapacity(int maxCapacity) { this.maxCapacity = maxCapacity; }
    public Employee getOperator() { return operator; }
    public void setOperator(Employee operator) { this.operator = operator; }
    public Queue<Visitor> getWaitingQueue() { return waitingQueue; }
    public LinkedList<Visitor> getRideHistory() { return rideHistory; }

    /**
     * Adds a visitor to the waiting queue for the ride.
     * 
     * @param visitor The visitor to add to the queue
     */
    @Override
    public void addVisitorToQueue(Visitor visitor) {
        if (visitor == null) {
            System.out.println("Error: Visitor object is null, cannot add to queue!");
            return;
        }
        // Add visitor to queue
        waitingQueue.offer(visitor);
        System.out.printf("Success: Visitor %s added to queue %s, current queue size: %d%n",
                visitor.getName(), this.rideName, waitingQueue.size());
    }
    
    @Override
    public void removeVisitorFromQueue(Visitor visitor) {
        // Validate queue status and visitor object
        if (waitingQueue.isEmpty()) {
            System.out.println("Error: Waiting queue is empty, cannot remove visitor!");
            return;
        }
        if (visitor == null) {
            System.out.println("Error: Visitor object is null, cannot remove!");
            return;
        }
    
        // Iterate through the queue to find the specified visitor
        boolean isRemoved = waitingQueue.removeIf(v -> 
                v.getVisitorCardNo().equals(visitor.getVisitorCardNo()));
        
        // Output result
        if (isRemoved) {
            System.out.printf("Success: Visitor %s has been removed from %s's waiting queue, current queue size: %d%n",
                    visitor.getName(), this.rideName, waitingQueue.size());
        } else {
            System.out.printf("Failed: Visitor %s not found in %s's waiting queue%n",
                    visitor.getName(), this.rideName);
        }
    }
    
    @Override
    public void printQueue() {
        if (waitingQueue.isEmpty()) {
            System.out.printf("Info: %s's waiting queue is empty, no visitors waiting%n", this.rideName);
            return;
        }
    
        // Print queue details
        System.out.printf("%s Waiting Queue Details (Total: %d people, Order: First Come First Served):%n",
                this.rideName, waitingQueue.size());
        int index = 1;
        for (Visitor visitor : waitingQueue) {
            System.out.printf("   %d. Name: %s | Age: %d | Card Number: %s | Entry Date: %s%n",
                    index++,
                    visitor.getName(),
                    visitor.getAge(),
                    visitor.getVisitorCardNo(),
                    visitor.getEntryDate());
        }
    }
    
    @Override
    public void addVisitorToHistory(Visitor visitor) {
        if (visitor == null) {
            System.out.println("Error: Visitor object is null, cannot add to history!");
            return;
        }
        // check if visitor is already in history
        if (checkVisitorFromHistory(visitor)) {
            System.out.printf("Error: Visitor %s is already in %s's ride history, cannot add again%n",
                    visitor.getName(), this.rideName);
            return;
        }
        // add in the last
        rideHistory.add(visitor);
        System.out.printf("Success: Visitor %s added to %s's ride history, current history size: %d%n",
                visitor.getName(), this.rideName, rideHistory.size());
    }

    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        if (rideHistory.isEmpty()) {
            return false; // history is empty, visitor not found
        }
        if (visitor == null) {
            System.out.println("Error: Visitor object is null, cannot check history!");
            return false;
        }
        // check visitor by card number
        for (Visitor v : rideHistory) {
            if (v.getVisitorCardNo().equals(visitor.getVisitorCardNo())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int numberOfVisitors() {
        int count = rideHistory.size();
        System.out.printf("Info: %s's ride history currently has %d visitors%n",
                this.rideName, count);
        return count;
    }

    @Override
    public void printRideHistory() {
        if (rideHistory.isEmpty()) {
            System.out.printf("Info: %s's ride history is empty, no riding records%n", this.rideName);
            return;
        }
        // print ride history
        System.out.printf("%s Ride History Details (Total: %d people, Order: Chronological):%n",
                this.rideName, rideHistory.size());
        Iterator<Visitor> iterator = rideHistory.iterator();
        int index = 1;
        while (iterator.hasNext()) {
            Visitor visitor = iterator.next();
            System.out.printf("   %d. Name: %s | Age: %d | Card Number: %s | Entry Date: %s%n",
                    index++,
                    visitor.getName(),
                    visitor.getAge(),
                    visitor.getVisitorCardNo(),
                    visitor.getEntryDate());
        }
    }

    @Override
    public void sortRideHistory() {
        if (rideHistory.isEmpty()) {
            System.out.printf("Error: %s's ride history is empty, cannot sort!\n", this.rideName);
            return;
        }
        // Sort by visitor name alphabetically as default sort order
        Collections.sort(rideHistory, (v1, v2) -> v1.getName().compareToIgnoreCase(v2.getName()));
        System.out.printf("Success: %s's ride history sorted by visitor name alphabetically%n", this.rideName);
    }

    public void sortRideHistory(Comparator<Visitor> comparator) {
        if (rideHistory.isEmpty()) {
            System.out.printf("Error: %s's ride history is empty, cannot sort!\n", this.rideName);
            return;
        }
        if (comparator == null) {
            System.out.println("Error: Comparator object is null, cannot sort!");
            return;
        }
        // sort ride history using Collections.sort()
        Collections.sort(rideHistory, comparator);
        System.out.printf("Success: %s's ride history sorted by specified rule\n", this.rideName);
    }

    @Override
    public void runOneCycle() {
        System.out.printf("\nRunning one cycle for %s (Max capacity: %d)...\n", rideName, maxCapacity);
        
        // Check if there are visitors in the queue
        if (waitingQueue.isEmpty()) {
            System.out.println("No visitors in queue. Ride cycle completed with no passengers.");
            return;
        }
        
        // Load visitors up to max capacity
        int loadedCount = 0;
        System.out.println("Loading visitors:");
        
        while (!waitingQueue.isEmpty() && loadedCount < maxCapacity) {
            Visitor visitor = waitingQueue.poll();
            rideHistory.add(visitor);
            loadedCount++;
            System.out.printf("  - Loaded visitor: %s (Card: %s)\n", visitor.getName(), visitor.getVisitorCardNo());
        }
        
        System.out.printf("\nRide in operation with %d visitors...\n", loadedCount);
        
        // Simulate ride completion
        System.out.printf("\nRide cycle completed. %d visitors have ridden and added to ride history.\n", loadedCount);
        System.out.printf("Current queue size: %d | Ride history size: %d\n", waitingQueue.size(), rideHistory.size());
    }
}