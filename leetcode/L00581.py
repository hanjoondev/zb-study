from time import perf_counter_ns as ns


class Solution:
    def findUnsortedSubarray(self, nums: list[int]) -> int:
        if (length := len(nums)) <= 1:
            return 0
        l, r, floor, ceil = length, -1, -int(1e5), int(1e5), 
        for i, n in enumerate(nums):
            if n < floor:
                r = i
            else:
                floor = n
        for i in range(len(nums) - 1, -1, -1):
            if nums[i] > ceil:
                l = i
            else:
                ceil = nums[i]
        return max(r - l + 1, 0)


if __name__ == '__main__':
    ITERATIONS = 1_000
    print(f'Running the basic tests {ITERATIONS:,} times...')
    tests = (
        ([2, 6, 4, 8, 10, 9, 15], 5),
        ([1, 2, 3, 4], 0),
        ([1], 0),
        ([2, 1], 2),
    )
    s = Solution()
    for numbers, expected in tests:
        print(f'findUnsortedSubarray({numbers}) returned', end=' ')
        if (result := s.findUnsortedSubarray(numbers)) == expected:
            print(f'the expected result {expected}', end=' ')
            fastest = float('inf')
            slowest = total = 0
            for _ in range(ITERATIONS):
                start = ns()
                s.findUnsortedSubarray(numbers)
                end = ns()
                time = end - start
                fastest, slowest = min(time, fastest), max(time, slowest)
                total += time
            print(f'in an average of {total / ITERATIONS / 1e3:,.2f}μs '
                  f'(min: {fastest / 1e3:,.2f}μs, '
                  f'max: {slowest / 1e3:,.2f}μs)')
        else:
            print(f'a wrong result {result} (expected: {expected})')
