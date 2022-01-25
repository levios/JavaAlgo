package leetcode.problems.medium;

import java.util.*;

/**
 * 1291. Sequential Digits
 * Constraints:
 *
 * 10 <= low <= high <= 10^9
 */
public class Sequential_Digits_1291 {
    static List<Integer> list = new LinkedList<>();
    static {
        for (int i = 2; i <= 9; i++) {
            generate(i);
        }
    }
    public List<Integer> sequentialDigits(int low, int high) {
        int minIdx = -1, maxIdx = list.size();
        for (int i = 0; i < list.size(); i++) {
            if (low <= list.get(i) && minIdx == -1){
                minIdx = i;
            }
            if (high < list.get(i) && minIdx != -1){
                maxIdx = i;
                break;
            }
        }
        if (minIdx == -1) return new LinkedList<>();
        return list.subList(minIdx, Math.min(maxIdx, list.size()));
    }
    static void generate(int k) {
        for (int start = 1; start <= 9-k+1; start++) {
            int j = 0;
            for (int i = start; i < start+k; i++) {
                j = j * 10 + i;
            }
            list.add(j);
        }
    }

    public static void main(String[] args) {
        Sequential_Digits_1291 x = new Sequential_Digits_1291();
        System.out.println(x.sequentialDigits(10, 99));
    }
}
