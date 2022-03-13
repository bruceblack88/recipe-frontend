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
public class Availability {

    private String person;
    private String tasking;
    private String training;
    private char availability;

    Availability(String person, String tasking, String training, char availability) {
        this.person = person;
        this.tasking = tasking;
        this.training = training;
        this.availability = availability;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String newPerson) {
        this.person = newPerson;
    }

    public String getTasking() {
        return tasking;
    }

    public void setTasking(String newTasking) {
        this.tasking = newTasking;
    }

    public String getTraining() {
        return training;
    }

    public void setTraining(String newTraining) {
        this.training = newTraining;
    }

    public char getAvailability() {
        return availability;
    }

    public void setAvailablity(char newAvailablity) {
        this.availability = newAvailablity;
    }

}
