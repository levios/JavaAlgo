package leetcode.problems.hard;

import java.util.*;

/**
 * https://leetcode.com/problems/numbers-at-most-n-given-digit-set/
 * 902. Numbers At Most N Given Digit Set
 *
 * Given an array of digits which is sorted in non-decreasing order.
 * You can write numbers using each digits[i] as many times as we want.
 * For example, if digits = ['1','3','5'], we may write numbers such as '13', '551', and '1351315'.
 *
 * Constraints:
    1 <= digits.length <= 9
    digits[i].length == 1
    digits[i] is a digit from '1' to '9'.
    All the values in digits are unique.
    digits is sorted in non-decreasing order.
    1 <= n <= 109
 */
public class Numbers_At_Most_N_Given_Digits_902 {

    int counter = 0;
    /**
     * @return number of positive integers that can be generated that are less than or equal to a given integer n.
     */
    public int atMostNGivenDigitSet(String[] digits, int n) {
        List<Integer> dgts = new ArrayList<>();
        counter = 0;
        // let's find the digits and put them in dgts List
        while(n > 0) {
            dgts.add(0, n % 10);
            n /= 10;
        }
        // for each number that has less digits than n, we have a formula
        for (int i = 1; i < dgts.size(); i++) {
            counter += Math.pow(digits.length, i);
        }
        // each number that has equal number of digits as n, let's use recursion
        recurse(digits, dgts, 0, dgts.size()-1);
        return counter;
    }

    void recurse(String[] digits, List<Integer> dgts, int idx, int pow) {
        // if we reach it, then it means we have exactly 1 digit that matched
        if (idx == dgts.size()) {
            counter++;
            return;
        }
        // otherwise we need to recurse
        for (String digit : digits) {
            int d1 = Integer.parseInt(digit);
            int d2 = dgts.get(idx);
            if (d1 < d2) {
                counter += Math.pow(digits.length, pow);
            } else if (d1 > d2) {
                break;
            } else {
                recurse(digits, dgts, idx + 1, pow - 1);
            }
        }
    }

    public static void main(String[] args) {
        Numbers_At_Most_N_Given_Digits_902 app = new Numbers_At_Most_N_Given_Digits_902();
        System.out.println(app.atMostNGivenDigitSet(new String[]{"7"}, 8));                  // 1
        System.out.println(app.atMostNGivenDigitSet(new String[]{"3","4","8"}, 4));          // 2
        System.out.println(app.atMostNGivenDigitSet(new String[]{"1","3","5","7"}, 100));    // 20
        System.out.println(app.atMostNGivenDigitSet(new String[]{"1","4","9"}, 1000000000)); // 29523
        System.out.println(app.atMostNGivenDigitSet(new String[]{"1","3","5","7"}, 782362)); // 5460
    }
}
