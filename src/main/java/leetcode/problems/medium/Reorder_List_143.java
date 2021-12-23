package leetcode.problems.medium;

import leetcode.problems.util.ListNode;

/**
 * https://leetcode.com/problems/reorder-list/
 * 143. Reorder List
 * You are given the head of a singly linked-list. The list can be represented as:
 * L0 → L1 → … → Ln - 1 → Ln
 * Reorder the list to be on the following form:
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * You may not modify the values in the list's nodes. Only nodes themselves may be changed.
 * TODO TODO
 */
public class Reorder_List_143 {
    public void reorderList(ListNode head) {
        ListNode tail = new ListNode(0);
        int counter = 1;
        ListNode cursor = head;
        while (cursor.next != null) {
            counter++;
            cursor = cursor.next;
            cursor.next = tail.next;
        }
        int half = counter / 2;
        counter = 1;
        cursor = head;
        while (counter < half) {
            counter++;
            cursor = cursor.next;
        }

        //while (cursor != null)

    }
}
