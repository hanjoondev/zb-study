from sys import stdin


def solution(fr: str, to: str, length: int) -> int:
    if length == 1:
        return int(fr != to)
    d, fr = {'0': '1', '1': '0'}, fr + '0'
    t1, t2 = [c for c in fr], [c for c in fr]
    t1[0], t1[1], a1, a2 = d[t1[0]], d[t1[1]], 1, 0
    for i in range(1, length):
        if t1[i - 1] != (t := to[i - 1]):
            t1[i - 1], t1[i], t1[i + 1] = d[t1[i - 1]], d[t1[i]], d[t1[i + 1]]
            a1 += 1
        if t2[i - 1] != t:
            t2[i - 1], t2[i], t2[i + 1] = d[t2[i - 1]], d[t2[i]], d[t2[i + 1]]
            a2 += 1
    n, f, t = t1[-2], t2[-2], to[-1]
    return (min(a1, a2) if n == f == t
            else a1 if n == t else a2 if f == t else -1)


def reader():
    read = stdin.readline
    n = int(read())
    fr, to = read().strip(), read().strip()
    print(solution(fr, to, n))


if __name__ == '__main__':
    reader()
