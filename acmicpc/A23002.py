from sys import stdin


def solution(a: list[list[int]], b: list[list[int]], length: int) -> str:
    tc, nodes = 0, set()
    neighbors = [[0] * (2 * length) for _ in range(2 * length)]
    for r in range(length):
        for c in range(length):
            if a[r][c] == -1:
                neighbors[r][c + length] = neighbors[c + length][r] = b[r][c]
                nodes.add(r)
                nodes.add(c + length)
                tc += b[r][c]
    ln = len(nodes)
    nodes, max_, v = list(nodes), [0] * ln, [False] * ln
    for _ in range(ln):
        target = -1
        for i in range(ln):
            if v[i]:
                continue
            if target == -1 or max_[i] > max_[target]:
                target = i
        v[target] = True
        tc -= max_[target]
        for i in range(ln):
            if neighbors[nodes[target]][nodes[i]] > max_[i]:
                max_[i] = neighbors[nodes[target]][nodes[i]]
    return tc


def reader():
    read = stdin.readline
    ans = []
    for i in range(int(read().strip())):
        n = int(read().strip())
        a = [list(map(int, read().split())) for _ in range(n)]
        b = [list(map(int, read().split())) for _ in range(n)]
        read(), read()
        ans.append(f'Case #{i + 1}: {solution(a, b, n)}')
    print('\n'.join(ans))


if __name__ == '__main__':
    reader()
