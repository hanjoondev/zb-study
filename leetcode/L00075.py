from time import perf_counter_ns as ns


class Solution:
    def sortColors(self, nums: list[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        self.quicksort(nums, 0, len(nums) - 1)
    
    def quicksort(self, n, start, end):
        if start >= end:
            return
        pivot, lo, hi = n[start], start + 1, end
        while True:
            while lo <= hi and n[hi] >= pivot:
                hi = hi - 1
            while lo <= hi and n[lo] <= pivot:
                lo = lo + 1
            if lo <= hi:
                n[lo], n[hi] = n[hi], n[lo]
            else:
                break
        n[start], n[hi] = n[hi], n[start]
        self.quicksort(n, start, hi - 1)
        self.quicksort(n, hi + 1, end)


if __name__ == '__main__':
    ITERATIONS = 1_000
    print(f'Running the basic tests {ITERATIONS:,} times...')
    tests = (
        ([2, 0, 2, 1, 1, 0], [0, 0, 1, 1, 2, 2]),
        ([2, 0, 1], [0, 1, 2]),
    )
    s = Solution()
    for n, expected in tests:
        print(f'sortColors({n}) mutated the list to', end=' ')
        nbackup = [i for i in n]
        s.sortColors(n)
        if (result := n) == expected:
            print(f'the expected {expected}', end=' ')
            fastest = float('inf')
            slowest = total = 0
            n = [i for i in nbackup]
            for _ in range(ITERATIONS):
                start = ns()
                s.sortColors(n)
                end = ns()
                time = end - start
                fastest, slowest = min(time, fastest), max(time, slowest)
                total += time
            print(f'in an average of {total / ITERATIONS / 1e3:,.2f}μs '
                  f'(min: {fastest / 1e3:,.2f}μs, '
                  f'max: {slowest / 1e3:,.2f}μs)')
        else:
            print(f'a wrong result {result} (expected: {expected})')
