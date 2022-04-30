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
    graph = {i: {} for i in range(1, length + 1)}
    for _ in range(length):
        data = [int(n) for n in s.readline().split()]
        for cnode, cost in zip(*[iter(data[1:-1])] * 2):
            graph[data[0]].update({cnode: cost})
            graph[cnode].update({data[0]: cost})
    print(bfs(graph))


if __name__ == '__main__':
    reader()
