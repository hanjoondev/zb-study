from collections import deque as dq
from sys import stdin as s


def bfs(m, h, w):
    v = [[0] * w for _ in range(h)]
    q = dq()
    q.append((0, 0, 1, 1))
    while q:
        r, c, dist, rem_demolitions = q.popleft()
        if r == h - 1 and c == w - 1:
            return dist
        for dr, dc in ((-1, 0), (1, 0), (0, -1), (0, 1)):
            if 0 <= (nr := r + dr) < h and 0 <= (nc := c + dc) < w:
                if not rem_demolitions:
                    if not v[nr][nc] and not m[nr][nc]:
                        v[nr][nc] = -1
                        q.append((nr, nc, dist + 1, 0))
                    continue
                if v[nr][nc] != 1:
                    v[nr][nc] = 1
                    if m[nr][nc] == 1:
                        m[nr][nc] = 2
                        q.append((nr, nc, dist + 1, rem_demolitions - 1))
                    elif not m[nr][nc]:
                        q.append((nr, nc, dist + 1, rem_demolitions))
    return -1


def reader():
    n, m = map(int, s.readline().split())
    board = [[int(c) for c in s.readline().strip()] for _ in range(n)]
    print(bfs(board, n, m))


if __name__ == '__main__':
    reader()
