from sys import stdin, setrecursionlimit as limit


class WeightedUF:
    def __init__(self, length):
        self.p = {i: i for i in range(1, length + 1)}
        self.r = {i: 0 for i in range(1, length + 1)}

    def find(self, k):
        if k == self.p[k]:
            return k
        p = self.find(self.p[k])
        self.r[k] += self.r[self.p[k]]
        self.p[k] = p
        return p

    def union(self, a, b, w):
        pa, pb = self.find(a), self.find(b)
        w += self.r[a] - self.r[b]
        if pa < pb:
            self.p[pb], self.r[pb] = pa, w
        else:
            self.p[pa], self.r[pa] = pb, -w


def reader():
    read = stdin.readline
    limit(10**9)
    ans = []
    while True:
        n, m = map(int, read().split())
        if n == m == 0:
            break
        uf = WeightedUF(n)
        for _ in range(m):
            c, *data = read().split()
            if c == '!':
                a, b, w = map(int, data)
                uf.union(a, b, w)
                continue
            a, b = map(int, data)
            matched = uf.find(a) == uf.find(b)
            ans.append(str(uf.r[b] - uf.r[a]) if matched else 'UNKNOWN')
    print('\n'.join(ans))


if __name__ == '__main__':
    reader()
