package leetcode;

import java.util.*;

public class IsHappy {
    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int sum, curr = n;
        while (true) {
            sum = 0;
            while (curr > 0) {
                int digit = curr % 10;
                sum += digit * digit;
                curr /= 10;
            }
            if (sum == 1) return true;
            if (!set.add(sum))
                return false;
            curr = sum;
        }
    }
}