from sys import stdin


def reader():
    root, ans = {}, 0
    for i in range(len(s := stdin.readline().strip())):
        d = root
        for c in s[i:]:
            ans += c not in d
            d = d.setdefault(c, {})
    print(ans)


if __name__ == '__main__':
    reader()
