from time import perf_counter_ns as ns
from heapq import heappush as hpush, heappop as hpop


class Solution:
    def smallestChair(self, times: list[list[int]], targetFriend: int) -> int:
        target = times[targetFriend][0]
        chairs, empty = [], []
        for arrival, leaving in sorted([time for time in times]):
            while chairs and arrival >= chairs[0][0]:
                hpush(empty, hpop(chairs)[1])
            if arrival == target:
                return empty[0] if empty else len(chairs)
            hpush(chairs, (leaving, len(chairs) if not empty else hpop(empty)))


if __name__ == '__main__':
    ITERATIONS = 1_000
    print(f'Running the basic tests {ITERATIONS:,} times...')
    tests = (
        ([[1, 4], [2, 3], [4, 6]], 1, 1),
        ([[3, 10], [1, 5], [2, 6]], 0, 2)
    )
    s = Solution()
    for times, tf, expected in tests:
        print(f'smallestChair({times}, {tf}) returned', end=' ')
        if (result := s.smallestChair(times, tf)) == expected:
            print(f'the expected result {expected}', end=' ')
            fastest = float('inf')
            slowest = total = 0
            for _ in range(ITERATIONS):
                start = ns()
                s.smallestChair(times, tf)
                end = ns()
                time = end - start
                fastest, slowest = min(time, fastest), max(time, slowest)
                total += time
            print(f'in an average of {total / ITERATIONS / 1e3:,.2f}μs '
                  f'(min: {fastest / 1e3:,.2f}μs, '
                  f'max: {slowest / 1e3:,.2f}μs)')
        else:
            print(f'a wrong result {result} (expected: {expected})')
