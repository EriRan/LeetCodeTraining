package fi.eriran.leetcode.problemset.arrays.nsum;

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
                buildAuxiliary(Arrays.copyOf(nums, nums.length)));
    }

    private Map<Integer, List<Pair>> buildAuxiliary(int[] nums) {
        Map<Integer, List<Pair>> auxiliary = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length - 1; j > i; j--) {
                int sum = nums[i] + nums[j];
                List<Pair> pairsOfSum = auxiliary.computeIfAbsent(sum, integer -> new ArrayList<>());
                pairsOfSum.add(new Pair(nums[i], nums[j], i, j));
            }
        }
        return auxiliary;
    }

    private ArrayList<List<Integer>> findQuadruplets(int target, Map<Integer, List<Pair>> auxiliary) {
        if (auxiliary == null || auxiliary.isEmpty()) {
            return new ArrayList<>();
        }
        Set<List<Integer>> foundQuadruplets = new HashSet<>();
        Set<Map.Entry<Integer, List<Pair>>> entries = auxiliary.entrySet();
        entries.forEach(entry ->
                entry.getValue()
                        .forEach(iteratedPair -> {
                            int requiredSum = target - entry.getKey();
                            List<Pair> pairsWithRequiredSum = auxiliary.get(requiredSum);
                            if (pairsWithRequiredSum == null) {
                                return;
                            }
                            pairsWithRequiredSum.stream()
                                    .filter(potentialPair -> !pairsAreUsingSameIndexes(iteratedPair, potentialPair))
                                    .forEach(validPair -> {
                                        List<Integer> potentialQuadruplet = Arrays.asList(
                                                iteratedPair.firstValue,
                                                iteratedPair.secondValue,
                                                validPair.firstValue,
                                                validPair.secondValue);
                                        potentialQuadruplet.sort(Integer::compareTo);
                                        foundQuadruplets.add(potentialQuadruplet);
                                    });
                        }));
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

        public Pair(int firstValue, int secondValue, int firstIndex, int secondIndex) {
            this.firstValue = firstValue;
            this.secondValue = secondValue;
            this.firstIndex = firstIndex;
            this.secondIndex = secondIndex;
        }
    }
}
