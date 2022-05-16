from bisect import bisect_right as br
from sys import stdin


def dfs(arr: list[int], cap: int, i=0, w=0) -> None:
    if i >= len(arr):
        dfs.weights.append(w)
        return
    dfs(arr, cap, i + 1, w)
    dfs(arr, cap, i + 1, w + arr[i])


def solution(arr: list[int], len_: int, capa: int) -> int:
    results = []
    for a in (arr[:len_ // 2], arr[len_ // 2:]):
        dfs.weights = []
        dfs(a, capa, 0, 0)
        results.append(dfs.weights)
    results[1].sort()
    return sum(br(results[1], capa - w) for w in results[0] if w <= capa)


def reader():
    n, c = map(int, stdin.readline().split())
    a = list(map(int, stdin.readline().split()))
    print(solution(a, n, c))


if __name__ == '__main__':
    reader()
