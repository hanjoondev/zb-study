from sys import stdin as s
from heapq import heappush as hpush, heappop as hpop


def solution(k: int, customers: list[tuple[int, int]]) -> None:
    queue, t_left, left = [], [0] * k, []
    for i in range(k):
        hpush(queue, (0, i, 0))
    for cid, minutes in customers:
        t_left[(line_no := hpop(queue)[1])] += minutes
        hpush(queue, (t_left[line_no], line_no, cid))
        left.append((t_left[line_no], -line_no, cid))
    print(sum(data[2] * (i + 1) for i, data in enumerate(sorted(left))))


def reader():
    n, k = map(int, input().split())
    solution(k, [map(int, s.readline().split()) for _ in range(n)])


if __name__ == '__main__':
    reader()


'''
10 3
123 4
21 5
34 14
56 1
45 7
723 5
55 7
13 5
910 10
73 3
'''  # expected 13900
