from sys import stdin as s


def solution(m: list[list[int]], coins: list[tuple[int]],
             h: int, w: int) -> None:
    def dfs(coin1, coin2, idx) -> None:
        if idx == dfs.len or idx == dfs.res:
            return
        (r1, c1), (r2, c2) = coin1, coin2
        for dr, dc in ((0, 1), (0, -1), (1, 0), (-1, 0)):
            nr1, nc1, nr2, nc2 = r1 + dr, c1 + dc, r2 + dr, c2 + dc
            if (not (0 <= nr1 < h and 0 <= nc1 < w) 
                and not (0 <= nr2 < h and 0 <= nc2 < w)):
                continue
            if not (0 <= nr1 < h and 0 <= nc1 < w 
                and 0 <= nr2 < h and 0 <= nc2 < w):
                dfs.res = min(dfs.res, idx + 1)
                continue
            nr1, nc1 = coin1 if m[nr1][nc1] else (nr1, nc1)
            nr2, nc2 = coin2 if m[nr2][nc2] else (nr2, nc2)
            if v[nr1][nc1][nr2][nc2]:
                continue
            v[nr1][nc1][nr2][nc2] = 1
            dfs((nr1, nc1), (nr2, nc2), idx + 1)
            v[nr1][nc1][nr2][nc2] = 0

    v = [[[[0] * w for _ in range(h)] for _ in range(w)] for _ in range(h)]
    v[coins[0][0]][coins[0][1]][coins[1][0]][coins[1][1]] = 1
    dfs.len, dfs.res = 10, float('inf')
    dfs(coins[0], coins[1], 0)
    print(dfs.res if dfs.res != float('inf') else -1)


def reader():
    n, m = map(int, s.readline().split())
    b = []
    coins = []
    for r in range(n):
        row = []
        for c, e in enumerate(s.readline().strip()):
            if e == '.':
                row.append(0)
            elif e == '#':
                row.append(1)
            else:
                row.append(0)
                coins.append((r, c))
        b.append(row)
    solution(b, coins, n, m)


if __name__ == '__main__':
    reader()
