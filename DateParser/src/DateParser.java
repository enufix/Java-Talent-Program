import java.util.Scanner;

public class DateParser {
    public static void main(String[] args) {
        String date = new Scanner(System.in).nextLine();
        String month = date.substring(0, 2);
        String day = date.substring(3, 5);
        String year = date.substring(6, 10);
        System.out.println("Month: " + month + ", Day: " + day + ", Year: " + year);
    }
}
