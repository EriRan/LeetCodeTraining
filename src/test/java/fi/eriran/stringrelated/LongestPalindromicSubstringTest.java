package fi.eriran.stringrelated;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestPalindromicSubstringTest {

    @Test
    void example1() {
        String palindrome = new LongestPalindromicSubstring().longestPalindrome("babad");
        assertTrue("bab".equals(palindrome) || "aba".equals(palindrome));
    }

    @Test
    void example2() {
        assertEquals("bb", new LongestPalindromicSubstring().longestPalindrome("cbbd"));
    }
}