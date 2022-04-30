from sys import stdin as s


def solution(N: int, k: int, c: int, belt: list[int]) -> None:
    window = {c: 1}
    l = r = num_kinds = 0
    while r < N:
        window[sushi] = window.get((sushi := belt[r]), 0) + 1
        r += 1
        if l < r - k:
            window[belt[l]] -= 1
            if not window[belt[l]]:
                del window[belt[l]]
            l += 1
        num_kinds = max(num_kinds, len(window))
    print(num_kinds)


def reader() -> None:
    N, d, k, c = map(int, s.readline().split())
    conveyor_belt = [int(s.readline()) for _ in range(N)]
    solution(N + k, k, c, conveyor_belt + conveyor_belt[:k])


if __name__ == '__main__':
    reader()
