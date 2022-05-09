from time import perf_counter_ns as ns


class Solution:
    def searchMatrix(self, m: list[list[int]], target: int) -> bool:
        l, r, mid = 0, len(m) - 1, 0
        while l <= r:
            if m[mid := (l + r) // 2][0] <= target <= m[mid][-1]:
                break
            if m[mid][0] < target:
                l = mid + 1
            else:
                r = mid - 1
        l, r, row = 0, len(m[0]) - 1, m[mid]
        while l <= r:
            if row[mid := (l + r) // 2] == target:
                return True
            if row[mid] < target:
                l = mid + 1
            else:
                r = mid - 1
        return False


if __name__ == '__main__':
    ITERATIONS = 1_000
    print(f'Running the basic tests {ITERATIONS:,} times...')
    tests = (
        ([[1]], 0, False),
        ([[ 1,  3,  5,  7],
          [10, 11, 16, 20],
          [23, 30, 34, 60]], 3, True),
        ([[ 1,  3,  5,  7],
          [10, 11, 16, 20],
          [23, 30, 34, 60]], 13, False),
        ([[ 1,  3,  5,  7],
          [10, 11, 16, 20],
          [23, 30, 34, 60]], 3, True),
        ([[1], [3]], 3, True),
    )
    s = Solution()
    for mat, target, expected in tests:
        print(f'searchMatrix({mat}, {target}) returned', end=' ')
        if (result := s.searchMatrix(mat, target)) == expected:
            print(f'the expected result {expected}', end=' ')
            fastest = float('inf')
            slowest = total = 0
            for _ in range(ITERATIONS):
                start = ns()
                s.searchMatrix(mat, target)
                end = ns()
                time = end - start
                fastest, slowest = min(time, fastest), max(time, slowest)
                total += time
            print(f'in an average of {total / ITERATIONS / 1e3:,.2f}μs '
                  f'(min: {fastest / 1e3:,.2f}μs, '
                  f'max: {slowest / 1e3:,.2f}μs)')
        else:
            print(f'a wrong result {result} (expected: {expected})')
