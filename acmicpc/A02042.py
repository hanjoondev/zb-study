from sys import stdin, setrecursionlimit as limit


class SegTree:
    def __init__(self, arr: list[int], n: int) -> None:
        self.arr = arr
        self.n = n - 1
        self.seg = [0] * (n * 4)
        self.build(1, 0, n - 1)

    def build(self, i, s, e):
        if s == e:
            self.seg[i] = self.arr[s]
            return self.seg[i]
        m = (s + e) >> 1
        lft = self.build(i * 2, s, m)
        rgt = self.build(i * 2 + 1, m + 1, e)
        self.seg[i] = lft + rgt
        return self.seg[i]

    def find(self, n, s, e, left, right) -> int:
        if right < s or left > e:
            return 0
        if left <= s and e <= right:
            return self.seg[n]
        m = (s + e) >> 1
        lft = self.find(n * 2, s, m, left, right)
        rgt = self.find(n * 2 + 1, m + 1, e, left, right)
        return lft + rgt

    def update(self, n, s, e, idx, diff) -> None:
        if idx < s or idx > e:
            return
        self.seg[n] += diff
        if s == e:
            return
        m = (s + e) >> 1
        self.update(n * 2, s, m, idx, diff)
        self.update(n * 2 + 1, m + 1, e, idx, diff)

    def update_helper(self, a, b) -> None:
        d = b - self.arr[a := a - 1]
        self.update(1, 0, self.n, a, d)
        self.arr[a] = b

    def find_helper(self, a, b) -> str:
        return str(self.find(1, 0, self.n, a - 1, b - 1))


def reader():
    limit(int(1e6))
    read = stdin.readline
    n, m, k = map(int, read().split())
    tree = SegTree([int(read().rstrip()) for _ in range(n)], n)
    ans = []
    for _ in range(m + k):
        a, b, c = map(int, read().split())
        if a == 1:
            tree.update_helper(b, c)
        else:
            ans.append(tree.find_helper(b, c))
    print('\n'.join(ans))


if __name__ == '__main__':
    reader()
