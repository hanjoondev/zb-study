from sys import stdin


def solution(g: list[list[int]], h: int, w: int) -> str:
    d, u = [[0] * w for _ in range(h)], [[0] * w for _ in range(h)]
    r, l = [[0] * w for _ in range(h)], [[0] * w for _ in range(h)]
    for i in range(h):
        for j in range(w):
            d[i][j] = (g[i][j] + d[i - 1][j] if g[i][j] else 0) if i else g[i][j]
            r[i][j] = (g[i][j] + r[i][j - 1] if g[i][j] else 0) if j else g[i][j]
            u[-1 - i][j] = (g[-1 - i][j] + u[-i][j] if g[-1 - i][j] else 0) if i else g[-1 - i][j]
            l[i][-1 - j] = (g[i][-1 - j] + l[i][-j] if g[i][-1 - j] else 0) if j else g[i][-1 - j]
    result = 0
    for i in range(h):
        for j in range(w):
            result += max(0, min(d[i][j], r[i][j] // 2) + min(d[i][j] // 2, r[i][j]) - 2)
            result += max(0, min(d[i][j], l[i][j] // 2) + min(d[i][j] // 2, l[i][j]) - 2)
            result += max(0, min(u[i][j], r[i][j] // 2) + min(u[i][j] // 2, r[i][j]) - 2)
            result += max(0, min(u[i][j], l[i][j] // 2) + min(u[i][j] // 2, l[i][j]) - 2)
    return result


def reader():
    read = stdin.readline
    ans = []
    for i in range(int(read().strip())):
        r, c = map(int, read().split())
        grid = [list(map(int, read().split())) for _ in range(r)]
        ans.append(f'Case #{i + 1}: {solution(grid, r, c)}')
    print('\n'.join(ans))


if __name__ == '__main__':
    reader()
