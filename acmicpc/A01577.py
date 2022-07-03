from sys import stdin
from functools import cmp_to_key


def compare(a, b):
    return a[0] - b[0] if a[0] != b[0] else a[1] - b[1]


def solution(roads: list[list[tuple[int]]], h: int, w: int) -> int:
    def dfs(r, c):
        if r == h and c == w:
            return 1
        if dp[r][c]:
            return dp[r][c]
        if (r, c) not in vert and r + 1 <= h:
            dp[r][c] += dfs(r + 1, c)
        if (r, c) not in hori and c + 1 <= w:
            dp[r][c] += dfs(r, c + 1)
        return dp[r][c]

    vert, hori = {}, {}
    dp = [[0] * (w + 1) for _ in range(h + 1)]
    for (r1, c1), (r2, c2) in roads:
        if r1 < r2:
            vert[(r1, c1)] = 1
        elif c1 < c2:
            hori[(r1, c1)] = 1
    return dfs(0, 0)


def reader():
    read = stdin.readline
    n, m = map(int, read().split())
    k = int(read().rstrip())
    roads = []
    for _ in range(k):
        r1, c1, r2, c2 = map(int, read().split())
        roads.append(sorted([(r1, c1), (r2, c2)], key=cmp_to_key(compare)))
    print(solution(roads, n, m))


if __name__ == '__main__':
    reader()
