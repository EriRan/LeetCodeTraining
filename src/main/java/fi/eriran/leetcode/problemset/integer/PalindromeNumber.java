package fi.eriran.leetcode.problemset.integer;

/**
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 *
 * Follow up:
 *
 * Could you solve it without converting the integer to a string?
 */
public class PalindromeNumber {

    public boolean isPalindrome(int number) {
        //Negative numbers cannot be palindromes
        if (number < 0) {
            return false;
        }

        int[] numberArray = createNumberArray(number);

        int leftPointer = 0;
        int rightPointer = numberArray.length - 1;

        while (leftPointer <= rightPointer) {
            if (numberArray[leftPointer] != numberArray[rightPointer]) {
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
