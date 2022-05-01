from sys import stdin as s


def solution(t: int, w: int, plums: list[int]) -> None:
    dp = [[0] * (w + 1) for _ in range(t)]
    for i in range(w + 1):
        dp[0][i] += plums[0] - 1 == i % 2
    for i in range(1, t):
        dp[i][0] = dp[i - 1][0] + 1 * (not (p := plums[i] - 1))
        for j in range(1, w + 1):
            dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - 1]) + (p == j % 2)
    print(max(dp[-1]))


def reader():
    t, w = map(int, s.readline().split())
    plums = [int(s.readline()) for _ in range(t)]
    solution(t, w, plums)


if __name__ == '__main__':
    reader()
