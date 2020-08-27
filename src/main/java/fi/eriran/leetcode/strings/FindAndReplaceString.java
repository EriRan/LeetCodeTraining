package fi.eriran.leetcode.strings;

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
                && sources.length != targets.length) {
            throw new IllegalArgumentException("Arrays must be same size");
        }
        if (string.length() > 1000) {
            throw new IllegalArgumentException("Too long string");
        }
        for (int index : indexes) {
            if (index >= string.length()
                    || index < 0) {
                throw new IllegalArgumentException("Invalid index value");
            }
        }
    }

    private String performFindAndReplace(String string, int[] indexes, String[] sources, String[] targets) {
        //Combined solution of
        //replaced indexes, would be better to do this as remaining indexes
        //Replace commands
        //Replace commands are: start and end indexes of the original
        //These need to be sorted according to the starting index
        Collection<ReplaceCommand> replaceCommands = new TreeSet<>();
        for (int currentIndex = 0; currentIndex < indexes.length; currentIndex++) {
            int replaceStartPoint = indexes[currentIndex];
            String substring = string.substring(replaceStartPoint);
            String currentSource = sources[currentIndex];
            String currentTarget = targets[currentIndex];
            //Try to find an occurrance
            //Try to find next occurrance
            //Loop until no occurrance is found
            //Replaced indexes are ignored

            //Try to find source
            int indexOf = substring.indexOf(currentSource);
            while (indexOf != -1) {
                int startIndex = indexOf + replaceStartPoint;
                replaceCommands.add(
                        new ReplaceCommand(
                                startIndex,
                                startIndex + currentSource.length(),
                                currentTarget
                        )
                );
                //Search next occurrence from the start of the last unless its impossible
                if (startIndex + currentSource.length() > substring.length()) {
                    break;
                }
                substring = substring.substring(startIndex + currentSource.length());
                indexOf = substring.indexOf(currentSource);
            }
        }
        return buildStringFromOriginalAndReplaceCommands(string, replaceCommands);
    }

    private String buildStringFromOriginalAndReplaceCommands(String string,
                                                             Collection<ReplaceCommand> replaceCommands) {
        if (replaceCommands.isEmpty()) {
            return string;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int currentOriginalStringIndex = 0;
        for (ReplaceCommand replaceCommand : replaceCommands) {
            if (currentOriginalStringIndex < replaceCommand.startIndex) {
                stringBuilder.append(string, currentOriginalStringIndex, replaceCommand.startIndex);
            }
            stringBuilder.append(replaceCommand.string);
            currentOriginalStringIndex = replaceCommand.endIndex;
        }
        //Append the rest from the original string that was not replaced
        if (currentOriginalStringIndex < string.length()) {
            stringBuilder.append(string.substring(currentOriginalStringIndex));
        }
        return stringBuilder.toString();
    }

    static class ReplaceCommand implements Comparable<ReplaceCommand> {
        //inclusive
        int startIndex;
        //exclusive
        int endIndex;
        String string;

        public ReplaceCommand(int startIndex, int endIndex, String string) {
            this.startIndex = startIndex;
            this.endIndex = endIndex;
            this.string = string;
        }

        @Override
        public int compareTo(ReplaceCommand o) {
            return Integer.compare(this.startIndex, o.startIndex);
        }

        //It is stated in the problem description that we will not run into overlapping replaces
        //This means that we will not run into sitations where we have two of the same startIndexes
        //Treeset uses compareTo to deduce whether objects are equal so we will never run into situation
        //where we can not lose a replace command because they have the same startIndex but different endIndex
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ReplaceCommand that = (ReplaceCommand) o;
            return startIndex == that.startIndex &&
                    endIndex == that.endIndex &&
                    Objects.equals(string, that.string);
        }

        @Override
        public int hashCode() {
            return Objects.hash(startIndex, endIndex, string);
        }
    }

}
