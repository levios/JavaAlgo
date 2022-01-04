package leetcode.problems.easy;

/**
 * The complement of an integer is the integer you get when you flip all the 0's to 1's and
 * all the 1's to 0's in its binary representation.
 * For example, The integer 5 is "101" in binary and its complement is "010" which is the integer 2.
 * Given an integer num, return its complement.
 * 1 <= num < 2^31
 */
public class Number_Complement_476 {
    public int findComplement(int num) {
        for (int i = 1; i <= 32; i++) {
            long pow = (long)Math.pow(2, i);
            if (pow > num) {
                return (int)(pow - 1 - num);
            }
        }
        return -1;
    }
    public int findComplement0(int num) {
        return ~num & (Integer.highestOneBit(num) - 1);
    }
    public static void main(String[] args) {
        Number_Complement_476 x = new Number_Complement_476();
        System.out.println(x.findComplement(5)); // 2
        System.out.println(x.findComplement(1)); // 0
        System.out.println(x.findComplement(637245)); // 411330
    }
}
