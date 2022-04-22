from time import perf_counter_ns as ns


class Solution:
    def digitSum(self, s: str, k: int) -> str:
        while len(s) > k:
            s = ''.join(str(sum(int(c) for c in s[i:i + k])) 
                                for i in range(0, len(s), k))
        return s


if __name__ == '__main__':
    ITERATIONS = 1_000
    print(f'Running the basic tests {ITERATIONS:,} times...')
    tests = (
        ('11111222223', 3, '135'),
        ('00000000', 3, '000')
    )
    s = Solution()
    for nums, k, expected in tests:
        print(f'digitSum("{nums}", {k}) returned', end=' ')
        if (result := s.digitSum(nums, k)) == expected:
            print(f'the expected result {expected}', end=' ')
            fastest = float('inf')
            slowest = total = 0
            for _ in range(ITERATIONS):
                start = ns()
                s.digitSum(nums, k)
                end = ns()
                time = end - start
                fastest, slowest = min(time, fastest), max(time, slowest)
                total += time
            print(f'in an average of {total / ITERATIONS / 1e3:,.2f}μs '
                  f'(min: {fastest / 1e3:,.2f}μs, '
                  f'max: {slowest / 1e3:,.2f}μs)')
        else:
            print(f'a wrong result {result} (expected: {expected})')

