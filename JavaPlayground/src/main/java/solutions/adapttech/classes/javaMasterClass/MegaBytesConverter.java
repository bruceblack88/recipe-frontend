package solutions.adapttech.classes.javaMasterClass;

public class MegaBytesConverter {
    static int megaBytes;
     static int remainingKiloBytes;

    public static void printMegaBytesAndKiloBytes(int kiloBytes) {
        megaBytes = Math.round(kiloBytes / 1024);
        remainingKiloBytes = (megaBytes * 1024) - kiloBytes;
        if (remainingKiloBytes < 0) {remainingKiloBytes *= -1;}
        if (kiloBytes < 0) {
            System.out.println("Invalid Value");
        } else {
            System.out.println(kiloBytes + " KB = " + megaBytes + " MB and " + remainingKiloBytes + " KB");
        }
    }
}
