package solutions.adapttech.classes.JavaObjectModel;

import org.junit.jupiter.api.Test;
import solutions.adapttech.classes.javaMasterClass.LeapYear;

class LeapYearTest {

    @Test
    void isLeapYear() {
        LeapYear testYear = new LeapYear();
        testYear.isLeapYear(2020);
        System.out.println(testYear.isLeapYear(1924));
    }
}