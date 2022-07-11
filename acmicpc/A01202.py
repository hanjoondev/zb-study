from sys import stdin
from heapq import heappush as hpush, heappop as hpop


def solution(gems: list[list[int]], bags: dict[int, int]) -> int:
    ans, cand, i, n = 0, [], 0, len(gems)
    for capa in sorted(bags):
        while i < n and gems[i][0] <= capa:
            hpush(cand, -gems[i][1])
            i += 1
        for _ in range(min(len(cand), bags[capa])):
            ans -= hpop(cand)
    return ans


def reader():
    read = stdin.readline
    n, k = map(int, read().split())
    gems, bags = [tuple(map(int, read().split())) for _ in range(n)], {}
    for _ in range(k):
        bags[capa] = bags.get(capa := int(read().rstrip()), 0) + 1
    b = max(bags)
    print(solution(sorted([g for g in gems[:] if g[0] <= b]), bags))


if __name__ == '__main__':
    reader()
