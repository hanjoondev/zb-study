from sys import stdin


def reader():
    read = stdin.readline
    n, _ = map(int, read().split())
    ans, d = 0, {}
    for _ in range(n):
        s = read().rstrip()
        for k in [k for k in d.keys()]:
            if s[k] == '0':
                del d[k]
            else:
                d[k] += 1
        for i, c in enumerate(s):
            if i not in d and c == '1':
                d[i] = 1
        ans = max(ans, max(i * v for i, v in enumerate(d.values(), start=1)))
    print(ans)


if __name__ == '__main__':
    reader()
