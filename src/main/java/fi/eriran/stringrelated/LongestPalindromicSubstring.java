package fi.eriran.stringrelated;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 */
public class LongestPalindromicSubstring {

    public String longestPalindrome(String string) {
        if (string == null || string.isEmpty() || string.length() < 2) {
            return "";
        }
        if (string.length() > 1000) {
            throw new IllegalArgumentException("Max allowed String length is 1000");
        }
        return findLongest(string);
    }

    private String findLongest(String string) {
        //Handle simple cases quickly
        if (string.length() == 2) {
            if (string.charAt(0) == string.charAt(1)) {
                return string;
            } else {
                return "";
            }
        } else if (string.length() == 3) {
            if (string.charAt(0) == string.charAt(2)) {
                return string;
            } else {
                return "";
            }
        }
        char[] charArray = string.toCharArray();

        String palindromeFromLeft = findPalindromeFromLeft(string, charArray);
        String palindromeFromRight = findPalindromeFromRight(string, charArray);
        if (palindromeFromLeft.length() > palindromeFromRight.length()) {
            return palindromeFromLeft;
        }
        return palindromeFromRight;
    }

    private String findPalindromeFromLeft(String string, char[] charArray) {
        String currentLongest = "";
        for (int leftPointer = 0; leftPointer < string.length() - 2; leftPointer++) {
            String foundPalindrome = findLongestPalindromeFromPositions(
                    string,
                    charArray,
                    leftPointer,
                    charArray.length - 1
            );
            if (!foundPalindrome.isEmpty()) {
                currentLongest = attemptToChangeLongest(currentLongest, foundPalindrome);
            }
        }
        return currentLongest;
    }

    private String findPalindromeFromRight(String string, char[] charArray) {
        String currentLongest = "";
        for (int rightPointer = charArray.length - 1; rightPointer > 1; rightPointer--) {
            String foundPalindrome = findLongestPalindromeFromPositions(
                    string,
                    charArray,
                    0,
                    rightPointer
            );
            if (!foundPalindrome.isEmpty()) {
                currentLongest = attemptToChangeLongest(currentLongest, foundPalindrome);
            }
        }
        return currentLongest;
    }

    private String findLongestPalindromeFromPositions(String string,
                                                      char[] charArray,
                                                      int leftPointer,
                                                      int rightPointer) {
        int palindromeStartIndex = leftPointer;
        int palindromeEndIndex = rightPointer;
        while (leftPointer <= rightPointer) {
            if (charArray[leftPointer] != charArray[rightPointer]) {
                palindromeStartIndex = leftPointer + 1;
                palindromeEndIndex = rightPointer - 1;
            }
            leftPointer++;
            rightPointer--;
        }
        if (palindromeEndIndex - palindromeStartIndex > 0) {
            return string.substring(palindromeStartIndex, palindromeEndIndex + 1);
        }
        return "";
    }

    private String attemptToChangeLongest(String currentLongest, String newPalindrome) {
        if (currentLongest.isEmpty() || currentLongest.length() < newPalindrome.length()) {
            return newPalindrome;
        }
        return currentLongest;
    }
}
