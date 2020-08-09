package fi.eriran.nsum;

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
        return findQuadruplets(
                createAuxiliary(a, b),
                createAuxiliary(c, d));
    }

    private int findQuadruplets(Map<Integer, List<Pair>> abAuxiliary,
                                Map<Integer, List<Pair>> cdAuxiliary) {
        if (abAuxiliary == null || abAuxiliary.isEmpty()) {
            return 0;
        }
        Set<List<Integer>> foundQuadruplets = new HashSet<>();
        abAuxiliary.forEach((abSum, abPairs) -> {
            int requiredValue = -abSum;
            List<Pair> validCdPairs = cdAuxiliary.get(requiredValue);
            if (validCdPairs == null) {
                return;
            }
            abPairs.forEach(validAbPair ->
                    validCdPairs.forEach(
                            validCdPair -> {
                                List<Integer> potentialQuadruplet = Arrays.asList(
                                        validAbPair.firstIndex,
                                        validAbPair.secondIndex,
                                        validCdPair.firstIndex,
                                        validCdPair.secondIndex);
                                //No sorting this time because the order must be a,b,c,d
                                foundQuadruplets.add(potentialQuadruplet);
                            }
                    ));
        });
        return foundQuadruplets.size();
    }

    private Map<Integer, List<Pair>> createAuxiliary(int[] arrayOne, int[] arrayTwo) {
        Map<Integer, List<Pair>> auxiliaryMap = new HashMap<>();
        for (int i = 0; i < arrayOne.length; i++) {
            for (int j = 0; j < arrayTwo.length; j++) {
                int sum = arrayOne[i] + arrayTwo[j];
                List<Pair> pairsOfSum = auxiliaryMap.computeIfAbsent(sum, integer -> new ArrayList<>());
                pairsOfSum.add(new Pair(arrayOne[i], arrayTwo[j], i, j));
            }
        }
        return auxiliaryMap;
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
        final int sum;

        public Pair(int firstValue, int secondValue, int firstIndex, int secondIndex) {
            sum = firstValue + secondValue;
            this.firstIndex = firstIndex;
            this.secondIndex = secondIndex;
        }
    }
}
