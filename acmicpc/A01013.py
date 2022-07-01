from re import fullmatch as m
from sys import stdin


def reader():
    read = stdin.readline
    print('\n'.join('YES' if m('(100+1+|01)+', read().rstrip()) else 'NO'
                    for _ in range(int(read().rstrip()))))


if __name__ == '__main__':
    reader()
