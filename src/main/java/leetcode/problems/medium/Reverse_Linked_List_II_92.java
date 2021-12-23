package leetcode.problems.medium;

import leetcode.problems.util.ListNode;

/**
 * https://leetcode.com/problems/reverse-linked-list-ii/
 * 92. Reverse Linked List II
 *
 * Given the head of a singly linked list and two integers left and right
 * where left <= right, reverse the nodes of the list from position left to position right
 * and return the reversed list.
 * Constraints:
 * 1 <= n <= 500
 * -500 <= Node.val <= 500
 * 1 <= left <= right <= n
 */
public class Reverse_Linked_List_II_92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head.next == null) return head;
        ListNode dummy = new ListNode(0, head);
        ListNode tempHead = dummy;
        for (int i = 1; i < left; i++) {
            tempHead = tempHead.next;
        }
        head = tempHead.next;
        ListNode next = head;
        for (int i = left; i < right; i++) {
            next = next.next;
        }
        ListNode tail = next.next;
        next.next = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = tail;
            tail = head;
            head = temp;
        }
        tempHead.next = tail;
        return dummy.next;
    }

    public static void main(String[] args) {
        Reverse_Linked_List_II_92 r = new Reverse_Linked_List_II_92();
        ListNode l = new ListNode(1, new ListNode(2, new ListNode(3,
                new ListNode(4, new ListNode(5)))));
        System.out.println(r.reverseBetween(l, 2,4));
        l = new ListNode(3, new ListNode(5));
        System.out.println(r.reverseBetween(l, 1,2));
    }
}
