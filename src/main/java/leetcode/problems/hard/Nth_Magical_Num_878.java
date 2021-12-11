package leetcode.problems.hard;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/nth-magical-number/
 * 878. Nth Magical Number
 *
 * A positive integer is magical if it is divisible by either a or b.
 * Given the three integers n, a, and b, return the nth magical number.
 * Since the answer may be very large, return it modulo 10^9 + 7.
 *
 * Constraints:
     1 <= n <= 10^9
     2 <= a, b <= 4 * 10^4
 */
class Nth_Magical_Num_878 {
    static final int modulo = 1_000_000_007;

    /**
     * Runtime: 7 ms, faster than 7.46%
     * Memory Usage: 39.4 MB, less than 5.97%
     */
    public int nthMagicalNumber(int n, int a, int b) {
        // least common multiple
        int lcm = lcm(a,b);
        // how many magical numbers are up to LCM
        long batchSize = magicalUntilN(lcm, a, b);
        // how many such "batch" there are at least
        long iterations = n / batchSize;
        // this is the lower bound of our result
        long lowerBound = lcm * iterations;
        // how many magical numbers are after the lower bound (if any)
        long remaining = n - (iterations*batchSize);
        // generate possible results
        long[] possibles = new long[(int)batchSize];
        int idx = 0;
        possibles[idx] = lowerBound;
        for (int i = 1; i < lcm/a; i++) {
            possibles[++idx] = lowerBound+(i*a);
        }
        for (int i = 1; i < lcm/b; i++) {
            possibles[++idx] = lowerBound+(i*b);
        }
        // make sure to sort them
        Arrays.sort(possibles);
        // return the remaining one from the set
        return (int)(possibles[(int)remaining] % modulo);
    }

    long magicalUntilN(long n, int a, int b) {
        long numOfA = n / a;
        long numOfB = n / b;
        return numOfA + numOfB - 1;
    }

    long allMagicalUntilN(long n, int a, int b) {
        if (b % a == 0 ) {
            return n / a;
        } else {
            long numOfA = n / a;
            long numOfB = n / b;
            long numOfAandB = n / lcm(a, b);
            return numOfA + numOfB - numOfAandB;
        }
    }

    static int gcd(int a, int b) {
        if (b==0) return a;
        return gcd(b,a%b);
    }

    // Least Common Multiple
    static int lcm(int a, int b) {
        return (a / gcd(a, b)) * b;
    }

    public static void main(String[] args) {
        Nth_Magical_Num_878 s = new Nth_Magical_Num_878();
        System.out.println(s.nthMagicalNumber(1000000000 , 40000, 40000)); // 999720007
        System.out.println(s.nthMagicalNumber(10,10,8)); // 50
        System.out.println(s.nthMagicalNumber(5,2,4)); // 10
        System.out.println(s.nthMagicalNumber(1,2,3)); // 2
        System.out.println(s.nthMagicalNumber(4,2,3)); // 6
        System.out.println(s.nthMagicalNumber(3,6,4)); // 8
    }

    // TLE
    public int nthMagicalNumber0(int n, int a, int b) {
        if (a > b) { // swap
            int temp = a;
            a = b;
            b = temp;
        }
        long start = 1;
        long max = n * a * b;
        long mid = 0;
        long end = max;
        while (start <= end) {
            mid = (start + end) / 2;
            long all = allMagicalUntilN(mid, a, b);
            if (all > n) {
                end = mid;
            } else if (all < n) {
                start = mid;
            } else {
                while (mid % a != 0 && mid % b != 0) {
                    mid--;
                }
                break;
            }
        }
        return (int)(mid % modulo);
    }

}