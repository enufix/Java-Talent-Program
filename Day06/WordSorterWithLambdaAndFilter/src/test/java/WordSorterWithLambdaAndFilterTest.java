import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class WordSorterWithLambdaAndFilterTest {

    private List<String> words;

    @BeforeEach
    void setUp() {
        words = Arrays.asList("elena", "elen", "ele", "el", "e", "e");
    }

    @Test
    public void fileExists() throws IOException {
        File file = new File("file.txt");
        Assertions.assertTrue(file.exists());
    }

    @Test
    void sortAndFilterWords_ASCENDING() {
        List<String> filteredAndSortedWords = WordSorterWithLambdaAndFilter.sortAndFilterWords(words, 1, 5, "asc");
        Assertions.assertEquals(Arrays.asList("e", "el", "ele", "elen", "elena"), filteredAndSortedWords);
    }

    @Test
    void sortAndFilterWords_DESCENDING() {
        List<String> filteredAndSortedWords = WordSorterWithLambdaAndFilter.sortAndFilterWords(words, 1, 5, "desc");
        Assertions.assertEquals(Arrays.asList("elena", "elen", "ele", "el", "e"), filteredAndSortedWords);
    }

    @Test
    void sortAndFilterWords_MIN0() {
        List<String> filteredAndSortedWords = WordSorterWithLambdaAndFilter.sortAndFilterWords(words, 0, 2, "desc");
        Assertions.assertEquals(Arrays.asList("el", "e"), filteredAndSortedWords);
    }

    @Test
    void sortAndFilterWords_MAX0() {
        List<String> filteredAndSortedWords = WordSorterWithLambdaAndFilter.sortAndFilterWords(words, 2, 0, "desc");
        Assertions.assertEquals(Arrays.asList("elena", "elen", "ele", "el"), filteredAndSortedWords);
    }

    @Test
    void sortAndFilterWords_MIN0MAX0() {
        List<String> filteredAndSortedWords = WordSorterWithLambdaAndFilter.sortAndFilterWords(words, 0, 0, "desc");
        Assertions.assertEquals(Arrays.asList("elena", "elen", "ele", "el", "e"), filteredAndSortedWords);
    }

    @Test
    void sortAndFilterWords_MINMAX() {
        List<String> filteredAndSortedWords = WordSorterWithLambdaAndFilter.sortAndFilterWords(words, 2, 4, "asc");
        Assertions.assertEquals(Arrays.asList("el", "ele", "elen"), filteredAndSortedWords);
    }

    @Test
    void sortAndFilterWords_InvalidSortingOrder() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> WordSorterWithLambdaAndFilter.sortAndFilterWords(words, 0, 0, "ascending"), "Invalid sorting order, enter asc or desc.");
    }

}
