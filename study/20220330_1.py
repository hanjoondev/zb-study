from time import perf_counter_ns as ns


def solution(numbers, hand):
    """
    Problem: https://programmers.co.kr/learn/courses/30/lessons/67256
    Result: Passed
    """
    answer, l, r  = '', 10, 12
    for n in (n if n else 11 for n in numbers):
        if (remainder := n % 3) == 1:
            answer, l = answer + 'L', n
            continue
        elif not remainder:
            answer, r = answer + 'R', n
            continue
        ldist, rdist = sum(divmod(abs(l - n), 3)), sum(divmod(abs(r - n), 3))
        h = hand[0].upper() if ldist == rdist else 'LR'[1 * (ldist > rdist)]
        l, r = n if h == 'L' else l, n if h == 'R' else r
        answer += h
    return answer


if __name__ == '__main__':
    ITERATIONS = 1_000
    print(f'Running the basic tests {ITERATIONS:,} times...')
    tests = (
        ([1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5], 'right', 'LRLLLRLLRRL'),
        ([7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2], 'left', 'LRLLRRLLLRR'),
        ([1, 2, 3, 4, 5, 6, 7, 8, 9, 0], 'right', 'LLRLLRLLRL')
    )
    for numbers, hand, expected in tests:
        print(f'solution({numbers}, "{hand}") returned', end=' ')
        if (result := solution(numbers, hand)) == expected:
            print(f'the expected result "{expected}"', end=' ')
            fastest = float('inf')
            slowest = total = 0
            for _ in range(ITERATIONS):
                start = ns()
                solution(numbers, hand)
                end = ns()
                time = end - start
                fastest, slowest = min(time, fastest), max(time, slowest)
                total += time
            print(f'in an average of {total / ITERATIONS / 1000:,.2f}ms '
                  f'(min: {fastest / 1000:,.2f}ms, '
                  f'max: {slowest / 1000:,.2f}ms)')
        else:
            print(f'a wrong result {result} (expected: {expected})')
