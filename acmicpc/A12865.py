from sys import stdin as s


def solution(n: int, cap: int, weights: list[int], vals: list[int]) -> None:
    dp = [0] * (cap + 1)
    for i in range(1, n + 1):
        weight, value = weights[i - 1], vals[i - 1]
        for w in range(cap, 0, -1):
            if weight <= w:
                dp[w] = max(dp[w], dp[w - weight] + value)
    print(dp[cap])


def reader():
    n, k = map(int, s.readline().split())
    weights, values = [], []
    for _ in range(n):
        w, v = map(int, s.readline().split())
        weights.append(w)
        values.append(v)
    solution(n, k, weights, values)


if __name__ == '__main__':
    reader()
