from collections import deque as dq
from sys import stdin as s


def solution(n: int) -> None:
    q = dq()
    for i in range(1, n + 1):
        q.append(i)
    while len(q) > 1:
        q.popleft()
        q.append(q.popleft())
    print(q.pop())


def reader():
    n = int(s.readline().strip())
    solution(n)


if __name__ == '__main__':
    reader()
