from sys import stdin


def solution(m: list[str], n: int) -> int:
    dp = [[i == j for j in range(n)] for i in range(n)]
    for i in range(n - 1, 0, -1):
        ndp = [[0] * n for _ in range(n)]
        for j in range(i):
            c = m[j][i - j - 1]
            for k in [k for k in range(n - i, n)
                      if c == m[k][2 * n - i - k - 1]]:
                ndp[j][k] += (dp[j][k]
                              + dp[j + 1][k] * (a := j + 1 < n)
                              + dp[j][k - 1] * (b := k - 1 >= 0)
                              + dp[j + 1][k - 1] * (a and b))
                ndp[j][k] %= 1000000007
        dp = ndp
    return dp[0][-1]


def reader():
    read = stdin.readline
    n = int(read())
    farm = [read().rstrip() for _ in range(n)]
    print(solution(farm, n))


if __name__ == '__main__':
    reader()
