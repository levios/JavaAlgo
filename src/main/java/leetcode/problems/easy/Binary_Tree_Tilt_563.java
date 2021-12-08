package leetcode.problems.easy;

import leetcode.problems.util.TreeNode;

/**
 * https://leetcode.com/problems/binary-tree-tilt/
 * 563. Binary Tree Tilt
 * Given the root of a binary tree, return the sum of every tree node's tilt.
 *
 * The tilt of a tree node is the absolute difference between the sum of all left subtree node values and all right subtree node values.
 * If a node does not have a left child, then the sum of the left subtree node values is treated as 0.
 * The rule is similar if there the node does not have a right child.
 */
class Binary_Tree_Tilt_563 {
    int tilt = 0;
    // Post-Order DFS will traverse each node only once, no need to cache
    public int findTilt(TreeNode root) {
        // tilt = 0;
        sum(root);
        return tilt;
    }
    /**
     * Runtime: 1 ms, faster than 38.44%
     * Memory Usage: 42.3 MB, less than 26.88%
     */
    private int sum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = sum(node.left);
        int right = sum(node.right);
        tilt += Math.abs(left - right);
        return node.val + left + right;
    }

    // CuncurrentModificationException ???
//    private int sum0(TreeNode node) {
//        if (node == null) {
//            return 0;
//        }
//        sumCache.computeIfAbsent(node, key -> node.val + sum(node.left) + sum(node.right));
//        tiltCache.computeIfAbsent(node, key -> Math.abs(sum(node.left) - sum(node.right)));
//        return sumCache.get(node);
//    }

    public static void main(String[] args) {
        Binary_Tree_Tilt_563 s = new Binary_Tree_Tilt_563();
        System.out.println(s.findTilt(
            new TreeNode(1,new TreeNode(2), new TreeNode(3))
        ));
        System.out.println(s.findTilt(
                new TreeNode(4,
                        new TreeNode(2,new TreeNode(3),new TreeNode(5)),
                        new TreeNode(9, null, new TreeNode(7))
                )
        ));
    }
}