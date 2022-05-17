from time import perf_counter_ns as ns


def solution(n, costs):
    c = [[0] * n for _ in range(n)]
    for fr, to, cost in costs:
        c[fr][to] = c[to][fr] = cost
    ans, idx, end = 0, 0, n - 1
    checked = [True] + [False] * end
    while idx < end:
        min_ = float('inf')
        fr = to = 0
        for f in [i for i in range(n) if checked[i]]:
            for t in range(n):
                if not checked[t] and c[f][t] and c[f][t] < min_:
                    min_ = c[f][t]
                    fr = f
                    to = t
        ans += c[fr][to]
        checked[to] = True
        idx += 1
    return ans


if __name__ == '__main__':
    ITERATIONS = 1
    print(f'Running the basic tests {ITERATIONS:,} times...')
    tests = (
        (4, [[0, 1, 1], [0, 2, 2], [1, 2, 5], [1, 3, 1], [2, 3, 8]], 4),
    )
    for n, costs, expected in tests:
        print(f'solution({n}, {costs}) returned', end=' ')
        if (result := solution(n, costs)) == expected:
            print(f'the expected result {expected}', end=' ')
            fastest = float('inf')
            slowest = total = 0
            for _ in range(ITERATIONS):
                start = ns()
                solution(n, costs)
                end = ns()
                time = end - start
                fastest, slowest = min(time, fastest), max(time, slowest)
                total += time
            print(f'in an average of {total / ITERATIONS / 1e3:,.2f}μs '
                  f'(min: {fastest / 1e3:,.2f}μs, '
                  f'max: {slowest / 1e3:,.2f}μs)')
        else:
            print(f'a wrong result {result} (expected: {expected})')
