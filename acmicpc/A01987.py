def solution(h: int, w: int, m: list[int]):
    ans = 1
    queue = {(0, 0, m[0][0])}
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


'''
2 4
CAAB
ADCB
'''  # input 1
'''
3
'''  # expected 1

'''
3 6
HFDFFB
AJHGDH
DGAGEH
'''  # input 2
'''
6
'''  # expected 2

'''
5 5
IEFCJ
FHFKC
FFALF
HFGCF
HMCHH
'''  # input 3
'''
10
'''  # expected 3
