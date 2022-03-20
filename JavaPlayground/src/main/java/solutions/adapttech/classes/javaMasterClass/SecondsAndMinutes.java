package solutions.adapttech.classes.javaMasterClass;

public class SecondsAndMinutes {
    public static String getDurationString(int minutes, int seconds) {
        int remainingMinutes = 0;
        int remainingSeconds = 0;
        int hours = 0;
        if (minutes < 0 || (seconds < 0 && seconds > 60)) {
            return "Invalid value";
        } else {
            hours = minutes /60;
            minutes = minutes + (seconds / 60) ;
            remainingSeconds = seconds;
            if (seconds > 59){
                remainingSeconds = (seconds % 60)  ;
            }
            remainingMinutes = minutes;
            if (minutes > 59) {
                remainingMinutes = (minutes % 60);
            }

        }

        return String.format("%02dh %02dm %02ds", hours, remainingMinutes, remainingSeconds);
    }

    public static void main(String[] args) {
        SecondsAndMinutes test = new SecondsAndMinutes();

        System.out.println(test.getDurationString(125, 130));

    }
}


