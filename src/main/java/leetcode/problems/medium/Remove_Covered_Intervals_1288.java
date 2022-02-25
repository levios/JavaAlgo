package leetcode.problems.medium;

import java.util.*;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * 1288. Remove Covered Intervals
 * https://leetcode.com/problems/remove-covered-intervals/
 *
 * Given an array intervals where intervals[i] = [li, ri] represent the interval [li, ri),
 * remove all intervals that are covered by another interval in the list.
 * The interval [a, b) is covered by the interval [c, d) if and only if c <= a and b <= d.
 * Return the number of remaining intervals.
 */
public class Remove_Covered_Intervals_1288 {

    public int removeCoveredIntervals(int[][] intervals) {
        int n = intervals.length;
        Map<Integer, Integer> counts = new HashMap<>();
        List<int[]> list = Arrays.stream(intervals).sorted(new IntArrayComparator()).collect(Collectors.toList());
        for (int[] i: list) {
            Set<Integer> keys = counts.keySet().stream().filter(k -> k <= i[1]).collect(Collectors.toSet());
            for (Integer k : keys) {
                n -= counts.remove(k);
            }
            counts.put(i[1], 1);
        }
        return n;
    }

    static class IntArrayComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] o1, int[] o2) {
            // decreasing order
            int compared = Integer.compare(o2[0], o1[0]);
            if (compared != 0) {
                return compared;
            }
            // increasing order
            return Integer.compare(o1[1], o2[1]);
        }
    }

    public static void main(String[] args) {
        Remove_Covered_Intervals_1288 x = new Remove_Covered_Intervals_1288();
        System.out.println(x.removeCoveredIntervals(new int[][]{{1,4},{3,6},{2,8}}));
        System.out.println(x.removeCoveredIntervals(new int[][]{{1,4},{2,3}}));
    }
}
