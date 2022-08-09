from sys import stdin


def reader():
    read = stdin.readline
    n = int(read())
    p = [list(map(int, read().split())) for _ in range(n)]
    p.append(p[0])
    print(round(abs(sum(p[i][0] * p[i + 1][1] - p[i + 1][0] * p[i][1]
                        for i in range(n))) / 2, 1))


if __name__ == '__main__':
    reader()
