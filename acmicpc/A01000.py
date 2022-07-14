from sys import stdin


def reader():
    read = stdin.readline
    print(sum(map(int, read().split())))


if __name__ == '__main__':
    reader()
