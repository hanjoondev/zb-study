from collections import Counter
from time import perf_counter_ns as ns


class Solution:
    def groupAnagrams(self, strs: list[str]) -> list[list[str]]:
        d = {}
        for i, s in enumerate(strs):
            d.setdefault((k := ''.join(sorted(s))), []).append(i)
        return [[strs[i] for i in l] for l in d.values()]


if __name__ == '__main__':
    ITERATIONS = 1_000
    print(f'Running the basic tests {ITERATIONS:,} times...')
    tests = (
        (["eat", "tea", "tan", "ate", "nat", "bat"],
         [["bat"], ["nat","tan"], ["ate","eat","tea"]]),
        ([""], [[""]]),
        (["a"], [["a"]])
    )
    s = Solution()
    for strings, expected in tests:
        print(f'groupAnagrams({strings}) returned', end=' ')
        if (len(result := s.groupAnagrams(strings)) == len(expected)
            and all(sorted(r) == sorted(e) for r, e in 
                    zip(sorted(result, key=len), sorted(expected, key=len)))):
            print(f'the expected result {expected}', end=' ')
            fastest = float('inf')
            slowest = total = 0
            for _ in range(ITERATIONS):
                start = ns()
                s.groupAnagrams(strings)
                end = ns()
                time = end - start
                fastest, slowest = min(time, fastest), max(time, slowest)
                total += time
            print(f'in an average of {total / ITERATIONS / 1e3:,.2f}μs '
                  f'(min: {fastest / 1e3:,.2f}μs, '
                  f'max: {slowest / 1e3:,.2f}μs)')
        else:
            print(f'a wrong result {result} (expected: {expected})')
