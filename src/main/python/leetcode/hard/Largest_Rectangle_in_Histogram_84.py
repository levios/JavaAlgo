from typing import List

# 84. Largest Rectangle in Histogram
# https://leetcode.com/problems/largest-rectangle-in-histogram/
# Given an array of integers heights representing the histogram's bar height where the width of each bar is 1,
# return the area of the largest rectangle in the histogram.
# 1 <= heights.length <= 105
# 0 <= heights[i] <= 104
class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        acc=[]
        current=[]
        for x in heights:
            if x == 0:
                acc.append(current)
                current=[]
            else:
                current.append(x)
        acc.append(current)
        mmax = 0
        for lis in acc:
            mmax = max(mmax, self.largest_rect_area(lis))
        return mmax

    def largest_rect_area(self, heights: List[int]) -> int:
        if len(heights) == 0:
            return 0
        min_elem = min(heights)
        #start, end, i = 0, len(heights)-1, 0
        max_area=0
        while len(heights) > 0:
            area=len(heights) * min_elem
            h_min = min(heights[0], heights[len(heights)-1])
            if heights[0] < heights[len(heights)-1]:
                heights = heights[1:]
            else:
                heights = heights[:len(heights)-1]
            max_area = max(area, max_area)
            if len(heights) > 0 and h_min == min_elem:
                min_elem = min(heights)
        return max_area

if __name__ == '__main__':
    x=Solution()
    print(x.largestRectangleArea([2,1,5,6,2,3]))            # 10
    print(x.largestRectangleArea([4,2,0,3,2,4,3,4]))        # 10
    print(x.largestRectangleArea([5,5,1,7,1,1,5,2,7,6]))    # 12