from time import perf_counter_ns as ns


def solution(s):
    d = {n: str(i) for i, n in enumerate('zero one two three four '
                                         'five six seven eight nine'.split())}
    for k, v in d.items():
        s = s.replace(k, v)
    return int(s)


if __name__ == '__main__':
    ITERATIONS = 1_000
    print(f'Running the basic tests {ITERATIONS:,} times...')
    tests = (
        ("one4seveneight", 1478),
        ("23four5six7", 234567),
        ("2three45sixseven", 234567),
        ("123", 123)
    )
    for s, expected in tests:
        print(f'solution({s}) returned', end=' ')
        if (result := solution(s)) == expected:
            print(f'the expected result {expected}', end=' ')
            fastest = float('inf')
            slowest = total = 0
            for _ in range(ITERATIONS):
                start = ns()
                solution(s)
                end = ns()
                time = end - start
                fastest, slowest = min(time, fastest), max(time, slowest)
                total += time
            print(f'in an average of {total / ITERATIONS / 1000:,.2f}ms '
                  f'(min: {fastest / 1000:,.2f}ms, '
                  f'max: {slowest / 1000:,.2f}ms)')
        else:
            print(f'a wrong result {result} (expected: {expected})')
