package leetcode.problems.easy;

import leetcode.problems.util.TreeNode;
import scala.Int;

import java.util.*;

/**
 * 104. Maximum Depth of Binary Tree
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 * Given the root of a binary tree, return its maximum depth.
 * A binary tree's max depth is the number of nodes along the longest path from the root node
 * down to the farthest leaf node.
 */
public class Max_Depth_of_Binary_Tree_104 {
    public int maxDepth_iterative(TreeNode root) {
        if (root == null) return 0;
        Deque<TreeNode> dq = new LinkedList<>();
        Deque<Integer> level = new LinkedList<>();
        dq.add(root);
        level.add(1);
        Integer lvl = 0;
        while (!dq.isEmpty()) {
            lvl = level.poll();
            TreeNode n = dq.poll();
            if (n.right != null) {
                dq.add(n.right);
                level.add(lvl+1);
            }
            if (n.left != null) {
                dq.add(n.left);
                level.add(lvl+1);
            }
        }
        return lvl;
    }

    public int maxDepth_recursive(TreeNode root) {
        if (root == null) return 0;
        int left = root.left != null ? maxDepth_recursive(root.left) : 0;
        int right = root.right != null ? maxDepth_recursive(root.right) : 0;
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        Max_Depth_of_Binary_Tree_104 x = new Max_Depth_of_Binary_Tree_104();
        System.out.println(x.maxDepth_iterative(
                new TreeNode(3,
                        new TreeNode(9),
                        new TreeNode(20,new TreeNode(13),new TreeNode(7))
                )
        ));
    }
}
