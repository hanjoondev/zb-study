from time import perf_counter_ns as ns


class Solution:
    def mergeStones(self, stones: list[int], k: int) -> int:
        return 0


if __name__ == '__main__':
    ITERATIONS = 1_000
    print(f'Running the basic tests {ITERATIONS:,} times...')
    tests = (
        ([3, 2, 4, 1], 2, 20),
        ([3, 2, 4, 1], 3, -1),
        ([3, 5, 1, 2, 6], 3, 25)
    )
    s = Solution()
    for stones, k, expected in tests:
        print(f'mergeStones({stones}, {k}) returned', end=' ')
        if (result := s.mergeStones(stones, k)) == expected:
            print(f'the expected result {expected}', end=' ')
            fastest = float('inf')
            slowest = total = 0
            for _ in range(ITERATIONS):
                start = ns()
                s.mergeStones(stones, k)
                end = ns()
                time = end - start
                fastest, slowest = min(time, fastest), max(time, slowest)
                total += time
            print(f'in an average of {total / ITERATIONS / 1000:,.2f}ms '
                  f'(min: {fastest / 1000:,.2f}ms, '
                  f'max: {slowest / 1000:,.2f}ms)')
        else:
            print(f'a wrong result {result} (expected: {expected})')
