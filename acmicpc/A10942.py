from sys import stdin


def solution(nums: list[int], n: int, queries: list[list[int]]) -> str:
    dp = [['1' if i == j else '0' for j in range(n + 1)] for i in range(n + 1)]
    for i in range(1, n):
        if nums[i] == nums[i + 1]:
            dp[i][i + 1] = '1'
    for r in range(3, n + 1):
        for l in range(1, n + 2 - r):
            if nums[l] == nums[l + r - 1] and dp[l + 1][l + r - 2] == '1':
                dp[l][l + r - 1] = '1'
            else:
                dp[l][l + r - 1] = '0'
    return '\n'.join(dp[s][e] for s, e in queries)


def reader():
    read = stdin.readline
    n = int(read())
    nums = list(map(int, read().split()))
    queries = [list(map(int, read().split())) for _ in range(int(read()))]
    print(solution([0] + nums, n, queries))


if __name__ == '__main__':
    reader()
