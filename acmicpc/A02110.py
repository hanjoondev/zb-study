from sys import stdin as s


def solution(coord: list[int], n: int, c: int) -> None:
    coord.sort()
    low, high, ans = 1, coord[-1] - coord[0], 0
    while low <= high:
        dist, prev, count = (low + high) // 2, coord[0], 1
        for cur in coord[1:]:
            if cur - prev >= dist:
                prev = cur
                count += 1
                if count > c:
                    break
        if count >= c:
            low = dist + 1
            ans = dist
        else:
            high = dist - 1
    print(ans)


def reader():
    n, c = map(int, s.readline().split())
    coord = []
    for _ in range(n):
        coord.append(int(s.readline().strip()))
    solution(coord, n, c)


if __name__ == '__main__':
    reader()
