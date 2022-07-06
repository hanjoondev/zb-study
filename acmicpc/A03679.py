from sys import stdin
from functools import cmp_to_key


class Point:
    def __init__(self, i, p: list[int]) -> None:
        self.i = i
        self.x = p[0]
        self.y = p[1]

    def dist(self, p) -> int:
        return (self.x - p.x)**2 + (self.y - p.y)**2

    def compare(self, a, b) -> int:
        if not (o := self.orientation(a, b)):
            return -1 if self.dist(b) >= self.dist(a) else 1
        return -1 if o == 2 else 1

    def comparo(self, a, b) -> int:
        return 1 if self.dist(a) <= self.dist(b) else -1

    def orientation(self, a, b) -> int:
        v = (a.y - self.y) * (b.x - a.x) - (a.x - self.x) * (b.y - a.y)
        return 1 if v > 0 else 0 if not v else 2

    def ccw(self, a, b) -> int:
        lft = self.x * a.y + a.x * b.y + b.x * self.y
        rgt = self.y * a.x + a.y * b.x + b.y * self.x
        return lft - rgt


def solution(pts: list[Point], length: int) -> str:
    anchor = Point(-1, [10001, 10001])
    for p in pts:
        if anchor.y > p.y or anchor.y == p.y and anchor.x > p.x:
            anchor.i, anchor.x, anchor.y = p.i, p.x, p.y
    pts.sort(key=cmp_to_key(anchor.compare))
    count = 0
    for i in range(length - 1, 0, -1):
        a, b = pts[i], pts[i - 1]
        if anchor.ccw(a, b):
            break
        count += 1
    if count:
        pts = pts[:length - count - 1] + sorted(
              pts[length - count - 1:], key=cmp_to_key(anchor.comparo))
    return f'{anchor.i} {" ".join(map(str, [p.i for p in pts[1:]]))}'


def reader():
    read = stdin.readline
    ans = []
    for _ in range(int(read().strip())):
        n, *data = map(int, read().split())
        pts = [Point(i, data[2 * i:2 * i + 2]) for i in range(n)]
        ans.append(solution(pts, n))
    print('\n'.join(ans))


if __name__ == '__main__':
    reader()
