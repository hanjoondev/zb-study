from time import perf_counter_ns as ns


def solution(d, rocks, n):
    stones = [0] + sorted(rocks) + [d]
    low, high = 0, d
    while low + 1 < high:
        dist = (low + high) // 2
        removed = failed = prev = 0
        for s in stones[1:]:
            if s - prev < dist:
                if removed == n:
                    failed = 1
                    break
                removed += 1
                continue
            prev = s
        if not failed:
            low = dist
        else:
            high = dist
    return low


if __name__ == '__main__':
    ITERATIONS = 1_000
    print(f'Running the basic tests {ITERATIONS:,} times...')
    tests = (
        (25, [2, 14, 11, 21, 17], 2, 4),
    )
    for distance, rocks, num_removal, expected in tests:
        print(f'solution({distance}, {rocks}, {num_removal}) returned', end=' ')
        if (result := solution(distance, rocks, num_removal)) == expected:
            print(f'the expected result {expected}', end=' ')
            fastest = float('inf')
            slowest = total = 0
            for _ in range(ITERATIONS):
                start = ns()
                solution(distance, rocks, num_removal)
                end = ns()
                time = end - start
                fastest, slowest = min(time, fastest), max(time, slowest)
                total += time
            print(f'in an average of {total / ITERATIONS / 1e3:,.2f}μs '
                  f'(min: {fastest / 1e3:,.2f}μs, '
                  f'max: {slowest / 1e3:,.2f}μs)')
        else:
            print(f'a wrong result {result} (expected: {expected})')
