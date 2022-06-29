from sys import stdin


def solution(pts: list[tuple[int]], xs: int, ys: int, length: int) -> str:
    fx, fy, p = pts[0][0], pts[0][1], 0.1
    d = e = f = i = 0
    for _ in range(25000):
        d, f, i = (xs - fx)**2 + (ys - fy)**2, 0, 1
        while i < length:
            e = (xs - pts[i][0])**2 + (ys - pts[i][1])**2
            if d < e:
                d, f = e, i
            i += 1
        xs, ys = xs + (pts[f][0] - xs) * p, ys + (pts[f][1] - ys) * p
        p *= 0.999
    x, y = round(xs, 10), round(ys, 10)
    x = f'{x:.10f}' if float(f'{x:.4f}') % 1 else int(x)
    y = f'{y:.10f}' if float(f'{y:.4f}') % 1 else int(y)
    return ' '.join(map(str, (x, y, round(d**0.5, 10))))


def reader():
    read = stdin.readline
    n = int(read().strip())
    pts, xsum, ysum = [], 0.0, 0.0
    for _ in range(n):
        x, y = map(int, read().split())
        xsum, ysum = xsum + x, ysum + y
        pts.append((x, y))
    print(solution(pts, xsum / n, ysum / n, n))


if __name__ == '__main__':
    reader()
