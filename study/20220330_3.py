from time import perf_counter_ns as ns


def solution(n, info):
    """
    Problem: https://programmers.co.kr/learn/courses/30/lessons/92342
    """
    return [-1]


if __name__ == '__main__':
    ITERATIONS = 1_000
    print(f'Running the basic tests {ITERATIONS:,} times...')
    tests = (
        (5, [2,1,1,1,0,0,0,0,0,0,0], [0,2,2,0,1,0,0,0,0,0,0]),
        (1, [1,0,0,0,0,0,0,0,0,0,0], [-1]),
        (9, [0,0,1,2,0,1,1,1,1,1,1], [1,1,2,0,1,2,2,0,0,0,0]),
        (10, [0,0,0,0,0,0,0,0,3,4,3], [1,1,1,1,1,1,1,1,0,0,2])
    )
    for n, info, expected in tests:
        print(f'solution({n}, {info}) returned', end=' ')
        if (result := solution(n, info)) == expected:
            print(f'the expected result {expected}', end=' ')
            fastest = float('inf')
            slowest = total = 0
            for _ in range(ITERATIONS):
                start = ns()
                solution(n, info)
                end = ns()
                time = end - start
                fastest, slowest = min(time, fastest), max(time, slowest)
                total += time
            print(f'in an average of {total / ITERATIONS / 1000:,.2f}ms '
                  f'(min: {fastest / 1000:,.2f}ms, '
                  f'max: {slowest / 1000:,.2f}ms)')
        else:
            print(f'a wrong result {result} (expected: {expected})')
