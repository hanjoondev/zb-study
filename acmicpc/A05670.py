from sys import stdin as s


class Trie:
    def __init__(self):
        self.root = {}

    def add(self, word: str) -> None:
        """ adds a word to the Trie """
        node = self.root
        for char in word:
            if char not in node:
                node[char] = {}
            node = node[char]
        node["EOL"] = True

    def startswith(self, prefix: str) -> dict:
        """ returns node with given prefix """
        node = self.root
        for char in prefix:
            if char not in node.keys():
                return None
            node = node[char]
        return node

    def count(self, word: str) -> int:
        """ count the number of node which has more than 1 child """
        node = self.startswith(word[0])
        cnt = 1
        for c in word[1:]:
            if len(node) > 1 or node.get("EOL", False):
                cnt += 1
            node = node[c]
        return cnt


def solution(n: int, words: list[str]) -> None:
    t = Trie()
    for word in words:
        t.add(word)
    counts = sum(t.count(w) for w in words)
    print(f'{counts / n:.2f}')


def reader():
    while True:
        try:
            n = int(s.readline())
        except:
            break
        words = [s.readline().strip() for _ in range(n)]
        solution(n, words)


if __name__ == '__main__':
    reader()


'''
4
hello
hell
heaven
goodbye
3
hi
he
h
7
structure
structures
ride
riders
stress
solstice
ridiculous
'''  # input
'''
2.00
1.67
2.71
'''  # expected
