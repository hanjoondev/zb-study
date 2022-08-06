from sys import stdin


def reader():
    read = stdin.readline
    n = int(read())
    d = [[0] * (n + 1) for _ in range(3)]
    ans = 0
    for i in range(2 * n):
        x, y = map(int, read().split())
        if x < 1:
            if y > 2:
                d[2][1] += 1
                ans += abs(x - 1) + abs(y - 2)
            elif y < 1:
                d[1][1] += 1
                ans += abs(x - 1) + abs(y - 1)
            else:
                if y == 1:
                    d[1][1] += 1
                else:
                    d[2][1] += 1
                ans += abs(x - 1)
        elif x > n:
            if y > 2:
                d[2][n] += 1
                ans += abs(x - n) + abs(y - 2)
            elif y < 1:
                d[1][n] += 1
                ans += abs(x - n) + abs(y - 1)
            else:
                if y == 1:
                    d[1][n] += 1
                else:
                    d[2][n] += 1
                ans += abs(x - n)
        else:
            if y > 2:
                d[2][x] += 1
                ans += abs(y - 2)
            elif y < 1:
                d[1][x] += 1
                ans += abs(y - 1)
            else:
                d[y][x] += 1
    d1 = d2 = 0
    for i in range(1, n + 1):
        d1 += d[1][i] - 1
        d2 += d[2][i] - 1
        if d1 > 0 and d2 < 0:
            ans += (tmp := min(d1, -d2))
            d1 -= tmp
            d2 += tmp
        if d1 < 0 and d2 > 0:
            ans += (tmp := min(-d1, d2))
            d1 += tmp
            d2 -= tmp
        ans += abs(d1) + abs(d2)
    print(ans)


if __name__ == '__main__':
    reader()
