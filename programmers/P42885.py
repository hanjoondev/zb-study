from time import perf_counter_ns as ns


def solution(people, limit):
    boats, left, right = 0, 0, len(people) - 1
    people.sort()
    while left <= right:
        if people[left] + people[right] <= limit:
            left += 1
        right -= 1
        boats += 1
    return boats


if __name__ == '__main__':
    ITERATIONS = 1
    print(f'Running the basic tests {ITERATIONS:,} times...')
    tests = (
        ([70, 50, 80, 50], 100, 3),
        ([70, 80, 50], 100, 3),
        ([100, 100, 100, 100], 100, 4),
        ([1, 2, 3, 4], 100, 2)
    )
    for p, l, expected in tests:
        print(f'solution({p}, {l}) returned', end=' ')
        if (result := solution(p, l)) == expected:
            print(f'the expected result {expected}', end=' ')
            fastest = float('inf')
            slowest = total = 0
            for _ in range(ITERATIONS):
                start = ns()
                solution(p, l)
                end = ns()
                time = end - start
                fastest, slowest = min(time, fastest), max(time, slowest)
                total += time
            print(f'in an average of {total / ITERATIONS / 1e3:,.2f}μs '
                  f'(min: {fastest / 1e3:,.2f}μs, '
                  f'max: {slowest / 1e3:,.2f}μs)')
        else:
            print(f'a wrong result {result} (expected: {expected})')
