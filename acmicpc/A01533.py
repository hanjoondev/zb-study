from sys import stdin


def mul(a: list[list[int]], b: list[list[int]], mod: int) -> list[list[int]]:
    return [[sum(x * y for x, y in zip(ar, bc)) % mod
            for bc in zip(*b)] for ar in a]


def mpow(mat: list[list[int]], exp: int, mod: int) -> list[list[int]]:
    if exp == 1:
        return mat
    m = mpow(mat, exp // 2, mod)
    return mul(mul(m, m, mod), mat, mod) if exp & 1 else mul(m, m, mod)


def solution(g: list[list[int]], n: int, s: int, e: int, t: int) -> str:
    matrix = [[0] * (5 * n) for _ in range(5 * n)]
    for i in range(n):
        for j in range(1, 5):
            matrix[5 * i + j - 1][5 * i + j] = 1
    for i, r in enumerate(g):
        for j, c in enumerate(r):
            if c > 0:
                matrix[5 * i + c - 1][5 * j] = 1
    return mpow(matrix, t, int(1e6) + 3)[5 * (s - 1)][5 * (e - 1)]


def reader():
    read = stdin.readline
    n, s, e, t = map(int, read().split())
    g = [[int(c) for c in read().rstrip()] for _ in range(n)]
    print(solution(g, n, s, e, t))


if __name__ == '__main__':
    reader()
