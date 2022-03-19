package practice.anagrams;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class Program {

    // O(w * n * log(n)) time | O(wn) space
    public static List<Integer> filterAnagrams(List<String> words, List<String> anagramsToSearch) {
        Map<String, Integer> anagrams = new HashMap<String, Integer>();
        List<Integer> output = new ArrayList<Integer>();

        for (String anagramToSearch : anagramsToSearch) {
            char[] anagramChar = anagramToSearch.toCharArray();
            Arrays.sort(anagramChar);
            String sortedAnagram = new String(anagramChar);

            for (String word : words) {
                char[] wordChar = word.toCharArray();
                Arrays.sort(wordChar);
                String sortedWord = new String(wordChar);

                if (sortedAnagram.equals(sortedWord)) {
                    anagrams.put(anagramToSearch, anagrams.getOrDefault(anagramToSearch, 0) + 1);
                }
            }

            if (!anagrams.containsKey(anagramToSearch)) {
                anagrams.put(anagramToSearch, 0);
            }
        }

        for (String anagramToSearch : anagramsToSearch) {
            if (anagrams.containsKey(anagramToSearch)) {
                output.add(anagrams.get(anagramToSearch));
            }
        }

        return output;
    }

}

class ProgramTest {

    @Test
    void testCaseOne() {
        List<String> words = Arrays.asList("hack", "a", "rank", "khac", "ackh", "kran", "rankhacker", "a", "ab", "bo", "stairs", "raits");
        List<String> anagramsToSearch = Arrays.asList("a", "nark", "bs", "hack", "stair");
        List<Integer> result = Program.filterAnagrams(words, anagramsToSearch);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(Arrays.asList(2, 2, 0, 3, 1), result);
    }

    @Test
    void testCaseTwo() {
        List<String> words = Arrays.asList("heater", "cold", "clod", "reheat", "docl");
        List<String> anagramsToSearch = Arrays.asList("codl", "heater", "abcd");
        List<Integer> result = Program.filterAnagrams(words, anagramsToSearch);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(Arrays.asList(3, 2, 0), result);
    }

    @Test
    void testCaseThree() {
        List<String> words = Arrays.asList("listen", "tow", "silent", "lisent", "two", "abc", "no", "on");
        List<String> anagramsToSearch = Arrays.asList("two", "bca", "no", "listen");
        List<Integer> result = Program.filterAnagrams(words, anagramsToSearch);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(Arrays.asList(2, 1, 2, 3), result);
    }
}
