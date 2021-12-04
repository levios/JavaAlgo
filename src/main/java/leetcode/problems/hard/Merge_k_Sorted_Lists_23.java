package leetcode.problems.hard;

import leetcode.problems.util.ListNode;

import java.util.*;

/**
 * https://leetcode.com/problems/merge-k-sorted-lists/
 * 23. Merge k Sorted Lists
 */
class Merge_k_Sorted_Lists_23 {

    // Priority Queue
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;
        if (lists.length == 1)
            return lists[0];
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return Integer.compare(o1.val, o2.val);
            }
        });

        ListNode dummy = new ListNode(0);
        ListNode tail=dummy;

        queue.addAll(Arrays.asList(lists));

        while (!queue.isEmpty()){
            tail.next=queue.poll();
            tail=tail.next;

            if (tail.next!=null)
                queue.add(tail.next);
        }

        return dummy.next;
    }

    /**
     * Runtime: 9 ms, faster than 31.44%
     * Memory Usage: 49.3 MB, less than 5.60%
     */
    public ListNode mergeKLists0(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;
        if (lists.length == 1)
            return lists[0];

        List<ListNode> nodeLists = new LinkedList<>(Arrays.asList(lists));
        while (nodeLists.size() > 1) {
            ListNode merged = mergeLists(
                    nodeLists.remove(nodeLists.size()-1),
                    nodeLists.remove(nodeLists.size()-1)
            );
            nodeLists.add(0, merged);
        }
        return nodeLists.get(0);

        // THIS IS MUCH MORE RAM / MUCH SLOWER
        //   ListNode first = lists[0];
        //   for (int i = 1; i < lists.length; i++) {
        //       first = mergeLists(first, lists[i]);
        //   }
        //   return first;
    }

    private ListNode mergeLists(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;

        ListNode current = new ListNode(Math.min(list1.val, list2.val));
        if (list1.val < list2.val) {
            current.next = mergeLists(list1.next, list2);
        } else {
            current.next = mergeLists(list1, list2.next);
        }
        return current;
    }

    public static void main(String[] args) {
        Merge_k_Sorted_Lists_23 app = new Merge_k_Sorted_Lists_23();
//        System.out.println(app.mergeKLists(
//
//        ));
    }
}