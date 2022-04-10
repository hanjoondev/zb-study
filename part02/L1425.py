from time import perf_counter_ns as ns


def solution(gems):
    d, num_types = {gems[0]: 1}, len(set(gems))
    ans = [1, (length := len(gems))]
    l = r = 0
    while l <= r < length:
        if len(d) == num_types:
            ans = [l + 1, r + 1] if ans[1] - ans[0] > r - l else ans
            d[gems[l]] -= 1
            if not d[gems[l]]:
                del d[gems[l]]
            l += 1
            continue
        r += 1
        if r < length:
            d[gems[r]] = d.get(gems[r], 0) + 1
    return ans


if __name__ == '__main__':
    ITERATIONS = 10_000
    print(f'Running the basic tests {ITERATIONS:,} times...')
    tests = (
        (["DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"], [3, 7]),
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
            print(f'in an average of {total / ITERATIONS / 1000:,.2f}ms '
                  f'(min: {fastest / 1000:,.2f}ms, '
                  f'max: {slowest / 1000:,.2f}ms)')
        else:
            print(f'a wrong result {result} (expected: {expected})')


''' programmers submission
    # Source: [카카오 인턴] 보석 쇼핑 https://programmers.co.kr/learn/courses/30/lessons/67258
    # Submission detail:
    #     정확성  테스트
    #     테스트 1 〉	통과 (0.02ms, 10.1MB)
    #     테스트 2 〉	통과 (0.06ms, 10.2MB)
    #     테스트 3 〉	통과 (0.33ms, 10.3MB)
    #     테스트 4 〉	통과 (0.18ms, 10.1MB)
    #     테스트 5 〉	통과 (0.02ms, 10.1MB)
    #     테스트 6 〉	통과 (0.01ms, 10.2MB)
    #     테스트 7 〉	통과 (0.02ms, 10.4MB)
    #     테스트 8 〉	통과 (0.33ms, 10.1MB)
    #     테스트 9 〉	통과 (0.55ms, 10.1MB)
    #     테스트 10 〉	통과 (0.33ms, 10.3MB)
    #     테스트 11 〉	통과 (0.49ms, 10.3MB)
    #     테스트 12 〉	통과 (0.90ms, 10.2MB)
    #     테스트 13 〉	통과 (1.18ms, 10.4MB)
    #     테스트 14 〉	통과 (1.02ms, 10.4MB)
    #     테스트 15 〉	통과 (2.46ms, 10.3MB)
    #     효율성  테스트
    #     테스트 1 〉	통과 (3.12ms, 10.4MB)
    #     테스트 2 〉	통과 (4.80ms, 10.6MB)
    #     테스트 3 〉	통과 (10.07ms, 11.1MB)
    #     테스트 4 〉	통과 (7.46ms, 11.8MB)
    #     테스트 5 〉	통과 (16.57ms, 11.8MB)
    #     테스트 6 〉	통과 (20.17ms, 12.1MB)
    #     테스트 7 〉	통과 (23.82ms, 12.6MB)
    #     테스트 8 〉	통과 (26.01ms, 12.9MB)
    #     테스트 9 〉	통과 (30.12ms, 13.3MB)
    #     테스트 10 〉	통과 (35.76ms, 13.7MB)
    #     테스트 11 〉	통과 (39.25ms, 14.7MB)
    #     테스트 12 〉	통과 (26.71ms, 15.4MB)
    #     테스트 13 〉	통과 (38.51ms, 16.2MB)
    #     테스트 14 〉	통과 (62.15ms, 17MB)
    #     테스트 15 〉	통과 (62.64ms, 17.7MB)
def solution(gems):
    d, num_types = {gems[0]: 1}, len(set(gems))
    ans = [1, (length := len(gems))]
    l = r = 0
    while l <= r < length:
        if len(d) == num_types:
            ans = [l + 1, r + 1] if ans[1] - ans[0] > r - l else ans
            d[gems[l]] -= 1
            if not d[gems[l]]:
                del d[gems[l]]
            l += 1
            continue
        r += 1
        if r < length:
            d[gems[r]] = d.get(gems[r], 0) + 1
    return ans
'''
