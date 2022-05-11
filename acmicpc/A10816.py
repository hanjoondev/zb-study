from bisect import bisect_left as bl, bisect_right as br
from sys import stdin as s


def binary_search(arr, target, lo, hi):
    if arr[0] > target or arr[-1] < target:
        return '0'
    return str(br(arr, target, lo, hi) - bl(arr, target, lo, hi))


def reader():
    n = int(s.readline())
    arr = sorted(list(map(int, s.readline().split())))
    m = int(s.readline())
    print(' '.join(binary_search(arr, num, 0, n)
                   for num in map(int, s.readline().split())) + '\n')


if __name__ == '__main__':
    reader()
