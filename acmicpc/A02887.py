from sys import stdin
from heapq import heappop as hpop, heappush as hpush


def find(parent, i):
    while i != parent[i]:
        i = parent[i]
    return i


def reader():
    read = stdin.readline
    n = int(read().strip())
    x, y, z, h, parents, ans = [], [], [], [], [i for i in range(n)], 0
    for i in range(n):
        a, b, c = map(int, read().split())
        x.append((a, i))
        y.append((b, i))
        z.append((c, i))
    x.sort()
    y.sort()
    z.sort()
    for i in range(n - 1):
        hpush(h, (abs(x[i][0] - x[i + 1][0]), x[i][1], x[i + 1][1]))
        hpush(h, (abs(y[i][0] - y[i + 1][0]), y[i][1], y[i + 1][1]))
        hpush(h, (abs(z[i][0] - z[i + 1][0]), z[i][1], z[i + 1][1]))
    while h:
        cost, a, b = hpop(h)
        if (a := find(parents, a)) != (b := find(parents, b)):
            if a > b:
                parents[b] = a
            else:
                parents[a] = b
            ans += cost
    print(ans)


if __name__ == '__main__':
    reader()
