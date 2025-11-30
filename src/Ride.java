import java.util.LinkedList;
import java.util.Queue;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * The Ride class represents an amusement park ride with queue management and ride history functionality.
 * This class implements the RideInterface and provides methods for managing visitors, operators, and ride operations.
 */
public class Ride implements RideInterface {
    // Private instance variables representing ride attributes
    private String rideName;       // Name of the amusement ride
    private int maxCapacity;       // Maximum number of visitors per ride cycle
    private Employee operator;     // Employee responsible for operating the ride
    private int maxRider;          // Maximum number of visitors allowed per cycle
    private int numOfCycles;       // Number of completed ride cycles
    
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
        this.maxRider = maxCapacity;  // Set maxRider to maxCapacity
        this.numOfCycles = 0;  // Initialize number of completed cycles to 0
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
        this.maxRider = maxCapacity;  // Set maxRider to maxCapacity
        this.numOfCycles = 0;  // Initialize number of completed cycles to 0
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

    public int getMaxRider() { 
        return maxRider; 
    }
    
    public void setMaxRider(int maxRider) { 
        // Ensure maxRider is at least 1
        this.maxRider = maxRider < 1 ? 1 : maxRider;
    }
    
    public int getNumOfCycles() { 
        return numOfCycles; 
    }
    @Override
    public void runOneCycle() {
        System.out.printf("\nRunning one cycle for %s (Max rider: %d)...\n", rideName, maxRider);
        
        // Check if there are visitors in the queue
        if (waitingQueue.isEmpty()) {
            System.out.println("No visitors in queue. Ride cycle completed with no passengers.");
            return;
        }

        // Check if operator is assigned
        if (operator == null) {
            System.out.println("Failed: No operator assigned to the ride, cannot run cycle!");
            return;
        }

        // Load visitors up to max capacity
        int loadedCount = 0;
        System.out.println("Loading visitors:");
        
       while (!waitingQueue.isEmpty() && loadedCount < maxRider) {
            Visitor visitor = waitingQueue.poll();
            rideHistory.add(visitor);
            loadedCount++;
            System.out.printf("  - Visitor %s (Card: %s) has boarded the ride\n", visitor.getName(), visitor.getVisitorCardNo());
        }
        
        // Increment cycle count
        numOfCycles++;
        
        System.out.printf("\nRide cycle #%d completed successfully!\n", numOfCycles);
        System.out.printf("  - %d visitors have ridden and added to ride history\n", loadedCount);
        System.out.printf("  - Remaining queue size: %d\n", waitingQueue.size());
        System.out.printf("  - Total ride history: %d visitors\n", rideHistory.size());
    }

    /**
     * Exports the ride history to a CSV file.
     * Each visitor record is stored on a separate line with fields separated by commas.
     * 
     * @param filePath The path of the file to export to ride_history.csv
     */
    public void exportRideHistory(String filePath) {
        // Validate input
        if (filePath == null || filePath.trim().isEmpty()) {
            System.out.println("Error: File path cannot be null or empty!");
            return;
        }
        
        // Check if ride history is empty
        if (rideHistory.isEmpty()) {
            System.out.println("Error: Ride history is empty, nothing to export!");
            return;
        }
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            // Export each visitor in the ride history
            for (Visitor visitor : rideHistory) {
                // Format: name,age,phone,visitorCardNo,entryDate
                String line = String.join(",", 
                    visitor.getName(),
                    String.valueOf(visitor.getAge()),
                    visitor.getPhone(),
                    visitor.getVisitorCardNo(),
                    visitor.getEntryDate()
                );
                writer.write(line);
                writer.newLine();
            }
            System.out.printf("Success: %d visitor records exported to %s\n", 
                    rideHistory.size(), filePath);
        } catch (IOException e) {
            System.out.printf("Error exporting ride history to %s: %s\n", 
                    filePath, e.getMessage());
        } catch (Exception e) {
            System.out.printf("Unexpected error during export: %s\n", e.getMessage());
        }
    }

    /**
     * Imports ride history from a CSV file.
     * Each line in the file is expected to contain a visitor record with fields separated by commas.
     * 
     * @param filePath The path of the file to import from ride_history.csv
     */
    public void importRideHistory(String filePath) {
        // Validate input
        if (filePath == null || filePath.trim().isEmpty()) {
            System.out.println("Error: File path cannot be null or empty!");
            return;
        }
        
        int importedCount = 0;
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Skip empty lines
                if (line.trim().isEmpty()) {
                    continue;
                }
                
                try {
                    // Split the line into fields
                    String[] fields = line.split(",");
                    
                    // Validate field count
                    if (fields.length < 5) {
                        System.out.printf("Warning: Invalid record format, skipping line: %s\n", line);
                        continue;
                    }
                    
                    // Create visitor object
                    String name = fields[0];
                    int age = Integer.parseInt(fields[1]);
                    String phone = fields[2];
                    String visitorCardNo = fields[3];
                    String entryDate = fields[4];
                    
                    Visitor visitor = new Visitor(name, age, phone, visitorCardNo, entryDate);
                    
                    // Add to history if not already present
                    if (!checkVisitorFromHistory(visitor)) {
                        rideHistory.add(visitor);
                        importedCount++;
                    } else {
                        System.out.printf("Warning: Visitor %s (Card: %s) already exists in history, skipping\n", 
                                name, visitorCardNo);
                    }
                } catch (NumberFormatException e) {
                    System.out.printf("Warning: Invalid age format in line: %s\n", line);
                } catch (Exception e) {
                    System.out.printf("Warning: Failed to process line: %s, error: %s\n", line, e.getMessage());
                }
            }
            
            System.out.printf("Success: Import completed. %d visitor records imported to %s\n", 
                    importedCount, this.rideName);
            
        } catch (IOException e) {
            System.out.printf("Error importing ride history from %s: %s\n", 
                    filePath, e.getMessage());
        } catch (Exception e) {
            System.out.printf("Unexpected error during import: %s\n", e.getMessage());
        }
    }
}