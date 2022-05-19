from time import perf_counter_ns as ns


def solution(p, s):
    ans, length = [], len(s)
    days = i = 0
    while i < length:
        if p[i] < 100:
            for j in range(i, length):
                p[j] += s[j]
            days += 1
            continue
        else:
            count = 0
            while i < length and p[i] >= 100:
                i += 1
                count += 1
            ans.append(count)
            days = 0
    return ans


if __name__ == '__main__':
    ITERATIONS = 1_000
    print(f'Running the basic tests {ITERATIONS:,} times...')
    tests = (
        ([93, 30, 55], [1, 30, 5], [2, 1]),
        ([95, 90, 99, 99, 80, 99], [1, 1, 1, 1, 1, 1], [1, 3, 2])
    )
    for p, s, expected in tests:
        print(f'solution({p}, {s}) returned', end=' ')
        if (result := solution(p, s)) == expected:
            print(f'the expected result {expected}', end=' ')
            fastest = float('inf')
            slowest = total = 0
            for _ in range(ITERATIONS):
                start = ns()
                solution(p, s)
                end = ns()
                time = end - start
                fastest, slowest = min(time, fastest), max(time, slowest)
                total += time
            print(f'in an average of {total / ITERATIONS / 1e3:,.2f}μs '
                  f'(min: {fastest / 1e3:,.2f}μs, '
                  f'max: {slowest / 1e3:,.2f}μs)')
        else:
            print(f'a wrong result {result} (expected: {expected})')
