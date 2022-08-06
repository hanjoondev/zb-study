from sys import stdin


def reader():
    read = stdin.readline
    n, m, k = map(int, read().split())
    arr, qs = list(map(int, read().split())), []
    for i in range(1, n):
        arr[i] += arr[i - 1]
    for _ in range(m + k):
        a, b, *c = map(int, read().split())
        c, d, ans = c[0], c[1] if len(c) > 1 else None, 0
        if a == 1:
            ans = arr[c - 1] - arr[b - 2] * (b >= 2)
            if not qs:
                print(ans)
                continue
            for s, e, l in qs:
                ans += max(0, min(e, c) - max(s, b) + 1) * l
            print(ans)
        else:
            qs.append((b, c, d))


if __name__ == '__main__':
    reader()
