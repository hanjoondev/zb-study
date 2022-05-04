from collections import deque as dq
from sys import stdin as s


def solution(n: int) -> None:
    if n < 2:
        return print(n)
    exp = 1
    while 2**exp < n:
        exp += 1
    exp -= 1
    print((n - 2**exp) * 2)


def reader():
    n = int(s.readline().strip())
    solution(n)


if __name__ == '__main__':
    reader()
