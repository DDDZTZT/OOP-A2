public class AssignmentTwo {
    public static void main(String[] args) {
        AssignmentTwo demo = new AssignmentTwo();
        demo.partThree();
        demo.partFourA();
        demo.partFourB();
    }
     public void partThree() {
        System.out.println("==================================== Part3 ====================================");
        
        //create employee
        Employee rideOperator = new Employee(
                "Peter", 35, "13800138000", 
                "EMP001", "RollerCoaster"
        );

        // 2. create rollercoaster every cricle 2 people maxium
        Ride rollerCoaster = new Ride(
                "RollerCoaster", 2, rideOperator
        );

        // 3. create 5 visitors
        Visitor v1 = new Visitor("Jack", 22, "13900139001", "VIS001", "2025-12-01");
        Visitor v2 = new Visitor("Sharon", 18, "13900139002", "VIS002", "2025-12-01");
        Visitor v3 = new Visitor("Benny", 25, "13900139003", "VIS003", "2025-12-01");
        Visitor v4 = new Visitor("Leo", 30, "13900139004", "VIS004", "2025-12-01");
        Visitor v5 = new Visitor("Nehemia", 28, "13900139005", "VIS005", "2025-12-01");

        // 4. add 5 visitors to queue
        System.out.println("\n Add 5 visitors to queue:");
        rollerCoaster.addVisitorToQueue(v1);
        rollerCoaster.addVisitorToQueue(v2);
        rollerCoaster.addVisitorToQueue(v3);
        rollerCoaster.addVisitorToQueue(v4);
        rollerCoaster.addVisitorToQueue(v5);

        // 5. print the result
        System.out.println("\n Print the queue:");
        rollerCoaster.printQueue();

        // 6. remove a visitor from queue
        System.out.println("\n Remove a visitor from queue:");
        rollerCoaster.removeVisitorFromQueue(v2);

        // 7. print the result again
        System.out.println("\n Print the queue:");
        rollerCoaster.printQueue();

        System.out.println("==================================== Part3 ====================================");
    }

     public void partFourA() {
        System.out.println("\n==================================== Part4A ====================================");
        
        // 1. create carousel ride
        Employee operator = new Employee("Lee", 40, "13700137000", "EMP002", "Carousel");
        Ride carousel = new Ride("Carousel", 4, operator);

        // 2. create 5 visitors
        Visitor v1 = new Visitor("Tom", 10, "13600136001", "VIS006", "2025-12-01");
        Visitor v2 = new Visitor("Sherly", 8, "13600136002", "VIS007", "2025-12-01");
        Visitor v3 = new Visitor("Ben", 12, "13600136003", "VIS008", "2025-12-02");
        Visitor v4 = new Visitor("David", 9, "13600136004", "VIS009", "2025-12-02");
        Visitor v5 = new Visitor("Jack", 11, "13600136005", "VIS010", "2025-12-01");

        // 3. add 5 visitors to ride history
        System.out.println("\n Add 5 visitors to ride history:");
        carousel.addVisitorToHistory(v1);
        carousel.addVisitorToHistory(v2);
        carousel.addVisitorToHistory(v3);
        carousel.addVisitorToHistory(v4);
        carousel.addVisitorToHistory(v5);

        // 4. check if visitor v3 exists in ride history
        System.out.println("\n Check if visitor v3 exists in ride history:");
        boolean isExists = carousel.checkVisitorFromHistory(v3);
        System.out.printf("Visitor %s exists in ride history: %b%n", v3.getName(), isExists);

        // 5. count the visiters number
        System.out.println("\n Count the visiters number:");
        carousel.numberOfVisitors();

        // 6. print ride history
        System.out.println("\n Print ride history: ");
        carousel.printRideHistory();

        System.out.println("==================================== Part4A ====================================");
    }

    public void partFourB() {
        System.out.println("\n==================================== Part4B ====================================");
        // 1. create carousel ride
        Employee operator = new Employee("Lee", 40, "13700137000", "EMP002", "Carousel");
        Ride carousel = new Ride("Carousel", 4, operator);

        // 2. create 5 visitors
        Visitor v1 = new Visitor("Tom", 10, "13600136001", "VIS006", "2025-12-01");
        Visitor v2 = new Visitor("Sherly", 8, "13600136002", "VIS007", "2025-12-01");
        Visitor v3 = new Visitor("Ben", 12, "13600136003", "VIS008", "2025-12-02");
        Visitor v4 = new Visitor("David", 9, "13600136004", "VIS009", "2025-12-02");
        Visitor v5 = new Visitor("Jack", 11, "13600136005", "VIS010", "2025-12-01");
    
        // 3. add 5 visitors to ride history
        System.out.println("\n Add 5 visitors to ride history:");
        carousel.addVisitorToHistory(v1);
        carousel.addVisitorToHistory(v2);
        carousel.addVisitorToHistory(v3);
        carousel.addVisitorToHistory(v4);
        carousel.addVisitorToHistory(v5);

        // 4. print the order after sorting
        System.out.println("\n Print ride history after sorting:");
        carousel.printRideHistory();

        // 5. sort the ride history
        System.out.println("\n Sort ride history:");
        carousel.sortRideHistory();

        // 6. print the order after sorting
        System.out.println("\n Print ride history after sorting:");
        carousel.printRideHistory();

        System.out.println("==================================== Part4B ====================================");
    }
    
    public void partFive() {}
    public void partSix() {}
    public void partSeven() {}
}