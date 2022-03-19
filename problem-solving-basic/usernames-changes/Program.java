package practice.change_usernames;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Program {

    // O(n^2) time | O(1) space
    public static List<String> changeUsernames(List<String> usernames) {
        List<String> result = new ArrayList<String>();
        for (String username : usernames) {
            result.add(processUsername(username));
        }
        return result;
    }

    private static String processUsername(String username) {
        String result = "NO";
        char firstChar = Character.toLowerCase(username.charAt(0));
        for (int i = 1; i < username.length(); i++) {
            int nextChar = username.charAt(i);
            boolean isSmallest = nextChar < (int) firstChar;

            if (isSmallest) {
                result = "YES";
            }

            if (firstChar == username.charAt(i)) {
                result = "NO";
            }
        }

        return result;
    }

}

class ProgramTest {

    @Test
    void testCaseOne() {
        List<String> result = Program.changeUsernames(Arrays.asList("Aba", "Cat", "Boby", "Buba", "Bapg", "bcda"));
        Assertions.assertNotNull(result);
        Assertions.assertEquals(Arrays.asList("NO", "YES", "NO", "YES", "YES", "YES"), result);
    }

    @Test
    void testCaseTwo() {
        List<String> result = Program.changeUsernames(Arrays.asList("hydra"));
        Assertions.assertNotNull(result);
        Assertions.assertEquals(Arrays.asList("YES"), result);
    }

    @Test
    void testCaseThree() {
        List<String> result = Program.changeUsernames(Arrays.asList("foo", "bar", "baz"));
        Assertions.assertNotNull(result);
        Assertions.assertEquals(Arrays.asList("NO", "YES", "YES"), result);
    }

}