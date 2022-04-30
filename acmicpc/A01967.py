from sys import stdin as s
from collections import deque as dq


def bfs(graph, start=1, first_run=True):
    q = dq()
    q.append((start, 0))
    visited = [False] * (max(graph) + 1)
    visited[start]= True
    farthest = max_cost = 0
    while q:
        node, cost = q.popleft()
        if max_cost < cost:
            max_cost = cost
            farthest = node
        for n, c in graph[node].items():
            if not visited[n]:
                q.append((n, c + cost))
                visited[n] = True
    return bfs(graph, farthest, False) if first_run else max_cost


def reader():
    length = int(s.readline())
    graph = {i: {} for i in range(length + 1)}
    for _ in range(length - 1):
        pnode, cnode, cost = [int(n) for n in s.readline().split()]
        graph[pnode].update({cnode: cost})
        graph[cnode].update({pnode: cost})
    print(bfs(graph))


if __name__ == '__main__':
    reader()
