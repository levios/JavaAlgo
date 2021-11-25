package leetcode.problems.util;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int val) {
        this.val = val;
    }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    @Override
    public String toString() {
        return "TreeNode{" +val+ ", " + left + ", " + right + '}';
    }

    public TreeNode find(int key) {
        if (val == key) {
            return this;
        } else if (val > key) {
            return find(left, key);
        } else {
            return find(right, key);
        }
    }

    public static TreeNode find(TreeNode node, int key) {
        if (node == null) return null;
        if (node.val == key) {
            return node;
        } else if (node.val > key) {
            return find(node.left, key);
        } else {
            return find(node.right, key);
        }
    }
}
