package fi.eriran.leetcode.problemset.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestSubstringWithoutRepeatingCharactersTest {

    @Test
    void example1() {
        assertEquals(3, new LongestSubstringWithoutRepeatingCharacters()
                .lengthOfLongestSubstring("abcabcbb"));
    }

    @Test
    void example2() {
        assertEquals(1, new LongestSubstringWithoutRepeatingCharacters()
                .lengthOfLongestSubstring("bbbbb"));
    }

    @Test
    void example3() {
        assertEquals(3, new LongestSubstringWithoutRepeatingCharacters()
                .lengthOfLongestSubstring("pwwkew"));
    }

    @Test
    void example4() {
        assertEquals(0, new LongestSubstringWithoutRepeatingCharacters()
                .lengthOfLongestSubstring(""));
    }

    @Test
    void submissionTest1() {
        assertEquals(2, new LongestSubstringWithoutRepeatingCharacters()
                .lengthOfLongestSubstring("aab"));
    }

    @Test
    void submissionTest2() {
        assertEquals(3, new LongestSubstringWithoutRepeatingCharacters()
                .lengthOfLongestSubstring("dvdf"));
    }
}