from sys import stdin


def mat_mul(m1: list[list[int]], m2: list[list[int]]) -> list[list[int]]:
    return [[sum(m1[i][k] * m2[k][j] % 1_000_000_007 for k in range(2))
            for j in range(2)] for i in range(2)]


def mat_pow(matrix: list[list[int]], exp: int) -> list[list[int]]:
    if exp == 1:
        return matrix
    mat = mat_mul(half := mat_pow(matrix, exp // 2), half)
    return mat_mul(mat, matrix) if exp & 1 else mat


def reader():
    read = stdin.readline
    n, m = int(read()), [[1, 1], [1, 0]]
    print(mat_pow(m, n)[0][1] % 1_000_000_007)


if __name__ == '__main__':
    reader()
