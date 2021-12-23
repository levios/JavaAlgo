package leetcode.problems.easy;

import leetcode.problems.util.ListNode;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 * 83. Remove Duplicates from Sorted List
 * Given the head of a sorted linked list, delete all duplicates such that each element appears only once.
 * Return the linked list sorted as well.
 * Constraints:
 *
 * The number of nodes in the list is in the range [0, 300].
 * -100 <= Node.val <= 100
 * The list is guaranteed to be sorted in ascending order.
 */
public class Remove_Duplicates_Sorted_List_83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.next.val != head.val) {
            head.next = deleteDuplicates(head.next);
        } else {
            head.next = head.next.next;
            deleteDuplicates(head);
        }
        return head;
    }

}
