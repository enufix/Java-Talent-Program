import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("City: ");
        String city = sc.nextLine();

        System.out.println("Street: ");
        String street = sc.nextLine();

        System.out.println("Street number: ");
        Integer streetNumber = sc.nextInt();

        System.out.println("Zip Code: ");
        Integer zipCode = sc.nextInt();

        try {
            Address address = new Address(street, streetNumber, city, zipCode);
            System.out.println(address.toString());

        } catch (ZipCodeLengthException ex) {
            System.out.println(ex.getMessage());
        }


    }
}
