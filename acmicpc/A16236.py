from sys import stdin
from collections import deque as dq


class Fish:
    def __init__(self, r, c, w, dist=0):
        self.r = r
        self.c = c
        self.w = w
        self.dist = dist
        self.ate = 0

    def eat(self, fish) -> None:
        self.r = fish.r
        self.c = fish.c
        self.ate += 1
        if self.ate == self.w:
            self.w += 1
            self.ate = 0
        self.dist = 0

    def is_edible(self, shark) -> bool:
        self.dist = shark.dist + 1
        return self.w < shark.w


def bfs(shark: Fish, m: list[list[Fish, int]], n: int) -> list[Fish]:
    def get_positions():
        return [(r, c) for dr, dc in ((1, 0), (-1, 0), (0, 1), (0, -1))
                if 0 <= (r := s.r + dr) < n and 0 <= (c := s.c + dc) < n
                and not v[r][c] and (not m[r][c] or m[r][c].w <= s.w)]

    v = [[0] * n for _ in range(n)]
    q, v[shark.r][shark.c], ans = dq([shark]), 1, []
    while q:
        s = q.popleft()
        for r, c in get_positions():
            q.append(Fish(r, c, s.w, s.dist + 1))
            v[r][c] = 1
            if m[r][c] and m[r][c].is_edible(s):
                ans.append(m[r][c])
    return sorted(ans, key=lambda x: (x.dist, x.r, x.c))


def solution(m: list[list[Fish, int]], n: int, s: Fish) -> str:
    ans = 0
    while (fishes := bfs(s, m, n)):
        s.eat(fish := fishes[0])
        m[fish.r][fish.c], ans = 0, ans + fish.dist
    return ans


def reader():
    read = stdin.readline
    n = int(read().rstrip())
    m, s = [[0] * n for _ in range(n)], None
    weights = {i: 0 for i in range(7)}
    for r in range(n):
        for c, w in enumerate(map(int, read().split())):
            if 0 < w < 7:
                m[r][c] = Fish(r, c, w)
                weights[w] += 1
            elif w == 9:
                s = Fish(r, c, 2)
    if (not any(count for w, count in weights.items() if w and w < s.w)
        or all(type(f := m[nr][nc]) == Fish and f.w > s.w
               for dr, dc in ((0, 1), (0, -1), (1, 0), (-1, 0))
               if 0 <= (nr := s.r + dr) < n and 0 <= (nc := s.c + dc) < n)):
        print("0")
        return
    print(solution(m, n, s))


if __name__ == '__main__':
    reader()
