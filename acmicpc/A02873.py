from sys import stdin


def reader():
    read = stdin.readline
    r, c = map(int, read().split())
    if r & 1:
        _, c = [read() for _ in range(r)], c - 1
        print('D'.join([('L' if i & 1 else 'R') * c for i in range(r)]))
        return
    if c & 1:
        _, r = [read() for _ in range(r)], r - 1
        print('R'.join([('U' if i & 1 else 'D') * r for i in range(c)]))
        return
    min_, ir, ic, rows, cols = float('inf'), -1, -1, r, c
    for r in range(rows):
        for c, num in enumerate(list(map(int, read().split()))):
            if (r + c) & 1 and min_ > num:
                min_, ir, ic = num, r, c
    rr, cc, r, c, pos = 0, 2 * (ic // 2), rows - 1, cols - 1, (ir, ic)
    limit, u, d, mid = cc + 1, 'U' * r, 'D' * r, ''
    f = (d + 'R' + u + 'R') * (ic // 2)
    b = ('R' + u + 'R' + d) * ((c - ic) // 2)
    while cc != limit or r != rr:
        if cc < limit and (rr, limit) != pos:
            cc += 1
            mid += 'R'
        elif cc == limit and (rr, limit - 1) != pos:
            cc -= 1
            mid += 'L'
        if rr != r:
            rr += 1
            mid += 'D'
    print(f + mid + b)


if __name__ == '__main__':
    reader()
