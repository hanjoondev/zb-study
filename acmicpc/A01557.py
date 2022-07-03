from sys import stdin
from math import pi, ceil


def get_mu(limit: int):
    mu = [0, 1] + [0] * (limit - 2)
    for i in range(1, limit):
        for j in range(2 * i, limit, i):
            mu[j] -= mu[i]
    return mu


def count(mu, n):
    cnt, i = 0, 1
    while i**2 <= n:
        cnt += mu[i] * (n // i**2)
        i += 1
    return cnt


def reader():
    n = int(stdin.readline().rstrip())
    mu = get_mu(ceil((n / (6 / pi**2))**0.5 * 1.02) + 500)
    l, r = 0, n * 2
    while l < r - 1:
        if count(mu, (mid := (l + r) // 2)) < n: l = mid
        else: r = mid
    print(r)


if __name__ == '__main__':
    reader()
