import java.util.Scanner;

public class Numbers {
    public static void main(String[] args) {
        System.out.println("Enter a number of digits as words: ");
        String str = new Scanner(System.in).nextLine();
        String[] digits = str.split(" ");
        for (String digit : digits) {
            switch (digit) {
                case "zero":
                    digit = "0";
                    break;
                case "one":
                    digit = "1";
                    break;
                case "two":
                    digit = "2";
                    break;
                case "three":
                    digit = "3";
                    break;
                case "four":
                    digit = "4";
                    break;
                case "five":
                    digit = "5";
                    break;
                case "six":
                    digit = "6";
                    break;
                case "seven":
                    digit = "7";
                    break;
                case "eight":
                    digit = "8";
                    break;
                case "nine":
                    digit = "9";
                    break;
            }
            System.out.print(digit);
        }
    }
}
