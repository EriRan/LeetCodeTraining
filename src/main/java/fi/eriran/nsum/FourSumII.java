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
                createAuxiliaryCollection(a, b),
                createAuxiliaryCollection(c, d));
    }

    private Collection<Integer> createAuxiliaryCollection(int[] arrayOne, int[] arrayTwo) {
        Collection<Integer> sumCollection = new ArrayList<>();
        for (int j : arrayOne) {
            for (int k : arrayTwo) {
                sumCollection.add(j + k);
            }
        }
        return sumCollection;
    }

    /**
     * Set to just store the fact if a sum is contained in the two arrays. It is faster to search from a set than to
     * iterate a whole collection
     */
    private Set<Integer> createAuxiliarySet(int[] arrayOne, int[] arrayTwo) {
        Set<Integer> sumCollection = new HashSet<>();
        for (int i : arrayOne) {
            for (int j : arrayTwo) {
                sumCollection.add(i + j);
            }
        }
        return sumCollection;
    }

    private int findQuadruplets(Collection<Integer> abAuxiliaryCollection,
                                Collection<Integer> cdAuxiliaryCollection) {
        if (abAuxiliaryCollection == null || abAuxiliaryCollection.isEmpty()) {
            return 0;
        }
        int foundQuadruplets = 0;
        for (Integer abSum : abAuxiliaryCollection) {
            for (Integer cdSum : cdAuxiliaryCollection) {
                if (abSum + cdSum == 0) {
                    foundQuadruplets++;
                }
            }
        }
        return foundQuadruplets;
    }

    private boolean containsTargetValue(Collection<Integer> cdAuxiliary, Integer abSum) {
        return cdAuxiliary.contains(-abSum);
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
