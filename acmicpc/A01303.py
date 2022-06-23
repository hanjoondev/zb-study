from sys import stdin


def solution(m: list[str], h: int, w: int) -> str:
    def dfs(r, c):
        if not 0 <= r < h or not 0 <= c < w or v[r][c] or m[r][c] != color:
            return
        v[r][c] = True
        dfs(r + 1, c)
        dfs(r - 1, c)
        dfs(r, c + 1)
        dfs(r, c - 1)
        dfs.count += 1

    v, ans = [[False] * w for _ in range(h)], {k: 0 for k in 'WB'}
    for r in range(h):
        for c in range(w):
            if v[r][c]:
                continue
            color, dfs.count = m[r][c], 0
            dfs(r, c)
            ans[color] += dfs.count**2
    return ' '.join(map(str, ans.values()))


def reader():
    read = stdin.readline
    w, h = map(int, read().split())
    print(solution([read().strip() for _ in range(h)], h, w))


if __name__ == '__main__':
    reader()
