package leetcode.problems.easy;

import leetcode.problems.util.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/binary-tree-paths/
 * 257. Binary Tree Paths
 *
 * Given the root of a binary tree, return all root-to-leaf paths in any order.
 * A leaf is a node with no children.
 * Constraints:
    The number of nodes in the tree is in the range [1, 100].
 */
public class Binary_Tree_Paths_257 {
    /**
     * Runtime: 7 ms, faster than 64.27%
     * Memory Usage: 38.9 MB, less than 96.06%
     */
    public List<String> binaryTreePathsRecursive(TreeNode root) {
        List<List<Integer>> list = new LinkedList<>();
        traverse(list, new LinkedList<>(), root);
        return list.stream()
                .map(l ->
                        l.stream()
                        .map(Object::toString)
                        .collect(Collectors.joining("->")))
                .collect(Collectors.toList());
    }
    void traverse(List<List<Integer>> list, List<Integer> current, TreeNode root) {
        current.add(root.val);
        if (root.left == null && root.right == null) {
            list.add(current);
        }
        if (root.left != null) {
            traverse(list, new ArrayList<>(current), root.left);
        }
        if (root.right != null) {
            traverse(list, new ArrayList<>(current), root.right);
        }
    }

    /**
     * BFS
     * Runtime: 6 ms, faster than 66.48%
     * Memory Usage: 39.2 MB, less than 74.79%
     */
    public List<String> binaryTreePathsBfs(TreeNode root) {
        List<String> res = new LinkedList<>();
        Queue<StringBuilder> p = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        p.add(new StringBuilder("" + root.val));
        while (!q.isEmpty()) {
            TreeNode n = q.remove();
            StringBuilder sb = p.remove();
            if (n.left == null && n.right == null) {
                res.add(sb.toString());
            }
            if (n.left != null) {
                q.add(n.left);
                p.add(new StringBuilder(sb).append("->").append(n.left.val));
            }
            if (n.right != null) {
                q.add(n.right);
                p.add(new StringBuilder(sb).append("->").append(n.right.val));
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
