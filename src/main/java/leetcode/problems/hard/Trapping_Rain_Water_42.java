package leetcode.problems.hard;

/**
 * 42. Trapping Rain Water
 * https://leetcode.com/problems/trapping-rain-water/
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it can trap after raining.
 * Constraints:
    n == height.length
    1 <= n <= 2 * 10^4
    0 <= height[i] <= 10^5
 */
public class Trapping_Rain_Water_42 {

    // dynamic programming
    public int trap(int[] height) {
        if (height.length == 0) return 0;
        int ans = 0;
        int size = height.length;
        int[] left_max = new int[size];
        int[] right_max = new int[size];
        left_max[0] = height[0];
        for (int i = 1; i < size; i++) {
            left_max[i] = Math.max(height[i], left_max[i - 1]);
        }
        right_max[size - 1] = height[size - 1];
        for (int i = size - 2; i >= 0; i--) {
            right_max[i] = Math.max(height[i], right_max[i + 1]);
        }
        for (int i = 1; i < size - 1; i++) {
            ans += Math.min(left_max[i], right_max[i]) - height[i];
        }
        return ans;
    }


    /**
     * Runtime: 2 ms, faster than 31.01%
     * Memory Usage: 41.9 MB, less than 15.87%
     */
    public int trap0(int[] height) {
        return trap_rec(height, 0, height.length-1);
    }
    /**
     * Divide and conquer
     * @param start left border, inclusive
     * @param end right border, inclusive
     * @return area
     */
    int trap_rec(int[] height, int start, int end) {
        while (start < height.length-1 && height[start+1] >= height[start]) start++;
        while (end >= 1 && height[end-1] >= height[end]) end--;
        if (end-start < 2) return 0;

        int min = Math.min(height[start], height[end]);

        int maxIdx = start+1;
        int max = height[start+1];
        for (int i = start+1; i < end; i++) {
            if (height[i] > max) {
                max = height[i];
                maxIdx = i;
            }
        }
        if (max <= min) {
            return calc(height, min, start, end);
        }
        return trap_rec(height, start, maxIdx) + trap_rec(height, maxIdx, end);
    }
    /**
     * calculate area between start and end (these are two)
     * start and end are guaranteed to be local maxes (there's a guarantee)
     */
    int calc(int[] heights, int height, int start, int end) {
        int width = end - start - 1;
        int area = height * width;
        for (int i = start+1; i < end; i++) {
            area -= heights[i];
        }
        return area;
    }

    public static void main(String[] args) {
        Trapping_Rain_Water_42 x = new Trapping_Rain_Water_42();
        System.out.println(x.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
        System.out.println(x.trap(new int[]{4,2,0,3,2,5}));
        System.out.println(x.trap(new int[]{5,5,4,7,8,2,6,9,4,5}));
    }
}
