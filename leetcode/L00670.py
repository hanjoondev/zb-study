from time import perf_counter_ns as ns


class Solution:
    def maximumSwap(self, num: int) -> int:
        s = [s for s in str(num)]
        length = len(s)
        maximum = length - 1
        cand = [maximum] * 2
        for i in range(length - 1, -1, -1):
            if s[i] > s[maximum]:
                maximum = i
            elif s[i] != s[maximum]:
                cand[0], cand[1] = i, maximum
        if cand[0] == cand[1]:
            return num
        s[cand[0]], s[cand[1]] = s[cand[1]], s[cand[0]]
        return int(''.join(s))


if __name__ == '__main__':
    ITERATIONS = 1_000
    print(f'Running the basic tests {ITERATIONS:,} times...')
    tests = (
        (2736, 7236),
        (9973, 9973)
    )
    s = Solution()
    for number, expected in tests:
        print(f'maximumSwap({number}) returned', end=' ')
        if (result := s.maximumSwap(number)) == expected:
            print(f'the expected result {expected}', end=' ')
            fastest = float('inf')
            slowest = total = 0
            for _ in range(ITERATIONS):
                start = ns()
                s.maximumSwap(number)
                end = ns()
                time = end - start
                fastest, slowest = min(time, fastest), max(time, slowest)
                total += time
            print(f'in an average of {total / ITERATIONS / 1e3:,.2f}μs '
                  f'(min: {fastest / 1e3:,.2f}μs, '
                  f'max: {slowest / 1e3:,.2f}μs)')
        else:
            print(f'a wrong result {result} (expected: {expected})')
