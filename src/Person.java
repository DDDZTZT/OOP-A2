/**
 * An abstract base class representing a general person with basic personal information.
 * This class provides common attributes and methods that can be inherited by more specific person types.
 */
public abstract class Person {
     // Private instance variables to store personal information
    private String name;    // name
    private int age;        // age
    private String phone;   // phone number

    /**
     * Default constructor that initializes a Person with default values.
     * Sets name to "name", age to 0, and phone to "phone".
     */
    public Person() {
        this.name = "name";// Default name value
        this.age = 0;      // Default age value
        this.phone = "phone";// Default phone value
    }

    public Person(String name, int age, String phone) {
        this.name = name;
        this.age = age;
        this.phone = phone;
    }

    /**
     * Getter method for retrieving the person's name.
     * 
     * @return The person's full name
     */
    public String getName() {
        return name;
    }

     /**
     * Setter method for updating the person's name.
     * 
     * @param name The new name to set
     */
    public void setName(String name) {
        this.name = name;
    }

     /**
     * Getter method for retrieving the person's age.
     * 
     * @return The person's age in years
     */
    public int getAge() {
        return age;
    }

     /**
     * Setter method for updating the person's age.
     * 
     * @param age The new age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Getter method for retrieving the person's phone number.
     * 
     * @return The person's contact phone number
     */
    public String getPhone() {
        return phone;
    }

     /**
     * Setter method for updating the person's phone number.
     * 
     * @param phone The new phone number to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }
}