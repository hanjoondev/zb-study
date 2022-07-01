from sys import stdin


def solution(cases: list[int]) -> str:
    ans = []
    for case in cases:
        pp = p = cur = nxt = 1
        for _ in range(3, case):
            pp, p, cur = p, cur, (nxt := p + pp)
        ans.append(str(nxt))
    return '\n'.join(ans)


def reader():
    read = stdin.readline
    n = int(read().rstrip())
    print(solution([int(read().rstrip()) for _ in range(n)]))


if __name__ == '__main__':
    reader()
