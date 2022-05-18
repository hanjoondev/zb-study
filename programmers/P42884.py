from time import perf_counter_ns as ns


def solution(routes) -> int:
    routes.sort(key=lambda x: x[1])
    answer = 1
    prev = routes[0][1]
    for s, e in routes[1:]:
        if s > prev:
            answer += 1
            prev = e
    return answer


if __name__ == '__main__':
    ITERATIONS = 1_000
    print(f'Running the basic tests {ITERATIONS:,} times...')
    tests = (
        ([[-20, -15], [-14, -5], [-18, -13], [-5, -3]], 2),
    )
    for routes, expected in tests:
        print(f'solution({routes}) returned', end=' ')
        if (result := solution(routes)) == expected:
            print(f'the expected result {expected}', end=' ')
            fastest = float('inf')
            slowest = total = 0
            for _ in range(ITERATIONS):
                start = ns()
                solution(routes)
                end = ns()
                time = end - start
                fastest, slowest = min(time, fastest), max(time, slowest)
                total += time
            print(f'in an average of {total / ITERATIONS / 1e3:,.2f}μs '
                  f'(min: {fastest / 1e3:,.2f}μs, '
                  f'max: {slowest / 1e3:,.2f}μs)')
        else:
            print(f'a wrong result {result} (expected: {expected})')
