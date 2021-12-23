package leetcode.problems.util;

import java.util.*;

/**
 * basic String Trie implementation
 */
public class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isWord;

    public void add(String s) {
        if (s.isEmpty()) {
            this.isWord = true;
            return;
        }
        Character c = s.charAt(s.length() - 1);
        TrieNode child = children.get(c);
        String sub = s.substring(0, s.length() - 1);
        if (child == null) {
            TrieNode newNode = new TrieNode();
            newNode.add(sub);
            children.put(c, newNode);
        } else {
            child.add(sub);
        }
    }

    public boolean search(String s) {
        if (s.length() < 1) return false;
        TrieNode t = children.get(s.charAt(s.length() - 1));
        if (t == null) {
            return false;
        } else if (t.isWord) {
            return true;
        } else {
            return t.search(s.substring(0, s.length() - 1));
        }
    }
}