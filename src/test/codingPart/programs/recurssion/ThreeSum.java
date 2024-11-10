package codingPart.programs.recurssion;

import codingPart.programs.basicJava.annotions.Information;

import java.util.*;

public class ThreeSum {

    public static int count = 0;

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>();
        findTriplets(nums, result, new ArrayList<>(), 0, -4);
//        Set<List<Integer>> triplets = threeSum(nums);
//        for (List<Integer> triplet : triplets) {
//            System.out.println(triplet);
//        }
    }

    private static void findTriplets(int[] nums, Set<List<Integer>> result, List<Integer> current, int start, int target) {
        System.out.println("Running for count=" + count+++" current"+ current);
        if (current.size() == 3) {
            if (target == 0) {
                System.out.println(current);
                result.add(new ArrayList<>(current));
            }
            return;
        }

        for (int i = start; i < nums.length; i++) {
//            if (i > start && nums[i] == nums[i - 1]) continue; // Skip duplicates
            if (current.contains(nums[i])  ) continue; // Skip duplicates
            current.add(nums[i]);
            findTriplets(nums, result, current, i + 1, target - nums[i]);
            current.remove(current.size() - 1); // Backtrack
        }
    }


}
