package fi.eriran.leetcode.problemset.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegularExpressionMatchingTest {

    @Test
    void example1() {
        assertNotMatch("aa", "a");
    }

    @Test
    void example2() {
        assertMatch("aa", "a*");
    }

    @Test
    void example3() {
        assertMatch("ab", ".*");
    }

    @Test
    void example4() {
        assertMatch("aab", "c*a*b");
    }

    @Test
    void example5() {
        assertNotMatch("mississippi", "mis*is*p*.");
    }

    @Test
    void submissionTest1() {
        assertMatch("a", "ab*");
    }

    @Test
    void submissionTest2() {
        assertMatch("aaa", "a*a");
    }

    @Test
    void submissionTest3() {
        assertNotMatch("aaa", "aaaa");
    }

    @Test
    void submissionTest4() {
        assertNotMatch("a", "ab*a");
    }

    @Test
    void submissionTest5() {
        assertMatch("aaa", "ab*a*c*a");
    }

    @Test
    void submissionTest6() {
        assertMatch("ab", ".*..");
    }

    @Test
    void submissionTest7() {
        assertNotMatch("", ".");
    }

    @Test
    void submissionTest8() {
        assertMatch("abcdede", "ab.*de");
    }

    @Test
    void matchAnyOrMoreWithOneMoreAfter() {
        assertMatch("aaa", ".*a");
    }

    @Test
    void useZeroMatchInsteadOfAllMatch() {
        assertMatch("aaa", "a*aaa");
    }

    @Test
    void matchAnyOrZeroWithEmptyString() {
        assertMatch("", ".*");
    }

    @Test
    void matchAnyOrZeroWithString() {
        assertMatch("su.cce*ss", ".*");
    }

    @Test
    void matchZeroOrMoreWithEmptyString() {
        assertMatch("", "c*");
    }

    @Test
    void matchMultipleZeroOrMoreWithEmptyString() {
        assertMatch("", "a*b*c*");
    }

    @Test
    void matchMultipleZeroOrMoreWithOneRequiredLetterAndEmptyString() {
        assertNotMatch("", "a*b*c*z");
    }

    private void assertMatch(String string, String pattern) {
        assertTrue(new RegularExpressionMatching().isMatch(string, pattern),
                "\"" + string + "\" did not match with \"" + pattern + "\"");
    }

    private void assertNotMatch(String string, String pattern) {
        assertFalse(new RegularExpressionMatching().isMatch(string, pattern),
                "\"" + string + "\" matched with \"" + pattern + "\"");
    }
}