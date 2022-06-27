from sys import stdin
from bisect import bisect_right as bl


def solution(m, c: list[int], s: list[int]) -> None:
    def find(i):
        if i == p[i]:
            return i
        p[i] = find(p[i])
        return p[i]

    c.sort()
    p = [i for i in range(m)]
    for n in s:
        print(c[i := find(bl(c, n))])
        if (a := find(i)) > (b := find(i + 1)):
            p[b] = a
        else:
            p[a] = b


def reader():
    read = stdin.readline
    n, m, k = map(int, read().split())
    solution(m + 1, list(map(int, read().split())), map(int, read().split()))


if __name__ == '__main__':
    reader()
