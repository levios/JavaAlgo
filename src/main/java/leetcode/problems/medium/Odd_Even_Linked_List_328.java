package leetcode.problems.medium;

import leetcode.problems.util.ListNode;

/**
 * https://leetcode.com/problems/odd-even-linked-list/
 * 328. Odd Even Linked List
 */
class Odd_Even_Linked_List_328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return head;
        boolean odd = true;
        ListNode current = head;
        ListNode evenRoot = head.next;
        while (current.next != null) {
            ListNode temp = current.next;
            if (current.next.next == null) {
                if (odd) {
                    current.next = evenRoot;
                    break;
                } else {
                    current.next.next = evenRoot;
                    current.next = null;
                    break;
                }
            } else {
                current.next = current.next.next;
            }
            current = temp;
            odd = !odd;
        }
        return head;
    }

    public static void main(String[] args) {
        Odd_Even_Linked_List_328 app = new Odd_Even_Linked_List_328();
        System.out.println(app.oddEvenList(
                new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))))
        ));
    }
}