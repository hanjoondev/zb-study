from sys import stdin
from collections import deque as dq


def solution(b: list[list[str]]) -> int:
    def tilt(rr, rc, br, bc):
        rstep = bstep = 0
        while b[rr + dr][rc + dc] != '#' and b[rr][rc] != 'O':
            rr, rc, rstep = rr + dr, rc + dc, rstep + 1
        while b[br + dr][bc + dc] != '#' and b[br][bc] != 'O':
            br, bc, bstep = br + dr, bc + dc, bstep + 1
        return rr, rc, br, bc, rstep, bstep

    p = {c: 0 for c in 'RBO'}
    for r, row in enumerate(b):
        for c, char in enumerate(row):
            if char in 'RBO':
                p[char] = [r, c]
    q, v, dst = dq([tuple(p['R'] + p['B'] + [0])]), set(), tuple(p['O'])
    v.add(tuple(p['R'] + p['B']))
    while q:
        rr, rc, br, bc, step = q.popleft()
        if step >= 10:
            return -1
        for dr, dc in ((1, 0), (-1, 0), (0, 1), (0, -1)):
            nrr, nrc, nbr, nbc, rstep, bstep = tilt(rr, rc, br, bc)
            if b[nbr][nbc] != 'O':
                if (nrr, nrc) == dst:
                    return step + 1
                if nrr == nbr and nrc == nbc:
                    if rstep > bstep:
                        nrr, nrc = nrr - dr, nrc - dc
                    else:
                        nbr, nbc = nbr - dr, nbc - dc
                if (nrr, nrc, nbr, nbc) not in v:
                    v.add((nrr, nrc, nbr, nbc))
                    q.append((nrr, nrc, nbr, nbc, step + 1))
    return -1


def reader():
    read = stdin.readline
    n, _ = map(int, read().split())
    print(solution([read().rstrip() for _ in range(n)]))


if __name__ == '__main__':
    reader()
