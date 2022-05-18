from time import perf_counter_ns as ns


class Solution:
    def jump(self, nums: list[int]) -> int:
        if not (target := len(nums) - 1):
            return 0
        ans = i = 1
        cur = reach = nums[0]
        while reach < target:
            if (tmp := nums[i] + i) > cur:
                cur = tmp
            ans += (ended := i == reach)
            reach = cur if ended else reach
            i += 1
        return ans


if __name__ == '__main__':
    ITERATIONS = 1_000
    print(f'Running the basic tests {ITERATIONS:,} times...')
    tests = (
        ([2, 3, 1, 1, 4], 2),
        ([2, 3, 0, 1, 4], 2),
    )
    s = Solution()
    for num, expected in tests:
        print(f'jump({num}) returned', end=' ')
        if (result := s.jump(num)) == expected:
            print(f'the expected result {expected}', end=' ')
            fastest = float('inf')
            slowest = total = 0
            for _ in range(ITERATIONS):
                start = ns()
                s.jump(num)
                end = ns()
                time = end - start
                fastest, slowest = min(time, fastest), max(time, slowest)
                total += time
            print(f'in an average of {total / ITERATIONS / 1e3:,.2f}μs '
                  f'(min: {fastest / 1e3:,.2f}μs, '
                  f'max: {slowest / 1e3:,.2f}μs)')
        else:
            print(f'a wrong result {result} (expected: {expected})')
