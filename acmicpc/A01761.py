from sys import stdin
from collections import deque as dq


def solution(graph: dict[int, list[tuple[int]]],
             queries: list[list[int]], n: int) -> str:
    def fill():
        q, p[1] = dq([1]), -1
        while q:
            for dst, cost in graph[src := q.popleft()]:
                if p[dst]:
                    continue
                d[dst], p[dst], dist[dst] = d[src] + 1, src, dist[src] + cost
                q.append(dst)

    def get_lca(fr, to) -> str:
        if d[fr] < d[to]:
            fr, to = to, fr
        while d[fr] != d[to]:
            fr = p[fr]
        while fr != to:
            fr, to = p[fr], p[to]
        return fr

    p, d, dist = [0] * n, [0] * n, [0] * n
    fill()
    return '\n'.join(str(dist[f] + dist[t] - dist[get_lca(f, t)] * 2)
                     for f, t in queries)


def reader():
    read = stdin.readline
    n = int(read().rstrip())
    g = {}
    for _ in range(n - 1):
        a, b, dist = map(int, read().split())
        g.setdefault(a, []).append((b, dist))
        g.setdefault(b, []).append((a, dist))
    k = int(read().rstrip())
    q = [list(map(int, read().split())) for _ in range(k)]
    print(solution(g, q, n + 1))


if __name__ == '__main__':
    reader()
