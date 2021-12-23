package leetcode.problems.easy;

/**
 * https://leetcode.com/problems/plus-one/submissions/
 * 66. Plus One
 * Increment the large integer by one and return the resulting array of digits.
 */
public class Plus_One_66 {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length-1; i >= 0 ; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i] += 1;
                break;
            }
        }
        if (digits[0] == 0) {
            int[] result = new int[digits.length+1];
            result[0] = 1;
            // this means everything up to this point was 0, so no need to copy
            // System.arraycopy(digits, 0, result, 1, digits.length);
            return result;
        }
        return digits;
    }
}
