package leetcode.problems.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/permutations-ii/
 * 47. Permutations II
 * https://leetcode.com/problems/permutations/discuss/18239/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partioning)
 *
 * Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
 * Constraints:
    1 <= nums.length <= 8
    -10 <= nums[i] <= 10
 */
class Permutations_II_47 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        boolean[] visited = new boolean[nums.length];
        backtrack(result, new ArrayList<>(nums.length), nums, visited);
        return result;
    }

    /**
     * Runtime: 2 ms, faster than 70.96%
     * Memory Usage: 39.3 MB, less than 96.72%
     */
    void backtrack(List<List<Integer>> result, List<Integer> current, int[] nums, boolean[] visited) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                if (i > 0 && nums[i-1] == nums[i] && visited[i-1])
                    continue;
                current.add(nums[i]);
                visited[i] = true;
                backtrack(result, current, nums, visited);
                current.remove(current.size() - 1);
                visited[i] = false;
            }
        }
    }

    /**
     * Runtime: 1 ms, faster than 99.45%
     * Memory Usage: 39.5 MB, less than 85.30%
     */
    private void backtrack0(List<List<Integer>> list, List<Integer> tempList, int [] nums, boolean [] used){
        if(tempList.size() == nums.length){
            list.add(new ArrayList<>(tempList));
        } else{
            for(int i = 0; i < nums.length; i++){
                if(used[i] || i > 0 && nums[i] == nums[i-1] && !used[i - 1]) continue;
                used[i] = true;
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, used);
                used[i] = false;
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Permutations_II_47 p = new Permutations_II_47();
        System.out.println(p.permuteUnique(new int[]{1,1,2}));
        System.out.println(p.permuteUnique(new int[]{1,3,2}));
    }
}