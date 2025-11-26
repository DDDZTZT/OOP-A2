import java.util.Iterator;
import java.util.Queue;
import java.util.LinkedList;

public interface RideInterface {
     /**
     * addVisitorToQueue
     * @param visitor to add
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
    /**
     * removeVisitorFromQueue
     * @param visitor to remove
     */
    @Override
    public void removeVisitorFromQueue(Visitor visitor) {
        // 1. Validate queue status and visitor object
        if (waitingQueue.isEmpty()) {
            System.out.println("Error: Waiting queue is empty, cannot remove visitor!");
            return;
        }
        if (visitor == null) {
            System.out.println("Error: Visitor object is null, cannot remove!");
            return;
        }

        // 2. Iterate through the queue to find the specified visitor (based on visitor card number for unique identification, avoiding object reference issues)
        boolean isRemoved = waitingQueue.removeIf(v -> 
                v.getVisitorCardNo().equals(visitor.getVisitorCardNo()));
        
        // 3. Output result prompt
        if (isRemoved) {
            System.out.printf("Success: Visitor %s has been removed from %s's waiting queue, current queue size: %d%n",
                    visitor.getName(), this.rideName, waitingQueue.size());
        } else {
            System.out.printf("Failed: Visitor %s not found in %s's waiting queue%n",
                    this.rideName, visitor.getName());
        }
    }

    /**
     * Print detailed information of all visitors in the waiting queue (requirement: print in the order they were added)
     */
    @Override
    public void printQueue() {
        if (waitingQueue.isEmpty()) {
            System.out.printf("Info: %s's waiting queue is empty, no visitors waiting%n", this.rideName);
            return;
        }

        // Use iterator to traverse in FIFO order (Queue's iterator naturally supports sequential traversal)
        System.out.printf("%s Waiting Queue Details (Total: %d people, Order: First Come First Served):%n",
                this.rideName, waitingQueue.size());
        Iterator<Visitor> iterator = waitingQueue.iterator();
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
}