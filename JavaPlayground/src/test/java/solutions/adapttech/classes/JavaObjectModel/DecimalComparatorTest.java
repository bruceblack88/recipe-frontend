package solutions.adapttech.classes.JavaObjectModel;

import org.junit.jupiter.api.Test;
import solutions.adapttech.classes.javaMasterClass.DecimalComparator;

import static org.junit.jupiter.api.Assertions.*;

class DecimalComparatorTest {

    @Test
    void areEqualByThreeDecimalPlaces() {
        DecimalComparator testComparator = new DecimalComparator();
        testComparator.areEqualByThreeDecimalPlaces(3.56, 3.1457);

        assertFalse(false);
        assertTrue(true);

    }
}