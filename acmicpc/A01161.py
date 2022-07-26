from sys import stdin


def solution(g: list[list[int]], k: int, n: int, c: int) -> int:
    g.sort(key=lambda x: x[1])
    ans, s = 0, [c] * n
    for i in range(k):
        if m := min(g[i][2], min(s[g[i][0]:g[i][1]])):
            ans += m
            for j in range(g[i][0], g[i][1]):
                s[j] -= m
    return ans


def reader():
    read = stdin.readline
    k, n, c = map(int, read().split())
    groups = [list(map(int, read().split())) for _ in range(k)]
    print(solution(groups, k, n, c))


if __name__ == '__main__':
    reader()
