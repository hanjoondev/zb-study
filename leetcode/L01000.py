from time import perf_counter_ns as ns


class Solution:
    def mergeStones(self, stones: list[int], k: int) -> int:
        if (L := len(stones)) == 1:
            return 0
        if (L- 1) % (k - 1):
            return -1
        ss = [0]
        for stone in stones: 
            ss.append(ss[-1] + stone)
        dp = [[0] * L for _ in range(L)]
        for i in range(k, L + 1):
            for j in range(L + 1 - i):
                dp[j][(t := i + j - 1)] = float('inf')
                for m in range(j, t, k - 1):
                    dp[j][t] = min(dp[j][t], dp[j][m] + dp[m + 1][t])
                dp[j][t] += 0 if (i - 1) % (k - 1) else ss[i + j] - ss[j]
        return dp[0][L - 1]


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
            print(f'in an average of {total / ITERATIONS / 1e3:,.2f}μs '
                  f'(min: {fastest / 1e3:,.2f}μs, '
                  f'max: {slowest / 1e3:,.2f}μs)')
        else:
            print(f'a wrong result {result} (expected: {expected})')
