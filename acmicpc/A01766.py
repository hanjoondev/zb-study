from sys import stdin
from heapq import heappush as hpush, heappop as hpop, heapify


def solution(g: dict[int, list[int]], r: dict[int, int], n: int) -> int:
    ans, q = [], [i for i in range(1, n + 1) if i not in r]
    heapify(q)
    while q:
        ans.append(str(idx := hpop(q)))
        if idx not in g:
            continue
        for i in g[idx]:
            r[i] -= 1
            if not r[i]:
                hpush(q, i)
    return ' '.join(ans)


def reader():
    read = stdin.readline
    n, m = map(int, read().split())
    g, r = {}, {}
    for _ in range(m):
        a, b = map(int, read().split())
        g.setdefault(a, []).append(b)
        r[b] = r.get(b, 0) + 1
    print(solution(g, r, n))


if __name__ == '__main__':
    reader()
