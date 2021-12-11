package leetcode.problems.medium;

import java.util.Arrays;

/**
 *
 * The algorithm for myAtoi(string s) is as follows:
 *
 * Read in and ignore any leading whitespace.
 *
 * Check if the next character (if not already at the end of the string) is '-' or '+'.
 * Read this character in if it is either.
 * This determines if the final result is negative or positive respectively. Assume the result is positive if neither is present.
 *
 * Read in next the characters until the next non-digit character or the end of the input is reached.
 * The rest of the string is ignored.
 *
 * Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0. Change the sign as necessary (from step 2)
 *
 * If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp the integer so that it remains in the range. Specifically, integers less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1.
 *
 * Return the integer as the final result.
 *
 * Constraints:
 *   0 <= s.length <= 200
 *   s consists of English letters (lower-case and upper-case), digits (0-9), ' ', '+', '-', and '.'.
 */
public class String_to_Integer_8 {
    /**
     * biggest int = 2147483648 (10 digits)
     * @param s
     * @return
     */
    public int myAtoi(String s) {
        s = s.trim();
        if (s.isEmpty()) return 0;
        char[] chars = new char[100];
        char sign = s.charAt(0);
        boolean isNegative = false;
        int next = 0;
        if (sign == '-') {
            isNegative = true;
            chars[0] = sign;
            s = s.substring(1);
            ++next;
        } else if (sign == '+') {
            s = s.substring(1);
        } else if (!Character.isDigit(sign)) {
            return 0;
        }
        // remove leading 0's
        while (!s.isEmpty() && s.charAt(0) == '0') {
            s = s.substring(1);
        }

        for (int i = 0; i < Math.min(s.length(), 12); i++) {
            char c = s.charAt(i);
            if (!Character.isDigit(c)) {
                break;
            }
            chars[next++] = c;
        }

        if ((isNegative && next < 2) || (next < 1)) {
            return 0;
        }

        String newStr = new String(Arrays.copyOf(chars, next));
        long l = Long.parseLong(newStr);
        if (l < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        if (l >= Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        return (int)l;
    }


    public static void main(String[] args) {
        String_to_Integer_8 app = new String_to_Integer_8();
        System.out.println(app.myAtoi("42"));
        System.out.println(app.myAtoi("   -42"));
        System.out.println(app.myAtoi("4193 with words"));
        System.out.println(app.myAtoi("words and 987"));
        System.out.println(app.myAtoi("  0000000000012345678"));
    }

}
