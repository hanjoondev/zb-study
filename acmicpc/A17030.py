from sys import stdin


def solution(cows: list[float], len_: int, max_: int) -> str:
    ans, a, b, r = max_, 0, 1, 0
    for l in range(len_):
        while r < len_ and a < 1:
            a += cows[r] / (1 - cows[r])
            b *= 1 - cows[r]
            r += 1
        ans = max(ans, a * b)
        a -= cows[l] / (1 - cows[l])
        b /= 1 - cows[l]
    return str(int(ans * 1e6))


def reader():
    read = stdin.readline
    n = int(read().strip())
    cows, max_ = [], -float('inf')
    for _ in range(n):
        cows.append(c := (int(read().rstrip()) / 1e6))
        max_ = max(max_, c)
    print(solution(cows, n, max_))


if __name__ == '__main__':
    reader()
