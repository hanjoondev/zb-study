from sys import stdin as s


def compare(n: str, length: int) -> str:
    if not length:
        return 'YES'
    i = 0
    while i < length:
        if n[i] == n[-1 - i]:
            return 'NO'
        i += 1
    return compare(n[:length], length // 2)


def solution(n: str) -> None:
    if (length := len(n)) == 1:
        print('YES')
        return
    exp = 2
    while 2**exp < length:
        exp += 1
    if 2**exp - 1 != length:
        print('NO')
        return
    print(compare(n, length // 2))


def reader():
    n = int(s.readline())
    for _ in range(n):
        solution(s.readline().strip())


if __name__ == '__main__':
    reader()
