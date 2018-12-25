import org.junit.Test;

import static org.junit.Assert.*;

public class NumberPrinterTest {

    @Test
    public void printNumber() {
        NumberPrinter tester = new NumberPrinter();

        /*
         * Test Scenario 1:
         *
         * Tests when start is lesser than end
         *
         * */
        String expectedOutput = "1";
        String actualOutput = tester.printNumbers(0, 2);
        assertEquals("It should print 1.", expectedOutput, actualOutput);

        /*
         * Test Scenario 2:
         *
         * Tests when start is greater than end
         *
         * */
        String expectedOutput1 = "-11";
        String actualOutput1 = tester.printNumbers(3, -3);
        assertEquals("It should print the numbers in the range exclusively.", expectedOutput1, actualOutput1);

        /*
         * Test Scenario 3:
         *
         * Tests when start is equal to end
         *
         * */
        String expectedOutput2 = "";
        String actualOutput2 = tester.printNumbers(0, 0);
        assertEquals("It should not print anything.", expectedOutput2, actualOutput2);

        /*
         * Test Scenario 4:
         *
         * Tests when start or/and end is/are negative
         *
         * */
        String expectedOutput3 = "";
        String actualOutput3 = tester.printNumbers(-3, -5);
        assertEquals("It should not print anything.", expectedOutput3, actualOutput3);

        /*
         * Test Scenario 5:
         *
         * Tests when start is one lesser than end
         *
         * */
        String expectedOutput4 = "";
        String actualOutput4 = tester.printNumbers(0, 1);
        assertEquals("It should not print anything.", expectedOutput4, actualOutput4);

        /*
         * Test Scenario 6:
         *
         * Tests for odd numbers in a range
         *
         * */
        String expectedOutput5 = "3579";
        String actualOutput5 = tester.printNumbers(1, 10);
        assertEquals("It should print the odd numbers in the range.", expectedOutput5, actualOutput5);
    }

}