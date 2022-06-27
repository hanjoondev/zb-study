from sys import stdin
from heapq import heappop as hpop, heappush as hpush


def calc(p1, p2):
    return min(abs(p1[0] - p2[0]), abs(p1[1] - p2[1]), abs(p1[2] - p2[2]))


def solution(pts: dict[int, tuple[int]], length: int):
    costs, h, v = {i: [] for i in range(length)}, [(0, 0)], set()
    for i in range(length):
        for j in range(i + 1, length):
            cost = calc(pts[i], pts[j])
            costs[i].append((cost, j))
            costs[j].append((cost, i))
    ans = count = 0
    while count < length:
        cost, cur = hpop(h)
        if cur in v:
            continue
        ans += cost
        count += 1
        v.add(cur)
        for nxt_cost, nxt in costs[cur]:
            if nxt in v:
                continue
            hpush(h, (nxt_cost, nxt))
    return ans


def reader():
    read = stdin.readline
    n = int(read().strip())
    pts = {i: tuple(map(int, read().split())) for i in range(n)}
    print(solution(pts, n))


if __name__ == '__main__':
    reader()
