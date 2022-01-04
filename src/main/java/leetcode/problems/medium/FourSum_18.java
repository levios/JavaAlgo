package leetcode.problems.medium;

import java.util.*;

/**
 * https://leetcode.com/problems/4sum/
 * >>> MEDIUM
 *
 */
public class FourSum_18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        // first sort
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> lists = threeSum(nums, target-nums[i], i);
            for (List<Integer> list: lists) {
                list.add(nums[i]);
            }
            for (List<Integer> list: lists) {
                Collections.sort(list);
            }
            result.addAll(lists);
        }
        return new ArrayList<>(result);
    }

    List<List<Integer>> threeSum(int[] nums, int target, int startIndex) {
        List<List<Integer>> result = new LinkedList<>();
        for (int i = startIndex+1; i < nums.length; i++) {
            List<List<Integer>> lists = twoSum(nums, target-nums[i], i);
            for (List<Integer> list : lists) {
                list.add(nums[i]);
            }
            result.addAll(lists);
        }
        return result;
    }

    List<List<Integer>> twoSum(int[] nums, int target, int startIndex) {
        List<List<Integer>> result = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        for (int i = startIndex+1; i < nums.length; i++) {
            if (set.contains(target-nums[i])) {
                result.add(new ArrayList<>(Arrays.asList(nums[i], target-nums[i])));
            } else {
                set.add(nums[i]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FourSum_18 app = new FourSum_18();
        System.out.println(app.fourSum(new int[]{1,0,-1,0,-2,2}, 0));
        System.out.println(app.fourSum(new int[]{2,2,2,2,2}, 8));
        System.out.println(app.fourSum(new int[]{2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2}, 8));
    }

}
