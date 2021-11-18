package leetcode.problems;

import leetcode.problems.util.ListNode;

/**
 * https://leetcode.com/problems/add-two-numbers/
 */
public class AddTwoNumbers_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum, remainder = 0;
        ListNode first = null;
        ListNode prev = null;
        ListNode left = l1;
        ListNode right = l2;
        while (left != null || right != null) {
            sum = remainder;
            if (left != null) {
                sum += left.val;
                // repoint pointer
                left = left.next;
            }
            if (right != null) {
                sum += right.val;
                // repoint pointer
                right = right.next;
            }
            ListNode curr = new ListNode(sum % 10);
            if (first == null) {
                first = curr;
            } else {
                prev.next = curr;
            }
            prev = curr;
            remainder = sum / 10;
        }
        if (remainder > 0) {
            prev.next = new ListNode(remainder);
        }
        return first;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;

        ListNode r1 = new ListNode(5);
        ListNode r2 = new ListNode(6);
        ListNode r3 = new ListNode(4);
        r1.next = r2;
        r2.next = r3;

        AddTwoNumbers_2 a = new AddTwoNumbers_2();
        System.out.println("[" + a.addTwoNumbers(l1,r1) + "]");

        ListNode l11 = new ListNode(2);
        ListNode l21 = new ListNode(4);
        l11.next = l21;

        ListNode r11 = new ListNode(5);

        System.out.println("[" + a.addTwoNumbers(l11,r11) + "]");
    }
}