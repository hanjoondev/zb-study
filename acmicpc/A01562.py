from sys import stdin


def solution(n: int):
    def dfs(i, j, k):
        if m[i][j][k] != -1:
            return m[i][j][k]
        if not k:
            if 1 < j < 8:
                m[i][j][k] = dfs(i - 1, j - 1, 0) + dfs(i - 1, j + 1, 0)
            else:
                m[i][j][k] = dfs(i - 1, j - 1 + (2 * (j == 1)), 0)
        elif k == 1:
            if 0 < j < 8:
                m[i][j][k] = dfs(i - 1, j - 1, 1) + dfs(i - 1, j + 1, 1)
            elif j == 8:
                m[i][j][k] = dfs(i - 1, j - 1, 1)
            else:
                m[i][j][k] = dfs(i - 1, j + 1, 0) + dfs(i - 1, j + 1, 1)
        elif k == 2:
            if 1 < j < 9:
                m[i][j][k] = dfs(i - 1, j - 1, 2) + dfs(i - 1, j + 1, 2)
            elif j == 1:
                m[i][j][k] = dfs(i - 1, j + 1, 2)
            else:
                m[i][j][k] = dfs(i - 1, j - 1, 0) + dfs(i - 1, j - 1, 2)
        else:
            if 1 <= j <= 8:
                m[i][j][k] = dfs(i - 1, j - 1, 3) + dfs(i - 1, j + 1, 3)
            elif j == 0:
                m[i][j][k] = dfs(i - 1, j + 1, 3) + dfs(i - 1, j + 1, 2)
            else:
                m[i][j][k] = dfs(i - 1, j - 1, 3) + dfs(i - 1, j - 1, 1)
        m[i][j][k] %= 10**9
        return m[i][j][k]

    m = [[[-1 if i != 1 else 0] * 4 for j in range(10)] for i in range(n + 1)]
    m[1][0][1] = m[1][9][2] = 1
    for i in range(1, 9):
        m[1][i][0] = 1
    return sum(dfs(n, i, 3) for i in range(1, 10)) % 10**9


def reader():
    read = stdin.readline
    print(solution(int(read().rstrip())))


if __name__ == '__main__':
    reader()
