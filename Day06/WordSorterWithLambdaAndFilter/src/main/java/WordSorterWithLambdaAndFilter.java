import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class WordSorterWithLambdaAndFilter {

    private static final String ASCENDING = "asc";
    private static final String DESCENDING = "desc";

    public static List<String> loadWordsFromFile() throws IOException {

        File file = new File("file.txt");
        String words = FileUtils.readFileToString(file, "UTF-8").replaceAll("[^a-zA-Z ]", "").toLowerCase();
        String[] splitedWords = words.split(" ");
        ArrayList<String> listWords = new ArrayList<>();
        Collections.addAll(listWords, splitedWords);
        return listWords;
    }

    public static List<String> sortAndFilterWords(List<String> list, int minLength, int maxLength, String sortingOrder) {

        if (sortingOrder.equals(ASCENDING)) {
            list = list.stream().filter(s -> maxLength > 0 ? (s.length() >= minLength && s.length() <= maxLength) : s.length() >= minLength).sorted((s1, s2) -> Integer.compare(s1.length(), s2.length())).distinct().collect(Collectors.toList());

        } else if (sortingOrder.equals(DESCENDING)) {
            list = list.stream().filter(s -> maxLength > 0 ? (s.length() >= minLength && s.length() <= maxLength) : s.length() >= minLength).sorted((s1, s2) -> Integer.compare(s2.length(), s1.length())).distinct().collect(Collectors.toList());

        } else {

            throw new IllegalArgumentException("Invalid sorting order, enter asc or desc.");
        }

        return list;
    }

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter asc for ascending order or desc for descending order: ");
        String sortingOrder = sc.nextLine();
        System.out.println("Enter the minimum length of words: ");
        int minLength = sc.nextInt();
        System.out.println("Enter the maximum length of words: ");
        int maxLength = sc.nextInt();

        List<String> words = loadWordsFromFile();
        List<String> filteredAndSortedWords = sortAndFilterWords(words, minLength, maxLength, sortingOrder);
        filteredAndSortedWords.forEach(System.out::println);

    }


}
