from time import perf_counter_ns as ns


def solution(n, lost, reserve):
    l, r = set(lost), set(reserve)
    lost, reserve = list(l - r), list(r - l)
    for r in reserve:
        if r - 1 in lost:
            lost.remove(r - 1)
        elif r + 1 in lost:
            lost.remove(r + 1)
    return n - len(lost)


if __name__ == '__main__':
    ITERATIONS = 1_000
    print(f'Running the basic tests {ITERATIONS:,} times...')
    tests = (
        (5, [2, 4], [1, 3, 5], 5),
        (5, [2, 4], [3], 4),
        (3, [3], [1], 2),
    )
    for n, l, r, expected in tests:
        print(f'solution({n}, {l}, {r}) returned', end=' ')
        if (result := solution(n, l, r)) == expected:
            print(f'the expected result {expected}', end=' ')
            fastest = float('inf')
            slowest = total = 0
            for _ in range(ITERATIONS):
                start = ns()
                solution(n, l, r)
                end = ns()
                time = end - start
                fastest, slowest = min(time, fastest), max(time, slowest)
                total += time
            print(f'in an average of {total / ITERATIONS / 1e3:,.2f}μs '
                  f'(min: {fastest / 1e3:,.2f}μs, '
                  f'max: {slowest / 1e3:,.2f}μs)')
        else:
            print(f'a wrong result {result} (expected: {expected})')
