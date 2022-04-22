from time import perf_counter_ns as ns


def solution(maps):
    m = [[0 if n else 1 for n in row] for row in maps]
    w, h = len(maps[0]), len(maps)
    queue = [(0, 0)]
    while queue:
        r, c = queue.pop(0)
        for dr, dc in ((-1, 0), (1, 0), (0, -1), (0, 1)):
            r_, c_ = r + dr, c + dc
            if 0 <= r_ < w and 0 <= c_ < h:
                if not m[c_][r_]:
                    m[c_][r_] = m[c][r] + 1
                    queue.append((r_, c_))
    return m[-1][-1] + 1 if m[-1][-1] else -1


if __name__ == '__main__':
    ITERATIONS = 1_000
    print(f'Running the basic tests {ITERATIONS:,} times...')
    tests = (
        ([[1, 0, 1, 1, 1],
          [1, 0, 1, 0, 1],
          [1, 0, 1, 1, 1],
          [1, 1, 1, 0, 1],
          [0, 0, 0, 0, 1]], 11),
        ([[1, 0, 1, 1, 1],
          [1, 0, 1, 0, 1],
          [1, 0, 1, 1, 1],
          [1, 1, 1, 0, 0],
          [0, 0, 0, 0, 1]], -1)
    )
    for map_array, expected in tests:
        print(f'solution({map_array}) returned', end=' ')
        if (result := solution(map_array)) == expected:
            print(f'the expected result {expected}', end=' ')
            fastest = float('inf')
            slowest = total = 0
            for _ in range(ITERATIONS):
                start = ns()
                solution(map_array)
                end = ns()
                time = end - start
                fastest, slowest = min(time, fastest), max(time, slowest)
                total += time
            print(f'in an average of {total / ITERATIONS / 1e3:,.2f}μs '
                  f'(min: {fastest / 1e3:,.2f}μs, '
                  f'max: {slowest / 1e3:,.2f}μs)')
        else:
            print(f'a wrong result {result} (expected: {expected})')
