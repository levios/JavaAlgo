package leetcode.problems.medium;

/**
 * 1094. Car Pooling
 * https://leetcode.com/problems/car-pooling/
 * There is a car with capacity empty seats. The vehicle only drives east (i.e., it cannot turn around and drive west).
 * You are given the integer capacity and an array trips where trip[i] = [numPassengersi, fromi, toi] indicates that
 * the ith trip has numPassengersi passengers and the locations to pick them up and drop them off are fromi and toi respectively.
 * The locations are given as the number of kilometers due east from the car's initial location.
 * Return true if it is possible to pick up and drop off all passengers for all the given trips, or false otherwise.
 * Constraints:
    1 <= trips.length <= 1000
    trips[i].length == 3
    1 <= numPassengersi <= 100
    0 <= fromi < toi <= 1000
 */
public class Car_Pooling_1094 {
    /**
     * SLOW
     * Runtime: 4 ms, faster than 64.26%
     * Memory Usage: 38.9 MB, less than 54.92%
     */
    public boolean carPooling0(int[][] trips, int capacity) {
        boolean res = true;
        int[] ride = new int[1000]; // comes from Constraints
        for (int i = 0; i < trips.length; i++) {
            int numPassengersi = trips[i][0];
            int fromi = trips[i][1];
            int toi = trips[i][2];
            for (int j = fromi; j < toi; j++) {
                ride[j] += numPassengersi;
                if (ride[j] > capacity) {
                    return false;
                }
            }
        }
        return res;
    }

    /**
     * FAST
     * Runtime: 2 ms, faster than 74.98%
     * Memory Usage: 41.4 MB, less than 16.67%
     */
    public boolean carPooling(int[][] trips, int capacity) {
        int[] stops = new int[1001];
        for (int[] t : trips) {
            stops[t[1]] += t[0];
            stops[t[2]] -= t[0];
        }
        for (int stop : stops) {
            capacity -= stop;
            if (capacity < 0) return false;
        }
        return true;
//        for (int i = 0; capacity >= 0 && i < 1001; ++i) capacity -= stops[i];
//        return capacity >= 0;
    }
}
