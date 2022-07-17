from sys import stdin
from collections import deque as dq


def solution(a: list[int], n: int) -> str:
    ans, q = [-1] * n, dq()
    for i, num in enumerate(a):
        while q and a[q[-1]] < num:
            ans[q[-1]] = num
            q.pop()
        q.append(i)
    return ' '.join(map(str, ans))


def reader():
    read = stdin.readline
    n = int(read())
    a = list(map(int, read().split()))
    print(solution(a, n) if n != 1 else -1)


if __name__ == '__main__':
    reader()
