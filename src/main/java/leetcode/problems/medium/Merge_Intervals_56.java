package leetcode.problems.medium;

import java.util.*;

/**
 * https://leetcode.com/problems/merge-intervals/
 * 56. Merge Intervals
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
 * and return an array of the non-overlapping intervals that cover all the intervals in the input.
 * Constraints:
 *
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
 */
public class Merge_Intervals_56 {

    /**
     * Runtime: 8 ms, faster than 27.00%
     * Memory Usage: 41.7 MB, less than 68.19%
     */
    public int[][] merge(int[][] intervals) {
        Arrays.sort(
                intervals,
                Comparator.comparingInt((int[] a) -> a[0]).thenComparingInt(a -> a[1])
        );
        int counter = intervals.length;
        for (int i = 0; i < intervals.length-1; i++) {
            int[] a = intervals[i];
            int[] b = intervals[i+1];
            if (a[1] >= b[0]) {
                b[0] = a[0];
                b[1] = Math.max(a[1], b[1]);
                // set it to -1 to denote removed interval
                a[0] = -1;
                counter--;
            }
        }
        int[][] result = new int[counter][2];
        int idx = 0;
        for (int[] interval : intervals) {
            if (interval[0] != -1) {
                result[idx++] = interval;
            }
        }
        return result;
    }
}
