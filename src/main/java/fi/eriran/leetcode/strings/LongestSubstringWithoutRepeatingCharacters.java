package fi.eriran.leetcode.strings;

import java.util.HashMap;
import java.util.Map;

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
        Map<Character, Integer> encounteredCharacters = new HashMap<>();
        char[] charArray = string.toCharArray();
        for (int i = 0, charArrayLength = charArray.length; i < charArrayLength; i++) {
            char currentChar = charArray[i];
            if (!encounteredCharacters.containsKey(currentChar)) {
                encounteredCharacters.put(currentChar, i);
            } else {
                longestSubstringSize = attemptToChangeLongest(longestSubstringSize, encounteredCharacters.size());
                i = encounteredCharacters.get(currentChar);
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
