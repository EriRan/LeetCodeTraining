package fi.eriran.leetcode.problemset.string.parenthesis;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestValidParenthesesTest {

    @Test
    void example1() {
        assertEquals(2, new LongestValidParentheses().longestValidParentheses("(()"));
    }

    @Test
    void example2() {
        assertEquals(4, new LongestValidParentheses().longestValidParentheses(")()())"));
    }

    @Test
    void twoValidSubstrings() {
        assertEquals(6, new LongestValidParentheses().longestValidParentheses(")()()())()()"));
    }

    @Test
    void multipleSplitters() {
        assertEquals(2, new LongestValidParentheses().longestValidParentheses("()(()(()(()("));
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

    @Test
    void submissionTest4() {
        assertEquals(22, new LongestValidParentheses().longestValidParentheses(")(((((()())()()))()(()))("));
    }

    @Test
    void submissionTest5() {
        assertEquals(10, new LongestValidParentheses().longestValidParentheses(")()(((())))("));
    }
}