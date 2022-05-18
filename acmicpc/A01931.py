from heapq import heappush as hpush, heappop as hpop
from sys import stdin


def greedy(intervals: list[tuple[int]], length: int) -> int:
    time = ans = 0
    while intervals:
        e, s = hpop(intervals)
        time += e - s
        ans += 1
        while intervals and intervals[0][1] < e:
            hpop(intervals)
    return ans


def reader():
    readline = stdin.readline
    n = int(readline().strip())
    heap = []
    for _ in range(n):
        s, e = map(int, readline().split())
        hpush(heap, (e, s))
    print(greedy(heap, n))


if __name__ == '__main__':
    reader()
