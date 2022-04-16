from time import perf_counter_ns as ns


def solution(n):
    return -solution(-n) if n < 0 else int(str(n)[::-1])


if __name__ == '__main__':
    ITERATIONS = 1_000
    print(f'Running the basic tests {ITERATIONS:,} times...')
    tests = (
        (12345, 54321),
        (-12345, -54321),
        (100, 1),
        (0, 0)
    )
    for num, expected in tests:
        print(f'solution({num}) returned', end=' ')
        if (result := solution(num)) == expected:
            print(f'the expected result {expected}', end=' ')
            fastest = float('inf')
            slowest = total = 0
            for _ in range(ITERATIONS):
                start = ns()
                solution(num)
                end = ns()
                time = end - start
                fastest, slowest = min(time, fastest), max(time, slowest)
                total += time
            print(f'in an average of {total / ITERATIONS / 1000:,.2f}ms '
                  f'(min: {fastest / 1000:,.2f}ms, '
                  f'max: {slowest / 1000:,.2f}ms)')
        else:
            print(f'a wrong result {result} (expected: {expected})')


''' 7. Reverse Integer https://leetcode.com/problems/reverse-integer/
    https://leetcode.com/submissions/detail/681368158/
    Runtime: 28 ms, faster than 97.38% of Python3 online submissions for Reverse Integer.
    Memory Usage: 13.9 MB, less than 67.40% of Python3 online submissions for Reverse Integer.
class Solution:
    def reverse(self, x: int) -> int:
        neg = -1 if x < 0 else 1
        x = int(str(abs(x))[::-1]) * neg
        return x * (-2147483648 <= x <= 2147483647)
'''
