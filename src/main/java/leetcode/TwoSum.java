package leetcode;

import java.util.*;

public class TwoSum {
    public static void main(String[] args) {
        TwoSum s = new TwoSum();
        int[] in = new int[]{2, 7, 11, 15};
        int[] out = s.twoSum(in, 18);
        System.out.println(in[out[0]] + ", " + in[out[1]]);
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> set = new HashMap<>();
        for (int i = 0; i< nums.length; ++i) {
            if (set.containsKey(nums[i])) {
                return new int[] { i, set.get(nums[i]) };
            }
            set.put(target - nums[i], i);
        }
        return new int[]{-1, -1};
    }
}
