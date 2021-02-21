package fi.eriran.leetcode.problemset.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        //Sort into a collection based on the first int in the inner array
        List<int[]> sortedArrayEntries = sortIntoListByFirstEntry(intervals);
        //Temporary variables
        List<int[]> unconvertedResults = new ArrayList<>();
        int[] previousEntry = null;

        //Iterate through the array entries. Keep storing the previous one. Previous one holds the combined entries
        // so far
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
        //Was the last previousEntry added?
        //If the results are empty, it was not added.
        //If the last entry in the results is equal to the previous, then it was added
        if (unconvertedResults.isEmpty()
                || !Arrays.equals(unconvertedResults.get(unconvertedResults.size() - 1), previousEntry)) {
            unconvertedResults.add(previousEntry);
        }
        return convertIntoResponseArray(unconvertedResults);
    }

    private List<int[]> sortIntoListByFirstEntry(int[][] intervals) {
        return Arrays.stream(intervals)
                .sorted(Comparator.comparingInt(arrayEntry -> arrayEntry[0]))
                .collect(Collectors.toList());
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
