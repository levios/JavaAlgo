from typing import List

# 189. Rotate Array
# https://leetcode.com/problems/rotate-array/
# Constraints:
# 1 <= nums.length <= 105
# -231 <= nums[i] <= 231 - 1
# 0 <= k <= 105

class Solution:
    # Runtime: 281 ms, faster than 50.86%
    # Memory Usage: 25.4 MB, less than 96.40%
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        n=len(nums)
        # if k is too big, reduce it
        while k >= n:
            k-=n
        # if we hit a loop in a cycle, let's try to escape it, by increasing 'cycle' each time
        cycle=0
        # current index
        i=0
        # store the last value
        last=nums[i-k]
        counter=0
        while counter<n:
            # swap
            temp=nums[i]
            nums[i]=last
            last=temp
            i = (i+k) % n
            # if a cycle is hit -> increase cycle and store new value in last
            if counter > 0 and i == cycle:
                cycle += 1
                i=cycle
                last=nums[i-k]
            counter += 1



if __name__ == '__main__':
    x=Solution()
    l=[1,2,3,4,5,6,7]
    x.rotate(l, 3)
    print(l)
    l=[-1,-100,3,99]
    x.rotate(l, 2)
    print(l)
    l=[1,2,3,4,5,6]
    x.rotate(l, 3)
    print(l)