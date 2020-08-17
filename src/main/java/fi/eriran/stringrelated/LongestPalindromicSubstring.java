package fi.eriran.stringrelated;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 */
public class LongestPalindromicSubstring {

    public String longestPalindrome(String string) {
        if (string == null || string.isEmpty()) {
            return "";
        }
        if (string.length() == 1) {
            return string;
        }
        if (string.length() > 1000) {
            throw new IllegalArgumentException("Max allowed String length is 1000");
        }
        return findLongest(string);
    }

    private String findLongest(String string) {
        char[] charArray = string.toCharArray();

        int leftPointer = 0;
        int rightPointer = charArray.length - 1;
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
        return string.substring(palindromeStartIndex, palindromeEndIndex + 1);
    }
}
