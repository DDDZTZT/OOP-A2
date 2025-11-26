public class AssignmentTwo {
    public static void main(String[] args) {
        partThree();
    }
     public static void partThree() {
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

    public void partFourA() {}
    public void partFourB() {}
    public void partFive() {}
    public void partSix() {}
    public void partSeven() {}
}