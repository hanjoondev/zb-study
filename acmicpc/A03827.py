from sys import stdin


def mul(a: list[list[int]], b: list[list[int]], mod: int) -> list[list[int]]:
    return [[sum(x * y for x, y in zip(ar, bc)) % mod
            for bc in zip(*b)] for ar in a]


def mpow(mat: list[list[int]], e: int, m: int, n: int) -> list[list[int]]:
    matrix = [[1 * (i == j) for j in range(n)] for i in range(n)]
    while e:
        if e & 1:
            matrix = mul(matrix, mat, m)
        mat = mul(mat, mat, m)
        e >>= 1
    return matrix


def solution(s: list[list[int]], n, m, a, b, c, t) -> str:
    matrix = [[0] * n for _ in range(n)]
    matrix[0][0], matrix[0][1] = b, a
    for i, row in enumerate(matrix[1:n - 1], start=1):
        row[i - 1], row[i], row[i + 1] = c, b, a
    matrix[-1][-2], matrix[-1][-1] = c, b
    return ' '.join(map(str, mul(s, mpow(matrix, t, m, n), m)[0]))


def reader():
    read = stdin.readline
    ans = []
    while True:
        n, m, a, b, c, t = map(int, read().split())
        if n == m == a == b == c == t == 0:
            break
        s = [list(map(int, read().split()))]
        ans.append(solution(s, n, m, a, b, c, t))
    print('\n'.join(ans))


if __name__ == '__main__':
    reader()
