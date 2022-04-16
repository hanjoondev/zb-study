from time import perf_counter_ns as ns


class Solution:
    def generate(self, num_rows: int) -> list[list[int]]:
        ans = []
        for i in range(num_rows):
            ans.append([1 if not j or i == j else
                        sum(ans[i - 1][j - 1:j + 1]) for j in range(i + 1)])
        return ans


if __name__ == '__main__':
    ITERATIONS = 1_000
    print(f'Running the basic tests {ITERATIONS:,} times...')
    tests = (
        (5, [[1], [1, 1],[1, 2, 1], [1, 3, 3, 1], [1, 4, 6, 4, 1]]),
        (1, [[1]])
    )
    s = Solution()
    for rows, expected in tests:
        print(f'generate({rows}) returned', end=' ')
        if (result := s.generate(rows)) == expected:
            print(f'the expected result {expected}', end=' ')
            fastest = float('inf')
            slowest = total = 0
            for _ in range(ITERATIONS):
                start = ns()
                s.generate(rows)
                end = ns()
                time = end - start
                fastest, slowest = min(time, fastest), max(time, slowest)
                total += time
            print(f'in an average of {total / ITERATIONS / 1000:,.2f}ms '
                  f'(min: {fastest / 1000:,.2f}ms, '
                  f'max: {slowest / 1000:,.2f}ms)')
        else:
            print(f'a wrong result {result} (expected: {expected})')


''' 118. Pascal's Triangle https://leetcode.com/problems/pascals-triangle/
    https://leetcode.com/submissions/detail/681368890/
    Runtime: 23 ms, faster than 98.95% of Python3 online submissions for Pascal's Triangle.
    Memory Usage: 13.8 MB, less than 97.73% of Python3 online submissions for Pascal's Triangle.
'''
