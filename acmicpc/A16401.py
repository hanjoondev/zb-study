from sys import stdin


def solution(sticks: list[int], niblings: int, max_: int) -> int:
    ans, l, r = 0, 1, max_
    while l <= r:
        m = (l + r) >> 1
        if sum(s // m for s in sticks if s >= m) >= niblings:
            l, ans = m + 1, m
        else:
            r = m - 1
    return ans


def reader():
    read = stdin.readline
    m, n = map(int, read().split())
    sticks = list(map(int, read().split()))
    print(solution(sticks, m, max_) if (max_ := max(sticks)) * n >= m else 0)


if __name__ == '__main__':
    reader()
