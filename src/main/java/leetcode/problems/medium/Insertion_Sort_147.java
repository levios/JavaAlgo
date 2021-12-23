package leetcode.problems.medium;

import leetcode.problems.util.ListNode;

import javax.swing.*;

/**
 * https://leetcode.com/problems/insertion-sort-list/
 * 147. Insertion Sort List
 *
 * Given the head of a singly linked list, sort the list using insertion sort, and return the sorted list's head.
 * The steps of the insertion sort algorithm:
 *   Insertion sort iterates, consuming one input element each repetition and growing a sorted output list.
 *   At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list and inserts it there.
 *   It repeats until no input elements remain.
 *   The following is a graphical example of the insertion sort algorithm. The partially sorted list (black) initially
 *   contains only the first element in the list. One element (red) is removed from the input data and inserted in-place into the sorted list with each iteration.
 * Constraints:
 * The number of nodes in the list is in the range [1, 5000].
 * -5000 <= Node.val <= 5000
 */
public class Insertion_Sort_147 {
    /**
     * Runtime: 79 ms, faster than 5.22%
     * Memory Usage: 42.2 MB, less than 8.29%
     */
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(-5001);
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = null;
            insert(dummy, current);
            current = next;
        }

        return dummy.next;
    }

    public void insert(ListNode head, ListNode toInsert) {
        if (head.next == null) {
            head.next = toInsert;
        } else if (head.next.val < toInsert.val) {
            insert(head.next, toInsert);
        } else {
            toInsert.next = head.next;
            head.next = toInsert;
        }
    }

    public static void main(String[] args) {
        Insertion_Sort_147 app = new Insertion_Sort_147();
        ListNode l = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3))));
        System.out.println(app.insertionSortList(l));
        l = new ListNode(4);
        System.out.println(app.insertionSortList(l));
    }
}
