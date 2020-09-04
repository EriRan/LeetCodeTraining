package fi.eriran.leetcode.strings;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String string) {
        if (string == null || string.isEmpty()) {
            return 0;
        } else if (string.length() == 1) {
            return 1;
        }
        int longestSubstringSize = 0;
        Set<Character> encounteredCharacters = new HashSet<>();
        for (char currentChar : string.toCharArray()) {
            if (!encounteredCharacters.contains(currentChar)) {
                encounteredCharacters.add(currentChar);
            } else {
                longestSubstringSize = attemptToChangeLongest(longestSubstringSize, encounteredCharacters.size());
                encounteredCharacters.clear();
            }
        }
        if (!encounteredCharacters.isEmpty()) {
            longestSubstringSize = attemptToChangeLongest(longestSubstringSize, encounteredCharacters.size());
        }
        return longestSubstringSize;
    }

    private int attemptToChangeLongest(int currentLongest, int currentSize) {
        return Math.max(currentLongest, currentSize);
    }
}
