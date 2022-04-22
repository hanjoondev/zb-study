from time import perf_counter_ns as ns
from heapq import heappush as hpush, heappop as hpop


class Solution:
    def minInterval(self, intervals: list[list[int]], queries: list[int]) -> list[int]:
        intervals.sort()
        heap, ans, i = [], {}, 0
        for q in sorted(queries):
            while i < len(intervals) and intervals[i][0] <= q:
                start, end = intervals[i]
                hpush(heap, (end - start + 1, end))
                i += 1
            while heap and heap[0][1] < q:
                hpop(heap)
            ans[q] = heap[0][0] if heap else -1
        return [ans[q] for q in queries]


if __name__ == '__main__':
    ITERATIONS = 1_000
    print(f'Running the basic tests {ITERATIONS:,} times...')
    tests = (
        ([[1, 4], [2, 4], [3, 6], [4, 4]], [2, 3, 4, 5], [3, 3, 1, 4]),
        ([[2, 3], [2, 5], [1, 8], [20, 25]], [2, 19, 5, 22], [2, -1, 4, 6])
    )
    s = Solution()
    for intervals, queries, expected in tests:
        print(f'minInterval({intervals}, {queries}) returned', end=' ')
        if (result := s.minInterval(intervals, queries)) == expected:
            print(f'the expected result {expected}', end=' ')
            fastest = float('inf')
            slowest = total = 0
            for _ in range(ITERATIONS):
                start = ns()
                s.minInterval(intervals, queries)
                end = ns()
                time = end - start
                fastest, slowest = min(time, fastest), max(time, slowest)
                total += time
            print(f'in an average of {total / ITERATIONS / 1e3:,.2f}μs '
                  f'(min: {fastest / 1e3:,.2f}μs, '
                  f'max: {slowest / 1e3:,.2f}μs)')
        else:
            print(f'a wrong result {result} (expected: {expected})')
