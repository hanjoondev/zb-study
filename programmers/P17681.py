from time import perf_counter_ns as ns


def solution(n, a1, a2):
    return [f'{a | b:0{n}b}'.replace("1", "#").replace("0", " ")
            for a, b in zip(a1, a2)]


if __name__ == '__main__':
    ITERATIONS = 1_000
    print(f'Running the basic tests {ITERATIONS:,} times...')
    tests = (
        (5, [9, 20, 28, 18, 11], [30, 1, 21, 17, 28],
         ["#####","# # #", "### #", "#  ##", "#####"]),
        (6, [46, 33, 33 ,22, 31, 50], [27 ,56, 19, 14, 14, 10],
         ["######", "### #", "## ##", " #### ", " #####", "### # "])
    )
    for n, a1, a2, expected in tests:
        print(f'solution({n}, {a1}, {a2}) returned', end=' ')
        if (result := solution(n, a1, a2)) == expected:
            print(f'the expected result {expected}', end=' ')
            fastest = float('inf')
            slowest = total = 0
            for _ in range(ITERATIONS):
                start = ns()
                solution(n, a1, a2)
                end = ns()
                time = end - start
                fastest, slowest = min(time, fastest), max(time, slowest)
                total += time
            print(f'in an average of {total / ITERATIONS / 1e3:,.2f}μs '
                  f'(min: {fastest / 1e3:,.2f}μs, '
                  f'max: {slowest / 1e3:,.2f}μs)')
        else:
            print(f'a wrong result {result} (expected: {expected})')
