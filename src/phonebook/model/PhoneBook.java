/*
 * Contains classes to store phonebook informations.
 */
package phonebook.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents a phone book (Portuguese format contacts).
 *
 * @author Ivo Ferro
 */
public class PhoneBook {
    
    /**
     * A list that contains phone contacts.
     */
    private List<Phone> phoneList;

    /**
     * Instantiates a phone book with default values.
     */
    public PhoneBook() {
        phoneList = new ArrayList<>();
    }
    
    /**
     * Instantiates a phone book with a copy of another phone book.
     * 
     * @param phoneBook another phone book
     */
    public PhoneBook(PhoneBook phoneBook){
        this.phoneList = new ArrayList<>(phoneBook.getPhoneList());
    }

    /**
     * Gets the phone list.
     * 
     * @return phone list
     */
    public List<Phone> getPhoneList() {
        return new ArrayList(phoneList);
    }

    /**
     * Sets the phone list with a phone book.
     * 
     * @param phoneBook phone book
     */
    public void setPhoneList(PhoneBook phoneBook) {
        this.phoneList.clear();
        addPhoneBook(phoneBook);
    }
    
    /**
     * Gets the phone contact of the specified index.
     * 
     * @param index index of the phone contact
     * @return the phone contact
     */
    public Phone getPhone(int index){
        return phoneList.get(index);
    }
    
    /**
     * Replaces the phone contact at the specified position with another phone contact.
     * 
     * @param index index of the pretended phone contact to be replaced.
     * @param phone the other phone number.
     * @return the element previously at the specified position. Null if the phone list already contains the phone contact
     */
    public Phone setPhone(int index, Phone phone) {
        return phoneList.contains(phone)
                ? null
                : phoneList.set(index, phone);
    }
    
    /**
     * Adds a phone to the phone list.
     * 
     * @param phone phone contact to be added
     * @return true if it is added with success. False otherwise.
     */
    public boolean addPhone(Phone phone) {
        return phoneList.contains(phone)
                ? false
                : phoneList.add(phone);
    }
    
    /**
     * Adds a phone book to the phone list.
     * 
     * @param phoneBook phone book to be added
     * @return the number of added phones.
     */
    public int addPhoneBook(PhoneBook phoneBook){
        int addedPhonesTotal = 0;
        for (Phone phone : phoneBook.getPhoneList()) {
            boolean isAdded = addPhone(phone);
            if(isAdded){
                addedPhonesTotal++;
            }
        }
        return addedPhonesTotal;
    }
    
    /**
     * Removes a phone contact.
     * 
     * @param phone phone to be removed
     * @return true if the phone list contained the specified element
     */
    public boolean removePhone(Phone phone){
        return phoneList.remove(phone);
    }
    
    /**
     * Removes a phone by its index.
     * 
     * @param index index of the phone
     * @return the phone previously at the specified position
     */
    public Phone removePhone(int index){
        return phoneList.remove(index);
    }
    
    /**
     * Remove all the phones presented on a specified phone book.
     * 
     * @param phoneBook phone book with the list of phones to be removed
     * @return true if any phone was removed.
     */
    public boolean removeAll(PhoneBook phoneBook){
        return this.phoneList.removeAll(phoneBook.getPhoneList());
    }
    
    /**
     * Gets the index of a pretended phone.
     * 
     * @param phone phone contact
     * @return the index of the first occurrence of the specified phone in
     *         this list, or -1 if this list does not contain the phone
     */
    public int getPhoneIndex(Phone phone){
        return phoneList.indexOf(phone);
    }
    
    /**
     * Cleans the phone list.
     */
    public void clear(){
        phoneList.clear();
    }
    
    /**
     * Returns the size of the phone list.
     * 
     * @return phone list size.
     */
    public int size(){
        return phoneList.size();
    }
    
    /**
     * Checks if the phone list is empty.
     * 
     * @return true if this phone list contains no phones.
     */
    public boolean isEmpty(){
        return phoneList.isEmpty();
    }
    
    /**
     * Converts the phone list into an array of phones.
     * 
     * @return the array of phone
     */
    public Phone[] getArray() {
        return phoneList.toArray( new Phone[phoneList.size()] );
    }

    /**
     * Returns a string representation of the phone book.
     * 
     * @return a string representation of the phone book.
     */
    @Override
    public String toString() {
        Collections.sort(phoneList);
        StringBuilder s = new StringBuilder();
        for (Phone phone : phoneList) {
            s.append(phone);
            s.append("\n");
        }
        return s.toString();
    }

    /**
     * Indicates whether some other phone book is "equal to" this one.
     * 
     * @param anotherObject the reference phone book with which to compare.
     * @return true if this phone book is the same as the other phone book. False otherwise.
     */
    @Override
    public boolean equals(Object anotherObject) {
        if (this == anotherObject) {
            return true;
        }
        if (anotherObject == null || getClass() != anotherObject.getClass()) {
            return false;
        }
        PhoneBook anotherPhoneBook = (PhoneBook) anotherObject;
        return phoneList.equals(anotherPhoneBook.getPhoneList());
    }
    
}
