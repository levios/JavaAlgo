package leetcode.problems.easy;

import leetcode.problems.util.TreeNode;

/**
 * https://leetcode.com/problems/diameter-of-binary-tree/submissions/
 * 543. Diameter of Binary Tree
 *
 * Given the root of a binary tree, return the length of the diameter of the tree.
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
 * This path may or may not pass through the root.
 * The length of a path between two nodes is represented by the number of edges between them.
 *
 * Constraints:
    The number of nodes in the tree is in the range [1, 104]
    -100 <= Node.val <= 100
 */
public class Diameter_Binary_Tree {
    /**
     * Runtime: 1 ms, faster than 26.49%
     * Memory Usage: 39.8 MB, less than 24.65%
     */
    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxLength(root);
        return max;
    }

    int maxLength(TreeNode node) {
        int left = node.left == null ? 0 : maxLength(node.left) + 1;
        int right = node.right == null ? 0 : maxLength(node.right) + 1;
        max = Math.max(max, left + right);
        return Math.max(left, right);
    }

    public static void main(String[] args) {
        Diameter_Binary_Tree d = new Diameter_Binary_Tree();
        TreeNode n = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
        //System.out.println(d.maxLength(n));
        System.out.println(d.diameterOfBinaryTree(n));
    }
}
