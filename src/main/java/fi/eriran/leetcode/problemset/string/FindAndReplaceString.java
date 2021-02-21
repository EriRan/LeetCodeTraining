package fi.eriran.leetcode.problemset.string;

import java.util.*;

/**
 * To some string S, we will perform some replacement operations that replace groups of letters with new ones
 * (not necessarily the same size).
 * <p>
 * Each replacement operation has 3 parameters: a starting index i, a source word x and a target word y.  The rule is
 * that if x starts at position i in the original string S, then we will replace that occurrence of x with y.  If not,
 * we do nothing.
 * <p>
 * For example, if we have S = "abcd" and we have some replacement operation i = 2, x = "cd", y = "ffff", then because
 * "cd" starts at position 2 in the original string S, we will replace it with "ffff".
 * <p>
 * Using another example on S = "abcd", if we have both the replacement operation i = 0, x = "ab", y = "eee", as well as
 * another replacement operation i = 2, x = "ec", y = "ffff", this second operation does nothing because in the original
 * string S[2] = 'c', which doesn't match x[0] = 'e'.
 * <p>
 * All these operations occur simultaneously.  It's guaranteed that there won't be any overlap in replacement: for
 * example, S = "abc", indexes = [0, 1], sources = ["ab","bc"] is not a valid test case.
 */
public class FindAndReplaceString {

    public String findReplaceString(String string, int[] indexes, String[] sources, String[] targets) {
        validateParameters(string, indexes, sources, targets);
        return performFindAndReplace(string, indexes, sources, targets);
    }

    private void validateParameters(String string, int[] indexes, String[] sources, String[] targets) {
        if (string == null || indexes == null || sources == null || targets == null) {
            throw new IllegalArgumentException("Parameters may not be null");
        }
        if (indexes.length != sources.length
                || sources.length != targets.length) {
            throw new IllegalArgumentException("Arrays must be same size");
        }
        if (string.length() > 1000) {
            throw new IllegalArgumentException("Too long string");
        }
        for (int index : indexes) {
            if (index >= string.length()
                    || index < 0) {
                throw new IllegalArgumentException("Invalid index value: " + index);
            }
        }
    }

    private String performFindAndReplace(String string, int[] indexes, String[] sources, String[] targets) {
        Set<ReplaceCommand> replaceCommands = new TreeSet<>();
        for (int currentIndex = 0; currentIndex < indexes.length; currentIndex++) {
            int replaceStartPoint = indexes[currentIndex];
            String currentSource = sources[currentIndex];
            int indexOf = string.indexOf(currentSource, replaceStartPoint);
            if (indexOf == replaceStartPoint) {
                replaceCommands.add(new ReplaceCommand(currentIndex, replaceStartPoint + currentSource.length()));
            }
        }
        return buildStringFromOriginalAndReplaceCommands(
                string,
                indexes,
                targets,
                replaceCommands);
    }

    private String buildStringFromOriginalAndReplaceCommands(String string,
                                                             int[] indexes,
                                                             String[] targets,
                                                             Set<ReplaceCommand> endpointsAndIndexesToUse) {
        if (endpointsAndIndexesToUse.isEmpty()) {
            return string;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int currentOriginalStringIndex = 0;
        for (ReplaceCommand replaceCommand : endpointsAndIndexesToUse) {
            int startIndex = indexes[replaceCommand.indexUsed];
            if (currentOriginalStringIndex < startIndex) {
                stringBuilder.append(string, currentOriginalStringIndex, startIndex);
            }
            stringBuilder.append(targets[replaceCommand.indexUsed]);
            currentOriginalStringIndex = replaceCommand.endIndex;
        }
        //Append the rest from the original string that was not replaced
        if (currentOriginalStringIndex < string.length()) {
            stringBuilder.append(string.substring(currentOriginalStringIndex));
        }
        return stringBuilder.toString();
    }

    static class ReplaceCommand implements Comparable<ReplaceCommand> {
        int indexUsed;
        int endIndex;

        public ReplaceCommand(int indexUsed, int endIndex) {
            this.indexUsed = indexUsed;
            this.endIndex = endIndex;
        }

        @Override
        public int compareTo(ReplaceCommand o) {
            return Integer.compare(this.endIndex, o.endIndex);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ReplaceCommand that = (ReplaceCommand) o;
            return indexUsed == that.indexUsed &&
                    endIndex == that.endIndex;
        }

        @Override
        public int hashCode() {
            return Objects.hash(indexUsed, endIndex);
        }
    }
}
