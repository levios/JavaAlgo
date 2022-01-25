package leetcode.problems.easy;

import leetcode.problems.util.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 111. Minimum Depth of Binary Tree
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 */
public class Min_Depth_of_Binary_Tree_111 {
    // BFS
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int depth = 0;
        Deque<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            int size = nodes.size();
            depth++;
            while (size>0) {
                TreeNode t = nodes.poll();
                size--;
                if (t.left == null && t.right == null) {
                    return depth;
                }
                if (t.left != null) {
                    nodes.add(t.left);
                }
                if (t.right != null) {
                    nodes.add(t.right);
                }
            }
        }
        return -1; // for compiler, we should never get here
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(2, null, new TreeNode(3, null,
                new TreeNode(4,null,new TreeNode(5,null,new TreeNode(6)))));
        System.out.println(new Min_Depth_of_Binary_Tree_111().minDepth(t));
    }
}