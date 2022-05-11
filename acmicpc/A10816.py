from sys import stdin as s


def reader():
    n = int(s.readline())
    arr = map(int, s.readline().split())
    m = int(s.readline())
    targets = map(int, s.readline().split())
    d = {}
    for num in arr:
        d[num] = d.get(num, 0) + 1
    print(' '.join(str(d.get(num, 0)) for num in targets) + '\n')


if __name__ == '__main__':
    reader()
