package leetcode.problems.easy;

import leetcode.problems.util.ListNode;
/**
 *
 */
public class Middle_of_LinkedList_976 {
    ListNode result = null;
    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) return head;
        find(head, 1);
        return result;
    }
    public int find(ListNode head, int index) {
        int lengthFromEnd;
        if (head.next == null) {
            lengthFromEnd = 1;
        } else {
            lengthFromEnd = find(head.next, index+1) + 1;
        }
        if (index == lengthFromEnd || index == lengthFromEnd+1) {
            result = head;
        }
        return lengthFromEnd;
    }
}
