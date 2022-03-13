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
public class Tasking {

    private int taskingNumber;
    private String taskingName;
    private String location;
    private String taskingDueDate;
    private String assignedTo;

    Tasking(int taskingNumber, String taskingName, String location, String taskingDueDate, String assignedTo) {
        this.taskingNumber = taskingNumber;
        this.taskingName = taskingName;
        this.location = location;
        this.taskingDueDate = taskingDueDate;
        this.assignedTo = assignedTo;
    }

    public int getTaskingNumber() {
        return taskingNumber;
    }

    public void setTaskingNumber(int newTaskingNumber) {
        this.taskingNumber = newTaskingNumber;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String newLocation) {
        this.location = newLocation;
    }

    public String getTaskingDueDate() {
        return taskingDueDate;
    }

    public void setTaskingDueDate(String newTaskingDueDate) {
        this.taskingDueDate = newTaskingDueDate;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String newAssignedTo) {
        this.assignedTo = newAssignedTo;
    }
}
