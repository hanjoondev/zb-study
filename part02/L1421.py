from time import perf_counter_ns as ns


def solution(priorities, location):
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
        ([5], 0, 1),
        ([1, 2, 3, 4], 2, 2),
        ([1, 1, 9, 1, 1, 1], 0, 5)
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


''' programmers submission
    # Source: 프린터 https://programmers.co.kr/learn/courses/30/lessons/42587
    # Submission detail:
    #     정확성  테스트
    #     테스트 1 〉	통과 (0.14ms, 10.1MB)
    #     테스트 2 〉	통과 (0.30ms, 10.2MB)
    #     테스트 3 〉	통과 (0.12ms, 10.2MB)
    #     테스트 4 〉	통과 (0.04ms, 10.1MB)
    #     테스트 5 〉	통과 (0.01ms, 10.1MB)
    #     테스트 6 〉	통과 (0.06ms, 10.1MB)
    #     테스트 7 〉	통과 (0.07ms, 10.2MB)
    #     테스트 8 〉	통과 (0.25ms, 10.3MB)
    #     테스트 9 〉	통과 (0.02ms, 10.1MB)
    #     테스트 10 〉	통과 (0.07ms, 10.1MB)
    #     테스트 11 〉	통과 (0.19ms, 10.1MB)
    #     테스트 12 〉	통과 (0.03ms, 10.1MB)
    #     테스트 13 〉	통과 (0.17ms, 10.1MB)
    #     테스트 14 〉	통과 (0.01ms, 10.1MB)
    #     테스트 15 〉	통과 (0.02ms, 10MB)
    #     테스트 16 〉	통과 (0.03ms, 10.1MB)
    #     테스트 17 〉	통과 (0.24ms, 10.2MB)
    #     테스트 18 〉	통과 (0.02ms, 10.2MB)
    #     테스트 19 〉	통과 (0.21ms, 10.1MB)
    #     테스트 20 〉	통과 (0.09ms, 10.1MB)
def solution(priorities, location):
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
'''
