package solutions.adapttech.classes.JavaObjectModel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeapYearTest {

    @Test
    void isLeapYear() {
        LeapYear testYear = new LeapYear();
        testYear.isLeapYear(2020);
        System.out.println(testYear.isLeapYear(1924));
    }
}