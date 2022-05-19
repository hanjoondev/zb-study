from sys import stdin


def solution(target: int, length: int, broken: list[int]) -> int:
    def brute(num: int, d: int, started: int) -> None:
        nonlocal ans, length, available
        ans = min(ans, d + abs(target - num))
        if d < length or d == length and started == 1:
            for a in available:
                brute(num * 10 + a, d + 1, started)

    if length == 10 or target == 100:
        return abs(target - 100)
    if not length:
        return min(abs(target - 100), len(str(target)))

    ans = abs(target - 100)
    length = len(str(target))
    available = [i for i in range(10) if i not in broken]
    for a in available:
        brute(a, 1, a)
    return ans


def reader():
    read = stdin.readline
    t = int(read().strip())
    b = list(map(int, read().split())) if (l := int(read().strip())) else []
    print(solution(t, l, b))


if __name__ == '__main__':
    reader()
