from time import perf_counter_ns as ns


def solution(n, a, b):
    answer = 0
    while a != b:
        b = b // 2 + 1 if b % 2 else b // 2
        a = a // 2 + 1 if a % 2 else a // 2
        answer += 1
    return answer


if __name__ == '__main__':
    ITERATIONS = 1_000
    print(f'Running the basic tests {ITERATIONS:,} times...')
    tests = (
        (8, 4, 7, 3),
    )
    for N, A, B, expected in tests:
        print(f'solution({N}, {A}, {B}) returned', end=' ')
        if (result := solution(N, A, B)) == expected:
            print(f'the expected result {expected}', end=' ')
            fastest = float('inf')
            slowest = total = 0
            for _ in range(ITERATIONS):
                start = ns()
                solution(N, A, B)
                end = ns()
                time = end - start
                fastest, slowest = min(time, fastest), max(time, slowest)
                total += time
            print(f'in an average of {total / ITERATIONS / 1e3:,.2f}μs '
                  f'(min: {fastest / 1e3:,.2f}μs, '
                  f'max: {slowest / 1e3:,.2f}μs)')
        else:
            print(f'a wrong result {result} (expected: {expected})')
