from collections import deque as dq
from time import perf_counter_ns as ns


def solution(board: list[list[int]], moves: list[int]) -> int:
    ans = 0
    stack = dq()
    for move in moves:
        picked = None
        for row in board:
            if (picked := row[move - 1]):
                row[move - 1] = 0
                break
        if picked:
            if stack and stack[-1] == picked:
                stack.pop()
                ans += 2
            else:
                stack.append(picked)
    return ans


if __name__ == '__main__':
    ITERATIONS = 1_000
    print(f'Running the basic tests {ITERATIONS:,} times...')
    tests = (
        ([[0, 0, 0, 0, 0],
          [0, 0, 1, 0, 3],
          [0, 2, 5, 0, 1],
          [4, 2, 4, 4, 2],
          [3, 5, 1, 3, 1]], 
          [1, 5, 3, 5, 1, 2, 1, 4], 4),
    )
    for board, moves, expected in tests:
        print(f'solution("{board, moves}") returned', end=' ')
        if (result := solution(board, moves)) == expected:
            print(f'the expected result {expected}', end=' ')
            fastest = float('inf')
            slowest = total = 0
            for _ in range(ITERATIONS):
                start = ns()
                solution(board, moves)
                end = ns()
                time = end - start
                fastest, slowest = min(time, fastest), max(time, slowest)
                total += time
            print(f'in an average of {total / ITERATIONS / 1e3:,.2f}μs '
                  f'(min: {fastest / 1e3:,.2f}μs, '
                  f'max: {slowest / 1e3:,.2f}μs)')
        else:
            print(f'a wrong result {result} (expected: {expected})')
