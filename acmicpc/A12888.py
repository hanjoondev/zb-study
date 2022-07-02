from sys import stdin


def solution(n: int) -> int:
    dp = [1, 1] + [0] * n
    for i in range(2, n + 1):
        dp[i] = dp[i - 1] * 2 + 1 - (2 * (i & 1))
    return dp[n]


def reader():
    read = stdin.readline
    print(solution(int(read().rstrip())))


if __name__ == '__main__':
    reader()
