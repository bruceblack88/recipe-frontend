/*
Bruce Black
Software Development
CSIS 505
Leader Tracker
July 4, 2021
 */
package solutions.adapttech.leadertracker;

/**
 *
 * @author bruceblack
 */
public class Person {

    private int idNumber;
    private String lastName;
    private String firstName;
    private String rank;
    private int dateOfBirth;
    private int dateOfRank;
    private char availability;
    private String taskingName;
    private int phoneNumber;
    private String email;
    private String address;

    Person(int idNumber, String lastName, String firstName, String rank,
            int dateOfBirth, int dateOfRank, char availability,
            String taskingName, int phoneNumber, String email, String address) {
        this.idNumber = idNumber;
        this.lastName = lastName;
        this.firstName = firstName;
        this.rank = rank;
        this.dateOfBirth = dateOfBirth;
        this.dateOfRank = dateOfRank;
        this.availability = availability;
        this.taskingName = taskingName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;

    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int newIdNumber) {
        this.idNumber = newIdNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String newLastName) {
        this.lastName = newLastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String newFirstName) {
        this.firstName = newFirstName;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String newRank) {
        this.rank = newRank;
    }

    public int getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(int newDateOfBirth) {
        this.dateOfBirth = newDateOfBirth;
    }

    public int getDateOfRank() {
        return dateOfRank;
    }

    public void setDateOfRank(int newDateOfRank) {
        this.dateOfRank = newDateOfRank;
    }

    public char getAvailability() {
        return availability;
    }

    public void setAvailability(char newAvailability) {
        this.availability = newAvailability;
    }

    public String getTaskingName() {
        return taskingName;
    }

    public void setTaskingName(String newTaskingName) {
        this.taskingName = newTaskingName;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int newPhoneNumber) {
        this.phoneNumber = newPhoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String newEmail) {
        this.email = newEmail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String newAddress) {
        this.address = newAddress;
    }
}
