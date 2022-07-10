from sys import stdin


def reader():
    read = stdin.readline
    n, k = map(int, read().split())
    t = [int(read().rstrip()) for _ in range(n)]
    s = sum(sorted([(t[i + 1] - t[i]) - 1 for i in range(n - 1)],
                   reverse=True)[:k - 1])
    print(t[-1] - t[0] + 1 - s)


if __name__ == '__main__':
    reader()
