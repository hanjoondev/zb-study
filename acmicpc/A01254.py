from sys import stdin


def pal(s: str) -> int:
    if (length := len(s)) < 3:
        return length + (0 if length < 2 else s[0] != s[1])
    for i in range(length):
        if s[i:] == s[i:][::-1]:
            return length + i


def reader():
    s = stdin.readline().strip()
    print(pal(s))


if __name__ == '__main__':
    reader()
