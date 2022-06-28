from sys import stdin


def solution(classroom: list[str], h: int, w: int) -> str:
    def dfs(r, c): 
        if v[r][c] == matched:
            return False
        v[r][c] = matched
        for dr, dc in ((-1, -1), (-1, 1), (0, -1), (0, 1), (1, -1), (1, 1)):
            nr, nc = r + dr, c + dc
            if 0<= nr < h and 0 <= nc < w and classroom[nr][nc] == '.':
                if (nr, nc) not in m or dfs(m[(nr, nc)][0], m[(nr, nc)][1]):
                    m[(r, c)], m[(nr, nc)] = (nr, nc), (r, c)
                    return True
        return False

    m, v = {}, [[None] * w for _ in range(h)]
    seats = matched = 0
    for r in range(h):
        for c in range(w):
            if classroom[r][c] == '.':
                seats += 1
                matched += dfs(r, c) if c % 2 else 0
    return str(seats - matched)


def reader():
    read = stdin.readline
    ans = []
    for _ in range(int(read().strip())):
        h, w = map(int, read().split())
        ans.append(solution([read().strip() for _ in range(h)], h, w))
    print('\n'.join(ans))


if __name__ == '__main__':
    reader()
