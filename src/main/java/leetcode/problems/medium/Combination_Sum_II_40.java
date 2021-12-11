package leetcode.problems.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum-ii/
 * 40. Combination Sum II
 *
 * Given a collection of candidate numbers (candidates) and a target number (target), 
 * find all unique combinations in candidates where the candidate numbers sum to target.
 * Each number in candidates may only be used once in the combination.
 * Note: The solution set must not contain duplicate combinations.
 *
 * https://leetcode.com/problems/permutations/discuss/18239/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partioning)
 */
class Combination_Sum_II_40 {
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(nums);
        backtrack(result, new LinkedList<>(), nums, target, 0, 0);
        return result;
    }
    void backtrack(List<List<Integer>> result, List<Integer> current, int[] nums, int target, int sum, int start) {
        if (sum == target) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            // big idea: i > start
            if (sum + nums[i] > target || (i > start && nums[i] == nums[i-1]) ) continue;
            current.add(nums[i]);
            backtrack(result, current, nums, target, sum + nums[i], i+1);
            current.remove(current.size()-1);
        }
    }
    public static void main(String[] args) {
        Combination_Sum_II_40 s = new Combination_Sum_II_40();
        System.out.println(s.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));
    }
}
