from time import perf_counter_ns as ns


def solution(grid):
    h, w = len(grid), len(grid[0])
    dr, dc = (-1, 0, 1, 0), (0, 1, 0, -1)
    t = lambda r, c, d: ('LSR'.index(grid[r][c]) - 1 + d) % 4
    v = [[[False] * 4 for _ in range(w)] for _ in range(h)]
    ans = []
    for r in range(h):
        for c in range(w):
            for d in range(4):
                if not v[r][c][d]:
                    started_from, length = (r, c, d), 0
                    while not v[r][c][d]:
                        v[r][c][d] = True
                        d = t(r := (r + dr[d]) % h, c := (c + dc[d]) % w, d)
                        length += 1
                    if (r, c, d) == started_from:
                        ans.append(length)
    return sorted(ans)


if __name__ == '__main__':
    ITERATIONS = 1_000
    print(f'Running the basic tests {ITERATIONS:,} times...')
    tests = (
        (["SL", "LR"], [16]),
        (["S"], [1, 1, 1, 1]),
        (["R","R"], [4, 4]),
        (["RLLRL", "SSSSS", "LRSRL", "SSRLR", "SLLLRR"], [4, 5, 5, 24, 28, 34])
    )
    for n, expected in tests:
        print(f'solution({n}) returned', end=' ')
        if (result := solution(n)) == expected:
            print(f'the expected result {expected}', end=' ')
            fastest = float('inf')
            slowest = total = 0
            for _ in range(ITERATIONS):
                start = ns()
                solution(n)
                end = ns()
                time = end - start
                fastest, slowest = min(time, fastest), max(time, slowest)
                total += time
            print(f'in an average of {total / ITERATIONS / 1e3:,.2f}μs '
                  f'(min: {fastest / 1e3:,.2f}μs, '
                  f'max: {slowest / 1e3:,.2f}μs)')
        else:
            print(f'a wrong result {result} (expected: {expected})')
