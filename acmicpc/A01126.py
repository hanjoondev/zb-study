from sys import stdin


def solution(heights: list[int], n: int) -> int:
    def dfs(i, d):
        if i == n or d > 250_000:
            return 0 if i - n == d == 0 else -float('inf')
        if dp[i][d] != -1:
            return dp[i][d]
        h = heights[i]
        dp[i][d] = max(dfs(i + 1, d), dfs(i + 1, d + h),
                       dfs(i + 1, abs(h - d)) + min(h, d))
        return dp[i][d]

    dp = [[-1] * 250001 for _ in range(n + 1)]
    return ans if (ans := dfs(0, 0)) > 0 else -1


def reader():
    read = stdin.readline
    n = int(read())
    heights = list(map(int, read().split()))
    print(solution(heights, n))


if __name__ == '__main__':
    reader()
