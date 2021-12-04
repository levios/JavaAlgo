package leetcode.problems.medium;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/maximum-product-subarray/
 * 152. Maximum Product Subarray
 *
 * Given an integer array nums, find a contiguous non-empty subarray within the array
 * that has the largest product, and return the product.
 * It is guaranteed that the answer will fit in a 32-bit integer.
 * A subarray is a contiguous subsequence of the array.
 */
public class Maximum_Product_Subarray_152 {

    /**
     * Facts:
     *   0 makes product to 0, so we should avoid it -> split it maybe ?
     *   negative numbers need to be even
     *   makes sense to include as many numbers as we can as long as the answer is positive
     */


    /**
     * Runtime: 3 ms, faster than 25.70%
     * Memory Usage: 39.2 MB, less than 35.34%
     */
    public int maxProduct(int[] nums) {
        System.out.println("Checking: " + Arrays.stream(nums).boxed().collect(Collectors.toList()));
        int max = Integer.MIN_VALUE;
        if (nums.length < 1) return max;
        if (nums.length == 1) return nums[0];

        List<Integer> negatives = new ArrayList<>();
        Set<Integer> zeros = new TreeSet<>();

        int positiveProd = 1;
        // O(n)
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeros.add(i);
                positiveProd = 1;
                max = Math.max(max, 0);
            }
            else if (nums[i] < 0) {
                negatives.add(i);
                positiveProd = 1;
                max = Math.max(max, nums[i]);
            }
            else {
                positiveProd *= nums[i];
                max = Math.max(max, positiveProd);
            }
        }

        if (zeros.isEmpty() && negatives.isEmpty())
            return max;

        if (!zeros.isEmpty()) {
            int startIdx = 0;
            // now we need to split the array by the 0's
            zeros.add(nums.length); //let's add a final zero so that the last interval is processed as well
            for (int zero : zeros) {
                max = Math.max(
                        max,
                        maxProduct(Arrays.copyOfRange(nums, startIdx, zero))
                );
                startIdx = zero+1;
            }
        } else { // there are negatives but no zeros

            // we just need to consider intervals where count of negatives inside is even
            if (negatives.size() % 2 == 1) {
                return Math.max(
                        prodBetween(nums, 0, negatives.get(negatives.size() - 1) - 1),
                        prodBetween(nums, negatives.get(0) + 1, nums.length - 1)
                );
            } else {
                return prodBetween(nums, 0, nums.length - 1);
            }
        }

        return max;
    }

    // O(n)
    int prodBetween(int[] nums, int startInclusive, int endInclusive) {
        if (startInclusive > endInclusive) return Integer.MIN_VALUE;
        int prod = 1;
        for (int i = startInclusive; i <= endInclusive; i++) {
            prod *= nums[i];
        }
        return prod;
    }

    public static void main(String[] args) {
        Maximum_Product_Subarray_152 app = new Maximum_Product_Subarray_152();
        System.out.println(app.maxProduct(new int[]{2,3,-2,4}));
        System.out.println(app.maxProduct(new int[]{-2,0,-1}));
        System.out.println(app.maxProduct(new int[]{-2,-1}));
        System.out.println(app.maxProduct(new int[]{-2,3,-3,2,-1}));
        System.out.println(app.maxProduct(new int[]{3,-1,4}));
        System.out.println(app.maxProduct(new int[]{1,0,-1,2,3,-5,-2}));
        System.out.println(app.maxProduct(new int[]{-3,-1,3,5,-6,-6,-1,6,-3,-5,1,0,-6,-5,0,-2,6,1,0,5})); // 48600
    }

}
