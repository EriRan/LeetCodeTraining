package fi.eriran.nsum;

import java.util.*;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique
 * triplets in the array which gives the sum of zero.
 * <p>
 * Note:
 * <p>
 * The solution set must not contain duplicate triplets.
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<>();
        }
        return findUniqueTriplets(Arrays.copyOf(nums, nums.length));
    }

    private List<List<Integer>> findUniqueTriplets(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> foundTriplets = new HashSet<>();
        Map<Integer, List<Integer>> hashMap = createHashMap(nums);
        Integer previousValue = null;
        for (int i = 0; i < nums.length; i++) {
            if (previousValue != null && nums[i] == previousValue) {
                continue;
            }
            foundTriplets.addAll(twoSum(nums, nums[i], i, hashMap));
            previousValue = nums[i];
        }
        return new ArrayList<>(foundTriplets);
    }

    private List<List<Integer>> twoSum(int[] nums, int target, int leftNumber, Map<Integer, List<Integer>> hashMap) {
        List<List<Integer>> twoSumTriplets = new ArrayList<>();
        Integer previousRightNumber = null;
        for (int rightNumber = nums.length - 1; rightNumber > leftNumber + 1; rightNumber--) {
            if (previousRightNumber != null && previousRightNumber == nums[rightNumber]) {
                continue;
            }
            Integer requiredNumber = -(nums[rightNumber] + target);
            Integer optionalRequiredValue = getRequiredValueIfAvailable(requiredNumber, leftNumber, rightNumber, hashMap);
            if (optionalRequiredValue != null) {
                twoSumTriplets.add(createSortedTriplet(target, requiredNumber, nums[rightNumber]));
            }
            previousRightNumber = nums[rightNumber];
        }
        return twoSumTriplets;
    }

    /**
     * Map of values and indexes they appear in
     */
    private Map<Integer, List<Integer>> createHashMap(int[] nums) {
        Map<Integer, List<Integer>> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> indexesThatContainValue = hashMap.get(nums[i]);
            if (indexesThatContainValue == null) {
                indexesThatContainValue = new ArrayList<>();
                indexesThatContainValue.add(i);
                hashMap.put(nums[i], indexesThatContainValue);
            } else {
                indexesThatContainValue.add(i);
            }

        }
        return hashMap;
    }

    private List<Integer> createSortedTriplet(int numberOne, Integer numberTwo, int numberThree) {
        List<Integer> newTriplet = Arrays.asList(numberOne, numberTwo, numberThree);
        newTriplet.sort(Integer::compareTo);
        return newTriplet;
    }

    private Integer getRequiredValueIfAvailable(Integer requiredNumber,
                                                int target,
                                                int rightNumber,
                                                Map<Integer, List<Integer>> hashMap) {
        List<Integer> potentialIndexes = hashMap.get(requiredNumber);
        if (potentialIndexes != null) {
            for (Integer potentialIndex : potentialIndexes) {
                if (potentialIndex != target && potentialIndex != rightNumber) {
                    return potentialIndex;
                }
            }
        }
        return null;
    }
}
