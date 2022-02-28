from typing import List

# 121. Best Time to Buy and Sell Stock
# https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
# Maximize profit by choosing a single day to buy one stock and choosing a different day in the future to sell it
# Return the maximum profit you can achieve from this transaction.
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        profit=0
        buy=prices[0]
        for p in prices[1:]:
            if p < buy:
                buy=p
            else:
                profit=max(profit, p-buy)
        return profit

if __name__ == '__main__':
    x=Solution()
    print(x.maxProfit([7,1,5,3,6,4]))
    print(x.maxProfit([7,6,4,3,1]))