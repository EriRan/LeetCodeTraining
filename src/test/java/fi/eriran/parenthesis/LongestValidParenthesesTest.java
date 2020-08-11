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
    void testParenthesisInsideParenthesis() {
        assertEquals(6, new LongestValidParentheses().longestValidParentheses("()(())"));
    }
}