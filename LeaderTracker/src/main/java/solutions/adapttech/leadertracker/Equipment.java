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
public class Equipment {

    private int equipmentIdNumber;
    private String equipmentName;
    private int quantity;
    private char status;

    Equipment(int equipmentIdNumber, String equipmentName, int quantity, char status) {
        this.equipmentIdNumber = equipmentIdNumber;
        this.equipmentName = equipmentName;
        this.quantity = quantity;
        this.status = status;
    }

    public int getEquipmentIdNumber() {
        return equipmentIdNumber;
    }

    public void setEquipmentIdNumber(int newEquipmentIdNumber) {
        this.equipmentIdNumber = newEquipmentIdNumber;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String newEquipmentName) {
        this.equipmentName = newEquipmentName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int newQuantity) {
        this.quantity = newQuantity;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char newStatus) {
        this.status = newStatus;
    }
}
