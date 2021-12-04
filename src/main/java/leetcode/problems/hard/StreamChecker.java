package leetcode.problems.hard;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/stream-of-characters/
 * 1032. Stream of Characters
 *
 * 1 <= words.length <= 2000
 * 1 <= words[i].length <= 2000
 *
 * Tags: Trie
 */
class StreamChecker {
    /**
     * Runtime: 202 ms, faster than 33.13%
     * Memory Usage: 68.7 MB, less than 95.75%
     */
    TrieNode root = new TrieNode();
    StringBuilder sb = new StringBuilder();
    int maxSize; // max character size among words

    static class TrieNode {
        HashMap<Character, TrieNode> children = new HashMap<>();
        boolean isWord;
        void add(String s) {
            if (s.isEmpty()) {
                this.isWord = true;
                return;
            }
            Character c = s.charAt(s.length()-1);
            TrieNode child = children.get(c);
            String sub = s.substring(0, s.length()-1);
            if (child == null) {
                TrieNode newNode = new TrieNode();
                newNode.add(sub);
                children.put(c, newNode);
            } else {
                child.add(sub);
            }
        }
        boolean search(String s) {
            if (s.length() < 1) return false;
            TrieNode t = children.get(s.charAt(s.length()-1));
            if (t == null) {
                return false;
            } else if (t.isWord) {
                return true;
            } else {
                return t.search(s.substring(0, s.length()-1));
            }
        }
    }

    public StreamChecker(String[] words) {
        for (String word : words) {
            root.add(word);
            maxSize = Math.max(maxSize, word.length());
        }
    }

    /**
     * Accepts a new character from the stream and returns true
     * if any non-empty suffix from the stream forms a word that is in words.
     */
    public boolean query(char letter) {
        sb.append(letter);
        if (sb.length() > maxSize) {
            sb.deleteCharAt(0);
        }
        return root.search(sb.toString());
    }

    public static void main(String[] args) {
        StreamChecker s = new StreamChecker(new String[]{"cd", "f", "kl"});
//        System.out.println(s.query('a')); // return False
//        System.out.println(s.query('c')); // return False
//        System.out.println(s.query('d')); // return True
//        System.out.println(s.query('e')); // return False
//        System.out.println(s.query('f')); // return True

        s = new StreamChecker(new String[]{"ab","ba","aaab","abab","baa"});
        System.out.println(s.query('a'));
        System.out.println(s.query('a'));
        System.out.println(s.query('a'));
        System.out.println(s.query('a'));
        System.out.println(s.query('a'));
        System.out.println(s.query('b'));
        System.out.println(s.query('a'));
        System.out.println(s.query('b'));
        System.out.println(s.query('a'));
        System.out.println(s.query('b'));
        System.out.println(s.query('b'));
        System.out.println(s.query('b'));
    }
}