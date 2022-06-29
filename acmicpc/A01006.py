from sys import stdin


def solution(n: int, w: int, i_: list[int], o_: list[int]) -> str:
    def gen(idx):
        for i in range(idx, n + 1):
            dp[i + 1][2] = min(dp[i][0] + 1, dp[i][1] + 1)
            if i_[i] + o_[i] <= w:
                dp[i + 1][2] = min(dp[i + 1][2], dp[i][2] + 1)
            if i_[i - 1] + i_[i] <= w and o_[i - 1] + o_[i] <= w:
                dp[i + 1][2] = min(dp[i + 1][2], dp[i - 1][2] + 2)
            if i == n:
                continue
            dp[i + 1][0], dp[i + 1][1] = dp[i + 1][2] + 1, dp[i + 1][2] + 1
            if i_[i] + i_[i + 1] <= w:
                dp[i + 1][0] = min(dp[i + 1][0], dp[i][1] + 1)
            if o_[i] + o_[i + 1] <= w:
                dp[i + 1][1] = min(dp[i + 1][1], dp[i][0] + 1)

    i_, o_ = [0] + i_, [0] + o_
    dp = [[0] * 3 for _ in range(n + 2)]
    dp[1][0], dp[1][1], dp[1][2] = 1, 1, 0
    gen(1)
    ans = dp[n + 1][2]
    if n <= 2:
        return str(ans)
    if i_[1] + i_[n] <= w:
        dp[2][0], dp[2][1], dp[2][2] = 2, 1 + (o_[1] + o_[2] > w), 1
        gen(2)
        ans = min(ans, dp[n][1] + 1)
    if o_[1] + o_[n] <= w:
        dp[2][0], dp[2][1], dp[2][2] = 1 + (i_[1] + i_[2] > w), 2, 1
        gen(2)
        ans = min(ans, dp[n][0] + 1)
    if i_[1] + i_[n] <= w and o_[1] + o_[n] <= w:
        dp[2][0], dp[2][1], dp[2][2] = 1, 1, 0
        gen(2)
        ans = min(ans, dp[n][2] + 2)
    return str(ans)


def reader():
    read = stdin.readline
    ans = []
    for _ in range(int(read().rstrip())):
        n, w = map(int, read().split())
        i, o = list(map(int, read().split())), list(map(int, read().split()))
        ans.append(solution(n, w, i, o))
    print('\n'.join(ans))


if __name__ == '__main__':
    reader()
