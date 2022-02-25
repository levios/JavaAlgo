
from leetcode.ListNode import ListNode
from typing import Optional

class Solution:
    def swapPairs(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if head is None:
            return None
        current=head
        while True:
            if current.next is not None:
                # swap
                temp = current.val
                current.val = current.next.val
                current.next.val = temp
                if current.next.next is not None:
                    current = current.next.next
                else:
                    break
            else:
                break

        return head

if __name__ == '__main__':
    x=Solution()
    print(x.swapPairs(ListNode(1, ListNode(2))))