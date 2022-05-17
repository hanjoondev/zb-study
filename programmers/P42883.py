from collections import deque as dq
from time import perf_counter_ns as ns


def solution(num, k):
    q = dq()
    for n in num:
        while q and k and q[-1] < n:
            q.pop()
            k -= 1
        q.append(n)
    return ''.join(q) if not k else num[:-k]


if __name__ == '__main__':
    ITERATIONS = 1_000
    print(f'Running the basic tests {ITERATIONS:,} times...')
    tests = (
        ("1924", 2, "94"),
        ("1231234", 3, "3234"),
        ("4177252841", 4, "775841")
    )
    for n, k, expected in tests:
        print(f'solution("{n}", {k}) returned', end=' ')
        if (result := solution(n, k)) == expected:
            print(f'the expected result "{expected}"', end=' ')
            fastest = float('inf')
            slowest = total = 0
            for _ in range(ITERATIONS):
                start = ns()
                solution(n, k)
                end = ns()
                time = end - start
                fastest, slowest = min(time, fastest), max(time, slowest)
                total += time
            print(f'in an average of {total / ITERATIONS / 1e3:,.2f}μs '
                  f'(min: {fastest / 1e3:,.2f}μs, '
                  f'max: {slowest / 1e3:,.2f}μs)')
        else:
            print(f'a wrong result "{result}" (expected: "{expected}")')
