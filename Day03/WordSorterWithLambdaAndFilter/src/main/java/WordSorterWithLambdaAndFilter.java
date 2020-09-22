import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class WordSorterWithLambdaAndFilter {

    private static final String ASCENDING = "asc";
    private static final String DESCENDING = "desc";


    public static void main(String[] args) throws IOException {

        File file = new File("file.txt");
        String string = FileUtils.readFileToString(file, "UTF-8").replaceAll("[^a-zA-Z ]", "").toLowerCase();
        String[] words = string.split(" ");

        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, words);

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter asc for ascending order or desc for descending order: ");
        String sortingOrder = sc.nextLine();
        System.out.println("Enter the minimum length of words: ");
        int minLength = sc.nextInt();
        System.out.println("Enter the maximum length of words: ");
        int maxLength = sc.nextInt();


        if (sortingOrder.equals(ASCENDING)) {
            list.stream().filter(s -> maxLength > 0 ? (s.length() >= minLength && s.length() <= maxLength) : s.length() >= minLength).sorted((s1, s2) -> Integer.compare(s1.length(), s2.length())).distinct().forEach(System.out::println);

        } else if (sortingOrder.equals(DESCENDING)) {
            list.stream().filter(s -> maxLength > 0 ? (s.length() >= minLength && s.length() <= maxLength) : s.length() >= minLength).sorted((s1, s2) -> Integer.compare(s2.length(), s1.length())).distinct().forEach(System.out::println);
        }

    }

}
