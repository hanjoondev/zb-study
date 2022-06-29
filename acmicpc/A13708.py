from sys import stdin
from math import hypot as h
from random import randint


class Point:
    def __init__(self, x=0, y=0) -> None:
        self.x = x
        self.y = y


class Circle:
    def __init__(self, c=Point(), r=0) -> None:
        self.c = c
        self.r = r


class MEC:
    def __init__(self, pts: list[Point], length: int) -> None:
        self.pts = pts
        self.length = length

    def is_inside(self, c: Circle, p: Point):
        return h(c.c.x - p.x, c.c.y - p.y) <= c.r

    def is_valid_circle(self, c, pts):
        for p in pts:
            if not self.is_inside(c, p):
                return False
        return True

    def get_center(self, bx, by, cx, cy):
        b, c, d = bx * bx + by * by, cx * cx + cy * cy, bx * cy - by * cx
        return Point((cy * b - by * c) / (2 * d), (bx * c - cx * b) / (2 * d))

    def get_min_circle(self, pts):
        assert len(pts) <= 3
        if not pts:
            return Circle()
        elif len(pts) == 1:
            return Circle(pts[0], 0)
        elif len(pts) == 2:
            return self.two(pts[0], pts[1])
        for i in range(3):
            for j in range(i + 1, 3):
                c = self.two(pts[i], pts[j])
                if self.is_valid_circle(c, pts):
                    return c
        return self.three(pts[0], pts[1], pts[2])

    def two(self, a, b):
        c = Point((a.x + b.x) / 2, (a.y + b.y) / 2)
        return Circle(c, h(a.x - b.x, a.y - b.y) / 2)

    def three(self, a, b, c):
        d = self.get_center(b.x - a.x, b.y - a.y, c.x - a.x, c.y - a.y)
        d.x, d.y = d.x + a.x, d.y + a.y
        return Circle(d, h(d.x - a.x, d.y - a.y))

    def welzl(self, pts: list[Point], r: list[Point], length: int):
        if not length or len(r) == 3:
            return self.get_min_circle(r)
        idx = randint(0, length - 1)
        p = pts[idx]
        pts[idx], pts[length - 1] = pts[length - 1], pts[idx]
        d = self.welzl(pts, r.copy(), length - 1)
        if self.is_inside(d, p):
            return d
        r.append(p)
        return self.welzl(pts, r.copy(), length - 1)

    def solve(self):
        c = self.welzl(self.pts.copy(), [], self.length)
        return str(round(c.r * 2, 2))


def reader():
    read = stdin.readline
    n = int(read().strip())
    pts = []
    for _ in range(n):
        x, y = map(int, read().split())
        pts.append(Point(x, y))
    print(MEC(pts, n).solve())


if __name__ == '__main__':
    reader()
