from sys import stdin, setrecursionlimit as limit


def solution(n: int, k: int) -> int:
    def dfs(a, b, c, d):
        if a == n:
            return not b
        if dp[a][b][c][d] != -1:
            return dp[a][b][c][d]
        dp[a][b][c][d] = 0
        if d < 10:
            for i in range(c, 10):
                dp[a][b][c][d] += (dfs(a + 1, b, c + d, d) if i == c + d
                                   else dfs(a + 1, b - 1, i, 10))
                dp[a][b][c][d] %= 1_000_000_007
        else:
            for i in range(c, 10):
                dp[a][b][c][d] += dfs(a + 1, b, i, i - c)
                dp[a][b][c][d] %= 1_000_000_007
        return dp[a][b][c][d]

    dp, ans = [[[[-1] * 11 for _ in range(11)] for _ in range(11)]
               for _ in range(n + 1)], 0
    for i in range(1, 10):
        ans += dfs(1, k - 1, i, 10)
        ans %= 1_000_000_007
    return ans


def reader():
    read = stdin.readline
    limit(int(1e6))
    n, a = map(int, read().split())
    print(solution(n, a) if a <= 9 else 0)


if __name__ == '__main__':
    reader()
