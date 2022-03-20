package solutions.adapttech.classes.JavaObjectModel;

import org.junit.jupiter.api.Test;
import solutions.adapttech.classes.javaMasterClass.BarkingDog;

import static org.junit.jupiter.api.Assertions.*;

class BarkingDogTest {
    @Test
    void barking() {
        BarkingDog testBark = new BarkingDog();

        testBark.shouldWakeUp(true, 1);
        assertEquals(true, testBark.shouldWakeUp(true, 1));

        testBark.shouldWakeUp(false, 2);
        assertEquals(true, testBark.shouldWakeUp(true, 2));

        testBark.shouldWakeUp(true, 8);
        assertEquals(true, testBark.shouldWakeUp(false, 8));

        testBark.shouldWakeUp(true, -1);
        assertEquals(true, testBark.shouldWakeUp(false, -1));


    }
}