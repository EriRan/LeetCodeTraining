package fi.eriran.leetcode.strings.parenthesis;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidParenthesesTest {

    @Test
    void example1() {
        assertTrue(new ValidParentheses().isValid("()"));
    }

    @Test
    void example2() {
        assertTrue(new ValidParentheses().isValid("()[]{}"));
    }

    @Test
    void example3() {
        assertFalse(new ValidParentheses().isValid("(]"));
    }

    @Test
    void example4() {
        assertFalse(new ValidParentheses().isValid("([)]"));
    }

    @Test
    void example5() {
        assertTrue(new ValidParentheses().isValid("{[]}"));
    }

    @Test
    void onlyOneOpenSquareBracket() {
        assertFalse(new ValidParentheses().isValid("["));
    }

    @Test
    void onlyOneCloseSquareBracket() {
        assertFalse(new ValidParentheses().isValid("]"));
    }

    @Test
    void blank() {
        ValidParentheses validParentheses = new ValidParentheses();
        assertThrows(IllegalArgumentException.class, () -> validParentheses.isValid("   "));
    }

    @Test
    void emptyIsValid() {
        assertTrue(new ValidParentheses().isValid(""));
    }
}