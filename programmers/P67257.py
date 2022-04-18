from time import perf_counter_ns as ns
import operator


def solution(expression):
    answer, nums, ops, n = 0, [], [], ''
    for c in expression:
        if c in '+-*':
            nums.append(int(n))
            ops.append(c)
            n = ''
        else:
            n += c
    nums.append(int(n))
    for order in '+-* +*- *+- *-+ -+* -*+'.split():
        ops_copy, nums_copy = [o for o in ops], [n for n in nums]
        for op in order:
            calc = operator.add if op == '+' else operator.sub if op == '-' else operator.mul
            i = 0
            while i < len(ops_copy):
                if ops_copy[i] == op:
                    nums_copy[i] = calc(nums_copy[i], nums_copy[i + 1])
                    del ops_copy[i]
                    del nums_copy[i + 1]
                else:
                    i += 1
        answer = max(abs(answer), abs(nums_copy[0]))
    return answer


if __name__ == '__main__':
    ITERATIONS = 1_000
    print(f'Running the basic tests {ITERATIONS:,} times...')
    tests = (
        ("100-200*300-500+20", 60420),
        ("50*6-3*2", 300)
    )
    for exp, expected in tests:
        print(f'solution("{exp}") returned', end=' ')
        if (result := solution(exp)) == expected:
            print(f'the expected result {expected}', end=' ')
            fastest = float('inf')
            slowest = total = 0
            for _ in range(ITERATIONS):
                start = ns()
                solution(exp)
                end = ns()
                time = end - start
                fastest, slowest = min(time, fastest), max(time, slowest)
                total += time
            print(f'in an average of {total / ITERATIONS / 1000:,.2f}ms '
                  f'(min: {fastest / 1000:,.2f}ms, '
                  f'max: {slowest / 1000:,.2f}ms)')
        else:
            print(f'a wrong result {result} (expected: {expected})')
