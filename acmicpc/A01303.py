from sys import stdin


def solution(m: list[str], h: int, w: int) -> str:
    def d(r, c):
        if not 0 <= r < h or not 0 <= c < w or m[r][c] != color:
            return 0
        m[r][c] = None
        return 1 + d(r + 1, c) + d(r - 1, c) + d(r, c + 1) + d(r, c - 1)

    ans = {k: 0 for k in 'WB'}
    for r in range(h):
        for c in range(w):
            if not m[r][c]:
                continue
            color = m[r][c]
            ans[color] += d(r, c) ** 2
    return ' '.join(map(str, ans.values()))


def reader():
    read = stdin.readline
    w, h = map(int, read().split())
    print(solution([[c for c in read().strip()] for _ in range(h)], h, w))


if __name__ == '__main__':
    reader()
