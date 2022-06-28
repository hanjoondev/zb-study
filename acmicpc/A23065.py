from sys import stdin
from collections import deque as dq


def solution(g: dict[int, list[int]], n: int) -> str:
    def bfs():
        q = dq([i for i in range(1, n + 1) if not d[i]])
        while q:
            u = q.popleft()
            for v in g[u]:
                if not ~d[v]:
                    q.append(v)
                    p[v] = u
                    d[v] = d[u] + 1

    p, d = [0] * (n + 1), [-1 if i != 1 else 0 for i in range(n + 1)]
    bfs()
    d = [-1 if i != (s := d.index(max(d[1:]))) else 0 for i in range(n + 1)]
    bfs()
    i, path = d.index(max(d[1:])), []
    while i ^ s:
        path.append(i)
        i = p[i]
    d = [-1] * (n + 1)
    for i in path:
        d[i] = 0
    bfs()
    if max(d[1:]) > 2:
        return 'NO'
    a = []
    for i in range(1, len(path)):
        for j in g[path[i]]:
            if d[j] and len(g[j]) > 1:
                a.append(path[i]), a.append(j)
        a.append(path[i])
    b = f'YES\n{2 * len(a)}\n'
    return b + f"{' '.join(map(str, a))} {' '.join(map(str, a[::-1]))}"


def reader():
    read = stdin.readline
    n, m, = map(int, read().split())
    graph = {i: [] for i in range(1, n + 1)}
    for _ in range(m):
        u, v = map(int, read().split())
        graph[u].append(v), graph[v].append(u)
    if n <= 2:
        print(f"YES\n{n}\n1{'' if n == 1 else ' 1'}")
        return
    if n <= m:
        print('NO')
        return
    print(solution(graph, n))


if __name__ == '__main__':
    reader()
