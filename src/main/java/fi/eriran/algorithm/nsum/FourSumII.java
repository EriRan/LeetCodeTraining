package fi.eriran.algorithm.nsum;

import java.util.*;

/**
 * Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) there are such that
 * A[i] + B[j] + C[k] + D[l] is zero.
 * <p>
 * To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500. All integers are in the range
 * of -228 to 228 - 1 and the result is guaranteed to be at most 231 - 1.
 */
public class FourSumII {

    public int fourSumCount(int[] a, int[] b, int[] c, int[] d) {
        validateInput(a, b, c, d);
        Map<Integer, List<Pair>> abAuxiliaryMap = createAuxiliaryMap(a, b);
        Map<Integer, List<Pair>> cdAuxiliaryMap = createAuxiliaryMap(c, d);
        if (abAuxiliaryMap.size() >= cdAuxiliaryMap.size()) {
            return findQuadruplets(
                    abAuxiliaryMap,
                    cdAuxiliaryMap
            );
        } else {
            return findQuadruplets(
                    cdAuxiliaryMap,
                    abAuxiliaryMap
            );
        }
    }

    private Map<Integer, List<Pair>> createAuxiliaryMap(int[] arrayOne,
                                                        int[] arrayTwo) {
        Map<Integer, List<Pair>> auxiliaryMap = new HashMap<>();
        for (int i = 0; i < arrayOne.length; i++) {
            for (int j = 0; j < arrayTwo.length; j++) {
                int sum = arrayOne[i] + arrayTwo[j];
                List<Pair> pairsWithSum = auxiliaryMap.computeIfAbsent(sum, integer -> new ArrayList<>());
                pairsWithSum.add(new Pair(i, j));
            }
        }
        return auxiliaryMap;
    }

    private int findQuadruplets(Map<Integer, List<Pair>> outerAuxiliary,
                                Map<Integer, List<Pair>> innerAuxiliary) {
        if (outerAuxiliary == null || outerAuxiliary.isEmpty()) {
            return 0;
        }
        int foundQuadruplets = 0;
        for (Map.Entry<Integer, List<Pair>> entry : outerAuxiliary.entrySet()) {
            Integer sum = entry.getKey();
            List<Pair> outerPairs = entry.getValue();
            List<Pair> innerPairs = innerAuxiliary.get(-sum);
            if (innerPairs != null && !innerPairs.isEmpty()) {
                foundQuadruplets += innerPairs.size() * outerPairs.size();
            }
        }
        return foundQuadruplets;
    }

    private void validateInput(int[] a, int[] b, int[] c, int[] d) {
        if (a == null || b == null || c == null || d == null) {
            throw new IllegalArgumentException("None of the arrays may be null");
        } else if (a.length != b.length
                || b.length != c.length
                || c.length != d.length) {
            throw new IllegalArgumentException("All arrays must have the same length");
        } else if (a.length > 500) {
            throw new IllegalArgumentException("Array length has to be between 0 and 500 (inclusive)");
        }
    }

    static class Pair {
        final int firstIndex;
        final int secondIndex;

        public Pair(int firstIndex, int secondIndex) {
            this.firstIndex = firstIndex;
            this.secondIndex = secondIndex;
        }
    }
}
