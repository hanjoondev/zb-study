from sys import stdin as s


def reader():
    n = int(s.readline())
    dp = [list(map(int, s.readline().split())) for _ in range(n)]
    r, g, b = 0, 1, 2
    for i in range(1, n):
        prev = i - 1
        dp[i][r] += min(dp[prev][g], dp[prev][b])
        dp[i][g] += min(dp[prev][r], dp[prev][b])
        dp[i][b] += min(dp[prev][r], dp[prev][g])
    print(min(dp[-1]))


if __name__ == '__main__':
    reader()
