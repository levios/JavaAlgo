package leetcode.problems.medium;

import leetcode.problems.util.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Constraints:
 * The number of nodes in the linked list will be in the range [1, 104].
 * -104 <= Node.val <= 104
 * At most 104 calls will be made to getRandom.
 *
 * Reservoir sampling: a family of randomized algorithms for sampling from a population of unknown size.
 *
 */
public class LinkedList_Random_Node_382 {

    Random r = new Random();
    List<Integer> values = new ArrayList<>();
    private int length = 0;

    public LinkedList_Random_Node_382(ListNode head) {
        while (head != null) {
            values.add(head.val);
            head = head.next;
        }
        length = values.size();
    }

    public int getRandom() {
        int nextIndex = r.nextInt(length);
        return values.get(nextIndex);
    }

    public static void main(String[] args) {
        ListNode l = new ListNode(1, new ListNode(2, new ListNode(3)));
        LinkedList_Random_Node_382 obj = new LinkedList_Random_Node_382(l);
        int[] nums = new int[4];
        for (int i = 0; i < 10000; i++) {
            nums[obj.getRandom()]++;
        }
        System.out.println(Arrays.stream(nums).boxed().collect(Collectors.toList()));
    }
}
