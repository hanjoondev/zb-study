from time import perf_counter_ns as ns


def solution(weights):
    weights.sort()
    ans = weights[0]
    for w in weights[1:]:
        if w > ans + 1:
            break
        ans += w
    return ans + 1


if __name__ == '__main__':
    ITERATIONS = 1_000
    print(f'Running the basic tests {ITERATIONS:,} times...')
    tests = (
        ([6, 1, 2, 3, 1, 7, 30], 21),
    )
    for w, expected in tests:
        print(f'solution({w}) returned', end=' ')
        if (result := solution(w)) == expected:
            print(f'the expected result {expected}', end=' ')
            fastest = float('inf')
            slowest = total = 0
            for _ in range(ITERATIONS):
                start = ns()
                solution(w)
                end = ns()
                time = end - start
                fastest, slowest = min(time, fastest), max(time, slowest)
                total += time
            print(f'in an average of {total / ITERATIONS / 1e3:,.2f}μs '
                  f'(min: {fastest / 1e3:,.2f}μs, '
                  f'max: {slowest / 1e3:,.2f}μs)')
        else:
            print(f'a wrong result {result} (expected: {expected})')
