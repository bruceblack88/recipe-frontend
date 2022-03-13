/*
Invoice Exercise 2
Bruce Black
Liberty University
CSIS 505: Software Development
Dr. James Dollens
June 06, 2021
 */
package invoice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;
import java.util.Map;
import java.util.TreeMap;

public class InvoiceMain {

    public static void main(String[] args) {
        //Use lambdas and streams to perform the following queries on the list of Invoice objects and display the results:
        List<String> list = Arrays.asList("Clothes", "Items");

        list.stream().map(word -> word.split(""));

        ArrayList<Invoice> invoices = generateData();

        Stream<Invoice> invoiceStream = invoices.stream();

        //System.out.println("Invoices sorted by Part Description alphabetically");
        //invoiceStream.sorted(Comparator.comparing(Invoice::getPartDescription)).forEach(System.out::println);
        //System.out.println("Invoices sorted by Price low to high.");
        //invoiceStream.sorted(Comparator.comparing(Invoice::getPrice)).forEach(System.out::println);
        //System.out.println("Invoices sorted by Quantity low to high.");
        //invoiceStream.sorted(Comparator.comparing(Invoice::getQuantity)).forEach(System.out::println);
        //System.out.println("Invoices sorted by Value low to high.");
        //invoiceStream.sorted(Comparator.comparing(Invoice::getValue)).forEach(System.out::println);
        System.out.println("Invoices sorted by price $200 to $500.");
        invoiceStream.map(Invoice::getTwoToFiveHundred).distinct().sorted().forEach(System.out::println);
        //invoiceStream.sorted(Comparator.comparing(Invoice::getTwoToFiveHundred)).forEach(System.out::println);

    }

    //Create a List of 10 Invoices containing data of your choosing.
    public static ArrayList<Invoice> generateData() {

        ArrayList<Invoice> invoices = new ArrayList<>();

        invoices.add(new Invoice(1, "Designer Short-Sleeve Shirt", 2, 80.28));

        invoices.add(new Invoice(2, "Designer Long-Sleeve Shirt", 3, 92.95));

        invoices.add(new Invoice(3, "Designer Sweater", 6, 105.89));

        invoices.add(new Invoice(4, "Designer Hoodie", 12, 110.99));

        invoices.add(new Invoice(5, "Designer Shorts", 13, 172.99));

        invoices.add(new Invoice(6, "Designer Pants", 11, 202.89));

        invoices.add(new Invoice(7, "Designer Jeans", 7, 230.99));

        invoices.add(new Invoice(8, "Designer Boots", 5, 400.50));

        invoices.add(new Invoice(9, "Designer Sneakers", 4, 500.30));

        invoices.add(new Invoice(10, "Designer Belt", 20, 100.30));

        return invoices;

    }

}
