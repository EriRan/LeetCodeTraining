package fi.eriran.leetcode.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegularExpressionMatchingTest {

    @Test
    void example1() {
        assertFalse(new RegularExpressionMatching().isMatch("aa", "a"));
    }

    @Test
    void example2() {
        assertTrue(new RegularExpressionMatching().isMatch("aa", "a*"));
    }

    @Test
    void example3() {
        assertTrue(new RegularExpressionMatching().isMatch("ab", ".*"));
    }

    @Test
    void example4() {
        assertTrue(new RegularExpressionMatching().isMatch("aab", "c*a*b"));
    }

    @Test
    void example5() {
        assertFalse(new RegularExpressionMatching().isMatch("mississippi", "mis*is*p*."));
    }

    @Test
    void submissionTest1() {
        assertTrue(new RegularExpressionMatching().isMatch("a", "ab*"));
    }

    @Test
    void multipleWildCardsAtEnd() {
        assertTrue(new RegularExpressionMatching().isMatch("aab", "c*a*b***************************"));
    }
}