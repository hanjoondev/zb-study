from sys import stdin
from heapq import heappop as hpop, heappush as hpush


def solution(pickups: list[None, list[int]], length: int) -> str:
    ans, h = [], []
    for pickup in pickups:
        if pickup is not None:
            for present in pickup:
                hpush(h, -present)
        else:
            ans.append(-hpop(h) if h else -1)
    return '\n'.join(map(str, ans))


def reader():
    read = stdin.readline
    n = int(read().strip())
    p = []
    for _ in range(n):
        a, *b = map(int, read().split())
        p.append(b if a else None)
    print(solution(p, n))


if __name__ == '__main__':
    reader()
