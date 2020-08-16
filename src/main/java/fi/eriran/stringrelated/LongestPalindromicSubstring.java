package fi.eriran.stringrelated;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 */
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        if (s.length() == 1) {
            return s;
        }
        if (s.length() > 1000) {
            throw new IllegalArgumentException("Max String length is 1000");
        }
        return "";
    }
}
