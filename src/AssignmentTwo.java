public class AssignmentTwo {
    public static void main(String[] args) {
        AssignmentTwo demo = new AssignmentTwo();
        demo.partThree();
        demo.partFourA();
        demo.partFourB();
        demo.partFive();
        demo.partSix();
        demo.partSeven();
    }
    public void partThree() {
        System.out.println("==================================== Part3 ====================================");
            
        //create employee
        Employee rideOperator = new Employee("Peter", 35, "13800138000", "EMP001", "RollerCoaster");

        // 2. create rollercoaster every cricle 2 people maxium
        Ride rollerCoaster = new Ride("RollerCoaster", 2, rideOperator);

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
        carousel.sortRideHistory(new VisitorComparator());
        carousel.sortRideHistory();

        // 5. sort the ride history
        System.out.println("\n Sort ride history:");
        carousel.sortRideHistory(new VisitorComparator());
        carousel.sortRideHistory();

        // 6. print the order after sorting
        System.out.println("\n Print ride history after sorting:");
        carousel.sortRideHistory(new VisitorComparator());
        carousel.sortRideHistory();

        System.out.println("==================================== Part4B ====================================");
    }
    public void partFive() {
        System.out.println("\n============================== Part5 ====================================");
        
        // 1. Create operator to ensure not null
        Employee rideOperator = new Employee("YYz", 38, "13500135000", "EMP003", "Thunder Coaster");

        // 2. Create ride facility
        Ride thunderCoaster = new Ride(
                "Thunder Coaster", 4, rideOperator  // maxRider=4
        );

        // 3. Add at least 10 visitors to the waiting queue
        System.out.println("[Step 1: Add 10 visitors to waiting queue]");
        for (int i = 1; i <= 10; i++) {
            Visitor visitor = new Visitor(
                    "Visitor" + i, 
                    15 + i,  // Age 16-25
                    "1300013000" + i, 
                    "VIS" + String.format("%03d", i),  // Card number VIS001-VIS010
                    "2025-12-01"
            );
            thunderCoaster.addVisitorToQueue(visitor);
        }

        // 4. Print waiting queue before operation
        System.out.println("\n Waiting queue before operation (10 people total)");
        thunderCoaster.printQueue();

        // 5. Run one ride cycle
        System.out.println("\n Run one ride cycle");
        thunderCoaster.runOneCycle();

        // 6. Print waiting queue after operation
        System.out.println("\n Waiting queue after operation (6 people remaining)");
        thunderCoaster.printQueue();

        // 7. Print ride history after operation
        System.out.println("\n Ride history after operation (4 new people added)");
        thunderCoaster.printRideHistory();

        // 8. Check total number of operations
        System.out.printf("\n[%s] Total number of operations: %d times\n",
                thunderCoaster.getRideName(), thunderCoaster.getNumOfCycles());

        System.out.println("=========================== Part5 ====================================");
    }
    public void partSix() {
        System.out.println("\n============================== Part6 ====================================");
    
        // 1. Create a new Ride object
        Employee operator = new Employee("Export Operator", 35, "13800138111", "EMP006", "Export Ride");
        Ride exportRide = new Ride("ExportRide", 5, operator);
        
        // 2. Add at least 5 visitors to the ride history
        System.out.println("\nAdding 5 visitors to ride history...");
        
        Visitor v1 = new Visitor("ExportVisitor1", 25, "13900139111", "EXP001", "2025-12-01");
        Visitor v2 = new Visitor("ExportVisitor2", 30, "13900139112", "EXP002", "2025-12-01");
        Visitor v3 = new Visitor("ExportVisitor3", 22, "13900139113", "EXP003", "2025-12-02");
        Visitor v4 = new Visitor("ExportVisitor4", 28, "13900139114", "EXP004", "2025-12-02");
        Visitor v5 = new Visitor("ExportVisitor5", 35, "13900139115", "EXP005", "2025-12-03");
        
        exportRide.addVisitorToHistory(v1);
        exportRide.addVisitorToHistory(v2);
        exportRide.addVisitorToHistory(v3);
        exportRide.addVisitorToHistory(v4);
        exportRide.addVisitorToHistory(v5);
        
        // 3. Print ride history before export
        System.out.println("\nRide history before export:");
        exportRide.printRideHistory();
        
        // 4. Export ride history to file
        String filePath = "ride_history.csv";
        System.out.println("\nExporting ride history to file: " + filePath);
        exportRide.exportRideHistory(filePath);
        
        System.out.println("\n============================== Part6 ====================================");
    }
    public void partSeven() {
        System.out.println("\n============================== Part7 ====================================");
    
        // 1. Create a new Ride object
        Employee operator = new Employee("Import Operator", 38, "13800138222", "EMP007", "Import Ride");
        Ride importRide = new Ride("ImportRide", 5, operator);
        
        // 2. Verify ride history is empty before import
        System.out.println("\nRide history before import:");
        importRide.printRideHistory();
        
        // 3. Import ride history from file
        String filePath = "ride_history.csv";
        System.out.println("\nImporting ride history from file: " + filePath);
        importRide.importRideHistory(filePath);
        
        // 4. Print the total number of visitors to confirm import count
        System.out.println("\nVerifying import results:");
        System.out.printf("Total visitors imported: %d\n", importRide.numberOfVisitors());
        
        // 5. Print all visitor details to confirm import accuracy
        System.out.println("\nDetailed visitor information after import:");
        importRide.printRideHistory();
        
        System.out.println("\n============================== Part7 ====================================");
    }
}