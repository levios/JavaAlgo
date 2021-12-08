package leetcode.problems.easy;

import java.util.*;

/**
 * https://leetcode.com/problems/maximum-product-of-three-numbers/submissions/
 * 628. Maximum Product of Three Numbers
 */
public class Maximum_Product_of_Three_Numbers_628 {

    /**
     * Runtime: 9 ms, faster than 65.93%
     * Memory Usage: 40.4 MB, less than 79.09%
     */
    public int maximumProduct(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        return Math.max(nums[len-1] * nums[len-2] * nums[len-3], nums[0] * nums[1] * nums[len-1]);
    }

    public static void main(String[] args) {
        Maximum_Product_of_Three_Numbers_628 app = new Maximum_Product_of_Three_Numbers_628();
        System.out.println(app.maximumProduct(new int[]{1,2,3}));
    }
}
