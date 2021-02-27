package fi.eriran.leetcode.problemset.string;

import java.util.List;

/**
 * A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words such that:
 * <p>
 * - The first word in the sequence is beginWord.
 * - The last word in the sequence is endWord.
 * - Only one letter is different between each adjacent pair of words in the sequence.
 * - Every word in the sequence is in wordList.
 * <p>
 * Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the
 * shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.
 */
public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (validateParameters(beginWord, endWord, wordList)) {
            return 0;
        }
        //I really don't understand this, but example seems to have this as a condition. Adjacency doesn't seem to
        // matter for it.
        if (!wordList.contains(endWord)) {
            return 0;
        }

        return followSequence(beginWord, endWord, wordList, 0);
    }

    private int followSequence(String beginWord, String endWord, List<String> wordList, int startPoint) {
        boolean firstIteration = true;
        int shortestFound = 0;
        for (int i = startPoint; i < wordList.size(); i++) {
            if (firstIteration) {
                firstIteration = false;
                if (!isOnlyOneCharacterDifferent(beginWord, wordList.get(i))) {
                    return 0;
                }
                //Length is now the beginWord + the first iterated word from wordList
                shortestFound += 2;
            } else {
                //Is the current word close enough to endWord? If it is, stop here
                if (isOnlyOneCharacterDifferent(wordList.get(i), endWord)) {
                    //Current word + end word
                    shortestFound += 2;
                    return shortestFound;
                }
                //Is the current word close enough to the previos word? If it is, increment shortestFound int
                if (!isOnlyOneCharacterDifferent(wordList.get(i - 1), wordList.get(i))) {
                    return 0;
                }
                shortestFound++;
            }
        }
        return shortestFound;
    }

    private boolean isOnlyOneCharacterDifferent(String wordOne, String wordTwo) {
        boolean hasOnlyOneDifferentCharacter = false;
        for (int i = 0; i < wordOne.length(); i++) {
            boolean areCharactersDifferent = wordOne.charAt(i) != wordTwo.charAt(i);
            if (hasOnlyOneDifferentCharacter) {
                if (areCharactersDifferent) {
                    return false;
                }
            } else {
                if (areCharactersDifferent) {
                    hasOnlyOneDifferentCharacter = true;
                }
            }
        }
        return hasOnlyOneDifferentCharacter;
    }

    private boolean validateParameters(String beginWord, String endWord, List<String> wordList) {
        return beginWord == null || endWord == null || wordList == null || wordList.isEmpty();
    }
}
