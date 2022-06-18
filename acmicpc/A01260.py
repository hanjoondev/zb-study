from sys import stdin
from collections import deque as dq


def solution(d: dict[int, set[int]], start: int):
    def dfs(i):
        if dv[i]:
            return
        dv[i] = True
        res_d.append(i)
        for w in d[i]:
            dfs(w)

    d = {k: sorted(v) for k, v in d.items()}
    bfs_q = dq([start])
    bv, dv = {k: 0 for k in d.keys()}, {k: 0 for k in d.keys()}
    bv[start], res_b, res_d = 1, [start], []
    dfs(start)
    while bfs_q:
        u = bfs_q.popleft()
        for w in d[u]:
            if not bv[w]:
                bv[w] = True
                bfs_q.append(w)
                res_b.append(w)
    return f"{' '.join(map(str, res_d))}\n{' '.join(map(str, res_b))}"


def reader():
    read = stdin.readline
    n, m, start = map(int, read().split())
    d = {}
    for _ in range(m):
        v, w = map(int, read().split())
        d.setdefault(v, []).append(w)
        d.setdefault(w, []).append(v)
    print(solution(d, start) if start in d else f'{start}\n{start}')


if __name__ == '__main__':
    reader()
