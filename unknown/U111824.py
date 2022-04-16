def solution(l):
    r = ""
    p = caps = shift = insert = 0
    d = {i: chr(i) for r in (range(48, 58), range(97, 123)) for i in r}
    s = {i: s for i, s in zip(range(48, 58), ')!@#$%^&*(')}
    for n in l:
        t = d.get(n, "") if caps + shift in (0, 2) else d.get(n, "").swapcase()
        t = s.get(n, "") if shift and 48 <= n < 58 else t
        r = r[:p] + t + r[p + 1 if insert and t else p:]
        r = (r[:p] + r[p + 1:]) if n == 127 else r
        p += 1 * t != ""
        p -= 1 * p > 0 and n == 37
        p += 1 * p <= len(r) and n == 39
        if n == 8:
            r = (r[:p - 1 if p > 0 else 0] + r[p:])
            p -= 1 * p > 0
        if n == 32:
            r = (r[:p] + " " + r[p:])
            p += 1
        shift = 1 * n == 16
        if n == 155:
            insert = 1 * insert != 1
        if n == 20:
            caps = 1 * caps != 1
    return r


if __name__ == '__main__':
    data = [
        [16, 106, 101, 108, 108, 111, 37, 37, 37, 37, 37, 155, 16, 104],
        [20, 104, 16, 105, 32, 20, 16, 106, 97, 118, 97],
        [49, 51, 8, 50, 51, 53, 55, 37, 37, 127, 127, 52, 53],
        [20, 97, 98, 16, 99, 16, 100, 16, 49, 16, 50, 16, 51]
    ]
    for lst in data:
        print(solution(lst))
