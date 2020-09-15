import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        System.out.println("Enter the width: ");
        int width = new Scanner(System.in).nextInt();
        System.out.println("Enter the height: ");
        int height = new Scanner(System.in).nextInt();
        System.out.println("Enter the depth: ");
        int depth = new Scanner(System.in).nextInt();

        Box b = new Box(height, width, depth);
        System.out.println("Volume: " + b.boxVolume());
    }
}
