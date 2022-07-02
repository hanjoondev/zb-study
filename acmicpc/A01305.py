from sys import stdin


def solution(s: str, length: int) -> int:
    t, j = [0] * (length + 1), 0
    for i in range(1, length):
        while j and s[j] != s[i]:
            j = t[j - 1]
        if s[j] == s[i]:
            t[i] = (j := j + 1)
    return length - t[length - 1]


def reader():
    read = stdin.readline
    n, s = int(read().rstrip()), read().rstrip()
    print(solution(s, n))


if __name__ == '__main__':
    reader()
