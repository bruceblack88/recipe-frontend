package solutions.adapttech.classes.classesAndInstances;

public class BankAccount {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //name and balance properties
    private String name;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    private double balance;
}

