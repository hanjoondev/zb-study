from collections import deque as dq
from operator import add, sub, mul, truediv as div
from sys import stdin as s


def calc_rpn(n: int, rpn: str, vals: list[str]) -> None:
    o, d = {'+': add, '-': sub, '*': mul, '/': div}, {}
    i = 0
    q = dq()
    for v in rpn:
        if v not in '+-*/':
            if v not in d:
                d[v] = int(vals[i])
                i += 1
            q.append(d[v])
            continue
        f, s = q.pop(), q.pop()
        q.append(o[v](s, f))
    print(f'{q.pop():.2f}')


def reader():
    n = int(s.readline())
    rpn = s.readline().strip()
    vals = [s.readline().strip() for _ in range(n)]
    calc_rpn(n, rpn, vals)

if __name__ == '__main__':
    reader()
