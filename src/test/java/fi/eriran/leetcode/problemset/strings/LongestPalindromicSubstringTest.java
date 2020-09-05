package fi.eriran.leetcode.problemset.strings;

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
        assertEquals("otto", new LongestPalindromicSubstring().longestPalindrome("ottomowoidf"));
    }

    @Test
    void singleCharacter() {
        assertEquals("a", new LongestPalindromicSubstring().longestPalindrome("a"));
    }

    @Test
    void twoSameCharacters() {
        assertEquals("aa", new LongestPalindromicSubstring().longestPalindrome("aa"));
    }

    @Test
    void twoDifferentCharacters() {
        assertEquals("z", new LongestPalindromicSubstring().longestPalindrome("za"));
    }

    @Test
    void threeCharactersWithOneTwoCharacterPalindromeAtEnd() {
        assertEquals("bb", new LongestPalindromicSubstring().longestPalindrome("abb"));
    }

    @Test
    void threeCharactersWithOneTwoCharacterPalindromeAtStart() {
        assertEquals("cc", new LongestPalindromicSubstring().longestPalindrome("ccd"));
    }

    @Test
    void oneCharacterInString() {
        assertEquals("a", new LongestPalindromicSubstring().longestPalindrome("abcda"));
    }
}