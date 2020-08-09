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

    private static final int TARGET = 0;

    public int fourSumCount(int[] a, int[] b, int[] c, int[] d) {
        validateInput(a, b, c, d);
        return findQuadruplets(
                createAuxiliaryList(a, b),
                createAuxiliaryList(c, d)
        );
    }

    private List<Integer> createAuxiliaryList(int[] arrayOne,
                                              int[] arrayTwo) {
        List<Integer> sumList = new ArrayList<>();
        for (int j : arrayOne) {
            for (int k : arrayTwo) {
                sumList.add(j + k);
            }
        }
        return sumList;
    }

    private int findQuadruplets(List<Integer> abAuxiliaryList,
                                List<Integer> cdAuxiliaryList) {
        if (abAuxiliaryList == null || abAuxiliaryList.isEmpty()) {
            return 0;
        }
        int foundQuadruplets = 0;
        for (Integer abSum : abAuxiliaryList) {
            for (Integer cdSum : cdAuxiliaryList) {
                if (abSum + cdSum == TARGET) {
                    foundQuadruplets++;
                }
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
}
