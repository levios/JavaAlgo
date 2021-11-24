package leetcode.problems.medium;

import java.util.Arrays;

/**
 * 16. 3Sum Closest
 * https://leetcode.com/problems/3sum-closest/
 *
 * Given an integer array of length n and an integer target, find three integers in nums such that the sum is closest to target.
 * Return the sum of the three integers.
 *
 * Constraints:
        3 <= nums.length <= 1000

 * TAGS:
 */
public class ThreeSum_Closest_16 {

    // Runtime: 6 ms, faster than 55.15%
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        int ret = 0;
        outer: for (int i = 0;  i < nums.length; ++i) {
            int k = i+1;
            int j = nums.length-1;
            while (k < j) {
                int sum = nums[i]+nums[k]+nums[j];
                int diff = Math.abs(target - sum);
                if (minDiff > diff) {
                    minDiff = diff;
                    ret = sum;
                }
                if (minDiff == 0) break outer;
                if (sum > target){
                    j--;
                } else {
                    k++;
                }
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        ThreeSum_Closest_16 app = new ThreeSum_Closest_16();
        System.out.println(app.threeSumClosest(new int[]{-1,2,1,-4}, 1));   // 2
        System.out.println(app.threeSumClosest(new int[]{0,0,0}, 1));       // 0
        System.out.println(app.threeSumClosest(new int[]{1,1,1,0}, -100));       // 2
    }
}
