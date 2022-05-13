from time import perf_counter_ns as ns


class Solution:
    def threeSum(self, nums: list[int]) -> list[list[int]]:
        if (length := len(nums)) < 3:
            return []
        if length == 3:
            return [] if sum(nums) else [nums]
        nums.sort()
        ans = []
        for left in range(length):
            if left and nums[left] == nums[left - 1]:
                continue
            mid, right = left + 1, length - 1
            while mid < right:
                vl, vm, vr = nums[left], nums[mid], nums[right]
                if not (vl + vm + vr):
                    ans.append([vl, vm, vr])
                    while mid < right and vm == nums[mid + 1]:
                        mid += 1
                    while mid < right and vr == nums[right - 1]:
                        right -= 1
                    mid += 1
                    right -= 1
                elif vl + vm + vr > 0:
                    right -= 1
                else:
                    mid += 1
        return ans


if __name__ == '__main__':
    ITERATIONS = 1_000
    print(f'Running the basic tests {ITERATIONS:,} times...')
    tests = (
        ([-1, 0, 1, 2, -1, -4], [[-1, -1, 2], [-1, 0, 1]]),
        ([], []),
        ([0], []),
    )
    s = Solution()
    for arr, expected in tests:
        print(f'threeSum({arr}) returned', end=' ')
        if (result := s.threeSum(arr)) == expected:
            print(f'the expected result {expected}', end=' ')
            fastest = float('inf')
            slowest = total = 0
            for _ in range(ITERATIONS):
                start = ns()
                s.threeSum(arr)
                end = ns()
                time = end - start
                fastest, slowest = min(time, fastest), max(time, slowest)
                total += time
            print(f'in an average of {total / ITERATIONS / 1e3:,.2f}μs '
                  f'(min: {fastest / 1e3:,.2f}μs, '
                  f'max: {slowest / 1e3:,.2f}μs)')
        else:
            print(f'a wrong result {result} (expected: {expected})')
