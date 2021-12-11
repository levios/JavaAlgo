package leetcode.problems.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets-ii/
 * 90. Subsets II
 *
 * Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 *
 * TAGS: backtrack ; back-track ; subset ; sub set
 */
public class Subsets_with_Duplicate_Input_90 {

    /**
     * Runtime: 2 ms, faster than 47.15%
     * Memory Usage: 40.7 MB, less than 22.34%
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
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
            if (i > start && nums[i] == nums[i-1]) continue; // skip duplicates
            current.add(nums[i]);
            int idx = current.size() - 1;
            // also increase start index
            backtrack(subsets, current, nums, i + 1);
            current.remove(idx);
        }
    }

    public static void main(String[] args) {
        Subsets_with_Duplicate_Input_90 s = new Subsets_with_Duplicate_Input_90();
        System.out.println(s.subsetsWithDup(new int[]{0}));
        System.out.println(s.subsetsWithDup(new int[]{1,2,2}));
    }
}
