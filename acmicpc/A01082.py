from sys import stdin


def solution(prices: list[int], n: int, m: int,) -> str:
    dp = [0] * (m + 1)
    for i in range(m):
        for j in range(n):
            if (tmp := prices[j] + i) <= m:
                dp[tmp] = max(dp[tmp], dp[i] * 10 + j)
    return dp[-1]


def reader():
    read = stdin.readline
    n = int(read())
    p = list(map(int, read().split()))
    m = int(read())
    print(solution(p, n, m) if n != 1 else '0')


if __name__ == '__main__':
    reader()
