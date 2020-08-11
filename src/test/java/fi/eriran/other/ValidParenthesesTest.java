package fi.eriran.other;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidParenthesesTest {

    @Test
    void testExample1() {
        assertTrue(new ValidParentheses().isValid("()"));
    }

    @Test
    void testExample2() {
        assertTrue(new ValidParentheses().isValid("()[]{}"));
    }

    @Test
    void testExample3() {
        assertFalse(new ValidParentheses().isValid("(]"));
    }

    @Test
    void testExample4() {
        assertFalse(new ValidParentheses().isValid("([)]"));
    }

    @Test
    void testExample5() {
        assertFalse(new ValidParentheses().isValid("{[]}"));
    }
}