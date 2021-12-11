package leetcode.problems.medium;

import java.util.*;

/**
 * https://leetcode.com/problems/subsets/
 * 78. Subsets
 *
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 *
 * TAGS: backtrack ; back-track ; subset ; sub set
 */
public class Subsets_78 {

    /**
     * Runtime: 1 ms, faster than 62.29%
     * Memory Usage: 39.2 MB, less than 68.89%
     */
    public List<List<Integer>> subsets(int[] nums) {
        // very important to sort first, because we need some order to avoid duplicates
        Arrays.sort(nums);
        List<List<Integer>> subsets = new LinkedList<>();
        // we start with 0 and only take indices into the current list that are bigger than this this index
        backtrack(subsets, new LinkedList<>(), nums, 0);
        return subsets;
    }

    void backtrack(List<List<Integer>> subsets, List<Integer> current, int[] nums, int start) {
        subsets.add(new ArrayList<>(current));
        // index starts from start parameter
        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);
            int idx = current.size() - 1;
            // also increase start index
            backtrack(subsets, current, nums, i + 1);
            current.remove(idx);
        }
    }

    public static void main(String[] args) {
        Subsets_78 s = new Subsets_78();
        //System.out.println(s.subsets(new int[]{0}));
        System.out.println(s.subsets(new int[]{1,2,3}));
    }
}
