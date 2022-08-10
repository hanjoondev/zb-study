from sys import stdin
from bisect import bisect_left as bl, bisect_right as br


def prefix(arr: list[int], len_: int) -> list[int]:
    a = []
    for i, n in enumerate(arr):
        a.append(n)
        for j in range(i + 1, len_):
            a.append(a[-1] + arr[j])
    return a


def solution(a: list[int], b: list[int], t: int, n: int, m: int) -> int:
    pre_a, pre_b, = prefix(a, n), sorted(prefix(b, m))
    return sum(br(pre_b, t - num) - bl(pre_b, t - num) for num in pre_a)


def reader():
    read = stdin.readline
    t, n = int(read()), int(read())
    a = list(map(int, read().split()))
    m = int(read())
    b = list(map(int, read().split()))
    print(solution(a, b, t, n, m))


if __name__ == '__main__':
    reader()
