from time import perf_counter_ns as ns


def solution(maps):
    """
    Problem: https://programmers.co.kr/learn/courses/30/lessons/1844
    Result: Passed
    """
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


if __name__ == '__main__':
    ITERATIONS = 1_000
    print(f'Running the basic tests {ITERATIONS:,} times...')
    tests = (
        ([[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,1],[0,0,0,0,1]], 11),
        ([[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,0],[0,0,0,0,1]], -1)
    )
    for maps, expected in tests:
        print(f'solution({maps}) returned', end=' ')
        if (result := solution(maps)) == expected:
            print(f'the expected result {expected}', end=' ')
            fastest = float('inf')
            slowest = total = 0
            for _ in range(ITERATIONS):
                start = ns()
                solution(maps)
                end = ns()
                time = end - start
                fastest, slowest = min(time, fastest), max(time, slowest)
                total += time
            print(f'in an average of {total / ITERATIONS / 1000:,.2f}ms '
                  f'(min: {fastest / 1000:,.2f}ms, '
                  f'max: {slowest / 1000:,.2f}ms)')
        else:
            print(f'a wrong result {result} (expected: {expected})')
