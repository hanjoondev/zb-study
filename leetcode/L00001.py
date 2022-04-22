from time import perf_counter_ns as ns


class Solution:
    def twoSum(self, nums: list[int], target: int) -> list[int]:
        if (length := len(nums)) == 1:
            return [0]
        if length == 2:
            return [0, 1]
        d = {}
        for i, n in enumerate(nums):
            if (rem := target - n) in d:
                return [d[rem], i]
            d[n] = i


if __name__ == '__main__':
    ITERATIONS = 1_000
    print(f'Running the basic tests {ITERATIONS:,} times...')
    tests = (
        ([2, 7, 11, 15], 9, [0, 1]),
        ([3, 2, 4], 6, [1, 2]),
        ([3, 3], 6, [0, 1])
    )
    s = Solution()
    for nums, t, expected in tests:
        print(f'twoSum({nums}, {t}) returned', end=' ')
        if (result := s.twoSum(nums, t)) == expected:
            print(f'the expected result {expected}', end=' ')
            fastest = float('inf')
            slowest = total = 0
            for _ in range(ITERATIONS):
                start = ns()
                s.twoSum(nums, t)
                end = ns()
                time = end - start
                fastest, slowest = min(time, fastest), max(time, slowest)
                total += time
            print(f'in an average of {total / ITERATIONS / 1e3:,.2f}μs '
                  f'(min: {fastest / 1e3:,.2f}μs, '
                  f'max: {slowest / 1e3:,.2f}μs)')
        else:
            print(f'a wrong result {result} (expected: {expected})')
