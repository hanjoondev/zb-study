from bisect import bisect_left as bl
from time import perf_counter_ns as ns


class Solution:
    def intersection(self, nums1: list[int], nums2: list[int]) -> list[int]:
        n1, n2 = sorted(nums1), sorted(nums2)
        l1, l2 = len(nums1), len(nums2)
        i, j = 0, 0
        ans = []
        while i < l1 and j < l2:
            if n1[i] == n2[j]:
                ans.append(n1[i])
                i, j = bl(n1, n1[i] + 1), bl(n2, n2[j] + 1)
            elif n1[i] < n2[j]:
                i += 1
            else:
                j += 1
        return ans


if __name__ == '__main__':
    ITERATIONS = 1_000
    print(f'Running the basic tests {ITERATIONS:,} times...')
    tests = (
        ([1, 2, 2, 1], [2, 2], [2]),
        ([4, 9, 5], [9, 4, 9, 8, 4], [9, 4]),
    )
    s = Solution()
    for n1, n2, expected in tests:
        print(f'intersection({n1}, {n2}) returned', end=' ')
        if (result := sorted(s.intersection(n1, n2))) == sorted(expected):
            print(f'the expected result {expected}', end=' ')
            fastest = float('inf')
            slowest = total = 0
            for _ in range(ITERATIONS):
                start = ns()
                s.intersection(n1, n2)
                end = ns()
                time = end - start
                fastest, slowest = min(time, fastest), max(time, slowest)
                total += time
            print(f'in an average of {total / ITERATIONS / 1e3:,.2f}μs '
                  f'(min: {fastest / 1e3:,.2f}μs, '
                  f'max: {slowest / 1e3:,.2f}μs)')
        else:
            print(f'a wrong result {result} (expected: {expected})')
