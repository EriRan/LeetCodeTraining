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
        List<Integer> abAuxiliary = createPrimaryAuxiliaryList(a, b);
        List<Integer> cdAuxiliary = createSecondaryAuxiliaryList(c,d, abAuxiliary);
        return findQuadruplets(
                abAuxiliary,
                cdAuxiliary
        );
    }

    private List<Integer> createPrimaryAuxiliaryList(int[] arrayOne,
                                                     int[] arrayTwo) {
        List<Integer> sumList = new ArrayList<>();
        for (int j : arrayOne) {
            for (int k : arrayTwo) {
                sumList.add(j + k);
            }
        }
        return sumList;
    }

    private List<Integer> createSecondaryAuxiliaryList(int[] arrayOne, int[] arrayTwo, List<Integer> primaryAuxiliary) {
        if (primaryAuxiliary == null || primaryAuxiliary.isEmpty()) {
            return new ArrayList<>();
        }
        primaryAuxiliary.sort(Integer::compareTo);
        int min = primaryAuxiliary.get(primaryAuxiliary.size() - 1);
        int max = primaryAuxiliary.get(0);
        List<Integer> sumList = new ArrayList<>();
        for (int j : arrayOne) {
            for (int k : arrayTwo) {
                int sum = j + k;
                if (sum >= min || sum <= max) {
                    sumList.add(sum);
                }
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
