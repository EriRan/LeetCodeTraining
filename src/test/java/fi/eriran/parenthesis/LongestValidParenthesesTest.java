package fi.eriran.parenthesis;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestValidParenthesesTest {

    @Test
    void testExample1() {
        assertEquals(2, new LongestValidParentheses().longestValidParentheses("(()"));
    }

    @Test
    void testExample2() {
        assertEquals(4, new LongestValidParentheses().longestValidParentheses(")()())"));
    }

    @Test
    void testTwoValidSubstrings() {
        assertEquals(6, new LongestValidParentheses().longestValidParentheses(")()()())()()"));
    }

    @Test
    void submissionTest1() {
        assertEquals(6, new LongestValidParentheses().longestValidParentheses("()(())"));
    }

    @Test
    void submissionTest2() {
        assertEquals(2, new LongestValidParentheses().longestValidParentheses("()(()"));
    }

    @Test
    void submissionTest3() {
        assertEquals(8, new LongestValidParentheses().longestValidParentheses("((()))())"));
    }
}