package leetcode.problems.easy;

import leetcode.problems.util.ListNode;

/**
 * https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/
 * 1290. Convert Binary Number in a Linked List to Integer
 */
class Binary_in_LinkedList_2_Int_1290 {

    // easy
    public int getDecimalValue_1(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val);
            head = head.next;
        }
        return Integer.parseInt(sb.toString(),2);  
    }

    // good
    public int getDecimalValue_2(ListNode head) {
        int sum = 0;
        while (head != null) {
            sum += head.val;
            sum = sum << 1;
            head = head.next;
        }
        sum = sum >> 1;
        return sum;
    }

    public static void main(String[] args) {
        Binary_in_LinkedList_2_Int_1290 a = new Binary_in_LinkedList_2_Int_1290();
        ListNode l = new ListNode(1,new ListNode(0,new ListNode(1)));
        System.out.println(a.getDecimalValue_1(l) + " " + a.getDecimalValue_2(l));
        l = new ListNode(0,new ListNode(0));
        System.out.println(a.getDecimalValue_1(l) + " " + a.getDecimalValue_2(l));
    }
}