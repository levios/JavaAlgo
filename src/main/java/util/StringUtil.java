package util;

import java.util.*;

public class StringUtil {

    static String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    static String join(int[] arr, String sep) {
        String[] sarr = Arrays.stream(arr).mapToObj(String::valueOf).toArray(String[]::new);
        return String.join(sep, sarr);
    }

    /**
     * Counts the occurrences of character 'ch' in string 's'
     */
    static int countOccurrences(String s, char ch) {
        int counter = 0;
        int index = s.indexOf(ch);
        while (index >= 0) {
            index = s.indexOf(ch, index + 1);
            counter++;
        }
        return counter;
    }

    /**
     * length of the longest String in the list
     */
    static int maxLength(List<String> strs) {
      return Collections.max(strs, Comparator.comparing(String::length)).length();
    }

    /**
     * Checks if 'sub' is a prefix substring to 'str' or not
     * e.g.
     * str="ABCD", sub="AB" => true
     * str="ACD", sub="AB" => false
     * @return true if yes
     */
    static boolean isPrefix(String str, String sub) {
        if(str.length() < sub.length()) return false;
        for (int i = 0; i < sub.length(); i++) {
            if (str.charAt(i) != sub.charAt(i))
                return false;
        }
        return true;
    }

    /**
     * Checks if 'sub' is a suffix substring to 'str' or not
     * e.g.
     * str="ABCD", sub="CD" => true
     * str="ACD", sub="AB" => false
     * @return true if yes
     */
    static boolean isSuffix(String str, String sub) {
        str = new StringBuilder(str).reverse().toString();
        sub = new StringBuilder(sub).reverse().toString();
        return isPrefix(str, sub);
    }
}
