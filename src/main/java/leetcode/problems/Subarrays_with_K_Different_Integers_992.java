package leetcode.problems;

import java.util.*;

/**
 * https://leetcode.com/problems/subarrays-with-k-different-integers/
 *
 * Given an integer array nums and an integer k, return the number of good subarrays of nums.
 *
 * A good array is an array where the number of different integers in that array is exactly k.
 *
 * For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.
 * A subarray is a contiguous part of an array.
 *
 * Constraints:
 *      1 <= nums.length <= 2 * 10^4
 *      1 <= nums[i], k <= nums.length
 */
public class Subarrays_with_K_Different_Integers_992 {

    public int subarraysWithKDistinct(int[] nums, int k) {
        return helper(nums, k) - helper(nums, k-1);
    }

    public int helper(int[] nums, int k) {
        int count = 0;
        int x = 0;
        int y = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); // number -> counts in current streak
        int maxIdx = -1;
        while (y < nums.length) {
            if (y > maxIdx) {
                map.put(nums[y], map.getOrDefault(nums[y], 0) + 1);
                maxIdx = y;
            }
            if (map.size() <= k) {
                int len = y-x+1;
                count += len;
                y++;
            } else /* if (map.size() > k) */ {
                if (1 < map.get(nums[x])) {
                    map.put(nums[x], map.get(nums[x])-1 );
                } else {
                    map.remove(nums[x]);
                }
                x++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Subarrays_with_K_Different_Integers_992 s = new Subarrays_with_K_Different_Integers_992();

        System.out.println(s.subarraysWithKDistinct(new int[] {1,2,1,2,3}, 2)); // Output: 7
        System.out.println(s.subarraysWithKDistinct(new int[] {1,2,1,3,4}, 3)); // Output: 3
        System.out.println(s.subarraysWithKDistinct(new int[] {2,1,1,1,2}, 1)); // Output: 8
        System.out.println(s.subarraysWithKDistinct(new int[] {2,2,1,2,2,2,1,1}, 2)); // Output: 23
    }

    /**
     * Naive approach, also very slow
     */
    public int subarraysWithKDistinct0(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length - k + 1; i++) {
            Set<Integer> set = new HashSet<>(Collections.singletonList(nums[i]));
            if (k == 1) {
                count++;
            }
            for (int j = i + 1; j < nums.length; j++) {
                set.add(nums[j]);
                if (set.size() == k) {
                    count++;
                } else if (set.size() > k) {
                    // overflow
                    break;
                }
            }

        }
        return count;
    }

}
