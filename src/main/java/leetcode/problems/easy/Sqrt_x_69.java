package leetcode.problems.easy;

/**
 * https://leetcode.com/problems/sqrtx/
 * 69. Sqrt(x)
 * Given a non-negative integer x, compute and return the square root of x.
 * Since the return type is an integer, the decimal digits are truncated,
 * and only the integer part of the result is returned.
 * Note: You are not allowed to use any built-in exponent function or operator,
 * such as pow(x, 0.5) or x ** 0.5.
 */
public class Sqrt_x_69 {
    // https://en.wikipedia.org/wiki/Integer_square_root#Using_only_integer_division
    /**
     * Runtime: 1 ms, faster than 99.98%
     * Memory Usage: 35.9 MB, less than 90.41%
     */
    public int mySqrt0(int x) {
        long r = x;
        while (r*r > x)
            r = (r + x/r) / 2;
        return (int) r;
    }

    /**
     * Runtime: 1 ms, faster than 99.98%
     * Memory Usage: 35.8 MB, less than 90.41%
     */
    public int mySqrt(int x) {
        int start = 0;
        int end = x;
        while (true) {
            int mid = (start + end) / 2;
            if ((long)mid * mid > x) {
                end = mid;
            } else {
                long p2 = (long) (mid + 1) * (mid + 1);
                if (p2 < x) {
                    start = mid;
                } else if (p2 == x) {
                    return mid+1;
                } else {
                    return mid;
                }
            }
        }
    }

    public static void main(String[] args) {
        Sqrt_x_69 app = new Sqrt_x_69();
//        System.out.println(app.mySqrt(0));
//        System.out.println(app.mySqrt(1));
//        System.out.println(app.mySqrt(4));
//        System.out.println(app.mySqrt(8));
//        System.out.println(app.mySqrt(9));
        System.out.println(app.mySqrt(Integer.MAX_VALUE));
    }
}
