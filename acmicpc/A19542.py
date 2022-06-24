from sys import stdin, setrecursionlimit as limit


def solution(e: dict[int, list[int]], start: int, k: int) -> int:
    def dfs(cur: int, prev: int) -> int:
        if (m := max([dfs(n, cur) for n in e[cur] if n != prev] + [0])) >= k:
            dfs.ans += 1
        return 1 + m

    dfs.ans = -1
    limit(1000000)
    dfs(start, 0)
    return dfs.ans * 2 if dfs.ans != -1 else 0


def reader():
    read = stdin.readline
    n, s, d = map(int, read().split())
    e = {}
    for _ in range(n - 1):
        u, v = map(int, read().split())
        e.setdefault(u, []).append(v)
        e.setdefault(v, []).append(u)
    print(solution(e, s, d))


if __name__ == '__main__':
    reader()
