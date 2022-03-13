package solutions.adapttech.classes.stateAndBehavior;


public class BumpsTheRoad {
    public static String bumps(final String road) {
        String flatRoad = "_";
        String bumpRoad = "n";
        int bumpCount = 0;
        while (bumpCount <= 15) {

            if (road.equals(bumpRoad)) {
                bumpCount += 1;
            }
            return "Woohoo!";
        }
        if (bumpCount >= 15) {
            return "Car Dead";

        }

        return null;
    }
}
