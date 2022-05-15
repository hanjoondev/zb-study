from sys import stdin


def two_pointer(a: list[int], n: int, x: int) -> int:
    a.sort()
    ans = left = 0
    right = n - 1
    while left < right:
        if (v := a[left] + a[right]) < x:
            left += 1
        else:
            right -= 1
            ans += v == x
    return ans


def reader():
    n = int(stdin.readline())
    a = list(map(int, stdin.readline().split()))
    x = int(stdin.readline())
    print(two_pointer(a, n, x))


if __name__ == '__main__':
    reader()
