# 438. Find All Anagrams in a String
# https://leetcode.com/problems/find-all-anagrams-in-a-string/
# Given 2 strings s and p, return an array of all the start indices of p's anagrams in s.
# You may return the answer in any order.
# 1 <= s.length, p.length <= 3 * 104

from typing import List

class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        result=[]
        chars, curr_set = {}, {}
        if len(p) > len(s):
            return result
        # build dict from p
        for ch in p:
            if ch not in chars:
                chars[ch] = 1
            else:
                chars[ch] = chars[ch] + 1
        # test first window
        for i in range(len(p)):
            if s[i] in chars:
                if s[i] in curr_set:
                    curr_set[s[i]] = curr_set[s[i]] + 1
                else:
                    curr_set[s[i]] = 1
        if chars == curr_set:
            result.append(0)
        # test the rest
        for i in range(len(p), len(s)):
            if s[i-len(p)] in curr_set:
                count=curr_set[s[i-len(p)]]
                if count == 1:
                   del curr_set[s[i-len(p)]]
                else:
                    curr_set[s[i-len(p)]] = count-1
            if s[i] in chars:
                if s[i] not in curr_set:
                    curr_set[s[i]] = 1
                else:
                    count=curr_set[s[i]]
                    curr_set[s[i]] = count + 1
                if chars == curr_set:
                    result.append(i-len(p)+1)
        return result

if __name__ == '__main__':
    x=Solution()
    print(x.findAnagrams( "cbaebabacd", "abc"))


