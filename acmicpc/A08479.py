from sys import stdin


def reader():
    read = stdin.readline
    n, m = map(int, read().split())
    k = sorted(list(map(int, read().split())), reverse=True)
    for _ in range(m):
        read()
    print(sum(p for i in range(n) if (p := k[i] - i) > 0))


if __name__ == '__main__':
    reader()
