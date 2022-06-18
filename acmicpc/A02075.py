from sys import stdin
from heapq import heappush as hpush, heappop as hpop


def reader():
    read = stdin.readline
    n, h = int(read()) - 1, []
    for i in map(int, read().split()):
        hpush(h, i)
    for _ in range(n):
        for i in map(int, read().split()):
            if i > h[0]:
                hpop(h)
                hpush(h, i)
    print(h[0])


if __name__ == '__main__':
    reader()
