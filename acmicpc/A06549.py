from sys import stdin
from collections import deque as dq


def solution(heights: list[int], length: int) -> str:
    ans, s = 0, dq()
    for i in range(length):
        min_ = i
        while s and s[-1][0] >= heights[i]:
            h, min_ = s.pop()
            ans = max(ans, h * (i - min_))
        s.append((heights[i], min_))
    for h, point in s:
        ans = max(ans, h * (length - point))
    return str(ans)


def reader():
    read = stdin.readline
    ans = []
    while True:
        n, *heights = map(int, read().split())
        if not n:
            break
        ans.append(solution(heights, n))
    print('\n'.join(ans))


if __name__ == '__main__':
    reader()
