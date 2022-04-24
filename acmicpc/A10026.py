def solution(m: list[str]) -> None:
    def dfs(r: int, c: int, color: str) -> None:
        for dr, dc in ((0, 1), (0, -1), (1, 0), (-1, 0)):
            nr, nc = r + dr, c + dc
            if 0 <= nr < h and 0 <= nc < w and m[nr][nc] in color:
                if len(color) == 1 and not visited[nr][nc]:
                    visited[nr][nc] = True
                    dfs(nr, nc, color)
                if len(color) == 2 and not visited_b[nr][nc]:
                    visited_b[nr][nc] = True
                    dfs(nr, nc, color)

    areas = areas_rg_blind = 0
    h, w = len(m), len(m[0])
    visited = [[False] * w for _ in range(h)]
    visited_b = [[False] * w for _ in range(h)]
    for r in range(h):
        for c in range(w):
            if not visited[r][c]:
                dfs(r, c, m[r][c])
                areas += 1
            if not visited_b[r][c]:
                dfs(r, c, 'RG' if m[r][c] in 'RG' else m[r][c] * 2)
                areas_rg_blind += 1
    print(f'{areas} {areas_rg_blind}')


def reader():
    m = [input() for _ in range(int(input()))]
    solution(m)


if __name__ == '__main__':
    import sys
    sys.setrecursionlimit(10000)
    reader()


'''
5
RRRBB
GGBBB
BBBRR
BBRRR
RRRRR
'''  # expected 4 3
