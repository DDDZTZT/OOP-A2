/**
 * The Visitor class extends the Person class to represent a visitor with additional visitor-specific information.
 * This class includes visitor identification details such as visitor card number and entry date.
 */
public class Visitor extends Person {
    // Private instance variables specific to a visitor
    private String visitorCardNo;  // Unique identification card number of the visitor
    private String entryDate;      // Date when the visitor entered (format: YYYY-MM-DD)

    /**
     * Default constructor that initializes a Visitor with default values.
     * Calls the parent class's default constructor and sets default values for visitor-specific fields.
     */
    public Visitor() {
        super();  // Call the default constructor of the superclass (Person)
        this.visitorCardNo = "cardno";  // Default card number
        this.entryDate = "2025-01-01";  // Default entry date
    }

    /**
     * Parameterized constructor that initializes a Visitor with specified values.
     * 
     * @param name The visitor's full name
     * @param age The visitor's age in years
     * @param phone The visitor's contact phone number
     * @param visitorCardNo The unique identification card number of the visitor
     * @param entryDate The date when the visitor entered (format: YYYY-MM-DD)
     */
    public Visitor(String name, int age, String phone, String visitorCardNo, String entryDate) {
        super(name, age, phone);  // Call the parameterized constructor of the superclass (Person)
        this.visitorCardNo = visitorCardNo;
        this.entryDate = entryDate;
    }

    /**
     * Getter method for retrieving the visitor's card number.
     * 
     * @return The visitor's card number
     */
    public String getVisitorCardNo() {
        return visitorCardNo;
    }

    /**
     * Setter method for updating the visitor's card number.
     * 
     * @param visitorCardNo The new card number to set
     */
    public void setVisitorCardNo(String visitorCardNo) {
        this.visitorCardNo = visitorCardNo;
    }

    /**
     * Getter method for retrieving the visitor's entry date.
     * 
     * @return The visitor's entry date in YYYY-MM-DD format
     */
    public String getEntryDate() {
        return entryDate;
    }

    /**
     * Setter method for updating the visitor's entry date.
     * 
     * @param entryDate The new entry date to set (should follow YYYY-MM-DD format)
     */
    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }
}