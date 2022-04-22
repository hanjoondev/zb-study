from time import perf_counter_ns as ns


def solution(arr):
    if not arr or len(arr) == 1:
        return arr
    answer = [arr[0]]
    prev = arr[0]
    for n in arr[1:]:
        if prev == n:
            continue
        answer.append(n)
        prev = n
    return answer


if __name__ == '__main__':
    ITERATIONS = 1_000
    print(f'Running the basic tests {ITERATIONS:,} times...')
    tests = (
        ([1, 1, 3, 3, 0, 1, 1], [1, 3, 0, 1]),
        ([4, 4, 4, 3, 3], [4, 3])
    )
    for array, expected in tests:
        print(f'solution({array}) returned', end=' ')
        if (result := solution(array)) == expected:
            print(f'the expected result {expected}', end=' ')
            fastest = float('inf')
            slowest = total = 0
            for _ in range(ITERATIONS):
                start = ns()
                solution(array)
                end = ns()
                time = end - start
                fastest, slowest = min(time, fastest), max(time, slowest)
                total += time
            print(f'in an average of {total / ITERATIONS / 1e3:,.2f}μs '
                  f'(min: {fastest / 1e3:,.2f}μs, '
                  f'max: {slowest / 1e3:,.2f}μs)')
        else:
            print(f'a wrong result {result} (expected: {expected})')
