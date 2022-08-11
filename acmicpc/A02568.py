from sys import stdin
from heapq import heappush as hpush, heappop as hpop
from bisect import bisect_left as bl


def solution(d: dict[int, int], q: list[int]) -> str:
    r, s, t = [], [], []
    for n in q:
        if (idx := bl(r, n)) != len(r):
            r[idx] = n
        else:
            r.append(n)
        s.append(idx + 1)
    lr = len(r)
    for i in range(len(s) - 1, -1, -1):
        if s[i] == lr:
            lr -= 1
        else:
            t.append(d[q[i]])
    return '\n'.join(map(str, [len(q) - len(r)] + t[::-1]))


def reader():
    read = stdin.readline
    n, d, e, h, q = int(read()), {}, {}, [], []
    for _ in range(n):
        a, b = map(int, read().split())
        d[a], e[b] = b, a
        hpush(h, a)
    while h:
        q.append(d[hpop(h)])
    print(solution(e, q))


if __name__ == '__main__':
    reader()
