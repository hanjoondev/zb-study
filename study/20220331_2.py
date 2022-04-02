from time import perf_counter_ns as ns


def solution(priorities, location):
    """
    Problem: https://programmers.co.kr/learn/courses/30/lessons/42587
    Result: Passed
    """
    papers = [p + 256 for p in priorities]
    d = {p: papers.count(p) for p in papers}
    target, answer = papers[location], 0
    while True:
        first = papers.pop(0)
        if first >= max(d):
            answer += 1
            if first is target:
                return answer
            d[first] -= 1
            if not d[first]:
                del d[first]
        else:
            papers.append(first)


if __name__ == '__main__':
    ITERATIONS = 1_000
    print(f'Running the basic tests {ITERATIONS:,} times...')
    tests = (
        ([2, 1, 3, 2], 2, 1),
        ([1, 1, 9, 1, 1, 1], 0, 5),
    )
    for priorities, location, expected in tests:
        print(f'solution({priorities}, {location}) returned', end=' ')
        if (result := solution(priorities, location)) == expected:
            print(f'the expected result {expected}', end=' ')
            fastest = float('inf')
            slowest = total = 0
            for _ in range(ITERATIONS):
                start = ns()
                solution(priorities, location)
                end = ns()
                time = end - start
                fastest, slowest = min(time, fastest), max(time, slowest)
                total += time
            print(f'in an average of {total / ITERATIONS / 1000:,.2f}ms '
                  f'(min: {fastest / 1000:,.2f}ms, '
                  f'max: {slowest / 1000:,.2f}ms)')
        else:
            print(f'a wrong result {result} (expected: {expected})')
