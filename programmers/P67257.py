from time import perf_counter_ns as ns
from operator import add, sub, mul


def solution(expression):
    count = {k: 0 for k in '+-*'}
    d = {c: f for c, f in zip('+-*', (add, sub, mul))}
    e, tmp = [], []
    for c in expression:
        if c in '+-*':           
            e.append(int(''.join(tmp)))
            e.append(c)
            count[c] += 1
            tmp = []
        else:
            tmp.append(c)
    e.append(int(''.join(tmp)))
    ans = 0
    for order in '+-* +*- *+- *-+ -+* -*+'.split():
        exp = [elem for elem in e]
        for op in order:
            i, o, op_count, op_target = 1, d[op], 0, count[op]
            while op_count < op_target:
                if exp[i] == op:
                    exp[i - 1] = o(exp[i - 1], exp[i + 1])
                    del exp[i:i + 2]
                    op_count += 1
                else:
                    i += 2
        if (tmp := abs(exp[0])) > ans:
            ans = tmp
    return ans


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
            print(f'in an average of {total / ITERATIONS / 1e3:,.2f}μs '
                  f'(min: {fastest / 1e3:,.2f}μs, '
                  f'max: {slowest / 1e3:,.2f}μs)')
        else:
            print(f'a wrong result {result} (expected: {expected})')
