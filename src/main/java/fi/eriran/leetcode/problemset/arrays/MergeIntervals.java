package fi.eriran.leetcode.problemset.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        //Sort into a collection
        List<int[]> sortedArrayEntries = Arrays.stream(intervals)
                .sorted(Comparator.comparingInt(arrayEntryOne -> arrayEntryOne[0]))
                .collect(Collectors.toList());
        List<int[]> unconvertedResults = new ArrayList<>();

        int[] previousEntry = null;

        for (int[] currentArrayEntry : sortedArrayEntries) {
            if (previousEntry == null) {
                previousEntry = currentArrayEntry;
            } else {
                //Is there an overlap?
                if (previousEntry[0] <= currentArrayEntry[0] && previousEntry[1] >= currentArrayEntry[0]) {
                    //Get the larger endpoint
                    int largerEndpoint = Math.max(previousEntry[1], currentArrayEntry[1]);
                    previousEntry = new int[]{previousEntry[0], largerEndpoint};
                } else {
                    //If not, add the two into results
                    unconvertedResults.add(previousEntry);
                    previousEntry = currentArrayEntry;
                }
            }
        }
        //Was the last entry added?
        if (unconvertedResults.isEmpty()
                || !Arrays.equals(unconvertedResults.get(unconvertedResults.size() - 1), previousEntry)) {
            unconvertedResults.add(previousEntry);
        }
        return convertIntoResponseArray(unconvertedResults);
    }

    private int[][] convertIntoResponseArray(List<int[]> unconvertedResults) {
        int[][] responseArray = new int[unconvertedResults.size()][2];
        for (int i = 0; i < unconvertedResults.size(); i++) {
            int[] entry = unconvertedResults.get(i);
            responseArray[i][0] = entry[0];
            responseArray[i][1] = entry[1];
        }
        return responseArray;
    }
}
