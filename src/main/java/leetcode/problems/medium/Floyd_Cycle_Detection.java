package leetcode.problems.medium;

import leetcode.problems.util.ListNode;

/**
 *142. Linked List Cycle II
 * https://leetcode.com/problems/linked-list-cycle-ii/
 * Given the head of a linked list, return the node where the cycle begins. If no cycle, return null.
 *
 * Floyd algorithm returns the beginning of the cycle (where the cycle starts) in a linked list.
 * This works, because one pointer goes twice as fast as the other one.
 * So if they meet, the faster did exactly twice as many cycles as the slower one.
 * Whatever is missing from the last cycle can be offset from the start when before we
 * entered the cycle.
 */
public class Floyd_Cycle_Detection {

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode slow = head, fast = head, start = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                while (slow != start) {
                    slow = slow.next;
                    start = start.next;
                }
                return start;
            }
        }
        return null;
    }
}