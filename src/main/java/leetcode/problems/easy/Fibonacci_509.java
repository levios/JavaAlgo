package leetcode.problems.easy;

/**
 * https://leetcode.com/problems/fibonacci-number/
 * 509. Fibonacci Number
 */
public class Fibonacci_509 {
    public int fib(int n) {
        int prevprev = 0;
        if (n == 0) return prevprev;
        int prev = 1;
        if (n == 1) return prev;
        for (int i = 2; i < n; i++) {
            int temp = prevprev;
            prevprev = prev;
            prev += temp;
        }
        return prev + prevprev;
    }
}
