from collections import deque as dq
from sys import stdin as s


def solution(n: int, k: int) -> None:
    ans = []
    q = dq()
    for i in range(1, n + 1):
        if not i % k:
            ans.append(str(i))
            continue
        q.append(i)
    i = n % k
    while q:
        i += 1
        if not i % k:
            ans.append(str(q.popleft()))
            continue
        q.append(q.popleft())
    print(f'<{", ".join(ans)}>')


def reader():
    n, k = map(int, s.readline().split())
    solution(n, k)


if __name__ == '__main__':
    reader()
