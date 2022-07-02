from sys import stdin


def solution(m: list[list[int]], h: int, w: int) -> str:
    q2, q1 = [[0] * w for _ in range(h)], [[0] * w for _ in range(h)]
    q3, q4 = [[0] * w for _ in range(h)], [[0] * w for _ in range(h)]
    ans, h, w = 0, h - 1, w - 1
    for r in range(1, h):
        for c in range(1, w):
            if m[r][c]:
                q1[r][c] = q1[r - 1][c + 1] + 1
                q2[r][c] = q2[r - 1][c - 1] + 1
    for r in range(h - 1, 0, -1):
        for c in range(1, w):
            if m[r][c]:
                q3[r][c] = q3[r + 1][c - 1] + 1
                q4[r][c] = q4[r + 1][c + 1] + 1
    for r in range(1, h):
        for c in range(1, w):
            k = min(q3[r][c], q4[r][c])
            while k >= ans + 1:
                if 0 <= (nr := 2 * (k - 1) + r) < h:
                    if q1[nr][c] >= k and q2[nr][c] >= k:
                        ans = max(ans, k)
                        break
                k -= 1
    return ans


def reader():
    read = stdin.readline
    row, col = map(int, read().split())
    mine = [[0] * (col + 1)]
    for _ in range(row):
        mine.append([0] + [int(c) for c in read().rstrip()])
    print(solution(mine, row + 2, col + 2))


if __name__ == '__main__':
    reader()
