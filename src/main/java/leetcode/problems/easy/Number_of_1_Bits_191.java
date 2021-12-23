package leetcode.problems.easy;

/**
 * Write a function that takes an unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).
 * https://en.wikipedia.org/wiki/Hamming_weight
 */
public class Number_of_1_Bits_191 {

    public int hammingWeight_0(int n) {
        return Integer.bitCount(n);
    }

    // n & (n - 1) drops the lowest set bit. It's a neat little bit trick.
    public int hammingWeight_1(int n) {
        int count = 0;
        while (n > 0) {
            n &= (n - 1);
            count++;
        }
        return count;
    }

    public static int hammingWeight_2(int n) {
        int c = 0;
        while (n != 0) {
            c += (n & 1);
            n >>>= 1;
        }
        return c;
    }

}
