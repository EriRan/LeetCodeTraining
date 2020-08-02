package fi.eriran.nsum;

import java.util.*;
import java.util.stream.Collectors;

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
        Set<Triplet> foundTriplets = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            twoSum(nums, nums[i], i + 1, foundTriplets);
        }
        return convertToListResponse(foundTriplets);
    }

    public void twoSum(int[] nums, int target, int startPoint, Set<Triplet> foundTriplets) {
        for (int i = startPoint; i < nums.length - 1; i++) {
            for (int j = nums.length - 1; j > startPoint && j > i; j--) {
                if (nums[i] + nums[j] + target == 0) {
                    //foundTriplets is a set to only unique triplets are added
                    Triplet triplet = new Triplet(target, nums[i], nums[j]);
                    foundTriplets.add(triplet);
                    break;
                }
            }
        }
    }

    private List<List<Integer>> convertToListResponse(Set<Triplet> foundTriplets) {
        return foundTriplets.stream()
                .map(triplet -> Arrays.asList(triplet.one, triplet.two, triplet.three))
                .collect(Collectors.toList());
    }

    static class Triplet implements Comparable<Triplet> {
        public final int one;
        public final int two;
        public final int three;

        public Triplet(int one, int two, int three) {
            List<Integer> tripletNumbers = Arrays.asList(one, two, three);
            tripletNumbers.sort(Integer::compareTo);
            this.one = tripletNumbers.get(0);
            this.two = tripletNumbers.get(1);
            this.three = tripletNumbers.get(2);
        }

        @Override
        public int compareTo(Triplet o) {
            int oneComparison = Integer.compare(this.one, o.one);
            if (oneComparison != 0) {
                return oneComparison;
            }
            int twoComparison = Integer.compare(this.two, o.two);
            if (twoComparison != 0) {
                return twoComparison;
            }
            return Integer.compare(this.three, this.three);
        }
    }
}
