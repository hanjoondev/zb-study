def solution(h: int, w: int, m: list[int]):
    ans = 1
    queue = set([(0, 0, m[0][0])])
    while queue:
        r, c, path = queue.pop()
        for dr, dc in ((1, 0), (0, 1), (-1, 0), (0, -1)):
            nr, nc = r + dr, c + dc
            if 0 <= nr < h and 0 <= nc < w and (alpha := m[nr][nc]) not in path:
                queue.add((nr, nc, path + alpha))
                ans = max(ans, len(path) + 1)
    print(ans)


def reader():
    r, c = map(int, input().split(" "))
    m = [input() for _ in range(r)]
    solution(r, c, m)


if __name__ == '__main__':
    reader()


''' acmicpc submission
    # Source: 알파벳 https://www.acmicpc.net/problem/1987
    # Submission detail: https://www.acmicpc.net/source/41899054
    #     Runtime: 1492 ms
    #     Memory Usage: 50296 KB
'''
