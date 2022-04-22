from time import perf_counter_ns as ns
from collections import deque as dq


def solution(cacheSize, cities):
    if not cacheSize:
        return len(cities) * 5
    ans = 0
    q = dq([])
    for c in cities:
        c = c.lower()
        if c not in q:
            if len(q) == cacheSize:
                q.popleft()
            q.append(c)
            ans += 5
        else:
            q.remove(c)
            q.append(c)
            ans += 1
    return ans


if __name__ == '__main__':
    ITERATIONS = 1_000
    print(f'Running the basic tests {ITERATIONS:,} times...')
    tests = (
        (3, ["Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo",
             "Seoul", "NewYork", "LA"], 50),
        (3, ["Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju",
             "Pangyo", "Seoul"], 21),
        (2, ["Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco",
             "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"], 60),
        (5, ["Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco",
             "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"], 52),
        (2, ["Jeju", "Pangyo", "NewYork", "newyork"], 16),
        (0, ["Jeju", "Pangyo", "Seoul", "NewYork", "LA"], 25)
    )
    for size, cities, expected in tests:
        print(f'solution({size}, {cities}) returned', end=' ')
        if (result := solution(size, cities)) == expected:
            print(f'the expected result {expected}', end=' ')
            fastest = float('inf')
            slowest = total = 0
            for _ in range(ITERATIONS):
                start = ns()
                solution(size, cities)
                end = ns()
                time = end - start
                fastest, slowest = min(time, fastest), max(time, slowest)
                total += time
            print(f'in an average of {total / ITERATIONS / 1e3:,.2f}μs '
                  f'(min: {fastest / 1e3:,.2f}μs, '
                  f'max: {slowest / 1e3:,.2f}μs)')
        else:
            print(f'a wrong result {result} (expected: {expected})')
