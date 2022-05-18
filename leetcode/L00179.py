from time import perf_counter_ns as ns


class Solution:
    def compare(self, s1: str, s2: str) -> bool:
        return s1 + s2 <= s2 + s1

    def quicksort(self, n, start, end):
        if start >= end:
            return
        pivot, lo, hi = n[start], start + 1, end
        while True:
            while lo <= hi and self.compare(n[hi], pivot):
                hi = hi - 1
            while lo <= hi and self.compare(pivot, n[lo]):
                lo = lo + 1
            if lo <= hi:
                n[lo], n[hi] = n[hi], n[lo]
            else:
                break
        n[start], n[hi] = n[hi], n[start]
        self.quicksort(n, start, hi - 1)
        self.quicksort(n, hi + 1, end)

    def largestNumber(self, nums: list[int]) -> str:
        nums = [str(i) for i in nums]
        self.quicksort(nums, 0, len(nums) - 1)
        return str(int(''.join(nums)))


if __name__ == '__main__':
    ITERATIONS = 1_000
    print(f'Running the basic tests {ITERATIONS:,} times...')
    tests = (
        ([10, 2], "210"),
        ([3, 30, 34, 5, 9], "9534330")
    )
    s = Solution()
    for arr, expected in tests:
        print(f'largestNumber({arr}) returned', end=' ')
        if (result := s.largestNumber(arr)) == expected:
            print(f'the expected result "{expected}"', end=' ')
            fastest = float('inf')
            slowest = total = 0
            for _ in range(ITERATIONS):
                start = ns()
                s.largestNumber(arr)
                end = ns()
                time = end - start
                fastest, slowest = min(time, fastest), max(time, slowest)
                total += time
            print(f'in an average of {total / ITERATIONS / 1e3:,.2f}μs '
                  f'(min: {fastest / 1e3:,.2f}μs, '
                  f'max: {slowest / 1e3:,.2f}μs)')
        else:
            print(f'a wrong result "{result}" (expected: "{expected}")')
