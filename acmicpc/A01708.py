from sys import stdin
from functools import reduce


def graham(pts):
    def turn(p, q, r):
        a = (q[0] - p[0]) * (r[1] - p[1]) - (r[0] - p[0]) * (q[1] - p[1])
        return (a > 0) - (a < 0)

    def find(h, r):
        while len(h) > 1 and turn(h[-2], h[-1], r) != 1:
            h.pop()
        if not len(h) or h[-1] != r:
            h.append(r)
        return h

    pts.sort()
    l, u = reduce(find, pts, []), reduce(find, reversed(pts), [])
    return l.extend(u[i] for i in range(1, len(u) - 1)) or l


def reader():
    read = stdin.readline
    pts = [list(map(int, read().split())) for _ in range(int(read().strip()))]
    print(len(graham(pts)))


if __name__ == '__main__':
    reader()
