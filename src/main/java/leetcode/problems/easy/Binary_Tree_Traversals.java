package leetcode.problems.easy;

import leetcode.problems.util.TreeNode;

import java.util.*;

/**
 * 94. Binary Tree Inorder Traversal
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 *
 * 144. Binary Tree Preorder Traversal
 * https://leetcode.com/problems/binary-tree-preorder-traversal/
 *
 * 145. Binary Tree Postorder Traversal
 * https://leetcode.com/problems/binary-tree-postorder-traversal/
 */
public class Binary_Tree_Traversals {

    /* iterative */
    public List<Integer> preorder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = root;
        while (!stack.isEmpty() || p != null) {
            if (p != null) {
                stack.push(p);
                result.add(p.val);  // Add before going to children
                p = p.left;
            } else {
                TreeNode node = stack.pop();
                p = node.right;
            }
        }
        return result;
    }

    public List<Integer> inorder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = root;
        while(!stack.isEmpty() || p != null) {
            if(p != null) {
                stack.push(p);
                p = p.left;
            } else {
                TreeNode node = stack.pop();
                result.add(node.val);  // Add after all left children
                p = node.right;
            }
        }
        return result;
    }

    public List<Integer> postorder(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = root;
        while (!stack.isEmpty() || p != null) {
            if (p != null) {
                stack.push(p);
                result.addFirst(p.val);  // Reverse the process of preorder
                p = p.right;             // Reverse the process of preorder
            } else {
                TreeNode node = stack.pop();
                p = node.left;           // Reverse the process of preorder
            }
        }
        return result;
    }

    /* recursion */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> l = new LinkedList<>();
        if (root == null) return l;
        l.addAll(preorderTraversal(root.left));
        l.add(root.val);
        l.addAll(preorderTraversal(root.right));
        return l;
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> l = new LinkedList<>();
        if (root == null) return l;
        l.add(root.val);
        l.addAll(preorderTraversal(root.left));
        l.addAll(preorderTraversal(root.right));
        return l;
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> l = new LinkedList<>();
        if (root == null) return l;
        l.addAll(postorderTraversal(root.left));
        l.addAll(postorderTraversal(root.right));
        l.add(root.val);
        return l;
    }
}
