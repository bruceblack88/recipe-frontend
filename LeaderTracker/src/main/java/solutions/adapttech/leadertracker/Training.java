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
public class Training {

    private int trainingIdNumber;
    private String trainingName;
    private String location;
    private String trainingDate;
    private String assignedTo;

    Training(int trainingIdNumber, String trainingName, String location, String trainingDate, String assignedTo) {
        this.trainingIdNumber = trainingIdNumber;
        this.trainingName = trainingName;
        this.location = location;
        this.assignedTo = assignedTo;
    }

    public int getTrainingIdNumber() {
        return trainingIdNumber;
    }

    public void setTrainingIdNumber(int newTrainingIdNumber) {
        this.trainingIdNumber = newTrainingIdNumber;
    }

    public String getTrainingName() {
        return trainingName;
    }

    public void setTrainingName(String newTrainingName) {
        this.trainingName = newTrainingName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String newLocation) {
        this.location = newLocation;
    }

    public String getTrainingDate() {
        return trainingDate;
    }

    public void setTrainingDate(String newTrainingDate) {
        this.trainingDate = newTrainingDate;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String newAssignedTo) {
        this.assignedTo = newAssignedTo;
    }

}
