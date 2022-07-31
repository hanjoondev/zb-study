from sys import stdin


def solution(b: list[str], h: int, w: int, k: int, word: str) -> int:
    def dfs(r: int, c: int, idx: int) -> int:
        if idx >= len_:
            return 1
        if dp[r][c][idx] != -1:
            return dp[r][c][idx]
        dp[r][c][idx] = 0
        for i in range(1, k + 1):
            for nr, nc in ((r + i, c), (r - i, c), (r, c + i), (r, c - i)):
                if 0 <= nr < h and 0 <= nc < w and b[nr][nc] == word[idx]:
                    dp[r][c][idx] += dfs(nr, nc, idx + 1)
        return dp[r][c][idx]

    ans, len_ = 0, len(word)
    dp = [[[-1] * len_ for _ in range(w)] for _ in range(h)]
    for r in range(h):
        for c in range(w):
            if b[r][c] == word[0]:
                ans += dfs(r, c, 1)
    return ans


def reader():
    read = stdin.readline
    n, m, k = map(int, read().split())
    b = [read().rstrip() for _ in range(n)]
    word = read().rstrip()
    print(solution(b, n, m, k, word))


if __name__ == '__main__':
    reader()
