/*
 * Contains classes to store phonebook informations.
 */
package phonebook.model;

/**
 * Represents a phone contact (Portuguese format).
 *
 * @author Ivo Ferro
 */
public class Phone implements Comparable<Phone> {

    /**
     * The name of the contact.
     */
    private String name;
    /**
     * The phone number (Portuguese format, 9 digits).
     */
    private int number;

    /**
     * Instantiates a phone receiving the name and the number.
     * 
     * @param name name of the contact.
     * @param number phone number (Portuguese format, 9 digits).
     */
    public Phone(String name, int number) {
        setName(name);
        setNumber(number);
    }

    /**
     * Gets the name of the phone contact.
     * 
     * @return name of the phone contact
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the number of the phone contact.
     * 
     * @return number of the phone contact
     */
    public int getNumber() {
        return number;
    }

    /**
     * Sets the name of the phone contact.
     * 
     * @param name name of the phone contact
     */
    public final void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("The name of the phone contact is invalid!");
        }
        this.name = name;
    }

    /**
     * Sets the number of the phone contact.
     * 
     * @param number number of the phone contact
     */
    public final void setNumber(int number) {
        if (number < 100000000 || number > 999999999) {
            throw new IllegalArgumentException("The number of the phone contact is invalid!");
        }
        this.number = number;
    }

    /**
     * Returns a string representation of the phone contact.
     * 
     * @return a string representation of the phone contact.
     */
    @Override
    public String toString() {
        return String.format("Number:%d Name:%s", number, name);
    }

    /**
     * Indicates whether some other phone is "equal to" this one.
     * 
     * @param anotherObject the reference phone with which to compare.
     * @return true if this phone is the same as the other phone. False otherwise.
     */
    @Override
    public boolean equals(Object anotherObject) {
        if (this == anotherObject) {
            return true;
        }
        if (anotherObject == null || getClass() != anotherObject.getClass()) {
            return false;
        }
        Phone anotherPhone = (Phone) anotherObject;
        
        return number == anotherPhone.number;
    }

    /**
     * Compares this phone with the specified phone for order.  Returns a
     * negative integer, zero, or a positive integer as this phone is less
     * than, equal to, or greater than the specified phone.
     * 
     * @param anotherPhone the phone to be compared.
     * @return a negative integer, zero, or a positive integer as this phone
     *          is less than, equal to, or greater than the specified phone.
     */
    @Override
    public int compareTo(Phone anotherPhone) {
        return number - anotherPhone.number;
    }

}
