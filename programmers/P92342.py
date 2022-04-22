from time import perf_counter_ns as ns


def solution(n, apeach):
    def dfs(ryan, a_pts, r_pts, i, rem_arrows):
        nonlocal cands, max_diff
        if i == 10 and rem_arrows >= 0:
            if (diff := r_pts - a_pts) >= max_diff:
                cands = [] if diff > max_diff else cands
                cands.append([a if j != i else rem_arrows
                              for j, a in enumerate(ryan)])
                max_diff = diff
            return
        if rem_arrows < 0 or i == 11:
            return
        if rem_arrows:
            nr = [a if j != i else apeach[i] + 1 for j, a in enumerate(ryan)]
            dfs(nr, a_pts, r_pts + 10 - i, i + 1, rem_arrows - nr[i])
        if apeach[i]:
            dfs(ryan, a_pts + 10 - i, r_pts, i + 1, rem_arrows)
        else:
            dfs(ryan, a_pts, r_pts, i + 1, rem_arrows)

    cands, max_diff = [], 0
    dfs([0] * 11, 0, 0, 0, n)
    if max_diff == 0:
        return [-1]
    if len(cands) == 1:
        return cands[0]
    lowest = cands[0]
    for cand in cands[1:]:
        if cand[::-1] > lowest[::-1]:
            lowest = cand
    return lowest


if __name__ == '__main__':
    ITERATIONS = 1
    print(f'Running the basic tests {ITERATIONS:,} times...')
    tests = (
        (5, [2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0], [0, 2, 2, 0, 1, 0, 0, 0, 0, 0, 0]),
        (1, [1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0], [-1]),
        (9, [0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1], [1, 1, 2, 0, 1, 2, 2, 0, 0, 0, 0]),
        (10, [0, 0, 0, 0, 0, 0, 0, 0, 3, 4, 3], [1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 2])
    )
    for n, info, expected in tests:
        print(f'solution({n}, {info}) returned', end=' ')
        if (result := solution(n, info)) == expected:
            print(f'the expected result {expected}', end=' ')
            fastest = float('inf')
            slowest = total = 0
            for _ in range(ITERATIONS):
                start = ns()
                solution(n, info)
                end = ns()
                time = end - start
                fastest, slowest = min(time, fastest), max(time, slowest)
                total += time
            print(f'in an average of {total / ITERATIONS / 1e3:,.2f}μs '
                  f'(min: {fastest / 1e3:,.2f}μs, '
                  f'max: {slowest / 1e3:,.2f}μs)')
        else:
            print(f'a wrong result {result} (expected: {expected})')
