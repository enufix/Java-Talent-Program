import java.util.Scanner;

public class YearlyCalendar {

    public static void main(String[] args) {

        System.out.println("Enter any year: ");
        int year = new Scanner(System.in).nextInt();
        String[] daysInYear;
        if (year % 4 == 0) {
            daysInYear = new String[366];
        } else {
            daysInYear = new String[365];
        }
        if ((year % 100 == 0) & (year % 400 != 0)) {
            daysInYear = new String[365];
        }
        int datesIndex = 0;

        for (int month = 1; month <= 12; month++) {
            switch (month) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    for (int day = 1; day <= 31; day++) {
                        daysInYear[datesIndex] = String.format("%d-%02d-%02d", year, month, day);
                        datesIndex++;
                    }
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    for (int day = 1; day <= 30; day++) {
                        daysInYear[datesIndex] = String.format("%d-%02d-%02d", year, month, day);
                        datesIndex++;
                    }
                    break;
                case 2:
                    if (year % 4 == 0) {

                        for (int day = 1; day <= 29; day++) {
                            daysInYear[datesIndex] = String.format("%d-%02d-%02d", year, month, day);
                            datesIndex++;
                        }
                    } else {

                        for (int day = 1; day <= 28; day++) {
                            daysInYear[datesIndex] = String.format("%d-%02d-%02d", year, month, day);
                            datesIndex++;
                        }
                    }
                    break;
            }
        }
        for (String date : daysInYear) {
            System.out.println(date);
        }
    }
}
