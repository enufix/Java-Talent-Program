import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class WordSorter {

    private static final String ASCENDING = "asc";
    private static final String DESCENDING = "desc";


    public static void main(String[] args) throws IOException {

        Set<String> uniqueWords = new HashSet<>();

        File file = new File("file.txt");
        String string = FileUtils.readFileToString(file, "UTF-8").replaceAll("[^a-zA-Z]", " ").toLowerCase();
        String[] words = string.split("\\s+");

        Collections.addAll(uniqueWords, words);
        ArrayList<String> list = new ArrayList<>(uniqueWords);

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter asc for ascending order or desc for descending order: ");
        String sortingOrder = sc.nextLine();

        if (sortingOrder.equals(ASCENDING)) {
            Collections.sort(list, new AscendingLengthStringComparator());
            for (String s : list) {
                System.out.println(s);
            }
        } else if (sortingOrder.equals(DESCENDING)) {
            Collections.sort(list, new DescendingLengthStringComparator());
            for (String s : list) {
                System.out.println(s);
            }

        }

    }

}
