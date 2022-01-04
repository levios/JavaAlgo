package leetcode.problems.medium;

import leetcode.problems.util.Pair;
import java.util.*;

/**
 * 973. K Closest Points to Origin
 * https://leetcode.com/problems/k-closest-points-to-origin/
 */
public class K_Closest_Points_Origin_973 {
    /**
     * Runtime: 31 ms, faster than 30.13%
     * Memory Usage: 47.3 MB, less than 81.33%
     */
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> closest = new PriorityQueue<>(new IntArrayComparator());
        for (int[] point: points) {
            closest.add(point);
            if (closest.size() > k) {
                closest.poll();
            }
        }
        return closest.toArray(new int[0][]);
    }
    static class IntArrayComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] o1, int[] o2) {
            Long d1 = (long)o1[0]*o1[0] + (long)o1[1]*o1[1];
            Long d2 = (long)o2[0]*o2[0] + (long)o2[1]*o2[1];
            // forditva hasonlitom, mert a PriorityQueue poll() a "legkisebbet" veszi ki
            return d2.compareTo(d1);
        }
    }

    public static void main(String[] args) {
        K_Closest_Points_Origin_973 x = new K_Closest_Points_Origin_973();
        System.out.println(Arrays.deepToString(x.kClosest(new int[][]{{0, 1}, {1, 0}}, 2)));
        System.out.println(Arrays.deepToString(
                x.kClosest(new int[][]{{3,3},{5,-1},{-2,4}}, 2)));
    }

    static class PairComparator implements Comparator<Pair> {
        @Override
        public int compare(Pair o1, Pair o2) {
            Long d1 = (long)o1.x*o1.x + (long)o1.y*o1.y;
            long d2 = (long)o2.x*o2.x + (long)o2.y*o2.y;
            return d1.compareTo(d2);
        }
    }
    public int[][] kClosest_Pair(int[][] points, int k) {
        PriorityQueue<Pair> closest = new PriorityQueue<>(new PairComparator());
        for (int[] point : points) {
            closest.add(new Pair(point[0], point[1]));
            if (closest.size() > k) {
                closest.poll();
            }
        }
        return closest.stream().map(p -> new int[]{p.x, p.y}).toArray(int[][]::new);
    }
}
