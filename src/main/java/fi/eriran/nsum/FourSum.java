package fi.eriran.nsum;

import java.util.*;

/**
 * Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such
 * that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 * <p>
 * Note:
 * <p>
 * The solution set must not contain duplicate quadruplets.
 */
public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        return findQuadruplets(
                target,
                buildAuxiliary(createSortedCopy(nums)));
    }

    private int[] createSortedCopy(int[] nums) {
        int[] numsCopy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(numsCopy);
        return numsCopy;
    }

    private List<Pair> buildAuxiliary(int[] numsCopy) {
        List<Pair> auxiliary = new ArrayList<>();
        for (int i = 0; i < numsCopy.length; i++) {
            for (int j = numsCopy.length - 1; j > i; j--) {
                auxiliary.add(new Pair(numsCopy[i], numsCopy[j], i, j));
            }
        }
        return auxiliary;
    }

    private ArrayList<List<Integer>> findQuadruplets(int target, List<Pair> auxiliary) {
        if (auxiliary == null || auxiliary.isEmpty()) {
            return new ArrayList<>();
        }
        Set<List<Integer>> foundQuadruplets = new HashSet<>();
        Integer previousSumOne = null;
        for (int i = 0; i < auxiliary.size(); i++) {
            Pair pairOne = auxiliary.get(i);
            if (previousSumOne != null && previousSumOne == pairOne.sum) {
                continue;
            }
            for (int j = auxiliary.size() - 1; j > i; j--) {
                Pair pairTwo = auxiliary.get(j);
                if (pairsAreUsingSameIndexes(pairOne, pairTwo)) {
                    continue;
                }
                if (pairOne.sum + pairTwo.sum == target) {
                    List<Integer> potentialQuadruplet = Arrays.asList(
                            pairOne.firstValue,
                            pairOne.secondValue,
                            pairTwo.firstValue,
                            pairTwo.secondValue);
                    potentialQuadruplet.sort(Integer::compareTo);
                    foundQuadruplets.add(potentialQuadruplet);
                }
            }
            previousSumOne = pairOne.sum;
        }
        return new ArrayList<>(foundQuadruplets);
    }

    private boolean pairsAreUsingSameIndexes(Pair pairOne, Pair pairTwo) {
        return pairOne.firstIndex == pairTwo.firstIndex
                || pairOne.firstIndex == pairTwo.secondIndex
                || pairOne.secondIndex == pairTwo.firstIndex
                || pairOne.secondIndex == pairTwo.secondIndex;
    }

    static class Pair {
        final int firstValue;
        final int secondValue;
        final int firstIndex;
        final int secondIndex;
        final int sum;

        public Pair(int firstValue, int secondValue, int firstIndex, int secondIndex) {
            this.firstValue = firstValue;
            this.secondValue = secondValue;
            this.firstIndex = firstIndex;
            this.secondIndex = secondIndex;
            sum = firstValue + secondValue;
        }
    }
}
