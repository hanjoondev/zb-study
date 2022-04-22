from time import perf_counter_ns as ns
from heapq import heappush as hpush, heappop as hpop


class Solution:
    def isPossible(self, target: list[int]) -> bool:
        if not target:
            return False
        h, total = [], 0
        for n in target:
            hpush(h, -n)
            total += n
        while True:
            if (biggest := -hpop(h)) == 1:
                return True
            if biggest <= (rest := total - biggest) or not rest:
                return False
            biggest = rest if not biggest % rest else biggest % rest
            total = biggest + rest
            hpush(h, -biggest)


if __name__ == '__main__':
    ITERATIONS = 1_000
    print(f'Running the basic tests {ITERATIONS:,} times...')
    tests = (
        ([9, 3, 5], True),
        ([1, 1, 1, 2], False),
        ([8, 5], True)
    )
    s = Solution()
    for t, expected in tests:
        print(f'isPossible({t}) returned', end=' ')
        if (result := s.isPossible(t)) == expected:
            print(f'the expected result {expected}', end=' ')
            fastest = float('inf')
            slowest = total = 0
            for _ in range(ITERATIONS):
                start = ns()
                s.isPossible(t)
                end = ns()
                time = end - start
                fastest, slowest = min(time, fastest), max(time, slowest)
                total += time
            print(f'in an average of {total / ITERATIONS / 1e3:,.2f}μs '
                  f'(min: {fastest / 1e3:,.2f}μs, '
                  f'max: {slowest / 1e3:,.2f}μs)')
        else:
            print(f'a wrong result {result} (expected: {expected})')
