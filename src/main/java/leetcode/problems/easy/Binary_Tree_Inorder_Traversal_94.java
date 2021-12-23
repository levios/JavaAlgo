package leetcode.problems.easy;

import leetcode.problems.util.TreeNode;

import java.util.*;

public class Binary_Tree_Inorder_Traversal_94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return Collections.emptyList();
        List<Integer> nodes = new LinkedList<>();
        nodes.addAll(inorderTraversal(root.left));
        nodes.add(root.val);
        nodes.addAll(inorderTraversal(root.right));
        return nodes;
    }
}
