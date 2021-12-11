package leetcode.problems.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum/
 * 39. Combination Sum
 *
 * Given an array of distinct integers candidates and a target integer target,
 * return a list of all unique combinations of candidates where the chosen numbers sum to target.
 * You may return the combinations in any order.
 *
 * The same number may be chosen from candidates an unlimited number of times.
 * Two combinations are unique if the frequency of at least one of the chosen numbers is different.
 * It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
 *
 * https://leetcode.com/problems/permutations/discuss/18239/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partioning)
 *
 * Constraints:
    1 <= candidates.length <= 30
    1 <= candidates[i] <= 200
    All elements of candidates are distinct.
    1 <= target <= 500
 */
class Combination_Sum_39 {

    /**
     * Runtime: 2 ms, faster than 99.00%
     * Memory Usage: 39.2 MB, less than 72.66%
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<>();
        backtrack(result, new LinkedList<>(), candidates, target, 0, 0);
        return result;
    }

    void backtrack(List<List<Integer>> result, List<Integer> current, int[] candidates, int target, int sum, int start) {
        //if (sum > target) return;
        if (sum == target) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (sum + candidates[i] <= target) {
                current.add(candidates[i]);
                backtrack(result, current, candidates, target, sum + candidates[i], i);
                current.remove(current.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        Combination_Sum_39 c = new Combination_Sum_39();
        System.out.println(c.combinationSum(new int[]{2,3,6,7}, 7));
        System.out.println(c.combinationSum(new int[]{2,3,5}, 8));
    }
}