from time import perf_counter_ns as ns


def solution(s):
    results = {0: (len_s := len(s))}
    for div in range(len_s // 2, 0, -1):
        q, r = divmod(len_s, div)
        length, matched, prev = 0, 1, s[:div]
        for i in range(div, div * q, div):
            cur = s[i:i + div]
            if cur == prev:
                matched += 1
            else:
                length += len(str(matched)) * (matched > 1) + div
                matched = 1
            prev = cur
        results[div] = length + (len(str(matched)) * (matched > 1) + div) + r
    return min(results.values())


if __name__ == '__main__':
    ITERATIONS = 1_000
    print(f'Running the basic tests {ITERATIONS:,} times...')
    tests = (
        ("abcdabcdabcdbcde", 9),
        ("aabbaccc", 7),
        ("ababcdcdababcdcd", 9),
        ("abcabcdede", 8),
        ("abcabcabcabcdededededede", 14),
        ("xababcdcdababcdcd", 17),
    )
    for s, expected in tests:
        print(f'solution("{s}") returned', end=' ')
        if (result := solution(s)) == expected:
            print(f'the expected result {expected}', end=' ')
            fastest = float('inf')
            slowest = total = 0
            for _ in range(ITERATIONS):
                start = ns()
                solution(s)
                end = ns()
                time = end - start
                fastest, slowest = min(time, fastest), max(time, slowest)
                total += time
            print(f'in an average of {total / ITERATIONS / 1e3:,.2f}μs '
                  f'(min: {fastest / 1e3:,.2f}μs, '
                  f'max: {slowest / 1e3:,.2f}μs)')
        else:
            print(f'a wrong result {result} (expected: {expected})')
