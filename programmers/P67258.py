from time import perf_counter_ns as ns


def solution(gems):
    d, num_types = {gems[0]: 1}, len(set(gems))
    ans = [1, (length := len(gems))]
    lft = rgt = 0
    while lft <= rgt < length:
        if len(d) == num_types:
            ans = [lft + 1, rgt + 1] if ans[1] - ans[0] > rgt - lft else ans
            d[gems[lft]] -= 1
            if not d[gems[lft]]:
                del d[gems[lft]]
            lft += 1
            continue
        rgt += 1
        if rgt < length:
            d[gems[rgt]] = d.get(gems[rgt], 0) + 1
    return ans


if __name__ == '__main__':
    ITERATIONS = 10_000
    print(f'Running the basic tests {ITERATIONS:,} times...')
    tests = (
        (["DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"],
         [3, 7]),
        (["AA", "AB", "AC", "AA", "AC"], [1, 3]),
        (["XYZ", "XYZ", "XYZ"], [1, 1]),
        (["ZZZ", "YYY", "NNNN", "YYY", "BBB"], [1, 5])
    )
    for gems, expected in tests:
        print(f'solution({gems}) returned', end=' ')
        if (result := solution(gems)) == expected:
            print(f'the expected result {expected}', end=' ')
            fastest = float('inf')
            slowest = total = 0
            for _ in range(ITERATIONS):
                start = ns()
                solution(gems)
                end = ns()
                time = end - start
                fastest, slowest = min(time, fastest), max(time, slowest)
                total += time
            print(f'in an average of {total / ITERATIONS / 1e3:,.2f}μs '
                  f'(min: {fastest / 1e3:,.2f}μs, '
                  f'max: {slowest / 1e3:,.2f}μs)')
        else:
            print(f'a wrong result {result} (expected: {expected})')
