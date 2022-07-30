from sys import stdin


def reader():
    read = stdin.readline
    ans = []
    for _ in range(int(read())):
        x1, y1, r1, x2, y2, r2 = map(int, read().split())
        d = (x2 - x1)**2 + (y2 - y1)**2
        if (x1, y1, r1) == (x2, y2, r2):
            ans.append('-1')
        elif d > (p := (r1 + r2)**2) or d < (m := (r2 - r1)**2):
            ans.append('0')
        elif d in (p, m):
            ans.append('1')
        else:
            ans.append('2')
    print('\n'.join(ans))


if __name__ == '__main__':
    reader()
