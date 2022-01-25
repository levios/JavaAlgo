package leetcode.problems.medium;

/**
 * 849. Maximize Distance to Closest Person
 * https://leetcode.com/problems/maximize-distance-to-closest-person/
 * You are given an array representing a row of seats where seats[i] = 1 represents a person sitting in the ith seat,
 * and seats[i] = 0 represents that the ith seat is empty (0-indexed).
 * There is at least one empty seat, and at least one person sitting.
 * Alex wants to sit in the seat such that the distance between him and the closest person to him is maximized.
 * Return that maximum distance to the closest person.
 */
public class Max_Distance_to_Closest_Person_849 {
    public int maxDistToClosest(int[] seats) {
        int gap = 0;
        int maxGap = 0;
        boolean first_1 = false;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 0) {
                gap++;
                maxGap = Math.max(gap, maxGap);
            } else {
                if (!first_1) {
                    maxGap = Math.max(maxGap, gap*2);
                }
                gap = 0;
                first_1 = true;
            }
        }
        if (seats[seats.length-1] == 0) {
            maxGap = Math.max(maxGap, gap*2);
        }
        return (maxGap+1)/2;
    }
}
