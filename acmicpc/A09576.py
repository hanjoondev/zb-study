from sys import stdin
from collections import deque as dq


def solution(ab: list[list[int]], n: int) -> str:
    ab.sort(key=lambda x: x[1])
    ans, q, v = 0, dq(ab), [False] * (n + 1)
    while q:
        a, b = q.popleft()
        for i in range(a, b + 1):
            if not v[i]:
                ans += 1
                v[i] = True
                break
    return str(ans)


def reader():
    read = stdin.readline
    ans = []
    for _ in range(int(read())):
        n, m = map(int, read().split())
        ab = [list(map(int, read().split())) for _ in range(m)]
        ans.append(solution(ab, n))
    print('\n'.join(ans))


if __name__ == '__main__':
    reader()
