from time import perf_counter_ns as ns
from heapq import heappush as hpush, heappop as hpop


class Solution:
    def maxPerformance(self, n: int, speed: list[int], efficiency: list[int], k: int) -> int:
        mod = 10**9 + 7
        if n == 1:
            return (speed[0] * efficiency[0]) % mod
        h = []
        tspd = tperf = 0
        for e, s in sorted(zip(efficiency, speed), reverse=True):
            tspd += s
            hpush(h, s)
            if len(h) > k:
                tspd -= hpop(h)
            tperf = max(tperf, e * tspd)
        return tperf % mod


if __name__ == '__main__':
    ITERATIONS = 1_000
    print(f'Running the basic tests {ITERATIONS:,} times...')
    tests = (
        (6, [2, 10, 3, 1, 5, 8], [5, 4, 3, 9, 7, 2], 1, 40),
        (6, [2, 10, 3, 1, 5, 8], [5, 4, 3, 9, 7, 2], 2, 60),
        (6, [2, 10, 3, 1, 5, 8], [5, 4, 3, 9, 7, 2], 3, 68),
        (6, [2, 10, 3, 1, 5, 8], [5, 4, 3, 9, 7, 2], 4, 72)
    )
    s = Solution()
    for n, speed, eff, k, expected in tests:
        print(f'maxPerformance({n}, {speed}, {eff}, {k}) returned', end=' ')
        if (result := s.maxPerformance(n, speed, eff, k)) == expected:
            print(f'the expected result {expected}', end=' ')
            fastest = float('inf')
            slowest = total = 0
            for _ in range(ITERATIONS):
                start = ns()
                s.maxPerformance(n, speed, eff, k)
                end = ns()
                time = end - start
                fastest, slowest = min(time, fastest), max(time, slowest)
                total += time
            print(f'in an average of {total / ITERATIONS / 1e3:,.2f}μs '
                  f'(min: {fastest / 1e3:,.2f}μs, '
                  f'max: {slowest / 1e3:,.2f}μs)')
        else:
            print(f'a wrong result {result} (expected: {expected})')
