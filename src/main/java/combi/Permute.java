package combi;

import java.util.*;

/**
 * !!!! Input has to be sorted !!!!!
 * Permute(new int[]{1,2,3})
 * Output:
 * 1 2 3
 * 1 3 2
 * 2 1 3
 * 2 3 1
 * 3 1 2
 * 3 2 1
 */
public class Permute {
    private int[] array;
    private boolean firstReady = false;

    private int fact = 1;
    private int counter = 0;

    public Permute(int[] arr) {
        if (arr.length < 1) {
            throw new IllegalArgumentException("length < 1");
        }
        array = arr;

        for(int i=1; i <= array.length; i++){
            fact = fact * i;
        }
    }
    // TODO
    public int[] getNext() {  return null; }
    public int[] hasNext() {  return null; } // TODO
    public boolean hasMore() {
        return counter < fact;
    }

    /**
     * List permutations of an array.
     *
     * @param s the input string
     * @return  the list of permutations
     */
    public static List<String> permutation(int[] s) {
        // The result
        List<int[]> res = new LinkedList<>();

        if (s.length == 1) {
            res.add(s);
        } else if (s.length > 1) {
            //TODO
//            int lastIndex = s.length - 1;
//            // Find out the last character
//            int last = s[lastIndex];
//            // Rest of the string
//            int[] rest = s.substring(0, lastIndex);
//            // Perform permutation on the rest string and
//            // merge with the last character
//            res = merge(permutation(rest), last);
        }
        return null; // TODO: res
    }

    /**
     * @param list a result of permutation, e.g. {"ab", "ba"}
     * @param c    the last character
     * @return     a merged new list, e.g. {"cab", "acb" ... }
     */
    private static List<String> merge(List<String> list, String c) {
        List<String> res = new LinkedList<>();
        // Loop through all the string in the list
        for (String s : list) {
            // For each string, insert the last character to all possible positions
            // and add them to the new list
            for (int i = 0; i <= s.length(); ++i) {
                String ps = new StringBuffer(s).insert(i, c).toString();
                res.add(ps);
            }
        }
        return res;
    }

    // permutation algorithm recursively
    public static <E> List<List<E>> permute(List<E> original) {
        if (original.isEmpty()) {
            List<List<E>> result = new ArrayList<>();
            result.add(new ArrayList<>());
            return result;
        }
        E firstElement = original.remove(0);
        List<List<E>> returnValue = new ArrayList<>();
        List<List<E>> permutations = permute(original);
        for (List<E> smallerPermutated : permutations) {
            for (int index = 0; index <= smallerPermutated.size(); index++) {
                List<E> temp = new ArrayList<>(smallerPermutated);
                temp.add(index, firstElement);
                returnValue.add(temp);
            }
        }
        return returnValue;
    }

}