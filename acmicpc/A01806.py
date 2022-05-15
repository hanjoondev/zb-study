from sys import stdin


def two_pointer(a: list[int], n: int, target: int) -> int:
    if sum(a) < target:
        return 0
    slow, fast, sum_, ans = 0, 0, 0, n
    while True:
        if sum_ >= target:
            sum_ -= a[slow]
            slow += 1
            ans = min(ans, fast - slow + 1)
            continue
        if fast == n:
            break
        sum_ += a[fast]
        fast += 1
    return ans


def reader():
    n, s = map(int, stdin.readline().split())
    a = list(map(int, stdin.readline().split()))
    print(two_pointer(a, n, s))


if __name__ == '__main__':
    reader()
