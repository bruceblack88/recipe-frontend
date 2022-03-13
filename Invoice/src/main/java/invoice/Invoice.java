/*
Invoice Exercise 2
Bruce Black
Liberty University
CSIS 505: Software Development
Dr. James Dollens
June 06, 2021
 */
package invoice;

//invoice class with 4 attributes partNumber, partDescription, quanity, price
public class Invoice {

    private int partNumber;

    private String partDescription;

    private int quantity;

    private double price;

// Create a constructor that allows you to initialize all 4 attributes from values passed in as parameters.
    public Invoice(int partNumber, String partDescription, int quantity, double price) {

        this.partNumber = partNumber;

        this.partDescription = partDescription;

        this.quantity = quantity;

        this.price = price;

    }

    public int getPartNumber() {

        return partNumber;

    }

    public void setPartNumber(int partNumber) {

        this.partNumber = partNumber;

    }

    public String getPartDescription() {

        return partDescription;

    }

    public void setPartDescription(String partDescription) {

        this.partDescription = partDescription;

    }

    public int getQuantity() {

        return quantity;

    }

    public void setQuantity(int quantity) {

        this.quantity = quantity;

    }

    public double getPrice() {

        return price;

    }

    public void setPrice(double price) {

        this.price = price;

    }
    //value and $200-$500
    private double value;

    private double twoToFiveHundred;

    public double getValue() {

        value = quantity * price;

        return value;

    }

    public void setValue(double value) {

        this.value = value;

    }

    public double getTwoToFiveHundred() {

        twoToFiveHundred = value;
        if (200 < value && value < 500) {
        } else {
            value = value;
        }

        return twoToFiveHundred;

    }

    public void setTwoToFiveHundred(double twoToFiveHundred) {

        this.twoToFiveHundred = twoToFiveHundred;

    }

    //Override the toString() method to display all 4 attributes in a format of your choosing.
    @Override

    public String toString() {

        return "Invoice{"
                + "partNumber=" + partNumber
                + ", partDescription='" + partDescription + '\''
                + ", quantity=" + quantity
                + ", price=" + price
                + '}';

    }

}
