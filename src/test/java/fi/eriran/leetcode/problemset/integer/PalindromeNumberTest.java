package fi.eriran.leetcode.problemset.integer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalindromeNumberTest {

    @Test
    void example1() {
        assertTrue(new PalindromeNumber().isPalindrome(121));
    }

    @Test
    void example2() {
        assertFalse(new PalindromeNumber().isPalindrome(-121));
    }

    @Test
    void example3() {
        assertFalse(new PalindromeNumber().isPalindrome(10));
    }
}