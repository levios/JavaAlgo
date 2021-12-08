package leetcode.problems.medium;

import leetcode.problems.util.ListNode;

/**
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 * 24. Swap Nodes in Pairs
 * Given a linked list, swap every two adjacent nodes and return its head.
 * You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)
 */
class Swap_Nodes_in_Pairs_24 {
    public ListNode swapPairs(ListNode head) {
        ListNode root = new ListNode(0, head);
        ListNode previous = root;
        while (head != null && head.next != null) {
            ListNode temp = head.next.next;
            head.next.next = head;
            previous.next = head.next;
            head.next = temp;
            ///
            head = head.next;
            previous = previous.next.next;
        }
        return root.next;
    }

    public static void main(String[] args) {
        Swap_Nodes_in_Pairs_24 s = new Swap_Nodes_in_Pairs_24();
        ListNode n =
        new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4))));
        System.out.println(s.swapPairs(n));
    }
}