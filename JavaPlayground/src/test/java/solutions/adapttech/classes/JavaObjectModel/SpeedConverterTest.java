package solutions.adapttech.classes.JavaObjectModel;

import org.junit.jupiter.api.Test;
import solutions.adapttech.classes.javaMasterClass.SpeedConverter;

import static org.junit.jupiter.api.Assertions.*;

class SpeedConverterTest {

    @Test
    void toMilesPerHour() {
        SpeedConverter testConverter = new SpeedConverter();
        testConverter.toMilesPerHour(5);
         assertEquals(8, testConverter.milesPerHour);
    }

    @Test
    void printConversion() {
        SpeedConverter testConverter = new SpeedConverter();
        testConverter.printConversion(2.0);
        assertEquals("Invalid Value", "Invalid Value" );
    }
}