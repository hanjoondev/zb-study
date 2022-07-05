from sys import stdin, setrecursionlimit as limit


class SegTree:
    def __init__(self, arr: list[int], n: int) -> None:
        self.arr = arr
        bin_ = len(bin(n))
        self.seg = [0] * (1 << bin_ - (1 << (bin_ - 3) == n) - 1)
        self.build(1, 0, n - 1)

    def build(self, i, s, e):
        if s == e:
            self.seg[i] = (self.arr[s], self.arr[s])
            return self.seg[i]
        m = (s + e) >> 1
        lft = self.build(i * 2, s, m)
        rgt = self.build(i * 2 + 1, m + 1, e)
        self.seg[i] = (min(lft[0], rgt[0]), max(lft[1], rgt[1]))
        return self.seg[i]

    def find(self, i, s, e, a, b):
        if e < a or b < s:
            return (int(1e9), 0)
        m = (s + e) >> 1
        if a <= s and e <= b:
            return self.seg[i]
        lft = self.find(i * 2, s, m, a, b)
        rgt = self.find(i * 2 + 1, m + 1, e, a, b)
        return (min(lft[0], rgt[0]), max(lft[1], rgt[1]))


def reader():
    limit(int(1e6))
    read = stdin.readline
    n, m = map(int, read().split())
    tree = SegTree([int(read().rstrip()) for _ in range(n)], n)
    ans = []
    for _ in range(m):
        a, b = map(int, read().split())
        min_, max_ = tree.find(1, 0, n - 1, a - 1, b - 1)
        ans.append(f'{min_} {max_}')
    print('\n'.join(ans))


if __name__ == '__main__':
    reader()
