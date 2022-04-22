from time import perf_counter_ns as ns


class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        h, w = len(s), len(p)
        dp = [[False] * (w + 1) for _ in range(h + 1)]
        dp[-1][-1] = True
        for r in range(h, -1, -1):
            for c in range(w - 1, -1, -1):
                matched = r < h and p[c] in (s[r], '.')
                if c + 1 < len(p) and p[c + 1] == '*':
                    dp[r][c] = matched and dp[r + 1][c] or dp[r][c + 2]
                else:
                    dp[r][c] = matched and dp[r + 1][c + 1]
        return dp[0][0]


if __name__ == '__main__':
    ITERATIONS = 1_000
    print(f'Running the basic tests {ITERATIONS:,} times...')
    tests = (
        ("aa", "a", False),
        ("aa", "a*", True),
        ("ab", ".*", True)
    )
    s = Solution()
    for string, pattern, expected in tests:
        print(f'isMatch("{string}", "{pattern}") returned', end=' ')
        if (result := s.isMatch(string, pattern)) == expected:
            print(f'the expected result {expected}', end=' ')
            fastest = float('inf')
            slowest = total = 0
            for _ in range(ITERATIONS):
                start = ns()
                s.isMatch(string, pattern)
                end = ns()
                time = end - start
                fastest, slowest = min(time, fastest), max(time, slowest)
                total += time
            print(f'in an average of {total / ITERATIONS / 1e3:,.2f}μs '
                  f'(min: {fastest / 1e3:,.2f}μs, '
                  f'max: {slowest / 1e3:,.2f}μs)')
        else:
            print(f'a wrong result {result} (expected: {expected})')
