from time import perf_counter_ns as ns


def solution(dirs):
    d = {c: direc for c, direc in 
         zip('UDRL', ((1, 0), (-1, 0), (0, 1), (0, -1)))}
    v = set()
    r = c = 0
    for cmd in dirs:
        dr, dc = d[cmd]
        nr, nc = r + dr, c + dc
        if -5 <= nr <= 5 and -5 <= nc <= 5:
            v.add(tuple(sorted(((r, c), (nr, nc)))))
            r, c = nr, nc
    return len(v)


if __name__ == '__main__':
    ITERATIONS = 1_000
    print(f'Running the basic tests {ITERATIONS:,} times...')
    tests = (
        ("ULURRDLLU", 7),
        ("LULLLLLLU", 7)
    )
    for directions, expected in tests:
        print(f'solution("{directions}") returned', end=' ')
        if (result := solution(directions)) == expected:
            print(f'the expected result {expected}', end=' ')
            fastest = float('inf')
            slowest = total = 0
            for _ in range(ITERATIONS):
                start = ns()
                solution(directions)
                end = ns()
                time = end - start
                fastest, slowest = min(time, fastest), max(time, slowest)
                total += time
            print(f'in an average of {total / ITERATIONS / 1e3:,.2f}μs '
                  f'(min: {fastest / 1e3:,.2f}μs, '
                  f'max: {slowest / 1e3:,.2f}μs)')
        else:
            print(f'a wrong result {result} (expected: {expected})')
