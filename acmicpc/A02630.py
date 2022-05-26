from sys import stdin


def solution(arr: list[list[int]], n: int) -> str:
    def dc(rpos, cpos, len_):
        color = arr[rpos][cpos]
        for r in range(rpos, rpos + len_):
            for c in range(cpos, cpos + len_):
                if arr[r][c] != color:
                    dc(rpos, cpos, len_ // 2)
                    dc(rpos, cpos + len_ // 2, len_ // 2)
                    dc(rpos + len_ // 2, cpos, len_ // 2)
                    dc(rpos + len_ // 2, cpos + len_ // 2, len_ // 2)
                    return
        dc.white += not color
        dc.blue += color

    dc.blue = dc.white = 0
    dc(0, 0, n)
    return f'{dc.white}\n{dc.blue}'


def reader():
    read = stdin.readline
    n = int(read().strip())
    arr = [list(map(int, read().split())) for _ in range(n)]
    print(solution(arr, n))


if __name__ == '__main__':
    reader()
