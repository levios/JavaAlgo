package leetcode.problems.easy;

/**
 * 1009. Complement of Base 10 Integer
 * https://leetcode.com/problems/complement-of-base-10-integer
 *
 */
public class Complement_of_Base_10_Integer_1009 {
    /**
     * Let's find the first number X that X = 1111....1 > N
     * And also, it has to be noticed that,
     * N = 0 is a corner case expecting1 as result.
     */
    public int bitwiseComplement(int n) {
        int x = 1;
        while (x < n) x = 2*x + 1;
        return x - n;
    }
    public int bitwiseComplement0(int n) {
        StringBuilder sb = new StringBuilder();
        for (char c: Integer.toBinaryString(n).toCharArray()) {
            sb.append(c == '0' ? '1' : '0');
        }
        return Integer.parseInt(sb.toString(), 2);
    }
}
