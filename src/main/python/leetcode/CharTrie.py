
class CharTrie:

    def __init__(self, value, leaf=False, children=None):
        self.value = value
        self.leaf = leaf
        if children is None:
            self.children = []