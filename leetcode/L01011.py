from time import perf_counter_ns as ns


class Solution:
    def shipWithinDays(self, weights: list[int], days: int) -> int:
        low, high = 0, max(weights) * len(weights)
        while low <= high:
            capacity = (low + high) // 2
            d, ship = 1, 0
            for w in weights:
                if ship + w > capacity:
                    if w > capacity:
                        d = days + 1
                    d += 1
                    ship = 0
                    if d > days:
                        break
                ship += w
            if d > days:
                low = capacity + 1
            else:
                high = capacity - 1
        return low


if __name__ == '__main__':
    ITERATIONS = 1_000
    print(f'Running the basic tests {ITERATIONS:,} times...')
    tests = (
        ([1, 2, 3, 4, 5, 6, 7, 8, 9, 10], 5, 15),
        ([3, 2, 2, 4, 1, 4], 3, 6),
        ([1, 2, 3, 1, 1], 4, 3),
    )
    s = Solution()
    for w, d, expected in tests:
        print(f'shipWithinDays({w}, {d}) returned', end=' ')
        if (result := s.shipWithinDays(w, d)) == expected:
            print(f'the expected result {expected}', end=' ')
            fastest = float('inf')
            slowest = total = 0
            for _ in range(ITERATIONS):
                start = ns()
                s.shipWithinDays(w, d)
                end = ns()
                time = end - start
                fastest, slowest = min(time, fastest), max(time, slowest)
                total += time
            print(f'in an average of {total / ITERATIONS / 1e3:,.2f}μs '
                  f'(min: {fastest / 1e3:,.2f}μs, '
                  f'max: {slowest / 1e3:,.2f}μs)')
        else:
            print(f'a wrong result {result} (expected: {expected})')
