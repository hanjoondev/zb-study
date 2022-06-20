from sys import stdin


def solution(n: int, dice: list[int]) -> int:
    if n == 1:
        return sum(dice) - max(dice)
    d = sorted(min(dice[i], dice[5 - i]) for i in range(3))
    edges = 4 * sum(d) + (8 * n - 12) * sum(d[:-1])
    return edges + (5 * n**2 - 16 * n + 12) * min(dice)


def reader():
    read = stdin.readline
    n = int(read().strip())
    dice = list(map(int, read().split()))
    print(solution(n, dice))


if __name__ == '__main__':
    reader()
