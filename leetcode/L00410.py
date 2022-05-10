from time import perf_counter_ns as ns


class Solution:
    def splitArray(self, nums: list[int], m: int) -> int:
        low, high, ans = 0, sum(nums), float('inf')
        while low <= high:
            limit = (low + high) // 2
            sum_, splits = 0, 1
            for n in nums:
                if sum_ + n > limit:
                    if n > limit:
                        splits = m + 1
                        break
                    splits += 1
                    if splits > m:
                        break
                    sum_ = n
                else:
                    sum_ += n
            if splits <= m:
                ans = min(ans, limit)
                high = limit - 1
            else:
                low = limit + 1
        return ans


if __name__ == '__main__':
    ITERATIONS = 1_000
    print(f'Running the basic tests {ITERATIONS:,} times...')
    tests = (
        ([7, 2, 5, 10, 8], 2, 18),
        ([1, 2, 3, 4, 5], 2, 9),
        ([1, 4, 4], 3, 4)
    )
    s = Solution()
    for numbers, target, expected in tests:
        print(f'splitArray({numbers}, {target}) returned', end=' ')
        if (result := s.splitArray(numbers, target)) == expected:
            print(f'the expected result {expected}', end=' ')
            fastest = float('inf')
            slowest = total = 0
            for _ in range(ITERATIONS):
                start = ns()
                s.splitArray(numbers, target)
                end = ns()
                time = end - start
                fastest, slowest = min(time, fastest), max(time, slowest)
                total += time
            print(f'in an average of {total / ITERATIONS / 1e3:,.2f}μs '
                  f'(min: {fastest / 1e3:,.2f}μs, '
                  f'max: {slowest / 1e3:,.2f}μs)')
        else:
            print(f'a wrong result {result} (expected: {expected})')
