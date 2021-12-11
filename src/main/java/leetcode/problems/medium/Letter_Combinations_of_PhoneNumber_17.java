package leetcode.problems.medium;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 17. Letter Combinations of a Phone Number
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 *
 * Given a string containing digits from 2-9 inclusive, return all possible letter
 * combinations that the number could represent. Return the answer in any order.
 */
public class Letter_Combinations_of_PhoneNumber_17 {
    static Map<Integer, String> m = new HashMap<>();
    static {
        m.put(0, "");
        m.put(1, "");
        m.put(2, "abc");
        m.put(3, "def");
        m.put(4, "ghi");
        m.put(5, "jkl");
        m.put(6, "mno");
        m.put(7, "pqrs");
        m.put(8, "tuv");
        m.put(9, "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty())
            return Collections.EMPTY_LIST;
        if (digits.length() == 1)
            return m.get(digits.charAt(0) - 48).chars().mapToObj(ch -> "" + (char)ch).collect(Collectors.toList());

        List<List<Character>> lists = new LinkedList<>();
        for (char c : digits.toCharArray()) {
            List<Character> set = m.get(c - 48).chars().mapToObj(ch -> (char) ch).collect(Collectors.toList());
            lists.add(set);
        }
        return cartesianProduct(lists)
                .stream()
                .map(list -> list.stream().map(String::valueOf).collect(Collectors.joining()))
                .collect(Collectors.toList());
    }

    public static <T> List<List<T>> cartesianProduct(List<List<T>> lists) {
        if (lists.size() < 2) throw new IllegalArgumentException("At least 2 listst needed");
        return _cartesianProduct(lists.size()-1, lists);
    }

    private static <T> List<List<T>> _cartesianProduct(int index, List<List<T>> lists) {
        List<List<T>> ret = new LinkedList<>();
        if (index == -1) {
            ret.add(new LinkedList<>());
        } else {
            for (T obj : lists.get(index)) {
                for (List<T> set : _cartesianProduct(index-1, lists)) {
                    set.add(obj);
                    ret.add(set);
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Letter_Combinations_of_PhoneNumber_17 app = new Letter_Combinations_of_PhoneNumber_17();
        System.out.println(app.letterCombinations("2"));
        System.out.println(app.letterCombinations("23"));
        System.out.println(app.letterCombinations("27"));
    }
}
