from time import perf_counter_ns as ns


class Solution:
    def reverse(self, x: int) -> int:
        neg = -1 if x < 0 else 1
        x = int(str(abs(x))[::-1]) * neg
        return x * (-2147483648 <= x <= 2147483647)


if __name__ == '__main__':
    ITERATIONS = 1_000
    print(f'Running the basic tests {ITERATIONS:,} times...')
    tests = (
        (123, 321),
        (-123, -321),
        (120, 21),
        (1534236469, 0)
    )
    s = Solution()
    for num, expected in tests:
        print(f'reverse({num}) returned', end=' ')
        if (result := s.reverse(num)) == expected:
            print(f'the expected result {expected}', end=' ')
            fastest = float('inf')
            slowest = total = 0
            for _ in range(ITERATIONS):
                start = ns()
                s.reverse(num)
                end = ns()
                time = end - start
                fastest, slowest = min(time, fastest), max(time, slowest)
                total += time
            print(f'in an average of {total / ITERATIONS / 1e3:,.2f}μs '
                  f'(min: {fastest / 1e3:,.2f}μs, '
                  f'max: {slowest / 1e3:,.2f}μs)')
        else:
            print(f'a wrong result {result} (expected: {expected})')
