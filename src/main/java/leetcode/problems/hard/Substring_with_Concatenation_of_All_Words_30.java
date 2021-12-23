package leetcode.problems.hard;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/substring-with-concatenation-of-all-words/
 * 30. Substring with Concatenation of All Words
 *
 * You are given a string s and an array of strings words of the same length.
 * Return all starting indices of substring(s) in s that is a concatenation of each word in words exactly once,
 * in any order, and without any intervening characters.
 * You can return the answer in any order.
 *
 * Constraints:
 *
 * 1 <= s.length <= 104
 * s consists of lower-case English letters.
 * 1 <= words.length <= 5000
 * 1 <= words[i].length <= 30
 * words[i] consists of lower-case English letters.
 */
class Substring_with_Concatenation_of_All_Words_30 {

    /**
     * with optimization attempt 2:
     * Runtime: 59 ms, faster than 81.49%
     * Memory Usage: 39.3 MB, less than 96.96%
     *
     * with optimization attempt 1:
     * Runtime: 222 ms, faster than 29.26%
     * Memory Usage: 114.3 MB, less than 9.19%
     */
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> indices = new LinkedList<>();
        int wlen = words[0].length();
        int len = words.length;
        // optimization attempt 1
        //Set<Character> firstLetters = Arrays.stream(words).map(str -> str.charAt(0)).collect(Collectors.toSet());
        // optimization attempt 2
        Set<String> wordsSet = Arrays.stream(words).collect(Collectors.toSet());

        Map<String, Integer> occurrence = new HashMap<>();
        for (String w : words) {
            occurrence.merge(w, 1, Integer::sum);
        }

        for (int i = 0; i < s.length() - len*wlen + 1; i++) {
            // optimization attempt 2
            if (wordsSet.contains(s.substring(i, i+wlen))) {
                // optimization attempt 1
                // if (firstLetters.contains(s.charAt(i))) {
                if (verify(s, i, new HashMap<>(occurrence), len, wlen)) {
                    indices.add(i);
                }
            }
        }
        return indices;
    }

    boolean verify(String str, int i, Map<String, Integer> occurrence, int len, int wlen) {
        for (int j = 0; j < len; j++) {
            String s = str.substring(i+j*wlen, i+(j+1)*wlen);
            Integer value = occurrence.get(s);
            if (value == null) {
                return false;
            }
            if (value.equals(1)) {
                occurrence.remove(s);
            } else {
                occurrence.put(s, value - 1);
            }
        }
        return true;
    }


    public List<Integer> findSubstring0(String s, String[] words) {
        List<Integer> indices = new LinkedList<>();
        // first occurrence
        Map<Integer, String> byIdx = new HashMap<>();
        for (String word: words) {
            int idx = s.indexOf(word);
            if (idx == -1) {
                return indices;
            }
            byIdx.put(idx, word);
        }
        xxx(indices, byIdx, s, words);
        return indices;
    }

    void xxx(List<Integer> indices, Map<Integer, String> byIdx, String s, String[] words) {
        Optional<Integer> minOpt = byIdx.keySet().stream().min(Integer::compareTo);
        if (!minOpt.isPresent()) {
            return;
        }
        int min = minOpt.get();
        boolean isAllWords = verify(s, new HashMap<>(byIdx), min);
        if (isAllWords) {
            indices.add(min);
        }
        // need to replace index for 'min' word with new index
        String word = byIdx.get(min);
        int offset = min + word.length();
        int idx = s.substring(offset).indexOf(word);
        if (idx == -1) {
            return; // reached the end
        }
        byIdx.remove(min);
        byIdx.put(offset + idx, word);
        // repeat
        xxx(indices, byIdx, s, words);
    }

    boolean verify(String s, Map<Integer, String> byIdx, int min) {
        if (!byIdx.containsKey(min) || !s.substring(min).startsWith(byIdx.get(min)))
            return false;
        String word = byIdx.remove(min);
        if (byIdx.isEmpty()) return true;
        return verify(s, byIdx, min + word.length());
    }

    public static void main(String[] args) {
        Substring_with_Concatenation_of_All_Words_30 s = new Substring_with_Concatenation_of_All_Words_30();
        System.out.println(s.findSubstring("barfoothefoobarman", new String[]{"bar","foo"})); // [0,9]
        System.out.println(s.findSubstring("wordgoodgoodgoodbestword", new String[]{"word","good","best","word"})); // []
        System.out.println(s.findSubstring("barfoofoobarthefoobarman", new String[]{"bar","foo","the"})); // [6,9,12]
        System.out.println(s.findSubstring("lingmindraboofooowingdingbarrwingmonkeypoundcake",
                new String[]{"fooo","barr","wing","ding","wing"})); // [13]
    }

}