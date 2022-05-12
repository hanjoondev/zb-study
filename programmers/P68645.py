from time import perf_counter_ns as ns


def solution(n):
    length = n * (n + 1) // 2
    ans = [[0] * n for _ in range(n)]
    r, c, i, direction, limit = -1, 0, 0, 0, n
    while i < length:
        if direction % 3 == 0:
            for _ in range(limit):
                r, i = r + 1, i + 1
                ans[r][c] = i
        elif direction % 3 == 1:
            for _ in range(limit):
                c, i = c + 1, i + 1
                ans[r][c] = i
        elif direction % 3 == 2:
            for _ in range(limit):
                r, c, i = r - 1, c - 1, i + 1
                ans[r][c] = i
        direction, limit = direction + 1, limit - 1
    return sum([[n for n in line if n] for line in ans], [])


if __name__ == '__main__':
    ITERATIONS = 1_000
    print(f'Running the basic tests {ITERATIONS:,} times...')
    tests = (
        (4, [1, 2, 9, 3, 10, 8, 4, 5, 6, 7]),
        (5, [1, 2, 12, 3, 13, 11, 4, 14, 15, 10, 5, 6, 7, 8, 9]),
        (6, [1, 2, 15, 3, 16, 14, 4, 17, 21, 13,
             5, 18, 19, 20, 12, 6, 7, 8, 9, 10, 11])
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
