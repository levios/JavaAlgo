package leetcode.problems.medium;

import leetcode.problems.util.DSU;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

/**
 * 452. Minimum Number of Arrows to Burst Balloons
 * https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/
 *
 * There are some spherical balloons taped onto a flat wall that represents the XY-plane.
 * The balloons are represented as a 2D integer array points where points[i] = [xstart, xend] denotes a balloon
 * whose horizontal diameter stretches between xstart and xend. You do not know the exact y-coordinates of the balloons.
 * Arrows can be shot up directly vertically (in the positive y-direction) from different points along the x-axis.
 * A balloon with xstart and xend is burst by an arrow shot at x if xstart <= x <= xend.
 * There is no limit to the number of arrows that can be shot.
 * A shot arrow keeps traveling up infinitely, bursting any balloons in its path.
 * Given the array points, return the minimum number of arrows that must be shot to burst all balloons.
 */
public class Min_Num_of_Arrows_to_Burst_Balloons_452 {
    // This is a greedy algorithm
    public int findMinArrowShots(int[][] points) {
        AtomicLong lastShot = new AtomicLong((long)Integer.MIN_VALUE-1L);
        AtomicInteger counter = new AtomicInteger(0);
        Arrays.stream(points).sorted(new IntArrayComparator()).forEach( p -> {
            if (p[0] > lastShot.get()) {
                lastShot.set(p[1]);
                counter.incrementAndGet();
            }
        });
        return counter.get();
    }

    static class IntArrayComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] o1, int[] o2) {
            return Integer.compare(o1[1], o2[1]);
        }
    }

    public static void main(String[] args) {
        Min_Num_of_Arrows_to_Burst_Balloons_452 x = new Min_Num_of_Arrows_to_Burst_Balloons_452();
        x.findMinArrowShots(new int[][]{{10,16},{2,8},{1,6},{7,12}});
    }
}
