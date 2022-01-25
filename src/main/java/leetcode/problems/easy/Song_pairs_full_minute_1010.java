package leetcode.problems.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 1010. Pairs of Songs With Total Durations Divisible by 60
 * https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/
 *
 * You are given a list of songs where the ith song has a duration of time[i] seconds.
 * Return the number of pairs of songs for which their total duration in seconds is divisible by 60.
 * Formally, we want the number of indices i, j such that i < j with (time[i] + time[j]) % 60 == 0.
 */
public class Song_pairs_full_minute_1010 {
    public int numPairsDivisibleBy60(int[] time) {
        int[] times = new int[60];
        for (int j : time) {
            times[j % 60]++;
        }
        int result = times[0] * (times[0]-1) / 2 + times[30] * (times[30]-1) / 2;
        for (int i = 1; i < 30; i++) {
            result += times[i] * times[60-i];
        }
        return result;
    }
    public static void main(String[] args) {
        Song_pairs_full_minute_1010 x = new Song_pairs_full_minute_1010();
        System.out.println(x.numPairsDivisibleBy60(new int[]{30,20,150,100,40}));
    }
}
