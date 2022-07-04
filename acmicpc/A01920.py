from sys import stdin as s


def reader():
    s.readline()
    arr = {k: None for k in map(int, s.readline().split())}
    s.readline()
    queries = list(map(int, s.readline().split()))
    print('\n'.join('1' if q in arr else '0' for q in queries) + '\n')


if __name__ == '__main__':
    reader()
