from sys import stdin


def reader():
    read = stdin.readline
    l, q = map(int, read().split())
    a, q = [int(c) for c in read().rstrip()], q + 1
    d1, d2 = [i for i in a], [i for i in a]
    for i in range(l):
        for j in range(1 << l):
            if (j >> i) & 1:
                d1[j] += d1[j - (1 << i)]
                d2[j - (1 << i)] += d2[j]
    p = [1] + [0] * 64
    for i in range(1, 1 << (l // 3)):
        p[i] = p[i >> 1] ^ (i & 1)
    while q := q - 1:
        k, kk = {c: 0 for c in '01?'}, {c: 0 for c in '01?'}
        for i, c in enumerate(read().rstrip()[::-1]):
            k[c] += 1
            kk[c] |= 1 << i
        ans = 0
        if 3 * k['?'] <= l:
            i = kk['?']
            while i >= 0:
                i &= kk['?']
                ans += a[i + kk['1']]
                i -= 1
        elif 3 * k['1'] <= l:
            i, o, kkk = kk['1'], 0, kk['?']
            while i >= 0:
                i &= kk['1']
                ans += d1[i + kkk] if p[o] else -d1[i + kkk]
                i -= 1
                o += 1
        else:
            i, o, kkk = kk['0'], 0, kk['0'] + kk['1']
            while i >= 0:
                i &= kk['0']
                ans += d2[kkk - i] if p[o] else -d2[kkk - i]
                i -= 1
                o += 1
        print(ans)


if __name__ == '__main__':
    reader()
