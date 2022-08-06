from sys import stdin, setrecursionlimit as limit


class SegTree:
    def __init__(self, arr: list[int], n: int) -> None:
        self.arr, self.n, b = arr, n - 1, len(bin(n))
        self.tree = [0] * (1 << b - (1 << (b - 3) == n) - 1)
        self.lazy = [0] * (1 << b - (1 << (b - 3) == n) - 1)
        self.build(0, 0, n - 1)

    def build(self, i, s, e):
        if s > e:
            return 0
        if s == e:
            self.tree[i] = self.arr[s]
            return self.tree[i]
        m = s + e >> 1
        lft = self.build(i * 2 + 1, s, m)
        rgt = self.build(i * 2 + 2, m + 1, e)
        self.tree[i] = lft + rgt
        return self.tree[i]

    def _sum(self, i, s, e, left, right) -> int:
        if lv := self.lazy[i]:
            self.tree[i] += (e - s + 1) * lv
            if s != e:
                self.lazy[i * 2 + 1] += lv
                self.lazy[i * 2 + 2] += lv
            self.lazy[i] = 0
        if left > e or right < s:
            return 0
        if left <= s and right >= e:
            return self.tree[i]
        m = s + e >> 1
        lft = self._sum(i * 2 + 1, s, m, left, right)
        rgt = self._sum(i * 2 + 2, m + 1, e, left, right)
        return lft + rgt

    def update(self, i, s, e, left, right, diff) -> None:
        if lv := self.lazy[i]:
            self.tree[i] += (e - s + 1) * lv
            if s != e:
                self.lazy[i * 2 + 1] += lv
                self.lazy[i * 2 + 2] += lv
            self.lazy[i] = 0
        if left > e or right < s:
            return
        if left <= s and right >= e:
            self.tree[i] += (e - s + 1) * diff
            if s != e:
                self.lazy[i * 2 + 1] += diff
                self.lazy[i * 2 + 2] += diff
            return
        m = s + e >> 1
        self.update(i * 2 + 1, s, m, left, right, diff)
        self.update(i * 2 + 2, m + 1, e, left, right, diff)
        self.tree[i] = self.tree[i * 2 + 1] + self.tree[i * 2 + 2]

    def update_helper(self, b, c, d) -> None:
        self.update(0, 0, self.n, b - 1, c - 1, d)

    def sum_helper(self, a, b) -> str:
        return str(self._sum(0, 0, self.n, a - 1, b - 1))


def reader():
    limit(int(1e6))
    read = stdin.readline
    n, m, k = map(int, read().split())
    st, ans = SegTree([int(read()) for _ in range(n)], n), []
    for _ in range(m + k):
        a, b, *c = map(int, read().split())
        if a == 1:
            st.update_helper(b, c[0], c[1])
        else:
            ans.append(st.sum_helper(b, c[0]))
    print('\n'.join(ans))


if __name__ == '__main__':
    reader()
