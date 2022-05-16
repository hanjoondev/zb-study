from time import perf_counter_ns as ns
from string import ascii_uppercase as a


def solution(name):
    d = {c: min(i, 26 - i) for i, c in enumerate(a)}
    n, ln = [d[c] for c in name], len(name)
    v = [0 if i and n[i] else 1 for i in range(ln)]
    if sum(v) == ln:
        return sum(n)
    count = ln - 1
    for i in range(ln):
        last = i + 1
        while last < ln and not n[last]:
            last += 1
        count = min(count, min(2 * i + ln - last, 2 * (ln - last) + i))
    return sum(n) + count


if __name__ == '__main__':
    ITERATIONS = 1_000
    print(f'Running the basic tests {ITERATIONS:,} times...')
    tests = (
        ('AZ', 2),
        ('JAZ', 11),
        ('JEROEN', 56),
        ('JAN', 23),
        ('BAAAAAA', 1),
        ('AAA', 0),
        ('Z', 1),
        ('BAAB', 3),
        ('ZAAAZZ', 5),
        ('BBBBAAAAAAAAAAAAAAAZ', 10),
    )
    for name, expected in tests:
        print(f'solution("{name}") returned', end=' ')
        if (result := solution(name)) == expected:
            print(f'the expected result {expected}', end=' ')
            fastest = float('inf')
            slowest = total = 0
            for _ in range(ITERATIONS):
                start = ns()
                solution(name)
                end = ns()
                time = end - start
                fastest, slowest = min(time, fastest), max(time, slowest)
                total += time
            print(f'in an average of {total / ITERATIONS / 1e3:,.2f}μs '
                  f'(min: {fastest / 1e3:,.2f}μs, '
                  f'max: {slowest / 1e3:,.2f}μs)')
        else:
            print(f'a wrong result {result} (expected: {expected})')
