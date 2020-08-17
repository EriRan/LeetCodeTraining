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

    /**
     * Classic Finnish palindrome which means "Soap stone merchant"
     */
    @Test
    void simplePalindrome() {
        String simplePalindrome = "saippuakivikauppias";
        assertEquals(simplePalindrome, new LongestPalindromicSubstring().longestPalindrome(simplePalindrome));
    }

    @Test
    void palindromeAtEnd() {
        assertEquals("otto", new LongestPalindromicSubstring().longestPalindrome("jgkeowotto"));
    }

    @Test
    void palindromeAtStart() {
        assertEquals("otto", new LongestPalindromicSubstring().longestPalindrome("ottomjosidf"));
    }
}