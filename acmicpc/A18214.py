from sys import stdin


def solution(s: list[int], n: int, m: int) -> int:
    if not m:
        return 0
    max_, min_ = [0] * (n + 3), [mod := int(1e9) + 7] * (n + 3)
    for i in range(n):
        max_[i + 1] = max(max_[i], s[i])
        min_[n - i - 1] = min(min_[n - i], s[n - i - 1])
    dp = [0, 1]
    for i in range(1, n):
        tmp = [0] * (i + 2)
        if max_[i + 1] == s[i]:
            b = min_[i + 1] >= max_[i]
            for j in range(i + 1):
                tmp[j + 1] = dp[j] + dp[i - j] * b
        elif min_[i] == s[i]:
            for j in range(i + 1):
                tmp[j] = dp[j]
        dp = [k % mod for k in tmp]
    return (sum(dp[n - m:m + 1]) * 2) % mod


def reader():
    read = stdin.readline
    n, m = map(int, read().split())
    s = [int(c) for c in input().split()]
    print(solution(s, n, m))


if __name__ == '__main__':
    reader()
