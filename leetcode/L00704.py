from time import perf_counter_ns as ns


class Solution:
    def search(self, nums: list[int], target: int) -> int:
        low, high = 0, len(nums) - 1
        while low <= high:
            if (n := nums[mid := (low + high) // 2]) == target:
                return mid
            if n < target:
                low = mid + 1
            else:
                high = mid - 1
        return -1


if __name__ == '__main__':
    ITERATIONS = 1_000
    print(f'Running the basic tests {ITERATIONS:,} times...')
    tests = (
        ([-1, 0, 3, 5, 9, 12], 9, 4),
        ([-1, 0, 3, 5, 9, 12], 2, -1),
        ([1], 1, 0),
        ([2, 5], 5, 1),
    )
    s = Solution()
    for numbers, target, expected in tests:
        print(f'search({numbers}, {target}) returned', end=' ')
        if (result := s.search(numbers, target)) == expected:
            print(f'the expected result {expected}', end=' ')
            fastest = float('inf')
            slowest = total = 0
            for _ in range(ITERATIONS):
                start = ns()
                s.search(numbers, target)
                end = ns()
                time = end - start
                fastest, slowest = min(time, fastest), max(time, slowest)
                total += time
            print(f'in an average of {total / ITERATIONS / 1e3:,.2f}μs '
                  f'(min: {fastest / 1e3:,.2f}μs, '
                  f'max: {slowest / 1e3:,.2f}μs)')
        else:
            print(f'a wrong result {result} (expected: {expected})')
