from sys import stdin
from heapq import heapify as h, heappop as hpop, _siftdown as siftdown


def calc(p1, p2):
    return min(abs(p1[0] - p2[0]), abs(p1[1] - p2[1]), abs(p1[2] - p2[2]))


def solution(pts):
    ans = 0
    heap = [(calc(pts[i], pts[0]), 0, i) for i in range(1, len(pts))]
    h(heap)
    while heap:
        cheapest, _, to = hpop(heap)
        ans += cheapest
        for idx, (cost, _, i) in enumerate(heap):
            if (c := calc(pts[i], pts[to])) < cost:
                heap[idx] = c, to, i
                siftdown(heap, 0, idx)
    return ans


def reader():
    read = stdin.readline
    n = int(read().strip())
    print(solution([list(map(int, read().split())) for _ in range(n)]))


if __name__ == '__main__':
    reader()
