from time import perf_counter_ns as ns
from re import split as sp


class Solution:
    def camelMatch(self, queries: list[str], pattern: str) -> list[bool]:
        ans = []
        p = sp('(?=[A-Z])', pattern)[1:]
        d = [{c: subp.count(c) for c in subp if c.islower()}
                for subp in p]
        for q in queries:
            q = sp('(?=[A-Z])', q)[1:]
            if len(q) != len(p):
                ans.append(False)
            elif any(p[i] not in q[i] for i in range(len(q))):
                failed = False
                for i, subq in enumerate(q):
                    td = {c: subq.count(c) for c in subq if c.islower()}
                    if any(v > td.get(k, 0) for k, v in d[i].items()):
                        ans.append(False)
                        failed = True
                        break
                if not failed:
                    ans.append(True)
            else:
                ans.append(True)
        return ans


if __name__ == '__main__':
    ITERATIONS = 1_000
    print(f'Running the basic tests {ITERATIONS:,} times...')
    tests = (
        (["FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"], "FB", [True, False, True, True, False]),
        (["FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"], "FoBa", [True, False, True, False, False]),
        (["FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"], "FoBaT", [False, True, False, False, False])
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
            print(f'in an average of {total / ITERATIONS / 1e3:,.2f}μs '
                  f'(min: {fastest / 1e3:,.2f}μs, '
                  f'max: {slowest / 1e3:,.2f}μs)')
        else:
            print(f'a wrong result {result} (expected: {expected})')
