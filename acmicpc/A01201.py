from sys import stdin
from collections import deque as dq


def reader():
    read = stdin.readline
    n, m, k = map(int, read().split())
    if m * k < n or n + 1 < m + k:
        print(-1)
        return
    q = dq([i for i in range(k, 0, -1)])
    n = n - k
    while m := m - 1:
        div = n // m
        q += dq([i for i in range(k + div, k, -1)])
        k, n = k + div, n - div
    print(' '.join(map(str, q)))


if __name__ == '__main__':
    reader()
