from sys import stdin


class SegTree:
    def __init__(self, arr: list[int], n: int, m: int) -> None:
        self.arr = arr
        for i in range(1, n):
            self.arr[i] += self.arr[i - 1]
        self.q = [[] for _ in range(m)]
        self.i = 0


def reader():
    read = stdin.readline
    n, m, k = map(int, read().split())
    st, i = SegTree(list(map(int, read().split())), n, m), 0
    for _ in range(m + k):
        a, b, *c = map(int, read().split())
        c, d, ans = c[0], c[1] if len(c) > 1 else None, 0
        if a == 1:
            ans = st.arr[c - 1] - st.arr[b - 2] * (b >= 2)
            for q in st.q:
                if not q:
                    break
                s, e, l = q
                ans += max(0, min(e, c) - max(s, b) + 1) * l
            print(ans)
        else:
            st.q[i] = b, c, d
            i += 1


if __name__ == '__main__':
    reader()
