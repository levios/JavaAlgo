package leetcode.problems;

import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class Merge_Two_Sorted_Lists_21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode root = null;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                if (root == null) {
                    root = new ListNode(l2.val);
                } else {
                    create(root, l2.val);
                }
                l2 = l2.next;
            } else if (l2 == null) {
                if (root == null) {
                    root = new ListNode(l1.val);
                } else {
                    create(root, l1.val);
                }
                l1 = l1.next;
            } else if (l1.val <= l2.val) {
                if (root == null) {
                    root = new ListNode(l1.val);
                } else {
                    create(root, l1.val);
                }
                l1 = l1.next;
            } else {
                if (root == null) {
                    root = new ListNode(l2.val);
                } else {
                    create(root, l2.val);
                }
                l2 = l2.next;
            }
        }
        return root;
    }

    void create(ListNode root, int val) {
        while (root.next != null) {
            root = root.next;
        }
        root.next = new ListNode(val);
    }

     static class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
         @Override
         public String toString() {
             return val + (next != null ? ", " + next : "");
         }
    }

    public static void main(String[] args) {
        Merge_Two_Sorted_Lists_21 app = new Merge_Two_Sorted_Lists_21();
        ListNode n1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode n2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        System.out.println(app.mergeTwoLists(n1, n2));
    }
}
