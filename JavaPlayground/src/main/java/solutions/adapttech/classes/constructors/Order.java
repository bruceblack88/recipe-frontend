package solutions.adapttech.classes.constructors;

import java.time.LocalDateTime;

/*Given the class Order below, declare a constructor that sets the order number and name.
When an order is created, it should also save the creation date (hint: use LocalDateTime.now()).
* */
class Order {
    private String orderNumber;
    private String name;
    private LocalDateTime createdDate;

    public Order(String name, String orderNumber) {
        this.name = name;
        this.orderNumber = orderNumber;
        this.createdDate = createdDate.now();
    }

//your code goes here, do not change any existing code

    public String getOrderNumber() {
        return orderNumber;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }
}