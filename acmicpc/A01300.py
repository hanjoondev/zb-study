from sys import stdin as s


def solution(n: int, k: int) -> None:
    low, high = 1, k
    while low <= high:
        mid = (low + high) // 2
        count = sum(min(n, mid // i) for i in range(1, n + 1))
        if count < k:
            low = mid + 1
        else:
            high = mid - 1
    print(low)


def reader():
    n = int(s.readline().strip())
    k = int(s.readline().strip())
    solution(n, k)


if __name__ == '__main__':
    reader()
