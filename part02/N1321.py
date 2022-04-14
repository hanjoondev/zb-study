from time import perf_counter_ns as ns


class Solution:
    def smallestChair(self, times: list[list[int]], targetFriend: int) -> int:
        target = times[targetFriend][0]
        chairs, empty = [], []
        for arrival, leaving in sorted([time for time in times]):
            while chairs and arrival >= chairs[0][0]:
                time_left, idx = chairs.pop(0)
                empty.append(idx)
            if empty:
                empty.sort()
            if arrival == target:
                return empty[0] if empty else len(chairs)
            chair_idx = len(chairs) if not empty else empty.pop(0)
            chairs.append((leaving, chair_idx))
            chairs.sort()


if __name__ == '__main__':
    ITERATIONS = 1_000
    print(f'Running the basic tests {ITERATIONS:,} times...')
    tests = (
        ([[1, 4], [2, 3], [4, 6]], 1, 1),
        ([[3, 10], [1, 5], [2, 6]], 0, 2)
    )
    s = Solution()
    for times, tf, expected in tests:
        print(f'solution({times}, {tf}) returned', end=' ')
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
            print(f'in an average of {total / ITERATIONS / 1000:,.2f}ms '
                  f'(min: {fastest / 1000:,.2f}ms, '
                  f'max: {slowest / 1000:,.2f}ms)')
        else:
            print(f'a wrong result {result} (expected: {expected})')


''' 1942. The Number of the Smallest Unoccupied Chair https://leetcode.com/problems/the-number-of-the-smallest-unoccupied-chair/
https://leetcode.com/submissions/detail/680490786/
Runtime: 5902 ms, faster than 5.35% of Python3 online submissions for The Number of the Smallest Unoccupied Chair.
Memory Usage: 20 MB, less than 89.29% of Python3 online submissions for The Number of the Smallest Unoccupied Chair.
'''
