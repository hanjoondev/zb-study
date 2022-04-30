from sys import stdin as s


def bisect(times: list[int], M: int) -> None:
    low, high = 0, max(times) * M
    while low <= high:
        mid = (low + high) // 2
        capacity = sum(mid // t for t in times)
        if capacity < M:
            low = mid + 1
        else:
            high = mid - 1
    print(low)


def reader() -> None:
    N, M = map(int, s.readline().split())
    times = [int(s.readline()) for _ in range(N)]
    bisect(sorted(times), M)


if __name__ == '__main__':
    reader()
