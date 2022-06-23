from sys import stdin
from collections import deque as dq


def solution(m: list[str], h: int, w: int) -> str:
    v, ans = [[False] * w for _ in range(h)], {k: 0 for k in 'WB'}
    for r in range(h):
        for c in range(w):
            if v[r][c]:
                continue
            q, color, count, v[r][c] = dq(), m[r][c], 1, True
            q.append((r, c))
            while q:
                tr, tc = q.popleft()
                for dr, dc in ((0, 1), (0, -1), (1, 0), (-1, 0)):
                    nr, nc = tr + dr, tc + dc
                    if 0 <= nr < h and 0 <= nc < w and m[nr][nc] == color and not v[nr][nc]:
                        v[nr][nc] = True
                        q.append((nr, nc))
                        count += 1
            ans[color] += count**2
    return ' '.join(map(str, ans.values()))


def reader():
    read = stdin.readline
    w, h = map(int, read().split())
    print(solution([read().strip() for _ in range(h)], h, w))


if __name__ == '__main__':
    reader()
