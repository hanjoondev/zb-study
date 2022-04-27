from sys import stdin as s


class Trie:
    def __init__(self):
        self.root = {}

    def insert(self, word: str) -> str:
        node = self.root
        first_branch = True
        ans = word
        for i, c in enumerate(word):
            if c not in node.keys():
                if first_branch:
                    first_branch = False
                    ans = ans[:i + 1]
                node[c] = {}
            node = node[c]
        node['count'] = node.get('count', 0) + 1
        ans += str(node['count']) if node['count'] > 1 else ""
        return ans


def reader():
    t = Trie()
    print('\n'.join(t.insert(s.readline().strip())
                    for _ in range(int(s.readline()))))


if __name__ == '__main__':
    reader()
