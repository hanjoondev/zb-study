from sys import stdin


def solution(x: list[int], n: int) -> int:
    lft, rgt, ans, m = 0, x[-1], 0, (n + 1) // 2
    while lft <= rgt:
        mid, count, j = (lft + rgt) // 2, 1, 0
        for i in range(n):
            if x[i] - x[j] > mid:
                count += 1
                j = i
        if count > m:
            ans = mid
            lft = mid + 1
        else:
            rgt = mid - 1
    return ans + 1


def reader():
    read = stdin.readline
    n, f = read().split()
    x, n = list(map(int, read().split())), int(n)
    if f.startswith('A') and n & 1 or f.startswith('B') and not n & 1:
        ans, m = x[-1], (n + 1) // 2
        for i in range(n - m):
            ans = min(ans, x[i + m] - x[i])
        print(ans)
        return
    print(solution(x, n))


if __name__ == '__main__':
    reader()
