from time import perf_counter_ns as ns


class Solution:
    def camelMatch(self, queries: list[str], pattern: str) -> list[bool]:
        return 0


if __name__ == '__main__':
    ITERATIONS = 1_000
    print(f'Running the basic tests {ITERATIONS:,} times...')
    tests = (
        (["FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"], "FB", [True, False, True, True, False]),
        (["FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"], "FoBa", [True, False, True, False, False]),
        (["FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"], "FoBaT", [False, True, False, False, False]),
    )
    s = Solution()
    for q, p, expected in tests:
        print(f'camelMatch({q}, "{p}") returned', end=' ')
        if (result := s.camelMatch(q, p)) == expected:
            print(f'the expected result {expected}', end=' ')
            fastest = float('inf')
            slowest = total = 0
            for _ in range(ITERATIONS):
                start = ns()
                s.camelMatch(q, p)
                end = ns()
                time = end - start
                fastest, slowest = min(time, fastest), max(time, slowest)
                total += time
            print(f'in an average of {total / ITERATIONS / 1000:,.2f}ms '
                  f'(min: {fastest / 1000:,.2f}ms, '
                  f'max: {slowest / 1000:,.2f}ms)')
        else:
            print(f'a wrong result {result} (expected: {expected})')
