import java.util.*;

public class CharCounter {

    public static void charCounter(String line) {

        HashMap<Character, Integer> map = new HashMap<>();

        char[] chars = line.toCharArray();

        for (char c : chars) {
            if (map.containsKey(c)) {

                map.put(c, map.get(c) + 1);
            } else {

                map.put(c, 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a sentence: ");
        String str = sc.nextLine();
        charCounter(str);
        sc.close();
    }
}