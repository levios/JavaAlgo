package leetcode.problems.medium;

import leetcode.problems.util.ListNode;

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * 19. Remove Nth Node From End of List
 *
 */
public class Remove_Nth_Node_End_of_List_19 {

    /**
     * Runtime: 0 ms, faster than 100.00%
     * Memory Usage: 38.5 MB, less than 30.37%
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0;
        ListNode curr = head;
        while (curr != null) {
            count++;
            curr = curr.next;
        }
        return removeFromEnd(head, count-n+1, 1);
    }

    private ListNode removeFromEnd(ListNode head, int removeFromStart, int current) {
        if (head == null) return null;
        if (removeFromStart == current) {
            return head.next;
        }
        head.next = removeFromEnd(head.next, removeFromStart, current+1);
        return head;
    }

    public static void main(String[] args) {
        Remove_Nth_Node_End_of_List_19 app = new Remove_Nth_Node_End_of_List_19();
        System.out.println(app.removeNthFromEnd(
                new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5))))),
                2
        ));
        System.out.println(app.removeNthFromEnd(
                new ListNode(1),
                1
        ));
        System.out.println(app.removeNthFromEnd(
                new ListNode(1,new ListNode(2)),
                1
        ));
    }
}
