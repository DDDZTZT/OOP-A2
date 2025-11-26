/**
 * The Employee class extends the Person class to represent an employee with additional work-related information.
 * This class includes employee identification details and job responsibilities.
 */
public class Employee extends Person {
    // Private instance variables specific to an employee
    private String employeeId;      // Unique identification number for the employee
    private String responsibleRide; // Name of the ride that the employee is responsible for operating

    /**
     * Default constructor that initializes an Employee with default values.
     * Calls the parent class's default constructor and sets default values for employee-specific fields.
     */
    public Employee() {
        super();  // Call the default constructor of the superclass (Person)
        this.employeeId = "employeeid";     // Default employee ID
        this.responsibleRide = "responsibleride"; // Default value indicating no ride assigned
    }

    /**
     * Parameterized constructor that initializes an Employee with specified values.
     * 
     * @param name The employee's full name
     * @param age The employee's age in years
     * @param phone The employee's contact phone number
     * @param employeeId The unique identification number for the employee
     * @param responsibleRide The name of the ride that the employee is responsible for
     */
    public Employee(String name, int age, String phone, String employeeId, String responsibleRide) {
        super(name, age, phone);  // Call the parameterized constructor of the superclass (Person)
        this.employeeId = employeeId;
        this.responsibleRide = responsibleRide;
    }

    /**
     * Getter method for retrieving the employee's ID.
     * 
     * @return The employee's ID number
     */
    public String getEmployeeId() {
        return employeeId;
    }

    /**
     * Setter method for updating the employee's ID.
     * 
     * @param employeeId The new employee ID to set
     */
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * Getter method for retrieving the ride that the employee is responsible for.
     * 
     * @return The name of the ride assigned to the employee
     */
    public String getResponsibleRide() {
        return responsibleRide;
    }

    /**
     * Setter method for updating the ride that the employee is responsible for.
     * 
     * @param responsibleRide The name of the new ride to assign to the employee
     */
    public void setResponsibleRide(String responsibleRide) {
        this.responsibleRide = responsibleRide;
    }
}