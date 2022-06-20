from sys import stdin


def pal(s: str) -> int:
    if (length := len(s)) < 3:
        return length + (0 if length < 2 else s[0] != s[1])
    ans, l, r = 0, 0, (length := length - 1)
    while l < r:
        if s[l] == s[r]:
            l, r = l + 1, r - 1
        else:
            l, r, ans = ans + 1, length, ans + 1
    return ans + length + 1


def reader():
    s = stdin.readline().strip()
    print(pal(s))


if __name__ == '__main__':
    reader()
