from sys import stdin
from heapq import heappush as hpush, heappop as hpop


def solution(g: dict[int, dict[int, int]], n: int, v1: int, v2: int) -> int:
    def dijkstra(node: int) -> int:
        q, d = [], [float('inf') if i != node else 0 for i in range(n + 1)]
        hpush(q, (0, node))
        while q:
            dist, fr = hpop(q)
            if d[fr] < dist:
                continue
            for to, cost in g[fr].items():
                if d[to] > (cost := cost + dist):
                    d[to] = cost
                    hpush(q, (cost, to))
        return d

    d0, d1, d2 = dijkstra(1), dijkstra(v1), dijkstra(v2)
    p1, p2 = d0[v1] + d1[v2] + d2[n], d0[v2] + d1[n] + d2[v1]
    return ans if (ans := min(p1, p2)) < float('inf') else -1


def reader():
    read = stdin.readline
    n, e = map(int, read().split())
    g = {i: {} for i in range(1, n + 1)}
    for _ in range(e):
        a, b, c = map(int, read().split())
        g[a][b] = g[b][a] = c
    v1, v2 = map(int, read().split())
    print(solution(g, n, v1, v2))


if __name__ == '__main__':
    reader()
