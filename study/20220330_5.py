from time import perf_counter_ns as ns


def solution(data):
    """
    Problem: https://www.acmicpc.net/problem/2573
    """
    return 0


if __name__ == '__main__':
    ITERATIONS = 1_000
    print(f'Running the basic tests {ITERATIONS:,} times...')
    tests = (
        (('5 7', '0 0 0 0 0 0 0', '0 2 4 5 3 0 0', '0 3 0 2 5 2 0', '0 7 6 2 4 0 0', '0 0 0 0 0 0 0'), 2),
    )
    for data, expected in tests:
        print(f'solution({data}) returned', end=' ')
        if (result := solution(data)) == expected:
            print(f'the expected result {expected}', end=' ')
            fastest = float('inf')
            slowest = total = 0
            for _ in range(ITERATIONS):
                start = ns()
                solution(data)
                end = ns()
                time = end - start
                fastest, slowest = min(time, fastest), max(time, slowest)
                total += time
            print(f'in an average of {total / ITERATIONS / 1000:,.2f}ms '
                  f'(min: {fastest / 1000:,.2f}ms, '
                  f'max: {slowest / 1000:,.2f}ms)')
        else:
            print(f'a wrong result {result} (expected: {expected})')
