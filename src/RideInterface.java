public interface RideInterface {
    /**
     * Add a visitor to the waiting queue
     * @param visitor The visitor to add
     */
    void addVisitorToQueue(Visitor visitor);
    
    /**
     * Remove a visitor from the waiting queue
     * @param visitor The visitor to remove
     */
    void removeVisitorFromQueue(Visitor visitor);

    /**
     * Print detailed information of all visitors in the waiting queue (requirement: print in the order they were added)
     */
    void printQueue();
    
    /**
     * Add a visitor to ride history
     * @param visitor The visitor to add to history
     */
    void addVisitorToHistory(Visitor visitor);
    
    /**
     * Check if a visitor exists in ride history
     * @param visitor The visitor to check
     * @return true if visitor exists, false otherwise
     */
    boolean checkVisitorFromHistory(Visitor visitor);
    
    /**
     * Get the number of visitors in ride history
     * @return The count of visitors
     */
    int numberOfVisitors();
    
    /**
     * Print ride history details
     */
    void printRideHistory();
    
    /**
     * Sort ride history
     */
    void sortRideHistory();
    
    /**
     * Run one cycle of the ride
     */
    void runOneCycle();
}