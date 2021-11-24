package leetcode.problems.medium;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/interval-list-intersections/
 * 986. Interval List Intersections
 * You are given two lists of closed intervals, firstList and secondList,
 * where firstList[i] = [starti, endi] and secondList[j] = [startj, endj].
 * Each list of intervals is pairwise disjoint and in sorted order.
 * Return the intersection of these two interval lists.
 */
public class Interval_List_Intersections_986 {
    /**
     * Runtime: 24 ms, faster than 5.13%
     * Memory Usage: 40 MB, less than 70.28%
     */
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> res = new LinkedList<>();

        for (int i = 0; i < firstList.length; i++) {
            int lenf = firstList[i].length;
            int starti = firstList[i][0];
            int endi = firstList[i][lenf-1];

            for (int j = 0; j < secondList.length; j++) {
                int startj = secondList[j][0];
                if (endi >= startj) {
                    int lens = secondList[j].length;
                    int endj = secondList[j][lens-1];

                    // find intersection
                    int bottom = Math.max(starti, startj);
                    int upper = Math.min(endi, endj);
                    if (bottom <= upper) {
                        res.add(new int[]{bottom, upper});
                    }
                }
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        Interval_List_Intersections_986 app = new Interval_List_Intersections_986();
        System.out.print("[");
        for (int[] arr : app.intervalIntersection(
                new int[][]{{0,2},{5,10},{13,23},{24,25}},
                new int[][]{{1,5},{8,12},{15,24},{25,26}}
                )) {
            System.out.print("[" + (arr.length > 0 ? arr[0]+","+arr[1] : "") + "],");
        }
        System.out.println("]");
    }
}
