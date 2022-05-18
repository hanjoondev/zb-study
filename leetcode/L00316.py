from time import perf_counter_ns as ns


class Solution:
    def removeDuplicateLetters(self, s: str) -> str:
        for c in sorted(ss := set(s)):
            if (set(tmp := s[s.index(c):])) == ss:
                return c + self.removeDuplicateLetters(tmp.replace(c, ''))
        return ''


if __name__ == '__main__':
    ITERATIONS = 1_000
    print(f'Running the basic tests {ITERATIONS:,} times...')
    tests = (
        ("bcabc", "abc"),
        ("cbacdcbc", "acdb"),
        ("abacb", "abc")
    )
    s = Solution()
    for string, expected in tests:
        print(f'removeDuplicateLetters("{string}") returned', end=' ')
        if (result := s.removeDuplicateLetters(string)) == expected:
            print(f'the expected result "{expected}"', end=' ')
            fastest = float('inf')
            slowest = total = 0
            for _ in range(ITERATIONS):
                start = ns()
                s.removeDuplicateLetters(string)
                end = ns()
                time = end - start
                fastest, slowest = min(time, fastest), max(time, slowest)
                total += time
            print(f'in an average of {total / ITERATIONS / 1e3:,.2f}μs '
                  f'(min: {fastest / 1e3:,.2f}μs, '
                  f'max: {slowest / 1e3:,.2f}μs)')
        else:
            print(f'a wrong result "{result}" (expected: "{expected}")')
