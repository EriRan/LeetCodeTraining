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
    void submissionTest2() {
        assertTrue(new RegularExpressionMatching().isMatch("aaa", "a*a"));
    }

    @Test
    void submissionTest3() {
        assertFalse(new RegularExpressionMatching().isMatch("aaa", "aaaa"));
    }

    @Test
    void submissionTest4() {
        assertFalse(new RegularExpressionMatching().isMatch("a", "ab*a"));
    }

    @Test
    void submissionTest5() {
        assertTrue(new RegularExpressionMatching().isMatch("aaa", "ab*a*c*a"));
    }

    @Test
    void submissionTest6() {
        assertTrue(new RegularExpressionMatching().isMatch("ab", ".*.."));
    }

    @Test
    void matchAnyOrMoreWithOneMoreAfter() {
        assertTrue(new RegularExpressionMatching().isMatch("aaa", ".*a"));
    }

    @Test
    void useZeroMatchInsteadOfAllMatch() {
        assertTrue(new RegularExpressionMatching().isMatch("aaa", "a*aaa"));
    }
}