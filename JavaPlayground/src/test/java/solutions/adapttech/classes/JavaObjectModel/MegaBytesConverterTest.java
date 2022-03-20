package solutions.adapttech.classes.JavaObjectModel;

import org.junit.jupiter.api.Test;
import solutions.adapttech.classes.javaMasterClass.MegaBytesConverter;

import static org.junit.jupiter.api.Assertions.*;

class MegaBytesConverterTest {

    @Test
    void printMegaBytesAndKiloBytes() {
        MegaBytesConverter testConverter = new MegaBytesConverter();

        testConverter.printMegaBytesAndKiloBytes(1024);

        assertEquals(1, testConverter.megaBytes);
    }
}