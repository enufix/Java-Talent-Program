import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WordCounter {

    public static void main(String[] args) throws IOException {

        HashMap<String, Integer> map = new HashMap<>();


        File file = new File("file.txt");
        String string = FileUtils.readFileToString(file, "UTF-8").replaceAll("[^a-zA-Z]", " ").toLowerCase();
        String[] words = string.split("\\s+");

        for (String word : words) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }

        for (Map.Entry<String, Integer> word : map.entrySet()) {
            System.out.println(word.getKey() + ": " + word.getValue());
        }
    }
}






