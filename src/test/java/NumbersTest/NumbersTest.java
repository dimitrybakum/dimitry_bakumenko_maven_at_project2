package NumbersTest;

import Numbers.Numbers;

public class NumbersTest {
    public static void main(String[] args) {
        Numbers numbers = new Numbers();

        testNumber(numbers, -1, 5, 98);
        testNumber(numbers, -1, 10, 48);
        testNumber(numbers, 2, 2, 53);
        testNumber(numbers, -2, 62, 96);
        testNumber(numbers, 2, -6, 53);
        testNumber(numbers, -100, -100, -50);
    }

    private static void testNumber(Numbers numbers, int x, int y, int expected) {
        int actual = numbers.getNumber(x, y);
        if (actual == expected) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");
        }
    }
}