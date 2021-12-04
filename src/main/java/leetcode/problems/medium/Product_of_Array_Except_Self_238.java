package leetcode.problems.medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/product-of-array-except-self/
 * 238. Product of Array Except Self
 * Constraints:
 *  2 <= nums.length <= 105
 */
class Product_of_Array_Except_Self_238 {
    /**
     * Given numbers [2, 3, 4, 5], regarding the third number 4, the product of array except 4 is 2*3*5 which consists
     * of two parts: left 2*3 and right 5. The product is left*right.
     * We can get lefts and rights:
     *
     * Numbers:     2    3    4     5
     * Lefts:            2  2*3 2*3*4
     * Rights:  3*4*5  4*5    5
     *
     * Let’s fill the empty with 1:
     *
     * Numbers:     2    3    4     5
     * Lefts:       1    2  2*3 2*3*4
     * Rights:  3*4*5  4*5    5     1
     *
     * We can calculate lefts and rights in 2 loops. The time complexity is O(n).
     */
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] lefts = new int[n];
        int[] rights = new int[n];
        int[] res = new int[n];
        // Calculate lefts and store in res.
        int left = 1; // accumulate left product
        lefts[0] = 1;
        for (int i = 1; i < n; i++) {
            left = left * nums[i - 1];
            lefts[i] = left;
        }
        // Calculate rights and the product from the end of the array.
        int right = 1; // accumulate right product
        rights[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            right = right * nums[i + 1];
            rights[i] = right;
        }
        for (int i = 0; i < n; i++) {
            res[i] = rights[i] * lefts[i];
        }
        return res;
    }

    public static void main(String[] args) {
        Product_of_Array_Except_Self_238 app = new Product_of_Array_Except_Self_238();
        System.out.println(Arrays.toString(app.productExceptSelf(new int[]{1, 2, 3, 4})));
    }
}