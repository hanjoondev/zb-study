from sys import stdin


def two_pointer(sol: list[int], n: int) -> str:
    sol.sort()
    left, right, min_ = 0, n - 1, float('inf')
    ans = f'{sol[left]} {sol[right]}'
    while left < right:
        l, r = sol[left], sol[right]
        if (abs_diff := abs(diff := l + r)) < min_:
            min_ = abs_diff
            ans = f'{l} {r}'
            if not min_:
                return ans
        if diff < 0:
            left += 1
        else:
            right -= 1
    return ans


def reader():
    n = int(stdin.readline())
    sol = list(map(int, stdin.readline().split()))
    print(two_pointer(sol, n))


if __name__ == '__main__':
    reader()
