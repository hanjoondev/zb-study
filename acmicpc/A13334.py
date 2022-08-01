from sys import stdin
from heapq import heappush as hpush, heappop as hpop


def solution(lines: list[list[int]], dist: int) -> int:
    ans, h = 0, []
    while lines:
        end, start = hpop(lines)
        hpush(h, start)
        while h and h[0] < end - dist:
            hpop(h)
        ans = max(ans, len(h))
    return ans


def reader():
    read = stdin.readline
    n = int(read())
    lines = []
    for _ in range(n):
        s, e = map(int, read().split())
        if s > e:
            s, e = e, s
        hpush(lines, (e, s))
    d = int(read())
    print(solution(lines, d))


if __name__ == '__main__':
    reader()
