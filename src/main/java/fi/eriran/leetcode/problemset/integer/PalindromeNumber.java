package fi.eriran.leetcode.problemset.integer;

public class PalindromeNumber {

    public boolean isPalindrome(int number) {
        //Negative numbers cannot be palindromes
        if (number < 0) {
            return false;
        }

        int[] reversedNumbers = createNumberArray(number);

        int leftPointer = 0;
        int rightPointer = reversedNumbers.length - 1;

        while (leftPointer <= rightPointer) {
            if (reversedNumbers[leftPointer] != reversedNumbers[rightPointer]) {
                return false;
            }
            leftPointer++;
            rightPointer--;
        }

        return true;
    }

    private int[] createNumberArray(int number) {
        int[] reversedNumbers = new int[countNumberOfDigits(number)];
        for (int i = 0; i < reversedNumbers.length; i++) {
            reversedNumbers[i] = number % 10;
            number /= 10;
        }
        return reversedNumbers;
    }

    private int countNumberOfDigits(int number) {
        int count = 0;
        while (number != 0) {
            number = number / 10;
            count++;
        }
        return count;
    }
}
