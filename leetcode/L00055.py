from time import perf_counter_ns as ns


class Solution:
    def canJump(self, nums: list[int]) -> bool:
        if (length := len(nums)) == 1:
            return True
        target = length - 1
        for i in range(length - 1, -1, -1):
            if i + nums[i] >= target:
                target = i
        return not target


if __name__ == '__main__':
    ITERATIONS = 1_000
    print(f'Running the basic tests {ITERATIONS:,} times...')
    tests = (
        ([2, 3, 1, 1, 4], True),
        ([3, 2, 1, 0, 4], False)
    )
    s = Solution()
    for arr, expected in tests:
        print(f'canJump({arr}) returned', end=' ')
        if (result := s.canJump(arr)) == expected:
            print(f'the expected result {expected}', end=' ')
            fastest = float('inf')
            slowest = total = 0
            for _ in range(ITERATIONS):
                start = ns()
                s.canJump(arr)
                end = ns()
                time = end - start
                fastest, slowest = min(time, fastest), max(time, slowest)
                total += time
            print(f'in an average of {total / ITERATIONS / 1e3:,.2f}μs '
                  f'(min: {fastest / 1e3:,.2f}μs, '
                  f'max: {slowest / 1e3:,.2f}μs)')
        else:
            print(f'a wrong result {result} (expected: {expected})')
