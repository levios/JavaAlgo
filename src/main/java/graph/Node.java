package graph;

import java.util.*;

public class Node<T> {
    public Node<T> left;
    public Node<T> right;
    final T value;

    public Node(T value) {
        this.value = value;
    }

    public void inorder(List<T> visited) {
        if (left != null) {
            left.inorder(visited);
        }
        visited.add(value);
        if (right != null) {
            right.inorder(visited);
        }
    }

    /**
     *       *
     *     /   \
     *    +     -
     *  /  \  /  \
     *  1   2 3   4
     *
     *  => ((1+2)*(3-4))
     */
    public void syntaxTree() {
        if (left != null) {
            System.out.print("(");
            left.syntaxTree();
        }
        System.out.print(this.value);
        if (right != null) {
            right.syntaxTree();
            System.out.print(")");
        }
    }

    /**
     * Construct the Tree back from postfix notation
     *        *
     *      /   \
     *     +     -
     *   /  \  /  \
     *   1   2 3   4
     *  => 12+34-*
     */
    public static Node<String> polishNotation(String s) {
        Stack<Node<String>> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            String c = "" + s.charAt(i);
            Node<String> n = new Node<>(c);
            if (c.matches("-?\\d+")) {
                st.push(n);
            } else {
                n.right = st.pop();
                n.left = st.pop();
                st.push(n);
            }
        }
        return st.pop();
    }

    /***
     * Time complexity: O(n + m) , n is the
     */
    public static <T> boolean isSameInOrder(Node<T> n, Queue<Integer> reference) {
        if (n == null || reference.isEmpty())
            return false;
        return isSameInOrderInner(n, reference);
    }
    private static <T> boolean isSameInOrderInner(Node<T> n, Queue<Integer> reference) {
        if (n == null)
            return true;
        if (reference.isEmpty())
            return false;
        boolean acc = isSameInOrder(n.left, reference);
        if (!acc)
            return false;
        Integer head = reference.remove();
        if (head != n.value)
            return false;
        acc = isSameInOrder(n.right, reference);
        return acc;
    }
}
