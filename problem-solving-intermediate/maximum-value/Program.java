package practice.maximum_value;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Program {

    // O(log n) time | O(1) space
    public static int maximumValue(int n, int maxSum, int index) {
        int left = maxSum / n;
        int right = maxSum + 1;
        int result = 0;
        while (left < right) {
            int middle = left + (right - left) / 2;
            int inLeft = getInLeft(middle, index);
            int inRight = getInRight(n, middle, index);

            if (inLeft + inRight <= maxSum) {
                result = middle;
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        return result;
    }

    private static int getInRight(int n, int middle, int index) {
        return (middle + Math.max(1, middle - (n - index - 1))) *
                Math.min(n - index, middle) / 2 +
                Math.abs(Math.min(0, middle - (n - index - 1) - 1));
    }

    private static int getInLeft(int middle, int index) {
        return (middle - 1 + Math.max(1, middle - index)) *
                Math.min(index, middle - 1) / 2 +
                Math.abs(Math.min(0, middle - index - 1));
    }
}

class ProgramTest {

    @Test
    void testCaseOne() {
        int result = Program.maximumValue(6, 14, 3);
        Assertions.assertEquals(3, result);
    }

    @Test
    void testCaseTwo() {
        int result = Program.maximumValue(7, 8, 4);
        Assertions.assertEquals(2, result);
    }

    @Test
    void testCaseThree() {
        int result = Program.maximumValue(6, 10, 1);
        Assertions.assertEquals(3, result);
    }
}