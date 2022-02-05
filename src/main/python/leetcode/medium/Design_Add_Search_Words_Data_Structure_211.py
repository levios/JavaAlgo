# 211. Design Add and Search Words Data Structure
# https://leetcode.com/problems/design-add-and-search-words-data-structure/
#
# Design a data structure that supports adding new words and finding if a string matches any previously added string.
# Implement the WordDictionary class
# 1 <= word.length <= 500

from collections import deque
#from leetcode import CharTrie

class CharTrie:
    def __init__(self, value, leaf=False, children=None):
        self.value = value
        self.leaf = leaf
        if children is None:
            self.children = []

class WordDictionary:

    # WordDictionary() Initializes the object.
    def __init__(self):
        self.root=CharTrie('')

    # void addWord(word) Adds word to the data structure, it can be matched later.
    def addWord(self, word: str) -> None:
        self.addWord_rec(word, self.root)

    def addWord_rec(self, word: str, trie) -> None:
        if len(word) == 0:
            trie.leaf=True
            return
        c=word[0]
        ch=None
        for child in trie.children:
            if child.value is c:
                ch=child
                break
        if ch is None:
            ch=CharTrie(c)
            trie.children.append(ch)
        # finally recurse
        self.addWord_rec(word[1:], ch)


    # bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise.
    # word may contain dots '.' where dots can be matched with any letter.
    def search(self, word: str) -> bool:
        return self.dfs(word, self.root)

    def dfs(self, word: str, trie) -> bool:
        if len(word) == 0:
            return trie.leaf
        c = word[0]
        if c == '.':
            for child in trie.children:
                if self.dfs(word[1:], child):
                    return True
            return False
        else:
            for child in trie.children:
                if child.value is c:
                    return self.dfs(word[1:], child)
            return False


if __name__ == '__main__':
    # wordDictionary=WordDictionary()
    # wordDictionary.addWord("bad")
    # wordDictionary.addWord("dad")
    # wordDictionary.addWord("mad")
    # print(wordDictionary.search("pad")) # return False
    # print(wordDictionary.search("bad")) # return True
    # print(wordDictionary.search(".ad")) # return True
    # print(wordDictionary.search("b..")) # return True

    wd2=WordDictionary()
    wd2.addWord("at")
    wd2.addWord("and")
    wd2.addWord("an")
    wd2.addWord("add")
    print(wd2.search("a"))
    print(wd2.search(".at"))
    wd2.addWord("bat")
    print(wd2.search(".at"))
    print(wd2.search("an."))
    print(wd2.search("a.d."))
    print(wd2.search("b."))
    print(wd2.search("a.d"))
    print(wd2.search("."))


# Your WordDictionary object will be instantiated and called as such:
# obj = WordDictionary()
# obj.addWord(word)
# param_2 = obj.search(word)