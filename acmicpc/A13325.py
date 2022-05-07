from sys import stdin as s


def solution(k: int, edges: list[int]) -> None:
    def dfs(i: int, length: int) -> int:
        if i >= length:
            return 0
        lsum, rsum = dfs(l(i), length) + e[l(i)], dfs(r(i), length) + e[r(i)]
        e[l(i) if lsum < rsum else r(i)] += abs(lsum - rsum)
        return max(lsum, rsum)

    l, r = lambda x: x * 2, lambda x: x * 2 + 1
    e = [0, 0] + edges
    dfs(1, 2**k)
    print(sum(e))


def reader():
    k = int(s.readline())
    edges = map(int, s.readline().split())
    solution(k, list(edges))


if __name__ == '__main__':
    reader()
