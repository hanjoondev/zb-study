from sys import stdin
from bisect import bisect_left as bl, bisect_right as br


def brute(i: int, sum_: int, arr: list[int], e: int, res: list[int]) -> None:
    if i == e:
        res.append(sum_)
        return
    brute(i + 1, sum_ + arr[i], arr, e, res)
    brute(i + 1, sum_, arr, e, res)


def solution(nums: list[int], n: int, s: int) -> int:
    brute(0, 0, lft := nums[:(mid := n // 2)], len(lft), l := [])
    brute(0, 0, rgt := nums[mid:], len(rgt), r := [])
    r.sort()
    return sum(br(r, s - num) - bl(r, s - num) for num in l) - (1 * (not s))


def reader():
    read = stdin.readline
    n, s = map(int, read().split())
    nums = list(map(int, read().split()))
    print(solution(nums, n, s))


if __name__ == '__main__':
    reader()
