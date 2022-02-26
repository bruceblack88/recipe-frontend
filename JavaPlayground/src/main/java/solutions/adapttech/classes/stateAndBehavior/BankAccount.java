package solutions.adapttech.classes.stateAndBehavior;

/*The class should have the following methods and corresponding behavior:

deposit(long cents): Adds cents to the bank account
withdraw(long cents): Removes cents from the bank account
balance(): Returns the current balance on the bank account
isOverDrawn(): Returns true if the balance on the account is negative
* */

public class BankAccount {


    private long balance = 10;
    private boolean isOverDrawn = false;

    void deposit(long cents) {
        balance += cents;
    }

    void withdraw(long cents) {
        balance -= cents;
    }

    private long balance() {
        return balance;
    }

    private boolean isOverDrawn() {
        if (balance < 0) {
            isOverDrawn = true;
        }
        return isOverDrawn;
    }
}


