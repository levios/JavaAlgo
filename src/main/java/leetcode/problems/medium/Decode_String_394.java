package leetcode.problems.medium;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * https://leetcode.com/problems/decode-string/
 * 394. Decode String
 * Given an encoded string, return its decoded string.
 *
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being
 * repeated exactly k times. Note that k is guaranteed to be a positive integer.
 * You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
 * Furthermore, you may assume that the original data does not contain any digits and that digits are only for
 * those repeat numbers, k. For example, there won't be input like 3a or 2[4].
 * Constraints:
 * 1 <= s.length <= 30
 * s consists of lowercase English letters, digits, and square brackets '[]'.
 * s is guaranteed to be a valid input.
 * All the integers in s are in the range [1, 300].
 */
public class Decode_String_394 {

//    String regex(String s) {
//        Pattern pattern = Pattern.compile("[0-9]{3}\\[([a-z]*)\\]");
//        Matcher matcher = pattern.matcher(s);
//    }

    public String decodeString(String s) {
        int repeat = 0;
        int lastDigitStartIdx = -1;
        int lastOpeningBracketIdx = -1;
        String temp = s;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i)) && (i == 0 || !Character.isDigit(s.charAt(i-1))) ) {
                repeat = s.charAt(i) - '0';
                lastDigitStartIdx = i;
            } else if (Character.isDigit(s.charAt(i))) {
                repeat *= 10;
                repeat += s.charAt(i) - '0';
            } else if (s.charAt(i) == '[') {
                lastOpeningBracketIdx = i;
            } else if (s.charAt(i) == ']') {
                StringBuilder sb = new StringBuilder();
                String toRepeat = s.substring(lastOpeningBracketIdx+1, i);
                for (int j = 1; j <= repeat; j++) {
                    sb.append(toRepeat);
                }
                String toReplace = s.substring(lastDigitStartIdx, i+1);
                s = s.replace(toReplace, sb.toString());
                break;
            }
        }
        if (!temp.equals(s)) {
            return decodeString(s);
        }
        return s;
    }

    public static void main(String[] args) {
        Decode_String_394 d = new Decode_String_394();
        System.out.println(d.decodeString("3[a]2[bc]"));        // "aaabcbc"
        System.out.println(d.decodeString("3[a2[c]]"));         // "accaccacc"
        System.out.println(d.decodeString("2[abc]3[cd]ef"));    // "abcabccdcdcdef"
        System.out.println(d.decodeString("abc3[cd]xyz"));      // "abccdcdcdxyz"
    }
}
