package solutions.adapttech.classes.javaMasterClass;

public class NumberOfDaysInMonth {
    public static boolean isLeapYear(int year) {
        if (year > 0 && year <= 9999) {
            return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0 && year % 100 == 0);
        } else {
            return false;
        }
    }

    public static int getDaysInMonth(int month, int year) {
        int days = 0;
        if (month < 1 || month > 12) {
            return -1;
        } else if (year < 1 || year > 9999) {
            return -1;
        } else {

            if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10
                    || month == 12) {
                days = 31;
            } else if (month == 4 || month == 6 || month == 9 || month == 11) {
                days = 30;

            } else if (month == 2) {
                if (year > 0 && year <= 9999 && year % 4 == 0 && year % 100 != 0 || year % 400 == 0 && year % 100 == 0) {
                    days = 29;
                } else {
                    days = 28;
                }

            }
            return days;
        }
    }
}
//            switch (days) {
//                case 1, 3, 5, 7, 8, 10, 12:
//                    days = 31;
//                    break;
//                case 2:
//                    if (((year % 4 == 0) &&
//                            !(year % 100 == 0))
//                            || (year % 400 == 0))
//                        days = 29;
//                    else
//                        days = 28;
//                    break;
//                case 4, 6, 9, 11:
//                    days = 30;
//                    break;
//                default:
//                    System.out.println("Invalid");
//                    break;
//            }