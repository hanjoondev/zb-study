from time import perf_counter_ns as ns


def remove_blocks(b, h: int, w: int) -> int:
    block = ((0, 0), (0, 1), (1, 0), (1, 1))
    blocks = []
    for r in range(h - 1):
        for c in range(w - 1):
            v = [b[r + dr][c + dc] for dr, dc in block]
            if v[0] and v.count(v[0]) == 4:
                blocks += [(r + dr, c + dc) for dr, dc in block]
    num_removed = len(unique_blocks := set(blocks))
    for r, c in unique_blocks:
        b[r][c] = 0
    return num_removed


def drop(b, h: int, w: int) -> None:
    for r in range(1, h):
        for c in range(w):
            if b[r][c]:
                continue
            for k in range(r, 0, -1):
                if not b[k - 1][c]:
                    break
                b[k][c], b[k - 1][c] = b[k - 1][c], b[k][c]


def solution(h: int, w: int, b) -> int:
    b = [[c for c in row] for row in b]
    ans = 0
    while True:
        if not (num_removed := remove_blocks(b, h, w)):
            return ans
        ans += num_removed
        drop(b, h, w)


if __name__ == '__main__':
    ITERATIONS = 1_000
    print(f'Running the basic tests {ITERATIONS:,} times...')
    tests = (
        (4, 5, ["CCBDE", "AAADE", "AAABF", "CCBBF"], 14),
        (6, 6, ["TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"],
         15)
    )
    for m, n, board, expected in tests:
        print(f'solution({m}, {n}, {board}) returned', end=' ')
        if (result := solution(m, n, board)) == expected:
            print(f'the expected result {expected}', end=' ')
            fastest = float('inf')
            slowest = total = 0
            for _ in range(ITERATIONS):
                start = ns()
                solution(m, n, board)
                end = ns()
                time = end - start
                fastest, slowest = min(time, fastest), max(time, slowest)
                total += time
            print(f'in an average of {total / ITERATIONS / 1e3:,.2f}μs '
                  f'(min: {fastest / 1e3:,.2f}μs, '
                  f'max: {slowest / 1e3:,.2f}μs)')
        else:
            print(f'a wrong result {result} (expected: {expected})')
