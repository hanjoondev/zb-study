from sys import stdin


def solution(L: list[int], s: list[int], m: int) -> int:
    len_, sum_ = len(L) - 1, s[-1]
    dp = [[[0] * 2 for _ in range(len_ + 1)] for _ in range(len_ + 1)]
    for lft in range(1, m + 1):
        for rgt in range(len_ - (lft == 1), m - 1, -1):
            f, b, c = float('inf'), float('inf'), sum_ - s[rgt] + s[lft - 1]
            if lft != 1:
                f = min(f, dp[lft - 1][rgt][0] + c * (L[lft] - L[lft - 1]))
                b = min(b, dp[lft - 1][rgt][0] + c * (L[rgt] - L[lft - 1]))
            if rgt != len_:
                f = min(f, dp[lft][rgt + 1][1] + c * (L[rgt + 1] - L[lft]))
                b = min(b, dp[lft][rgt + 1][1] + c * (L[rgt + 1] - L[rgt]))
            dp[lft][rgt] = [f, b]
    return min(dp[m][m])


def reader():
    read = stdin.readline
    n, m = map(int, read().split())
    lampposts, prefix_sum = [0] * (n + 1), [0]
    for i in range(1, n + 1):
        lampposts[i], consumption = map(int, read().split())
        prefix_sum.append(prefix_sum[-1] + consumption)
    print(solution(lampposts, prefix_sum, m))


if __name__ == '__main__':
    reader()
