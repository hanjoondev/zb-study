def solution(maps):
    m = [[0 if n else 1 for n in row] for row in maps]
    w, h = len(maps[0]), len(maps)
    queue = [(0, 0)]
    while queue:
        x, y = queue.pop(0)
        for i, j in ((-1, 0), (1, 0), (0, -1), (0, 1)):
            x_, y_ = x + i, y + j
            if 0 <= x_ < w and 0 <= y_ < h:
                if not m[y_][x_]:
                    m[y_][x_] = m[y][x] + 1
                    queue.append((x_, y_))
    return m[-1][-1] + 1 if m[-1][-1] else -1
