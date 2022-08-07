from sys import stdin, setrecursionlimit as limit


class SegTree:
    def __init__(self, arr: list[int], n: int) -> None:
        self.arr, self.n, b = arr, n - 1, len(bin(n))
        self.tree = [0] * (1 << b - (1 << (b - 3) == n) - 1)

    def _sum(self, i, s, e, n, x) -> int:
        if x < s or e < n:
            return 0
        elif n <= s and e <= x:
            return self.tree[i]
        lft = self._sum(i * 2 + 1, s, m := s + e >> 1, n, x)
        rgt = self._sum(i * 2 + 2, m + 1, e, n, x)
        return lft + rgt

    def update(self, i, s, e, n, k) -> None:
        if s <= n <= e:
            if s == e:
                self.tree[i] += k
                return self.tree[i]
            lft = self.update(i * 2 + 1, s, m := s + e >> 1, n, k)
            rgt = self.update(i * 2 + 2, m + 1, e, n, k)
            self.tree[i] = lft + rgt
        return self.tree[i]

    def update_helper(self, b, c, d) -> None:
        self.update(0, 0, self.n, b - 1, d)
        self.update(0, 0, self.n, c, -d)

    def sum_helper(self, x) -> str:
        return str(self._sum(0, 0, self.n, 0, x - 1) + self.arr[x - 1])


def reader():
    limit(int(1e6))
    read = stdin.readline
    n = int(read())
    st, ans = SegTree(list(map(int, read().split())), n), []
    for _ in range(int(read())):
        a, *b = map(int, read().split())
        b, c, d = b[0], b[1] if len(b) > 1 else None, b[2] if len(b) > 1 else None
        if a == 1:
            st.update_helper(b, c, d)
        else:
            ans.append(st.sum_helper(b))
    print('\n'.join(ans))


if __name__ == '__main__':
    reader()
