package leetcode.problems.medium;

import java.util.*;

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

    /// iterative below

    List<List<Integer>> combinationSumIterative(int[] candidates, int target) {
        // sort candidates to try them in asc order
        Arrays.sort(candidates);
        // dp[t] stores all combinations that add up to t
        List<List<Integer>>[] dp = new List[target+1];

        // build up dp
        for (int t=0; t<=target; t++) {
            // initialize
            dp[t] = new ArrayList<>();
            // initialize
            List<List<Integer>> combList = new ArrayList<>();

            // for each t, find possible combinations
            for (int j=0; j<candidates.length && candidates[j] <= t; j++) {
                if (candidates[j] == t) {
                    combList.add(Arrays.asList(candidates[j])); // itself can form a list
                } else {
                    for(List<Integer> prevlist: dp[t-candidates[j]]) { // here use our dp definition
                        // i thought it makes more sense to compare with the last element
                        // only add to list when the candidates[j] >= the last element
                        // so the list remains ascending order, can prevent duplicate (ex. has [2 3 3], no [3 2 3])
                        // equal is needed since we can choose the same element many times
                        if(candidates[j] >= prevlist.get(prevlist.size()-1)){
                            List<Integer> temp = new ArrayList<>(prevlist); // temp is needed since
                            temp.add(candidates[j]); // cannot edit prevlist inside 4eeach looop
                            combList.add(temp);
                        }
                    }
                }
            }
            dp[t] = combList;
        }
        return dp[target];
    }
}