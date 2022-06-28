from sys import stdin


def update(m, h, w, fr):
    updated = []
    for r in range(h):
        line, limit = [], 0
        for c in range(w):
            c = -1 - c if fr in 'rd' else c
            limit = max(limit, m[r][c]) if fr in 'lr' else max(limit, m[c][r])
            line.append(limit)
            limit -= 1
        if fr in 'rd':
            line.reverse()
        updated.append(line)
    return updated


def four_ways(m, h, w):
    left, right = update(m, h, w, 'l'), update(m, h, w, 'r')
    up, down = update(m, w, h, 'u'), update(m, w, h, 'd')
    return [[max(left[r][c], right[r][c], up[c][r], down[c][r])
             for c in range(w)] for r in range(h)]


def solution(grid: list[list[int]], h: int, w: int) -> str:
    g = four_ways(four_ways([[i for i in line] for line in grid], h, w), h, w)
    boxes = 0
    for r in range(h):
        for c in range(w):
            boxes += g[r][c] - grid[r][c]
    return boxes


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
