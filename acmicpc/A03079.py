from heapq import heappush as hpush, heappop as hpop
from sys import stdin as s


def solution(times: list[int], M: int) -> None:
    heap = []
    hpush(heap, (times[0], 0))
    required = {i: t for i, t in enumerate(sorted(times))}
    finished = {k: 0 if k else v for k, v in required.items()}
    for _ in range(M - 1):
        hpop(heap)
        fastest = float('inf')
        line_no = 0
        for (k, r), f in zip(required.items(), finished.values()):
            if r + f < fastest:
                fastest = r + f
                line_no = k
        finished[line_no] = fastest
        hpush(heap, (fastest, line_no))
    print(max(finished.values()))


def reader() -> None:
    N, M = map(int, s.readline().split())
    times = [int(s.readline()) for _ in range(N)]
    solution(times, M)


if __name__ == '__main__':
    reader()
