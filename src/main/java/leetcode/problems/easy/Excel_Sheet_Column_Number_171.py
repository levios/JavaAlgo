# 171. Excel Sheet Column Number
# https://leetcode.com/problems/excel-sheet-column-number/
# Given a string columnTitle that represents the column title as appear in an Excel sheet
# return its corresponding column number.

class Solution:
    def titleToNumber(self, columnTitle: str) -> int:
        alphabet = list(string.ascii_uppercase)
        num = 0
        idx = 0
        for col in columnTitle[::-1] :
            index = alphabet.index(col)
            num += pow(26,idx) * (index+1)
            idx += 1
        return num

    def titleToNumber_2(self, columnTitle: str) -> int:
        ans, pos = 0, 0
        for letter in reversed(columnTitle):
            digit = ord(letter)-64
            ans += digit * 26**pos
            pos += 1

        return ans